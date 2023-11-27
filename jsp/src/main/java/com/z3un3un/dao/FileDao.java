package com.z3un3un.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.z3un3un.common.DBConnPool;
import com.z3un3un.dto.FileDto;

public class FileDao extends DBConnPool{
	public int regFile(FileDto dto) {
		int res = 0;
		String sql = "INSERT INTO tbl_file ( file_no, name, title, cate, ofile, sfile)\r\n"
				+ "VALUES ( seq_tbl_file_seq.nextval,\r\n"
				+ "?,\r\n"
				+ "?,\r\n"
				+ "?,\r\n"
				+ "?,\r\n"
				+ "?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getCate());
			pstmt.setString(4, dto.getOfile());
			pstmt.setString(5, dto.getSfile());
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	public List<FileDto> getList(){
		List<FileDto> list = new ArrayList<>();
		String sql= "SELECT * FROM tbl_file ORDER BY file_no DESC";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("file_no");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String cate = rs.getString("cate");
				String ofile = rs.getString("ofile");
				String sfile = rs.getString("sfile");
				String postdate = rs.getString("postdate");
				
				FileDto dto = new FileDto(no, name, title, cate,
						ofile, sfile, postdate);
				list.add(dto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
		
	}
	

}
