package com.z3un3un.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {

	public CookieManager() {
		
	}
	
	/*
	 *  쿠키를 생성 후 응답객체에 저장
	 *  
	 *  쿠키를 생성하기 위해 필요한 값
	 *  - 쿠키이름, 쿠키값, 시간 => 매개변수로 받기
	 *  
	 *  사용자에게 응답하기위해서
	 *  - 응답객체를 매개변수로 전달받는다.
	 */
	public static void makeCookie(
			HttpServletResponse response,
			String name,
			String value,
			int time) {
		
		//쿠키 생성
		Cookie cookie = new Cookie(name, value);
		
		//유지기간 설정
		cookie.setMaxAge(time);
				
		//응답객체에 추가
		response.addCookie(cookie);
		
		
	}
	/*
	 * 요청객체로부터 쿠키배열을 가지고 온 뒤
	 * 원하는 쿠키이름을 찾아서 쿠키값을 반환
	 * 
	 * @return
	 */
	public static String readCookie(
			HttpServletRequest request,
			String name) {
		String value = "";
		// 요청객체로부터 쿠키배열을 획득
		// 쿠키배열을 돌면서 쿠키이름이 일치하는 객체가 있는지 확인
		Cookie[] cookies = request.getCookies();
		//브라우저를 통해 처음 접근했을 때
		//쿠키도 하나도 저장되어 있지 않은 경우 getCookies 메서드를 호출하면 null을 반환
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(name.equals(cookie.getName())) {
					value = cookie.getValue();
					break;
				}
			}
		}
		
		return value;
	}
	
	/**
	 * 쿠키를 삭제한다.
	 * @param response
	 * @param name
	 */
	//쿠키 삭제하기
	public static void deleteCookie (
			HttpServletResponse response,
			String name) {
		
		makeCookie(response, name, "", 0); //쿠키생성 메소드 이용하기
	
		
			
	}
	
	
	

}
