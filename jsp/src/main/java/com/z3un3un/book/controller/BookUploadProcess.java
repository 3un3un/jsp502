package com.z3un3un.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.z3un3un.dao.BookFileDao;
import com.z3un3un.dto.BookFileDto;

/**
 * Servlet implementation class BookUploadController
 */
@WebServlet("/book/uploadList")
public class BookUploadProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookFileDao dao = new BookFileDao();
		List<BookFileDto> list = dao.getList();
		
		request.setAttribute("list", list);
		System.out.println(list);
		dao.close();
		request.getRequestDispatcher("/book/bookFileList.jsp").forward(request, response);
	
	
	
	}


}
