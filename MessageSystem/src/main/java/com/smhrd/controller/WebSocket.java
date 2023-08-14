package com.smhrd.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

@ServerEndpoint("/websocket")
public class WebSocket {
	
	private Gson gson = new Gson();
	
	// static 반드시 줘야함 ㅂㄷ....
	private static List<Session> sessionList = new ArrayList<>();
	
	
	// WebSocket으로 브라우저가 접속하면 요청되는 함수	
	  @OnOpen
	  public void handleOpen(Session session) {
	    // 콘솔에 접속 로그를 출력한다.
	    System.out.println("client is now connected...");
	    sessionList.add(session);
	    System.out.println(sessionList);
	    
	  }
	  // WebSocket으로 메시지가 오면 요청되는 함수
	  @OnMessage
	  public void handleMessage(String message) {
	    // 에코 메시지를 작성한다.
	    String replymessage = message;
	    // 에코 메시지를 브라우저에 보낸다.
	    try {
	    	System.out.println(sessionList.size());
	    	for(Session session : sessionList) {
	    		session.getBasicRemote().sendText(replymessage);
	    	}
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	  // WebSocket과 브라우저가 접속이 끊기면 요청되는 함수
	  @OnClose
	  public void handleClose() {
	    // 콘솔에 접속 끊김 로그를 출력한다.
	    System.out.println("client is now disconnected...");
	  }
	  // WebSocket과 브라우저 간에 통신 에러가 발생하면 요청되는 함수.
	  @OnError
	  public void handleError(Throwable t) {
	    // 콘솔에 에러를 표시한다.
	    t.printStackTrace();
	  }

}
