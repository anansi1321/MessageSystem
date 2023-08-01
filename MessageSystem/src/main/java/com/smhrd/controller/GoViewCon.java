package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.dao.BoardDAO;
import com.smhrd.entity.Board;

public class GoViewCon implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int idx = Integer.parseInt( request.getParameter("idx") );
		
		BoardDAO dao = new BoardDAO();
		
		Board board = dao.view(idx);
		
		request.setAttribute("board", board);
		
		return "viewBoard";
	}

}
