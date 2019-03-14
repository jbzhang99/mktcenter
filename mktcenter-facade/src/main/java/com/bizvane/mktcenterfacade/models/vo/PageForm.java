package com.bizvane.mktcenterfacade.models.vo;

import com.github.pagehelper.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

@ApiModel("数据页信息")
public class PageForm<T> implements Serializable {
    private static final long serialVersionUID = 8656597559014685635L;
    private List<T> list;
    private int pageNum = 0;
    private int pageSize = 10;
    private long total = 0L;
    private int pages = 0;
    private int size = 0;
    private int pageNumber;

    public PageForm(List<T> list, int pageNum, int pageSize, long total, int pages, int size) {
        this.list = list;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.pages = pages;
        this.size = size;
    }

    public PageForm() {
    }

    @ApiModelProperty("总页数")
    public int getPages() {
        if (this.pages > 0) {
            return this.pages;
        } else {
            return this.total > 0L ? (int)((this.total + (long)this.pageSize - 1L) / (long)this.pageSize) : this.pages;
        }
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @ApiModelProperty("当前页数据数")
    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public PageForm(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public PageForm(List<T> list) {
        if (list instanceof Page) {
            Page<T> page = (Page)list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.total = page.getTotal();
            this.pages = page.getPages();
            this.list = page;
            this.size = page.size();
        }

    }

    @ApiModelProperty("数据列表")
    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @ApiModelProperty("页索引")
    public int getPageNum() {
        return this.pageNum;
    }

    public void setPage(int pageNum) {
        this.pageNum = pageNum;
    }

    @ApiModelProperty("每页几条数据")
    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @ApiModelProperty("总记录数")
    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
