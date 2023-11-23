package com.z3un3un.lib.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.z3un3un.common.DBConnPool;
import com.z3un3un.lib.dto.BookDto;
import com.z3un3un.lib.dto.Criteria;

public class BookDao extends DBConnPool{
	
	public List<BookDto> getList(Criteria cri){
		List<BookDto> list = new ArrayList<>();
		try {
			if(!"".equals(cri.getSearchWord()) 
					&& !"".equals(cri.getSearchField())){
				pstmt = con.prepareStatement("select * from\r\n"
						+ "(select * from book where "+cri.getSearchField()+" like '%"+cri.getSearchWord()+"%')");
			} else {
				pstmt = con.prepareStatement("select * from book"
						+ " where no between ? and ?");
				pstmt.setInt(1,cri.getStartNo());
				pstmt.setInt(2,cri.getEndNo());
			}
			System.out.println("cri.getSearchField()"+cri.getSearchField());
			System.out.println("cri.getSearchWord()"+cri.getSearchWord());

			rs = pstmt.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String rentyn = rs.getString("rentyn");
				BookDto dto = new BookDto(no, title, author, rentyn);
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int totalCnt(Criteria cri) {
		int res = 0;
		String sql = "select count(*) from book";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				res = rs.getInt(1);
				System.out.println("res"+res);
			}
		} catch (SQLException e) {
			System.out.println("totalCnt오류");
			e.printStackTrace();
		}
		
		return res;
	
		
		
		
	}

}
