package com.z3un3un.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.z3un3un.common.DBConnPool;
import com.z3un3un.dto.BookFileDto;
import com.z3un3un.dto.FileDto;

public class BookFileDao extends DBConnPool{
	
	public int regBookFile(BookFileDto dto) {
		int res = 0;
		/*
		 * String sql =
		 * "INSERT INTO book_file ( file_no, title, author, intro, ofile, sfile)\r\n" +
		 * "VALUES ( seq_book_file_seq.nextval,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" +
		 * "?,\r\n" + "?)";
		 */
		
		String sql = "INSERT INTO book_file ( file_no, title, author, intro, ofile, sfile)\r\n"
				+ "VALUES ( seq_book_file_seq.nextval,\r\n"
				+ "?,\r\n"
				+ "?,\r\n"
				+ "?,\r\n"
				+ "?,\r\n"
				+ "?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getAuthor());
			pstmt.setString(3, dto.getIntro());
			pstmt.setString(4, dto.getOfile());
			pstmt.setString(5, dto.getSfile());
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	public List<BookFileDto> getList(){
		List<BookFileDto> list = new ArrayList<>();
		String sql= "SELECT * FROM book_file ORDER BY file_no DESC";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("file_no");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String intro = rs.getString("intro");
				String ofile = rs.getString("ofile");
				String sfile = rs.getString("sfile");
				String postdate = rs.getString("postdate");
				System.out.println("intro"+intro);
				
				BookFileDto dto = new BookFileDto(no, title, author, intro,
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
