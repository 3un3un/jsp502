package com.z3un3un.dto;

public class BookFileDto {
	
	private int file_no;
	private String title;
	private String author;
	private String intro;
	private String ofile;
	private String sfile;
	private String postdate;
	
	public BookFileDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "file_no:" + file_no
				+ "\ntitle : " + title
				+ "\nauthor : " + author
				+ "\nintro : " + intro
				+ "\nofile : " + ofile
				+ "\nsfile : " + sfile
				+ "\npostdate : " + postdate;
				
	}
	
	public BookFileDto(int file_no, String title, String author, String intro, String ofile, String sfile, String postdate) {
		super();
		this.file_no = file_no;
		this.title = title;
		this.author = author;
		this.intro = intro;
		this.ofile = ofile;
		this.sfile = sfile;
		this.postdate = postdate;
	}
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
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
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getOfile() {
		return ofile;
	}
	public void setOfile(String ofile) {
		this.ofile = ofile;
	}
	public String getSfile() {
		return sfile;
	}
	public void setSfile(String sfile) {
		this.sfile = sfile;
	}
	public String getPostdate() {
		return postdate;
	}
	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}
	
	
	
	
}
