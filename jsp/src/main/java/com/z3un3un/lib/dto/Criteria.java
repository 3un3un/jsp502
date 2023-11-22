package com.z3un3un.lib.dto;

public class Criteria {
	private int startNo;
	private int EndNo;
	
	private int pageNo = 1;
	private int amount = 10;
	
	
	public Criteria(String pageNo, String amount) {
		super();
		this.pageNo = Integer.parseInt(pageNo);
		this.amount = Integer.parseInt(amount);
		
		EndNo = this.pageNo * this.amount;
		startNo = EndNo - (this.amount-1);
				
		
	}
	
	public Criteria() {
		super();
		EndNo = this.pageNo * this.amount;
		startNo = EndNo - (this.amount-1);
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
	
	
}
