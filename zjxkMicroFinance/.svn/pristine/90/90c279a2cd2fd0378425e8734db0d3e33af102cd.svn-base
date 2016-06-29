package com.yzframework.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page implements Serializable {

	private static final long serialVersionUID = -7168454064979913946L;

	public Page() {}

	protected Integer pageNum = 1;
	protected Integer numPerPage = 20;
	protected Long    totalCount = -1L;
	protected String  orderField = null;
	protected String  orderDirection = null;
	protected List<Model> resultList = new ArrayList<Model>();

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(Integer numPerPage) {
		this.numPerPage = numPerPage;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	public List<Model> getResultList() {
		return resultList;
	}

	public void setResultList(List<Model> resultList) {
		this.resultList = resultList;
	}
}
