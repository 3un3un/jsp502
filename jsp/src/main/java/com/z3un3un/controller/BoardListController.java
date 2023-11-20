package com.z3un3un.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.z3un3un.dao.BoardDao;
import com.z3un3un.dto.BoardDto;
import com.z3un3un.dto.Criteria;
import com.z3un3un.dto.PageDto;


@WebServlet("/boardList")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//리스트를 조회하기 위한 파라메터 수집
		Criteria cri = new Criteria(request.getParameter("pageNo"),
								request.getParameter("amount"));
		
		//리스트 조회 후 리퀘스트 영역에 저장
		BoardDao dao = new BoardDao();
		List<BoardDto> list = dao.getList(new Criteria());
		request.setAttribute("list", list);
		
		
		//페이지 블럭을 생성하기 위해 필요한 정보를 저장
		int totalCnt = dao.getTotalCnt();
		PageDto pageDto = new PageDto(totalCnt, cri);
		request.setAttribute("pageDto", pageDto);
		
		// 페이지 전환 
		// forward방식으로 전환 하므로 request영역이 공유됨
		dao.close();
		request.getRequestDispatcher("/06session/servletEx/board.jsp")
												.forward(request, response);
		
	}
}
