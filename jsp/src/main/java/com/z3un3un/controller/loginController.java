package com.z3un3un.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.z3un3un.dao.BoardDao;
import com.z3un3un.dao.MemberDao;
import com.z3un3un.dto.BoardDto;
import com.z3un3un.dto.MemberDto;

@WebServlet("/06session/servletEx/loginProcess")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * Controller의 역할
	 *  - 파라메터 수집
	 *  - 페이지 전환(jsp로 요청을 위임) 
	 *
	 * 사용자의 로그인 요청을 처리
	 * 1. 파라메터 수집(id, pw)
	 * 2. DB로부터 해당 사용자가 있는지 확인
	 * 		2-1. 사용자가 존재하면 로그인 처리(세션에 사용자 정보를 저장)
	 * 		2-2. 사용자가 존재하지 않으면 이전페이지로 넘어가서 오류 메세지를 출력
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//servlet에서 세션을 사용하기 위해서 request로부터 꺼낸다.
		HttpSession session = request.getSession();
		
		//파라메터 수집
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		//사용자정보 인증
		MemberDao dao = new MemberDao();
		MemberDto dto = dao.login(id, pw);
		dao.close();
		
		//페이지 전환
		if(dto != null) {
			//로그인 성공 -> session에 로그인 정보 저장 -> board.jsp 이동
			session.setAttribute("userId", dto.getId());
			session.setAttribute("MemberDto", dto);
			
			//게시글 조회 후 request에 담아준다.
//			BoardDao boardDao = new BoardDao();
//			request.setAttribute("list", boardDao.getList());
//			boardDao.close();
			
			//sendRedirect를 사용할 경우, requeset영역이 공유되지 않기 때문에
			//list값을 화면으로 전달할 수 없어 forward를 사용해야 한다.
			//response.sendRedirect("board.jsp");
			//request.getRequestDispatcher("board.jsp").forward(request, response);
			response.sendRedirect("/boardList");
		} else {
			//로그인 실패
			request.getRequestDispatcher("loginForm.jsp?isError=1").forward(request, response);
		}
		
		
	}

}
