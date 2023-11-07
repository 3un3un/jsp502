package com.z3un3un.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.z3un3un.common.DBConnection;
import com.z3un3un.dto.Job;

/*
 * Dao
 * 데이터 엑세스 객체(Data Access Object)
 * 
 * 데이터베이스와의 상호작용을 관리하고 데이터베이스에서 데이터를 읽고 쓰는데 사용
 * 
 * Dto
 * 데이터 전송 객체(Data Transfer Object)
 * 
 * 데이터를 전송하거나 전달하기 위해 사용되는 객체
 * setter, getter 메서드만 존재한다.
 * 
 */
public class JobDao extends DBConnection {
	public JobDao(ServletContext application) {
		super(application); //부모 생성자 호출
		
	}
	
	/*
	 * job 테이블의 내용을 조회 후 리스트에 담아서 반환
	 * @return
	 */
	public List<Job> getList() {
		List<Job> list = new ArrayList<>();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from job");
			while(rs.next()) {
				Job job = new Job();
				//job.setJobCode(rs.getString("JOB_CODE"));
				//job.setJobCode(rs.getString("JOB_NAME"));
				job.setJobCode(rs.getString(1));
				job.setJobName(rs.getString(2));
				
				list.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
