package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.smhrd.dao.BoardDAO;
import com.smhrd.entity.Board;

public class SearchRestCon implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String search = request.getParameter("search");
		
		BoardDAO dao = new BoardDAO();
		
		List<Board> list = dao.search(search);
		
		Gson gson = new Gson();
		
		String json = gson.toJson(list);
		
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(json);
		
		return null;
	}

}
