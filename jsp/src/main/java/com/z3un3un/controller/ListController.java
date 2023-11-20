package com.z3un3un.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.z3un3un.dao.BoardDao;
import com.z3un3un.dto.BoardDto;
import com.z3un3un.dto.Criteria;


@WebServlet("/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 리스트를 조회 후 반환
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao dao = new BoardDao();
		//request 영역에 list를 담아준다.
		List<BoardDto> list = dao.getList(new Criteria());
		request.setAttribute("list", list);
		
		//forward - request영역을 공유하기 위해서
		request.getRequestDispatcher("/09JSTL/core/list.jsp").forward(request, response);
	}


}
