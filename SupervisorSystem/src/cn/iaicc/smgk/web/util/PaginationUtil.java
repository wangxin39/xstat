package cn.iaicc.smgk.web.util;

/**
 * <p>
 * Title: 分页显示类
 * </p>
 * 
 * <p>
 * Description: 分页算法
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * 
 * <p>
 * Company:
 * </p>
 * 
 * @author 王鑫
 * @version 1.2
 */
public class PaginationUtil {
	private int currentPage = 0; // 当前页

	private int pageRecords = 10; // 默认每页显示记录数

	private int totalPageNum = 0; // 总页数

	private int totalRecordNum = 0; // 总记录数

	private int startRecord = 0; // 开始记录

	private int endRecord = 0; // 结束记录

	private int previous = 0; // 上一页

	private int next = 0; // 下一页

	/**
	 * 指定总记录数和要显示的页 显示默认10条记录
	 * 
	 * @param totalRecordNum
	 *            int 总记录数
	 * @param currentPage
	 *            int 当前页
	 */
	public PaginationUtil(int totalRecordNum, int currentPage) {
		setTotalRecordNum(totalRecordNum);
		setCurrentPage(currentPage);

		compute();
	}

	/**
	 * 指定总记录数和要显示的页数以及每页显示的记录数。
	 * 
	 * @param totalRecordNum
	 *            int
	 * @param currentPage
	 *            int
	 * @param pageRecords
	 *            int
	 */
	public PaginationUtil(int totalRecordNum, int currentPage, int pageRecords) {
		setTotalRecordNum(totalRecordNum);
		setCurrentPage(currentPage);
		setPageRecords(pageRecords);

		compute();
	}

	/**
	 * 分页算法
	 */
	private void compute() {
		totalPageNum = (int) Math.ceil((double) totalRecordNum/(double) pageRecords);
		if ((totalPageNum * pageRecords) < totalRecordNum) {
			totalPageNum++;
		}
		if (currentPage == 1) {
			startRecord = 0;
			endRecord = pageRecords;	
		} else {
			//最后一页
			if (currentPage == getTotalPageNum()) {
				startRecord = (currentPage-1)*pageRecords;
				endRecord = totalRecordNum;
			}else{
				startRecord = (currentPage-1)*pageRecords;				
				endRecord = currentPage*pageRecords;
			}
		}
		if(endRecord >= totalRecordNum) {
			endRecord = totalRecordNum;
		}						
		
		if(totalPageNum == 0) {
			startRecord = 0;
			endRecord = 0;
		}
	}

	public void setPageRecords(int pageRecords) {
		this.pageRecords = pageRecords;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setEndRecord(int endRecord) {
		this.endRecord = endRecord;
	}

	public void setStartRecord(int startRecord) {
		this.startRecord = startRecord;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public void setTotalRecordNum(int totalRecordNum) {
		this.totalRecordNum = totalRecordNum;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public void setPrevious(int previous) {
		this.previous = previous;
	}

	public int getPageRecords() {
		return pageRecords;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getEndRecord() {
		return endRecord;
	}

	public int getStartRecord() {
		return startRecord;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public int getTotalRecordNum() {
		return totalRecordNum;
	}

	public int getNext() {
		next = currentPage + 1;
		if (next > totalPageNum) {
			next = totalPageNum;
		}
		return next;
	}

	public int getPrevious() {
		previous = currentPage - 1;
		if (previous <= 1) {
			previous = 1;
		}
		return previous;
	}
	public static void main(String[] args)
	{
		PaginationUtil pu = new PaginationUtil(39,3,10);
		System.out.println("start:"+pu.getStartRecord());
		System.out.println("end:"+pu.getEndRecord());
		System.out.println("currentPage："+pu.currentPage);
		
	}
}
