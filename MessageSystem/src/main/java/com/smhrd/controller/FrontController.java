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
		
		// 메인페이지 이동
		handlerMapping.put("/goMain.do", new GoMainCon() );
		// Ex.06 회원가입 기능 만들기
		handlerMapping.put("/join.do", new JoinCon() );
		// Ex07. 로그인 기능 만들기
		handlerMapping.put("/login.do", new LoginCon() );
		// Ex08. 개인정보수정 페이지로 이동
		handlerMapping.put("/goUpdate.do", new GoUpdateCon() );
		// Ex08. 개인정보수정 기능 만들기
		handlerMapping.put("/update.do", new UpdateCon() );
		// Ex10. 게시글 목록 출력 기능 만들기
		handlerMapping.put("/goBoard.do", new GoBoardCon() );
		// Ex11. 게시글 상세보기 기능 만들기
		handlerMapping.put("/goView.do", new GoViewCon() );
		// Ex12. 게시글 작성하러 가기
		handlerMapping.put("/goWrite.do", new GoWriteCon() );
		// Ex12. 게시글 작성하기
		handlerMapping.put("/write.do", new WriteCon() );
		// Ex13. 아이디 중복체크
		handlerMapping.put("/emailCheck.do", new EmailCheckCon() );
		// Ex14. 게시글 검색하기
		handlerMapping.put("/search.do", new SearchRestCon() );
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
