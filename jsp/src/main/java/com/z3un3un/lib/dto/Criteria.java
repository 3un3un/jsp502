package com.z3un3un.lib.dto;

public class Criteria {
	private int startNo;
	private int EndNo;
	
	private int pageNo = 1;
	private int amount = 10;
	
	private String searchWord = "";
	private String searchField = "";
	
	public Criteria() {
		super();
		EndNo = this.pageNo * this.amount;
		startNo = EndNo - (this.amount-1);
	}
	public Criteria(String pageNo, String amount, String searchField, String searchWord) {
		
		if(pageNo != null && !"".equals(pageNo)) {
			this.pageNo = Integer.parseInt(pageNo);
		}
		if(amount != null && !"".equals(amount)) {
			this.amount = Integer.parseInt(amount);
		}
		
		EndNo = this.pageNo * this.amount;
		startNo = EndNo - (this.amount-1);
		
		if(searchWord != null && !"".equals(searchWord)) {
			this.searchWord = searchWord;
		}
		if(searchField != null && !"".equals(searchField)) {
			this.searchField = searchField;
		}
		
	}
	@Override
	public String toString() {
		return "[pageNo] : " + pageNo
			 + "\n[amount] : " + amount;
	}
	
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return EndNo;
	}
	public void setEndNo(int endNo) {
		EndNo = endNo;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public String getSearchField() {
		return searchField;
	}
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	
	
}
