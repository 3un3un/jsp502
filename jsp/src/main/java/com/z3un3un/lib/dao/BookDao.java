package com.z3un3un.lib.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.z3un3un.common.DBConnPool;
import com.z3un3un.lib.dto.BookDto;
import com.z3un3un.lib.dto.Criteria;

public class BookDao extends DBConnPool{
	
	public List<BookDto> getList(){
		String sql = "select * from book";
		List<BookDto> list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String title = rs.getString("title");
				String author = rs.getString("author");
				
				BookDto dto = new BookDto(no, title, author);
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int totalCnt(Criteria cri) {
		int tot = 0;
		String sql = "select count(*) from book where ";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				tot = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tot;
	
		
		
		
	}

}
