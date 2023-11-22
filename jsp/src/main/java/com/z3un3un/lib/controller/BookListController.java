package com.z3un3un.lib.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.z3un3un.lib.dao.BookDao;
import com.z3un3un.lib.dto.Criteria;
import com.z3un3un.lib.dto.PageDto;


@WebServlet("/bookList")
public class BookListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 도서목록을 조회 후 request 영역에 저장한다.
	 * bookList.jsp로 foward한다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	BookDao dao = new BookDao();
	
	request.setAttribute("list", dao.getList());
	
	//페이징
	String pageNo = request.getParameter("pageNo");
	String amount = request.getParameter("amount");
	Criteria cri = new Criteria(pageNo, amount);
	int totalCnt = dao.totalCnt(cri);
	PageDto pageDto = new PageDto(totalCnt, cri);
	request.setAttribute("pageDto", pageDto);
	
	
	dao.close();
	request.getRequestDispatcher("/lib/bookList.jsp").forward(request, response);
	}


}
