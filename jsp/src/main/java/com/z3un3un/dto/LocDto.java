package com.z3un3un.dto;

public class LocDto {
	private String dept_id;
	private String dept_title;
	private String local_name;
	
	public String toString() {
		return dept_id + "/" + dept_title + "/" + local_name;
	}
	
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_title() {
		return dept_title;
	}
	public void setDept_title(String dept_title) {
		this.dept_title = dept_title;
	}
	public String getLocal_name() {
		return local_name;
	}
	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}
}
