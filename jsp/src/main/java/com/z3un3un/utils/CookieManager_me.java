package com.z3un3un.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager_me {
	
	public CookieManager_me() {
		
	}
	
	public static void makeCookie(String name, String value,
			HttpServletResponse response, int time) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(time);
		response.addCookie(cookie);
		
	}
	//쿠키읽기
	public static String readCookie(String name,
			HttpServletRequest request) {
		String value ="";
		Cookie cookies[] = request.getCookies();
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
	
	public static void deleteCookie(HttpServletResponse response,
			String name) {
		makeCookie(name, "", response, 0);
		
	}
	
	
}


