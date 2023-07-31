package com.smhrd.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 5. if문 대신 HashMap을 이용해 구현하기
	private HashMap<String, Controller> handlerMapping;
	
	public void init() throws ServletException {
		
		handlerMapping = new HashMap<String, Controller>();
		
		handlerMapping.put("/goMain.do", new GoMainCon() );
	
	}
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. UrlMapping 가져오기
		// 전체 uri
		String uri = request.getRequestURI();
		// Context path
		String cpath = request.getContextPath();
		// 슬라이싱
		String urlMapping = uri.substring(cpath.length());
		
		System.out.println(urlMapping);
		
		// ======================================================================
		// 2. URLMapping 구분하기
		
		Controller con = handlerMapping.get(urlMapping);
		
		// 3. 실행하고 View 받아오기
		String nextPage = null;
		if(con != null) {
			nextPage = con.execute(request, response);
		}
		// ======================================================================
		
		// 4. View 선택하기
		if(nextPage != null) {
			
			if(nextPage.contains("redirect:/")) {
				response.sendRedirect(nextPage.split(":/")[1]);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher( "WEB-INF/views/" + nextPage + ".jsp");
				rd.forward(request, response);
			}

		}
		
	}

}
