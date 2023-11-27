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
 * Servlet implementation class BookRegController
 */
@WebServlet("/book/bookRegProcess")
public class BookRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("get방식 요청입니다. 확인 후 다시 요청해주세요.").append(request.getContextPath();
	}

	/**
	 * 도서 등록후 메세지 처리
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		System.out.println(request.getParameter("content"));
		System.out.println(request.getParameter("imgFile"));
		//도서 등록처리
		BookDao dao = new BookDao();
		int res= dao.bookReg(new BookDto(title, author));
		System.out.println("res"+res);
				
		//입력성공
		if(res>0) {
			request.setAttribute("msg", "등록되었습니다.");
			request.setAttribute("url", "/book/list");
		
		} else { //입력실패
			request.setAttribute("msg", "등록 중 예외가 발생하였습니다. \n관리자에게 문의해주세요.");
			
		}
		
		//페이지 전환(도서등록 성공: 목록 페이지로 이동, 실패: 뒤로가기)
		request.getRequestDispatcher("/book/msgBox.jsp").forward(request, response);
		
		
		dao.close();
	
	
	}

}
