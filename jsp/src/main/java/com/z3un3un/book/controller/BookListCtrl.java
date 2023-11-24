package com.z3un3un.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.z3un3un.book.dao.BookDao;
import com.z3un3un.dto.Criteria;
import com.z3un3un.dto.PageDto;
import com.z3un3un.lib.dto.BookDto;


/**
 * Servlet implementation class BookListCtrl
 */
@WebServlet("/book/list")
public class BookListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자의 요청 정보를 수집한다.
		
		/*
		 * Criteria cri = new Criteria(request.getAttribute("pageNo"),
		 * request.getAttribute("amount"));
		 */
		String pageNo = request.getParameter("pageNo");
		String amount = request.getParameter("amount");
		String searchField = request.getParameter("searchField");
		String searchWord = request.getParameter("searchWord");
		
		System.out.println("pageNo :"+pageNo);
		System.out.println("amount :"+amount);
		Criteria cri = new Criteria(pageNo, amount, searchField, searchWord);
		
		System.out.println(cri);
		BookDao dao = new BookDao();
		List<BookDto> list = dao.getList(cri);
		
		PageDto pageDto = new PageDto(dao.getTotalCnt(cri), cri); 
		
		request.setAttribute("list", list);
		request.setAttribute("pageDto", pageDto);
		dao.close();
		request.getRequestDispatcher("/book/list.jsp").forward(request, response);
	}


}
