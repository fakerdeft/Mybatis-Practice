package com.kh.mybatis.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public interface BoardService {
	
	//전체 게시글 개수 조회
	int selectListCount();
	//게시글 목록 전체 조회
	ArrayList<Board> selectList(PageInfo pi);
	
	//게시글 상세 조회
	int increaseCount(int boardNo); //조회수 증가
	Board selectBoard(int boardNo); //하나의 게시글 정보 조회
	
	//댓글
	ArrayList<Reply> selectReplyList(int boardNo);
	int insertReply(Reply reply);
	
	//검색어를 이용한 목록 조회
	ArrayList<Board> searchList(Map<String,String> map, PageInfo pi);
	
	//검색어 조회결과 개수
	int searchCount(Map<String, String> map);
}



















