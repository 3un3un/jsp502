package com.z3un3un.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.z3un3un.book.dao.BookDao;
import com.z3un3un.lib.dto.BookDto;

/**
 * Servlet implementation class BookViewController
 */
@WebServlet("/book/view")
public class BookViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

/**
 * 도서정보를 조회 후 view.jsp 이동한다.
 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao dao = new BookDao();
		String no = request.getParameter("no");
		BookDto dto = dao.view(no);
		System.out.println("no: "+no);
		request.setAttribute("bookDto", dto);
		
		dao.close();
		request.getRequestDispatcher("/book/view.jsp")
								.forward(request, response);
	
	}


}
