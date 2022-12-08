package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardDao {

	public int selectListCount(SqlSession sqlSession) {
//		int listCount = sqlSession.selectOne("boardMapper.selectListCount");
//		return listCount;
		return sqlSession.selectOne("boardMapper.selectListCount");
	}

	//전체 게시글 리스트 조회
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) {
		/*
		 * 마이바티스에서 페이징 처리를 위해 제공하는 RowBounds 클래스를 이용해보자.
		 * 
		 * offset: 몇 개의 게시글을 건너뛰고 조회할 것인지에 대한 값
		 * limit: 몇 개를 조회할 것인지
		 * 
		 * boardLimit이 5일 경우
		 * 
		 * currentPage(현재 페이지): 1일 경우 보여줘야 하는 게시글은 1~5
		 * 						-이때 offset은 0 (하나도 건너뛰면 안됨)
		 * currentPage(현재 페이지): 2일 경우 보여줘야 하는 게시글은 6~10
		 * 						-이때 offset은 5 (5개의 게시글을 건너뛰고 보여줘야 6부터 보여줄 수 있음)
		 * currentPage(현재 페이지): 3일 경우 보여줘야 하는 게시글은 11~15
		 * 						-이때 offset은 10 (10개의 게시글을 건너뛰고 보여줘야 11부터 보여줄 수 있음)
		 * 
		 * 현재 페이지 - 1 * boardLimit
		 */
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset,limit);
		/*
		 * RowBounds 객체를 넘겨야할 경우
		 * selectList 메서드의 오버로딩된 형태를 지켜줘야 하기 때문에 매개변수 3개짜리 형식을 지켜야한다.
		 * 이때 2번째 매개변수로 넘길 값이 없다면 비워두는 것이 아니라 null값을 넣음으로써 형식을 지킨다.
		 */
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
		return list;
	}

	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount",boardNo);
	}

	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard",boardNo);
	}

	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo) {
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo);
	}

	public int insertReply(SqlSession sqlSession, Reply reply) {
		return sqlSession.insert("boardMapper.insertReply",reply);
	}

	public ArrayList<Board> searchList(SqlSession sqlSession, Map<String, String> map) {		
		return (ArrayList)sqlSession.selectList("boardMapper.searchList",map);
	}

	public int searchCount(SqlSession sqlSession, Map<String, String> map) {		
		return sqlSession.selectOne("boardMapper.searchCount",map);
	}

	public ArrayList<Board> searchList(SqlSession sqlSession, Map<String, String> map, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset,limit);
		return (ArrayList)sqlSession.selectList("boardMapper.searchList",map,rowBounds);
	}
}




















