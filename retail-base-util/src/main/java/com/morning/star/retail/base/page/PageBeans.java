package com.morning.star.retail.base.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.Page;

/**
 * 分页
 * 
 * @author jiangyf
 */
public class PageBeans<T> implements Serializable {
	private static final long serialVersionUID = 8656597559014685635L;

	/**
	 * 总记录数
	 */
	private long totalNum;
	/**
	 * 结果集
	 */
	private List<T> record;
	/**
	 * 第几页
	 */
	private int pageNo;
	/**
	 * 每页记录数
	 */
	private int pageSize;
	/**
	 * 总页数
	 */
	private int pages;

	public PageBeans() {
		this.pageNo = 1;
		this.pageSize = 20;
		this.totalNum = 0;
		this.pages = 0;
		this.record = new ArrayList<>();
	}

	/**
	 * 包装Page对象，因为直接返回Page对象，在JSON处理以及其他情况下会被当成List来处理， 而出现一些问题。
	 * 
	 * @param list
	 *            page结果
	 * @param navigatePages
	 *            页码数量
	 */
	public PageBeans(List<T> list) {
		if (list instanceof Page) {
			Page<T> page = (Page<T>) list;
			this.pageNo = page.getPageNum();
			this.pageSize = page.getPageSize();
			this.totalNum = page.getTotal();
			this.pages = page.getPages();
			this.record = page.getResult();
		}
	}

	public PageBeans(Page<T> page, List<T> record) {
		this.pageNo = page.getPageNum();
		this.pageSize = page.getPageSize();
		this.totalNum = page.getTotal();
		this.pages = page.getPages();
		this.record = record;
	}

	public PageBeans(PageBeans<T> pageBean, List<T> list) {
		this.totalNum = pageBean.getTotalNum();
		this.record = list;
		this.pageNo = pageBean.getPageNo();
		this.pageSize = pageBean.getPageSize();
		this.pages = pageBean.getPages();
	}

	/**
	 * 构造函数
	 * 
	 * @param totalNum
	 *            总记录数
	 * @param list
	 *            结果集
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页记录数
	 * @param pages
	 *            总页数
	 * @param size
	 *            当前页记录数
	 */
	public PageBeans(long totalNum, List<T> list, int pageNo, int pageSize, int pages) {
		this.totalNum = totalNum;
		this.record = list;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.pages = pages;
	}

	public long getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(long totalNum) {
		this.totalNum = totalNum;
	}

	public List<T> getRecord() {
		return record;
	}

	public void setRecord(List<T> record) {
		this.record = record;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

}
