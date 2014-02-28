package com.wisco.util;
import java.util.List;

/**
 * 分页组件
 * @author miomin
 *
 */
public class PageModel {

	private int pageNo;  //页码,第几页
	
	private int pageSize;  //每页显示记录条数
	
	private int totalRecords;  //总的记录条数
	
	private int totalPages;//总页数
	
	private int previousPageNo;//上一页
	
	private int nextPageNo;//下一页
	
	private int topPageNo;//首页
	
	private int bottomPageNo;//最后一页
	
	private List list;  //当前页的记录
	
	public void setValues(){
		topPageNo = 1;
		totalPages = (totalRecords + pageSize - 1) / pageSize;
		previousPageNo = pageNo <= 1 ? 1 : pageNo - 1;
		nextPageNo = pageNo >= totalPages ? totalPages : pageNo + 1;
		bottomPageNo = totalPages <= 1 ? 1 : totalPages;
	}
	
	
	/**
	 * 获得总的页数
	 * @return
	 */
	public int getTotalPages() {
		return totalPages;
	}
	
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * 返回首页
	 * @return
	 */
	public int getTopPageNo() {
		return 1;
	}
	
	/**
	 * 返回上一页的页码
	 * @return
	 */
	public int getPreviousPageNo() {
		if(pageNo <= 1) {
			return 1;
		} else {
			return pageNo - 1;
		}
	}
	
	/**
	 * 返回下一页的页码
	 * @return
	 */
	public int getNextPageNo() {
		if(pageNo >= getTotalPages()) {
			return getTotalPages() == 0 ? 1 : getTotalPages();
		} else {
			return pageNo + 1;
		}
	}
	
	/**
	 * 返回最后一页的页码
	 * @return
	 */
	public int getBottomPageNo() {
		return getTotalPages() == 0 ? 1 : getTotalPages();
	}
	
	/****************getter()  and  setter()************************/
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

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public void setPreviousPageNo(int previousPageNo) {
		this.previousPageNo = previousPageNo;
	}

	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}

	public void setTopPageNo(int topPageNo) {
		this.topPageNo = topPageNo;
	}

	public void setBottomPageNo(int bottomPageNo) {
		this.bottomPageNo = bottomPageNo;
	}
	
}
