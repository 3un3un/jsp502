package com.z3un3un.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.z3un3un.dao.EmpDao;
import com.z3un3un.dto.EmpDto;


@WebServlet("/empList")
public class EmpListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//DBConnPool -> EmpDao 기본생성자 이용
		//EmpDao dao = new EmpDao(request.getServletContext());
		EmpDao dao = new EmpDao();
		List<EmpDto> list = dao.getList();
		
		request.setAttribute("list", list);
		
		//view페이지로 이동
		request.getRequestDispatcher("jdbc/empList.jsp")
									.forward(request, response);
		
		
		
	}
	

}
