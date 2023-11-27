package com.z3un3un.book.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.z3un3un.common.DBConnPool;
import com.z3un3un.dto.Criteria;
import com.z3un3un.lib.dto.BookDto;

public class BookDao extends DBConnPool{
	/**
	 * 도서목록을 조회 후 반환한다.
	 */
	public List<BookDto> getList(Criteria cri){
		List<BookDto> list = new ArrayList<>();
		String where="";
		if(!"".equals(cri.getSearchField()) && !"".equals(cri.getSearchWord())) {
			where="where "+cri.getSearchField()
				+" like '%"+cri.getSearchWord()+"%'";
		}
		String sql = "select *\r\n"
				+ "    from book\r\n"
				+where
				+ "    order by no desc";
		
		try {
			//pageingQuery를 이용시 페이지 처리를 위한 파라메터를 세팅해줘야 한다.
			sql = pageingQuery(sql);
			
			System.out.println("sql\n" + sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cri.getStartNum());
			pstmt.setInt(2, cri.getEndNum());
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
	
	/**
	 * 도서의 상세 정보를 조회 후 반환한다.
	 * @param no
	 * @return 도서정보(BookDto)
	 */
	public BookDto view(String no) {
		String sql ="select * from book where no = ?";
		BookDto dto = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String num = rs.getString("no");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String rentyn = rs.getString("rentyn");
				dto = new BookDto(num, title, author, rentyn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
	/**
	 * 도서의 총 건수를 조회한다.
	 * @return
	 */
	public int getTotalCnt(Criteria cri) {
		String where="";
		if(!"".equals(cri.getSearchField()) && !"".equals(cri.getSearchWord())) {
			where="where "+cri.getSearchField()
				+" like '%"+cri.getSearchWord()+"%'";
		}
		int res = 0;
		String sql = "select count(*) from book " + where;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				res = rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}
	
	
	/**
	 * 도서의 상세 정보를 조회 후 반환한다.
	 * @param no
	 * @return 도서정보(BookDto)
	 */
	public int bookReg(BookDto dto) {
		int res = 0;
		String sql ="INSERT INTO BOOK (no, title, rentyn, author)\r\n"
				+ "		VALUES (seq_book_no.nextval, ?, 'N', ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getAuthor());
			System.out.println(dto.getTitle()+" / "+dto.getAuthor());
			res = pstmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

}
