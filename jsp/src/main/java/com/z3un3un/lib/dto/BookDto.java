package com.z3un3un.lib.dto;

/**
 * 도서 테이블의 정보를 담아준다.
 * 
 */
public class BookDto {
	private String no;
	private String title;
	private String author;
	private String rentyn;
	private String rentynStr;
	
	/**
	 * object객체가 가지고 있는 메서드 : '객체의이름@주소값' 을 출력
	 */
	@Override
	public String toString() {
		return "[title: " + title + "]";
	}
	

	public BookDto() {
	}


	public BookDto(String no, String title, String author, String rentyn) {
		super();
		this.no = no;
		this.title = title;
		this.author = author;
		this.rentyn = rentyn;
	}
	
	public String getRentyn() {
		return rentyn;
	}
	//rentyn이 세팅될 때 rentynStr을 같이 세팅해줘야 다른 생성자로 들어와도 일관성 갖는다.
	public void setRentyn(String rentyn) {
		this.rentyn = rentyn;
		rentynStr = rentyn.equals("Y")? "대여중" : "";
	}

	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getRentynStr() {
		return rentynStr;
	}
	public void setRentynStr(String rentynStr) {
		this.rentynStr = rentynStr;

		
	}
	

}
