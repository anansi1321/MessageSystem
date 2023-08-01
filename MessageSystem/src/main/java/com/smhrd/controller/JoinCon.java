package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.dao.MemberDAO;
import com.smhrd.entity.Member;

public class JoinCon implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		Member member = new Member();
		member.setEmail(email);
		member.setPw(pw);
		member.setTel(tel);
		member.setAddress(address);
		
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.join(member);
		
		String nextView = "";
		if(cnt > 0) {
			request.setAttribute("email", email);
			nextView = "join_success";
		}else {
			nextView = "goMain.do";
		}
		
		return nextView;
	}

}
