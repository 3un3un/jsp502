package com.z3un3un.lib.dto;

public class PageDto {
	int startNo;
	int endNo;
	int realEnd;
	boolean prev, next;
	
	//총개수, 블럭당 몇개?
	int totalCnt;
	int blockAmount = 10;
	Criteria cri;
	

	
	public PageDto(int totalCnt,Criteria cri) {
		super();
		this.totalCnt = totalCnt;
		this.cri = cri;
		
		endNo = (int)Math.ceil(cri.getPageNo()/(blockAmount*1.0))* blockAmount;
		startNo = endNo - (blockAmount-1);
		//77개면 블럭 8개 나와야함 77/10 = 7.7 12/10 1.2
		realEnd = (int)Math.ceil((totalCnt*1.0) / cri.getAmount());
		
		endNo = (endNo>realEnd ? realEnd : endNo);
		prev = (startNo == 1 ? false : true);
		next = (endNo == realEnd ? false : true);
		System.out.println("endNo "+endNo + " startNo " + startNo + " realEnd " + realEnd
				+ " prev " + prev + " next " + next);
		System.out.println("totalCnt "+totalCnt + " cri.getPageNo " + cri.getPageNo()
		+  " cri.getAmount() " + cri.getAmount() + " blockAmount " + blockAmount);
		
	}
	
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	public int getRealEnd() {
		return realEnd;
	}
	public void setRealEnd(int realEnd) {
		this.realEnd = realEnd;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public int getBlockAmount() {
		return blockAmount;
	}
	public void setBlockAmount(int blockAmount) {
		this.blockAmount = blockAmount;
	}
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	

	
	
	
	

}
