package com.smhrd.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;
import com.smhrd.entity.Member;

public class MemberDAO {
	
	private SqlSessionFactory factory = SqlSessionManager.getSqlSessionFactory();
	
	// Ex06. 회원가입 기능 만들기
	public int join(Member member) {
		
		SqlSession session = factory.openSession(true);
		
		int cnt = session.insert("join", member);
		
		session.close();
		
		return cnt;
	}
	
	// Ex07. 로그인 기능 만들기
	public Member login(Member member) {
		
		SqlSession session = factory.openSession(true);
		
		Member result = session.selectOne("login", member);
		
		session.close();
		
		return result;
	}
	
	// Ex08. 개인정보수정 기능 만들기
	public int update(Member member) {
		
		SqlSession session = factory.openSession(true);
		
		int cnt = session.update("update", member);
		
		session.close();
		
		return cnt;
		
	}
	
	// EX13. 아이디 중복체크
	public List<Member> check(String email) {
		
		SqlSession session = factory.openSession(true);
		
		List<Member>list = session.selectList("check", email);
		
		session.close();
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
}
