package com.z3un3un.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.z3un3un.common.DBConnPool;
import com.z3un3un.common.DBConnection;
import com.z3un3un.dto.EmpDto;

/*
 * 데이터 베이스에 접근해서
 * 데이터 입력, 출력, 삭제, 조회를 처리하는 객체
 * 
 * Dao -> mapper
 */
public class EmpDao extends DBConnPool{
	
	
	/**
	 * 생성자를 이용하여 Connection 객체를 생성 후
	 * 멤버변수인 con에 저장한다.
	 * @param application
	 */
/*	DBConnPool -> 생성자 더이상 필요X
//	public EmpDao(ServletContext application) {
//		super(application); //부모 생성자 호출
//	}
	
	/*
	 * 데이터베이스로부터 사원의 목록을 조회하여 반환한다.
	 * 조회된 데이터를 반환하기 위해서 리스트에 담아준다.(화면에 출력하기 위함)
	 */
	public List<EmpDto> getList() {
		List<EmpDto> list = new ArrayList<>();
		
		try {
			stmt = con.createStatement();
			String sql = "select * from employee";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
//				System.out.print(rs.getString(1));
//				System.out.print(rs.getString(2));
//				System.out.print(rs.getString(3));
//				System.out.println();
				EmpDto dto = new EmpDto();
				dto.setEmp_id(rs.getString(1));
				dto.setEmp_name(rs.getString(2));
				dto.setEmp_no(rs.getString(3));
				
				list.add(dto);
			}
			close();
			

		} catch (SQLException e) {
			System.out.println("SQLException 발생");
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		//EmpDao empDao = new EmpDao();
		//empDao.getList();
	}


}
