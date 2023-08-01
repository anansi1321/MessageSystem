package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.reflection.DefaultReflectorFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.smhrd.dao.BoardDAO;
import com.smhrd.entity.Board;

public class WriteCon implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 파일 저장 위치
		// webapp에 save 폴더 만들고
		String savePath = request.getServletContext().getRealPath("save");
		// 최대 파일 사이즈(byte)
		int maxSize = 5 * 1024 * 1024; // 5Mb
		// 인코딩 방식
		String encoding = "UTF-8";
		
		// MultiPartRequest 생성
		MultipartRequest multi = new MultipartRequest(request,
				savePath,
				maxSize,
				encoding,
				new DefaultFileRenamePolicy());
		
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		
		// 파일 이름 가져오기, 이때 저장됨
		String img = multi.getFilesystemName("file");
		
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setImg(img);
		
		BoardDAO dao = new BoardDAO();
		
		int cnt = dao.write(board);
		
		String nextView = "";
		if(cnt > 0) {
			nextView = "redirect:/goBoard.do";
		}else {
			nextView = "redirect:/goWrite.do";
		}
		
		return nextView;
	}

}
