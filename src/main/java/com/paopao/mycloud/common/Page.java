package com.paopao.mycloud.common;

public class Page {

	private static final int DEFAULT_PAGE_SIZE = 10;
	private static final int DEFAULT_PAGE_NO = 1;

	private int pageNo;
	private int pageSize;
	private int start;

	public int getPageNo() {
		if(pageNo <=0) {
			this.pageNo = DEFAULT_PAGE_NO;
		}
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		if (pageSize <= 0) {
			this.pageSize = DEFAULT_PAGE_SIZE;
		}
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStart() {

		if (pageNo <= 0) {
			this.start = 0;
		} else {
			this.start = (pageNo - 1) * pageSize;
		}

		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

}
