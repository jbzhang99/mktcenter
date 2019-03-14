package com.bizvane.messageservice.wxpublicapi;

import com.bizvane.mktcenterservice.common.utils.SpringContextHolder;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


/**
 * 流式导出excel
 *
 * @param <T>
 */
public class StreamingExportExcelUtil<T> {
	// 默认第一行为标题行
	private final Integer MAX_NUM_EXCEL_SHEET_ROW = 65535;
	// 线程池默认线程数
	private Integer MAX_NUM_THREAD_POOL = 3;
	// 每次从数据库读取的数据条数
	private Integer PER_READ_NUM = 20000;
	// 要写入excel的数据量
	private Long TOTAL_NUM_DATA = 0L;
	// 线程池
	private ExecutorService es = null;
	// excel workbook对象，内存中始终保持十条数据，超过的数据持久化到硬盘
	private SXSSFWorkbook wb = new SXSSFWorkbook(10);
	// 对象锁，同步控制
	private Object obj = new Object();

	/*************** 以下处理excel导出进度 ******************/
	// 维护对应exportProcessId要导出的excel总条数
	private static Map<Object, Long> totalMap = new ConcurrentHashMap<>();
	// 维护对应exportProcessId要导出的excel处理完成的条数
	private static Map<Object, AtomicLong> progressMap = new ConcurrentHashMap<>();
	// 当前导出excel工作的唯一标志
	private Object exportProcessId;

	/**
	 * @param total_num_data 要导出的数据条数
	 */
	public StreamingExportExcelUtil(Long total_num_data) {
		this.TOTAL_NUM_DATA = total_num_data;
		es = Executors.newFixedThreadPool(MAX_NUM_THREAD_POOL);
	}

	/**
	 * @param per_read_num   每次从数据库读取的条数
	 * @param total_num_data 要导出的数据条数
	 */
	public StreamingExportExcelUtil(Integer per_read_num, Long total_num_data) {
		this.PER_READ_NUM = per_read_num;
		this.TOTAL_NUM_DATA = total_num_data;
		es = Executors.newFixedThreadPool(MAX_NUM_THREAD_POOL);
	}

	/**
	 * @param max_num_thread_pool 最大线程池数
	 * @param per_read_num        每次从数据库读取的条数
	 * @param total_num_data      要导出的数据条数
	 */
	public StreamingExportExcelUtil(Integer max_num_thread_pool, Integer per_read_num, Long total_num_data) {
		this.MAX_NUM_THREAD_POOL = max_num_thread_pool;
		this.PER_READ_NUM = per_read_num;
		this.TOTAL_NUM_DATA = total_num_data;
		es = Executors.newFixedThreadPool(max_num_thread_pool);
	}

	/**
	 * 设置当前导出任务的唯一进度ID，统计当前导出任务进度使用
	 * 
	 * @param exportProcessId
	 */
	public void setExportProcessId(Object exportProcessId) {
		this.exportProcessId = exportProcessId;
	}

	/**
	 * 获取当前导出任务处理过的excel条数
	 * 
	 * @param exportProcessId
	 * @return
	 */
	public static AtomicLong getExportProcess(Object exportProcessId) {
		AtomicLong al = progressMap.get(exportProcessId);
		return al;
	}

	/**
	 * 从内存中移除当前
	 * 
	 * @param exportProcessId
	 */
	public static void removeExportProcess(Object exportProcessId) {
		progressMap.remove(exportProcessId);
	}

	/**
	 * 返回当前已处理条数除总条数
	 * 
	 * @param exportProcessId
	 * @return
	 */
	public static BigDecimal getExportPercentageProcess(Object exportProcessId) {
		AtomicLong al = progressMap.get(exportProcessId);
		if (al != null) {
			long currentProcessRow = al.get();
			long total = totalMap.get(exportProcessId);
			return new BigDecimal(currentProcessRow).divide(new BigDecimal(total));
		}
		return null;
	}

