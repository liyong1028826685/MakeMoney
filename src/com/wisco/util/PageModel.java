package com.wisco.util;
import java.util.List;

/**
 * ��ҳ���
 * @author miomin
 *
 */
public class PageModel {

	private int pageNo;  //ҳ��,�ڼ�ҳ
	
	private int pageSize;  //ÿҳ��ʾ��¼����
	
	private int totalRecords;  //�ܵļ�¼����
	
	private int totalPages;//��ҳ��
	
	private int previousPageNo;//��һҳ
	
	private int nextPageNo;//��һҳ
	
	private int topPageNo;//��ҳ
	
	private int bottomPageNo;//���һҳ
	
	private List list;  //��ǰҳ�ļ�¼
	
	public void setValues(){
		topPageNo = 1;
		totalPages = (totalRecords + pageSize - 1) / pageSize;
		previousPageNo = pageNo <= 1 ? 1 : pageNo - 1;
		nextPageNo = pageNo >= totalPages ? totalPages : pageNo + 1;
		bottomPageNo = totalPages <= 1 ? 1 : totalPages;
	}
	
	
	/**
	 * ����ܵ�ҳ��
	 * @return
	 */
	public int getTotalPages() {
		return totalPages;
	}
	
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * ������ҳ
	 * @return
	 */
	public int getTopPageNo() {
		return 1;
	}
	
	/**
	 * ������һҳ��ҳ��
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
	 * ������һҳ��ҳ��
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
	 * �������һҳ��ҳ��
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
