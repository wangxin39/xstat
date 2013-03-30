package org.xsaas.xstat.utils.page;

import java.util.ArrayList;
import java.util.List;

public class ListRange<T> {
	boolean success;
	String message;
	long size;
	List<T> list;
	public Page page;
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public ListRange() {
		this.size = 0;
		this.list = new ArrayList<T>();
	}

	public long getSize() {
		return size;
	}

	public void setSize(long totalSize) {
		this.size = totalSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
