package com.z3un3un.dao.me;

import java.sql.SQLException;

import com.z3un3un.common.DBConnPool;
import com.z3un3un.dto.me.MemberDto;


public class MemberDao extends DBConnPool{
	
	public MemberDto login(String id, String pw) {
		MemberDto memberDto = new MemberDto();
		String sql = "select * from member where id=? and pass=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			if(rs.next()) { 
				memberDto.setId(rs.getString(1));
				memberDto.setName(rs.getString(3));
				memberDto.setRegidate(rs.getString(4));
				
				return memberDto;
			} else {
				return null;
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//rs.close() <-??
		return null;
		
	}
	

}
