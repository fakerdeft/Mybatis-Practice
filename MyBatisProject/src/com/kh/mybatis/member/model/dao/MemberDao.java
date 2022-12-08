package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {

	public int insertMember(SqlSession sqlSession, Member m) {
		/*
		 * int result = 0; //처리된 행 수 전달받기 위한 변수
		 * PreparedStatement pstmt = null;
		 * String sql = prop.getProp~
		 * pstmt = conn.prepareStatement(sql);
		 * result = pstmt.executeUpdate();
		 */
		/*
		 * mybatis 에서는 sqlSession에서 제공하는 메서드를 통해 sql문을 찾아 실행하고
		 * 결과를 받는다.
		 * sqlSession.sql문 종류에 따른 메서드("매퍼파일 별칭.sql문 id","sql문 완성시킬 객체(파라미터)")
		 * -sql문이 완성상태라면 sql문 완성시킬 객체(파라미터[전달값])은 생략이 가능하다.
		 */
		int result = sqlSession.insert("memberMapper.insertMember",m);
		return result;
	}

	public Member loginMember(SqlSession sqlSession, Member m) {
		//selectOne 메서드: 
		return sqlSession.selectOne("memberMapper.selectMember",m);
	}
}

















