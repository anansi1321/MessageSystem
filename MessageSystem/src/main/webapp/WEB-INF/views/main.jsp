<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="UTF-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header" class="alt">
						<a href="index.html" class="logo"><strong>Forty</strong> <span>by HTML5 UP</span></a>
						<nav>
							<!--Ex07. 로그인 한 상태라면 '게시판'버튼과 '개인정보수정', '로그아웃' 버튼을 출력하시오. -->
								<c:if test="${empty user}">
									<a href="#menu">로그인</a>
								</c:if>
								<c:if test="${!empty user}">
									<a href="goBoard.do">게시판</a>
									<a href="goUpdate.do">개인정보수정</a>
									<a href="#">로그아웃</a>
								</c:if>
						</nav>
					</header>

				<!-- Menu -->
					<nav id="menu">	
						<ul class="links">
							<%--Ex07. 로그인 기능 만들기 : 사용자에게 정보를 입력받아 회원인지 아닌지 조회하는 기능을 만들어 봅시다. --%>
							<li><h5>로그인</h5></li>
								<form action="login.do" method="post">
									<li><input name="email" type="text"  placeholder="Email을 입력하세요"></li>
									<li><input name="pw" type="password"  placeholder="PW를 입력하세요"></li>
									<li><input type="submit" value="LogIn" class="button fit"></li>
								</form>
						</ul>
						<ul class="actions vertical">
							<%--Ex06. 회원가입 기능 만들기 : 사용자에게 정보를 입력받아 저장하는 기능을 만들어 봅시다. --%>
							<li><h5>회원가입</h5></li>
								<form action="join.do" method="post">
									<li><input id="checkInput" name="email" type="text"  placeholder="Email을 입력하세요"></li>
									<p id="checkResult"></p>
									<li><input name="pw" type="password"  placeholder="PW를 입력하세요"></li>
									<li><input name="tel" type="text"  placeholder="전화번호를 입력하세요"></li>
									<li><input name="address" type="text"  placeholder="집주소를 입력하세요"></li>
									<li><input type="submit" value="JoinUs" class="button fit"></li>
								</form>
						</ul>
					</nav>			
				<!-- Banner -->
					<section id="banner" class="major">
						<div class="inner">
							<header class="major">
								<%--Ex07. 로그인 후 로그인 한 사용자의 세션아이디로 바꾸시오. ex)smart님 환영합니다 --%>
									<c:if test="${empty user}">
										<h1>로그인 한 세션아이디를 출력해주세요</h1>
									</c:if>
									<c:if test="${!empty user}">
										<h1>${user.email}님 환영합니다.</h1>
									</c:if>
							</header>
							<div class="content">
								<p>아래는 지금까지 배운 웹 기술들입니다.<br></p>
								<ul class="actions">
									<li><a href="#one" class="button next scrolly">확인하기</a></li>
								</ul>
							</div>
						</div>
					</section>

				<!-- Main -->
					<div id="main">

						<!-- One -->
							<section id="one" class="tiles">
								<article>
									<span class="image">
										<img src="images/pic01.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">HTML</a></h3>
										<p>홈페이지를 만드는 기초 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic02.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">CSS</a></h3>
										<p>HTML을 디자인해주는 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic03.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">Servlet/JSP</a></h3>
										<p>Java를 기본으로 한 웹 프로그래밍 언어/스크립트 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic04.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">JavaScript</a></h3>
										<p>HTML에 기본적인 로직을 정의할 수 있는 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic05.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">MVC</a></h3>
										<p>웹 프로젝트 중 가장 많이 사용하는 디자인패턴</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic06.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">Web Project</a></h3>
										<p>여러분의 최종프로젝트에 웹 기술을 활용하세요!</p>
									</header>
								</article>
							</section>
					<!-- Two -->
							<section id="two">
								<div class="inner">
									<header class="major">
										<h2>메세지 확인하기</h2>
									</header>
									<%-- chatting 기능을 만들어 봅시다! --%>
									<div class="container chat" id="messageBox">
									
										<div class="other">
											<p>보낸사람 이름 :</p>
											<p>다른사람에게서 온 메세지</p>
										</div>
										
										<div class="mychat">
											<p>내가보낸 채팅</p>
										</div>
										
										<div class="other">
											<p>보낸사람 이름2 :</p>
											<p>다른사람에게서 온 메세지2</p>
										</div>
										
										
									</div>
									<%-- 채팅창 끝! --%>
								</div>
							</section>

					</div>

				<!-- Contact -->
					<section id="contact">
						<div class="inner">
							<section>
								<form>
									<div class="field">
										<label for="message">Message</label>
										<textarea  id="message" rows="6"></textarea>
									</div>
									<ul class="actions">
										<li><input id="sendBtn" type="button" value="Send Message" class="special" /></li>
										<li><input type="reset" value="Clear" /></li>
									</ul>
								</form>
							</section>
							
							<%--Ex07. 로그인 한 사용자의 정보로 변경해 봅시다. --%>
							<section class="split">
								<section>
									<div class="contact-method">
										<span class="icon alt fa-envelope"></span>
										<h3>Email</h3>
										<c:if test="${empty user}">
										<a href="#">로그인 한 사람의 이메일을 출력</a>
										</c:if>
										<c:if test="${!empty user}">
										<a href="#">${user.email}</a>
										</c:if>
										<!-- 로그인 한 사용자의 이메일을 출력하시오 -->
									</div>
								</section>
								<section>
									<div class="contact-method">
										<span class="icon alt fa-phone"></span>
										<h3>Phone</h3>
										<c:if test="${empty user}">
										<span>로그인 한 사람의 전화번호를 출력</span>
										</c:if>
										<c:if test="${!empty user}">
										<span>${user.tel}</span>
										</c:if>
										<!-- 로그인 한 사용자의 전화번호를 출력하시오 -->
									</div>
								</section>
								<section>
									<div class="contact-method">
										<span class="icon alt fa-home"></span>
										<h3>Address</h3>
										<c:if test="${empty user}">
										<span>로그인 한 사람의 집주소를 출력</span>
										</c:if>
										<c:if test="${!empty user}">
										<span>${user.address}</span>
										</c:if>
										<!-- 로그인 한 사용자의 집주소를 출력하시오 -->
									</div>
								</section>
							</section>					
						</div>
					</section>

				<!-- Footer -->
					<footer id="footer">
						<div class="inner">
							<ul class="icons">
								<li><a href="#" class="icon alt fa-twitter"><span class="label">Twitter</span></a></li>
								<li><a href="#" class="icon alt fa-facebook"><span class="label">Facebook</span></a></li>
								<li><a href="#" class="icon alt fa-instagram"><span class="label">Instagram</span></a></li>
								<li><a href="#" class="icon alt fa-github"><span class="label">GitHub</span></a></li>
								<li><a href="#" class="icon alt fa-linkedin"><span class="label">LinkedIn</span></a></li>
							</ul>
							<ul class="copyright">
								<li>&copy; Untitled</li><li>Design: <a href="https://html5up.net">HTML5 UP</a></li>
							</ul>
						</div>
					</footer>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
			<script src="assets/js/Ex13.js"></script>
			<c:if test="${!empty user}">
			<script type="text/javascript">
			      // 「WebSocketEx」는 프로젝트 명
			      // 「websocket」는 호스트 명
			      // WebSocket 오브젝트 생성 (자동으로 접속 시작한다. - onopen 함수 호출)
			      let webSocket;
			      const messageTextArea = $("#messageBox");
			      user = '${user.email}'
			      $(document).ready(function() {
			    	  
			    	  messageTextArea.html('');
			    	  
				      webSocket = new WebSocket("ws://localhost:8081/MessageSystem/websocket");
				      // 콘솔 텍스트 에리어 오브젝트
				      // WebSocket 서버와 접속이 되면 호출되는 함수
				      webSocket.onopen = function(message) {
				        // 콘솔 텍스트에 메시지를 출력한다.
				        messageTextArea.append("<p class='mychat'>Server connect...\n</p>");
				      };
				      // WebSocket 서버와 접속이 끊기면 호출되는 함수
				      webSocket.onclose = function(message) {
				        // 콘솔 텍스트에 메시지를 출력한다.
				        messageTextArea.append("<p class='mychat'>Server Disconnect...\n</p>");
				      };
				      // WebSocket 서버와 통신 중에 에러가 발생하면 요청되는 함수
				      webSocket.onerror = function(message) {
				        // 콘솔 텍스트에 메시지를 출력한다.
				        messageTextArea.append("<p class='mychat'>error...\n</p>");
				      };
				      // WebSocket 서버로 부터 메시지가 오면 호출되는 함수
				      webSocket.onmessage = function(message) {
				        // 콘솔 텍스트에 메시지를 출력한다.
				        
				        var msg = JSON.parse(message.data);
				      	console.log(msg.email + " : " + user);
				        
				        if(msg.email != user){
				        	console.log('gd')
				        	html = `
							<div class="other">
								<p>\${msg.email} :</p>
								<p>\${msg.message}</p>
							</div>
				        	`;
				        	
				        	messageTextArea.append(html);
				        }
				        
				      };
				      
				      $('#sendBtn').on('click', sendMessage);
			      });
			      
			     // Send 버튼을 누르면 호출되는 함수
			    function sendMessage() {
			      // 송신 메시지를 작성하는 텍스트 박스 오브젝트를 취득한다.
			      var message = $("#message");
			      // 콘솔 텍스트에 메시지를 출력한다.
			      let today = new Date();   

			      msg = {
			    		  'email' : user,
			    		  'message' : message.val(),
			    		  'indate' : today.toLocaleDateString() + ' ' + today.toLocaleTimeString()
			      }
			      
			      html = `
			    	<div class="mychat">
						<p>\${message.val()}</p>
					</div>
			      `;
			      
			      messageTextArea.append(html);
			      // WebSocket 서버에 메시지를 송신한다.
			      webSocket.send(JSON.stringify(msg));
			      // 송신 메시지를 작성하는 텍스트 박스를 초기화한다.
			      message.val('');
			    }
			    			     
			    // Disconnect 버튼을 누르면 호출되는 함수
			    function disconnect() {
			      // WebSocket 접속 해제
			      webSocket.close();
			    }
			  </script>
			  </c:if>
	</body>
</html>

