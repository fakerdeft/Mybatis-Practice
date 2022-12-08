package com.kh.mybatis.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.util.BoardConstant;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;
import com.kh.mybatis.common.template.Template;

public class BoardServiceImpl implements BoardService{
	
	@Override
	public int selectListCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = BoardConstant.DAO.selectListCount(sqlSession);
		sqlSession.close();
		return listCount;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = BoardConstant.DAO.selectList(sqlSession,pi);
		sqlSession.close();
		return list;
	}

	@Override
	public int increaseCount(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = BoardConstant.DAO.increaseCount(sqlSession,boardNo);
		if(result > 0) {
			sqlSession.commit();
		}
		if(result <= 0) {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public Board selectBoard(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		Board b = BoardConstant.DAO.selectBoard(sqlSession,boardNo);
		sqlSession.close();
		return b;
	}
	
	@Override
	public ArrayList<Reply> selectReplyList(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Reply> list = BoardConstant.DAO.selectReplyList(sqlSession,boardNo);
		sqlSession.close();
		return list;
	}
	
	@Override
	public int insertReply(Reply reply) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = BoardConstant.DAO.insertReply(sqlSession,reply);
		if(result > 0) {
			sqlSession.commit();
		}
		if(result <= 0) {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}
	
	@Override
	public ArrayList<Board> searchList(Map<String,String> map, PageInfo pi){
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> searchList = BoardConstant.DAO.searchList(sqlSession,map,pi);
		sqlSession.close();
		return searchList;
	}

	//검색결과 개수
	@Override
	public int searchCount(Map<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int searchCount = BoardConstant.DAO.searchCount(sqlSession,map);
		sqlSession.close();
		return searchCount;
	}
	
}
