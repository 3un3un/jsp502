package com.z3un3un.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.z3un3un.dao.BoardDao;
import com.z3un3un.dto.BoardDto;


@WebServlet("/boardRead")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			//사용자의 요청 파라메터 수집
			String num = request.getParameter("num");
			System.out.println("요청 게시글번호 : " + num);
			//1건의 게시글을 조회
			BoardDao dao = new BoardDao();
			//상세보기 조회
			BoardDto dto = dao.getOne(num);
			request.setAttribute("dto", dto);
			//조회수 증가
			dao.visitcountUp(num);
			//삭제하기
			request.setAttribute("num", num);
			
			dao.close();
			
			//페이지 전환
			//forward방식으로 전환하므로 request영역이 공유됨
			request.getRequestDispatcher("/06session/servletEx/boardRead.jsp").forward(request, response);
	
	}


}
