package com.bizvane.messageservice.common.utils;

import com.bizvane.messagefacade.models.po.SysCodeValuePO;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 字典数据帮助类
 *
 * @author yangyulei
 */
public class DictHelper {

  private DictHelper() {

  }

  private static final Map<String, List<SysCodeValuePO>> DICT_MAP = new HashMap<>();


  public static Map<String, List<SysCodeValuePO>> getDictMap() {
    return DictHelper.DICT_MAP;
  }

  public static List<SysCodeValuePO> getDicts(String dictType) {

    return DictHelper.DICT_MAP.get(dictType);

  }

  public static Map<String, SysCodeValuePO> getDictMap(String dictType) {

    Map<String, SysCodeValuePO> result = new HashMap<>();
    List<SysCodeValuePO> list = DictHelper.DICT_MAP.get(dictType);

    if (list != null) {
      for (SysCodeValuePO value : list) {
        result.put(value.getItemCode(), value);
      }
    }
    return result;

  }

  public static SysCodeValuePO getDict(String dictType, String dictKey) {
    if (StringUtils.isBlank(dictKey)) {
      return null;
    }
    List<SysCodeValuePO> list = DictHelper.DICT_MAP.get(dictType);
    if (list != null) {
      for (SysCodeValuePO value : list) {
        if (dictKey.equals(value.getItemCode())) {
          return value;
        }
      }
    }
    return null;

  }
}
