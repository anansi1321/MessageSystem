package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.dao.MemberDAO;
import com.smhrd.entity.Member;

public class UpdateCon implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		HttpSession session = request.getSession();
		Member user = (Member)session.getAttribute("user");
		String email = user.getEmail();
		
		Member member = new Member();
		member.setEmail(email);
		member.setPw(pw);
		member.setTel(tel);
		member.setAddress(address);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.update(member);
		
		if(cnt > 0 ) {
			session.setAttribute("user", member);
		}
		
		return "redirect:/goMain.do";
	}

}
