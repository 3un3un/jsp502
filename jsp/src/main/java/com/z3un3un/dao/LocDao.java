package com.z3un3un.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.z3un3un.common.DBConnection;
import com.z3un3un.dto.LocDto;

public class LocDao extends DBConnection{
	public String dept_id;
	public String dept_title;
	public String local_name;
	
	//생성자를 통해서(dao) Connection객체를 생성 후 멤버변수 con에 저장(DBConnection)
	public LocDao(ServletContext application) {
		super(application);
	}
	
	public List<LocDto> getList() {
		List<LocDto> list = new ArrayList<>();
		try {
			stmt = con.createStatement();
			
			String sql = "select d.dept_id, d.dept_title, l.local_name"
					+ " from department d, location l"
					+ " where d.location_id = l.local_code";
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				LocDto dto = new LocDto();
				dto.setDept_id(rs.getString(1));
				dto.setDept_title(rs.getString(2));
				dto.setLocal_name(rs.getString(3));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	

}
