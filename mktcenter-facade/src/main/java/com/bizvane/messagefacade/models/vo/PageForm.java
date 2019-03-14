package com.bizvane.messagefacade.models.vo;

/**
 * 分页bo
 * 
 * @author 董争光 2018年5月21日下午1:49:10
 */
public class PageForm {

  @io.swagger.annotations.ApiModelProperty(value = "页码", name = "pageNum", required = false, example = "")
  private Integer pageNum = 1;
  
  @io.swagger.annotations.ApiModelProperty(value = "每页显示条数", name = "pageSize", required = false, example = "")
  private Integer pageSize = 10;

  public void setRows(Integer rows) {
    this.pageSize = rows;
  }

  public void setPage(Integer page) {
    this.pageNum = page;
  }

  private long total = 0;

  public Integer getTotalPages() {
    Integer totalPages =
        (int) (this.getPageSize() == 0 ? 1 : Math.ceil((double) this.total / (double) this.getPageSize()));
    if (totalPages == 0) {
      totalPages = 1;
    }

    return totalPages;
  }

  public boolean isFirst() {
    return this.pageNum == 1;
  }

  public boolean isLast() {
    return this.pageNum == this.getLastPage();
  }

  public Integer getLastPage() {
    return this.getTotalPages();
  }

  public Integer getPageNum() {
    return this.pageNum;
  }

  public void setPageNum(Integer page) {
    this.pageNum = page;
  }

  public Integer getPageSize() {
    return this.pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public long getTotal() {
    return this.total;
  }

  public void setTotal(long total) {
    this.total = total;
  }
}
