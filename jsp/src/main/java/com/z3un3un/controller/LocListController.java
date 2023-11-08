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
 * URL매핑('/localList') 페이지를 요청하면 실행
 *  - 요청 메서드에 따라서 실행되는 메서드가 결정
 *  
 *  주소표시줄, 링크 -> get방식-> doGet()메서드 사용
 *  
 *  Controller
 *  - 사용자의 요청정보를 수집
 *  - 비지니스 로직 호출(서비스 객체)
 * 	- View로 페이지 전환
 * 
 * 
 * 
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
		
		//DB에 접근해서 리스트를 조회
		LocDao dao = new LocDao(request.getServletContext());
		List<LocDto> list = dao.getList();
		
		request.setAttribute("list", list);
		//Controller에서 화면을 구성하는 태그를 작성하는 것은
		//매우 번거롭기 때문에 JSP를 이용해서 화면을 작성 후 페이지 전환!
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
