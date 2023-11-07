package com.z3un3un.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.z3un3un.dao.LocDao;
import com.z3un3un.dto.LocDto;

/**
 * Servlet implementation class LocListController
 */
@WebServlet("/localList")
public class LocListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//DV에 접근해서 리스트를 조회
		LocDao dao = new LocDao(request.getServletContext());
		List<LocDto> list = dao.getList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("localList.jsp").forward(request, response);
		
		//PrintWriter out = response.getWriter();
		//out.print("<h2>안녕하세요</h2>");
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