	/**
	 * 
	 * @param beanName 取数据调用者bean 如(memberInfoServiceImpl)
	 * @param method   取数据方法 如(getMemberInfoWithLimitTo)
	 * @param callback 回调方法
	 * @param args     取数据参数数组(数据开始和结束为止除外)
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void read(String beanName, Method method, StreamingCallBack<T> callback, Object... args) throws Exception {

		Long startTimeMillis = System.currentTimeMillis();
		// 计算已经处理的行数，用来统计进度
		AtomicLong al = new AtomicLong(0);
		if (exportProcessId != null) {
			progressMap.put(exportProcessId, al);
			totalMap.put(exportProcessId, TOTAL_NUM_DATA);
		}
		// 要写入的sheet数量
		Integer sheetNum = (int) (TOTAL_NUM_DATA / MAX_NUM_EXCEL_SHEET_ROW
				+ (TOTAL_NUM_DATA % MAX_NUM_EXCEL_SHEET_ROW == 0 ? 0 : 1));// sheet数量
		// 控制并发
		CountDownLatch cd = new CountDownLatch(sheetNum);
		// 保证数据的顺序性
		AtomicInteger ai = new AtomicInteger(0);

		for (int i = 0; i < sheetNum; i++) {
			es.submit(() -> {
				try {
					int sheetExecuteNum = ai.getAndIncrement();
					Sheet sh = null;
					// 创建sheet过程非线程安全
					synchronized (obj) {
						sh = wb.createSheet("sheet" + sheetExecuteNum);
					}
					// 创建表头
					if (true) {
						Row row = sh.createRow(0);
						callback.onCompletion(null, row);
					}
					// 每个线程for循环读取数据
					for (int perQuery = 0; perQuery * PER_READ_NUM < MAX_NUM_EXCEL_SHEET_ROW; perQuery++) {
						// 每次开始写入的位置
						long beginNum = sheetExecuteNum * MAX_NUM_EXCEL_SHEET_ROW + perQuery * PER_READ_NUM;
						// 每次最后写入的条数
						long endNum = Math.min(PER_READ_NUM, MAX_NUM_EXCEL_SHEET_ROW - perQuery * PER_READ_NUM);

						if (beginNum >= TOTAL_NUM_DATA) {
							break;
						}
						if (beginNum + endNum > TOTAL_NUM_DATA) {
							endNum = TOTAL_NUM_DATA - beginNum;
						}
						Object bean = SpringContextHolder.getBean(beanName);
						List<T> datalist = null;
						if (args != null && args.length > 0) {
							int length = args.length;
							Object[] realArgs = Arrays.copyOf(args, length + 2, Object[].class);
							realArgs[length] = beginNum;
							realArgs[length + 1] = endNum;
							datalist = (List<T>) ReflectionUtils.invokeMethod(method, bean, realArgs);
						} else {
							datalist = (List<T>) ReflectionUtils.invokeMethod(method, bean, beginNum, endNum);
						}
						for (int column = 0; column < datalist.size(); column++) {
							if (exportProcessId != null) {
								// 统计的行数+1
								al.incrementAndGet();
							}
							T t = datalist.get(column);
							// 第一行为表头，创建row+1
							Row row = sh.createRow(column + perQuery * PER_READ_NUM + 1);
							callback.onCompletion(t, row);
						}
					}
					System.out.println("countDown:" + sheetExecuteNum);
					cd.countDown();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		cd.await();
		es.shutdown();
		for (int i = 0; i < sheetNum; i++) {
			// 多线程并发处理sheet顺序会乱掉，这里等sheet写入数据完成后手动指定顺序
			wb.setSheetOrder("sheet" + i, i);
		}
		// 处理完成后，直接重置处理的条数为总条数(存在读取list时数据被修改或删除的情况)，即进度为100%
		if (exportProcessId != null) {
			progressMap.put(exportProcessId, new AtomicLong(TOTAL_NUM_DATA));
			totalMap.put(exportProcessId, TOTAL_NUM_DATA);
		}
		Long endTimeMillis = System.currentTimeMillis();
		long internal = endTimeMillis - startTimeMillis;
		System.out.println("执行时间：" + internal);
	}

	/**
	 * @param os 输出流,导出到文件可使用FileOutputStream，导出到网络流中可使用httpservletresponse.getoutputstream...
	 * @throws IOException
	 */
	public void exportToOutputStream(OutputStream os) throws IOException {

		wb.write(os);
		wb.dispose();
	}

	public static void receiveParam(Object... args) {
		Object[] args11 = Arrays.copyOf(args, 2, Object[].class);
		System.out.println(args11[0] + "" + args11[1]);
	}

	public static void main(String[] args) {
		Map<Object, AtomicLong> map = new ConcurrentHashMap<>();
		AtomicLong al = new AtomicLong(0);
		map.put("xxx", al);
		al.getAndIncrement();
		al.getAndIncrement();
		System.out.println(map.get("xxx"));
		StreamingExportExcelUtil.receiveParam(new Object());
	}
}
