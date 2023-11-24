package com.z3un3un.dao;


import java.sql.SQLException;

import com.z3un3un.common.DBConnPool;
import com.z3un3un.dto.MemberDto;

public class MemberDao extends DBConnPool{
	
	public MemberDto login(String id, String pass) {
		MemberDto memberDto = new MemberDto();
		String sql = "select *\r\n"
				+ "from member\r\n"
				+ "where id=?\r\n"
				+ "and pass=?";
		//입력받은 사용자 정보를 DB로부터 조회
		try {
			
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			rs = pstmt.executeQuery();
			
			//id, pw는 중복되지 않으니까 if문 사용한다!
			if(rs.next()) {
				//로그인 성공
				memberDto.setId(rs.getString(1));
				memberDto.setName(rs.getString(3));
				memberDto.setRegidate(rs.getString(4));
				
				//사용자정보를 MemberDto객체에 담아서 반환
				return memberDto;
			} else {
				//로그인 실패

				
				return null;
				
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
		
		
	}
	//유효성 체크하기
	/*
	 * public MemberDto validation(MemberDto dto) { //MemberDto memberDto = new
	 * MemberDto(); String sql = "select *\r\n" + "from member"; //입력받은 사용자 정보를
	 * DB로부터 조회 try {
	 * 
	 * pstmt = con.prepareStatement(sql); rs = pstmt.executeQuery();
	 * 
	 * //id, pw는 중복되지 않으니까 if문 사용한다! while(rs.next()) { //로그인 성공
	 * rs.getString("id").equals(dto.getId());
	 * rs.getString("email")equals(dto.getEmail());
	 * 
	 * }
	 * 
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); return null; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	
	
	//회원가입 book/register.jsp
	public int register(MemberDto dto) {
		int res = 0;
		String sql = "insert into member (id, pass, name, regidate, email)\r\n"
				+ "values(?, ?, ?, sysdate, ? )";
		String sql2 = "select * from member";
		
		try {
			System.out.println("dto"+dto);
			if(dto.getId() !=null && dto.getName() != null
						&& dto.getPass() != null && dto.getEmail() != null) {
				System.out.println("널이 아니면");
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql2);
/*				while(rs.next()) {

					if(!dto.getId().equals(rs.getString("id"))
								&&!dto.getEmail().equals(rs.getString("email"))) { */
						
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, dto.getId());
						pstmt.setString(2, dto.getPass());
						pstmt.setString(3, dto.getName());
						pstmt.setString(4, dto.getEmail());
						res = pstmt.executeUpdate();
					//}
				//}			
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return res;
		
		
		
		
		
	}


}
