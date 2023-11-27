package com.z3un3un.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.z3un3un.dao.MemberDao;
import com.z3un3un.dto.MemberDto;

@WebServlet("/book/regProcess")
public class MemberRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 주소표시줄에 바로 호출하는 경우, 기본방식으로 요청이 되어
	 * 405오류가 발생할 수 있다.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 요청");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.append("post방식으로 요청해주세요.");
	}
	
	/**
	 * 회원가입을 진행한다.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/book/regProcess 요청");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		System.out.println("파라메터:"+id + "/" + name + "/" + pw + "/" + email);
		//pw 체크
		String pwCheck = request.getParameter("pwCheck");
		//dto를 생성
		//if(pw.equals("pwCheck")) { //pw 중복체크 통과해야 db에 접근
			MemberDto dto = new MemberDto(id, pw, pwCheck, name, "", email);
			MemberDao dao = new MemberDao();
			
			

			//회원가입
			int res = dao.register(dto);
			dao.close();
			
			
			//메세지 출력 후 페이지 전환(성공: 로그인페이지, 실패 : 뒤로가기)
			if(res > 0) {
				//회원가입 성공
				System.out.println("성공");
				request.setAttribute("msg", "회원가입 성공! 로그인 후 이용해주세요.");
				request.setAttribute("url", "/06session/servletEx/.jsp");
			} else {
				//회원가입 실패
				//	- 컬럼의 사이즈보다 입력값이 큰 경우, 타입이 맞지않는 경우 -> 입력화면에 유효성검증을 추가하여 해결
				System.out.println("실패");
				request.setAttribute("msg", "회원가입 실패! 관리자에게 문의해주세요.");
			}
			
			//response.sendRedirect("/06session/servletEx/loginForm.jsp");
			//forward 방식으로 페이지 전환 - request영역을 공유
			request.getRequestDispatcher("/book/msgBox.jsp").forward(request, response);
		//}
	}

}
