package com.z3un3un.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.z3un3un.dao.BoardDao;
import com.z3un3un.dto.Criteria;


@WebServlet("/boardList")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//리스트를 조회하기 위한 파라메터 수집
		Criteria cri = new Criteria(request.getParameter("pageNo"),
								request.getParameter("amount"));
		
		//리스트 조회 후 리퀘스트 영역에 저장
		BoardDao dao = new BoardDao();
		request.setAttribute("list", dao.getList(cri));
		
		//페이지 블럭을 생성하기 위해 필요한 정보를 저장
		//cri : 요청페이지 번호, 페이지 당 게시물 수
		request.setAttribute("cri", cri);
		//totalCnt : 총 게시물의 수
		request.setAttribute("totalCnt", dao.getTotalCnt());

		// 페이지 전환 
		// forward방식으로 전환 하므로 request영역이 공유됨
		dao.close();
		request.getRequestDispatcher("/06session/servletEx/board.jsp")
												.forward(request, response);
		
	}
}
