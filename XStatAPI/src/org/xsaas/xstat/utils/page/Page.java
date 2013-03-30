package org.xsaas.xstat.utils.page;

import org.xsaas.xstat.conf.Common;

public class Page {
	public boolean hasPrePage = false;
	public boolean hasNextPage = false;
	public int everyPage = Common.PAGE_MAX_RESULT;
	public int totalPage = 0;
	public int currentPage = 1;
	public int beginIndex = 0;
	public int totalRecords = 0;

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public Page() {

	}

	public Page(int everyPage) {
		this.everyPage = everyPage;
	}

	public Page(boolean hasPrePage, boolean hasNextPage, int everyPage, int totalPage, int currentPage, int beginIndex, int totalRecords) {
		this.hasPrePage = hasPrePage;
		this.hasNextPage = hasNextPage;
		this.everyPage = everyPage;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.beginIndex = beginIndex;
		this.totalRecords = totalRecords;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	public boolean getHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public boolean getHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
