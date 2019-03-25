package com.bizvane.messagefacade.utils;

/**
 * @author chen.li
 * @date 2018-3-8 19:56:08
 * @description 分页工具类
 */
public class PageFormUtil {

    @io.swagger.annotations.ApiModelProperty(value = "当前页数", name = "pageNumber")
    private Integer pageNumber = 1;

    @io.swagger.annotations.ApiModelProperty(value = "显示条数", name = "pageSize")
    private Integer pageSize = 20;
    private Integer page = 1;
    private Integer rows = 20;
    @io.swagger.annotations.ApiModelProperty(value = "总条数", name = "total")
    private long total = 0;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        Integer totalPages = (int) (getPageSize() == 0 ? 1 : Math.ceil((double) total / (double) getPageSize()));
        if (totalPages == 0) {
            totalPages = 1;
        }

        return totalPages;
    }

    public boolean isFirst() {
        return pageNumber == 1;
    }

    public boolean isLast() {
        return pageNumber.equals(getLastPage());
    }

    public Integer getLastPage() {
        return getTotalPages();
    }


}
