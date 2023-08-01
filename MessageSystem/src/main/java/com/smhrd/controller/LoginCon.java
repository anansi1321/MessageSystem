package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.dao.MemberDAO;
import com.smhrd.entity.Member;

public class LoginCon implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		Member member = new Member();
		member.setEmail(email);
		member.setPw(pw);
		
		MemberDAO dao = new MemberDAO();
		Member result = dao.login(member);
		
		if(result != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", result);
		}
		
		return "redirect:/goMain.do";
	}

}
