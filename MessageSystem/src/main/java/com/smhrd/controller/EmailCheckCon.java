package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.dao.MemberDAO;
import com.smhrd.entity.Member;

public class EmailCheckCon implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		MemberDAO dao = new MemberDAO();
		List<Member> list = dao.check(email);
				
		response.setContentType("text/plain ; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(list.size() == 0) {
			out.print("true");
		}else {
			out.print("false");
		}
		
		// 비동기 통신에 응답하는 경우 null로 유지
		return null;
	}

}
