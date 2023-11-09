package com.z3un3un.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.z3un3un.dao.BoardDao;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/06session/servletEx/detailForm")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
			//게시글 조회 후 request에 담아준다.
			BoardDao boardDao = new BoardDao();
			request.setAttribute("listDetail", boardDao.getDetail("3"));
			boardDao.close();
			
			System.out.println("ㅇㅇ");
			request.getRequestDispatcher("detailForm.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
