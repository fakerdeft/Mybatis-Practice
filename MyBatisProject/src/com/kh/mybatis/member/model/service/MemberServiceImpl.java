package com.kh.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.template.Template;
import com.kh.mybatis.member.model.vo.Member;
import com.kh.mybatis.member.util.MemberConstant;

public class MemberServiceImpl implements MemberService{

	@Override
	public int insertMember(Member m) {
		/*
		 * Connection conn = JDBCTemplate.getConnection();
		 * int result = new MemberDao().insertMember(conn,m);
		 * if(result > 0){
		 * 		JDBCTemplate.commit(conn);
		 * }
		 * if(result <= 0){
		 * 		JDBCTemplate.rollback(conn);
		 * }
		 * JDBCTemplate.close(conn);
		 * return result;
		 */
		SqlSession sqlSession = Template.getSqlSession();
		//connection 객체 대신 sqlSession 객체를 보내준다 (mybatis 전용)
		int result = MemberConstant.DAO.insertMember(sqlSession,m);
		if(result > 0) {
//			JDBCTemplate.commit();
			sqlSession.commit();
		}
		if(result <= 0) {
//			JDBCTemplate.rollback();
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public Member loginMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		Member loginUser = MemberConstant.DAO.loginMember(sqlSession,m);
		sqlSession.close();
		return loginUser;
	}

	@Override
	public int updateMember(Member m) {
		return 0;
	}

	@Override
	public int deleteMember(Member m) {
		return 0;
	}
	
}
