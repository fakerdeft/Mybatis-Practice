package com.kh.mybatis.board.model.util;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;

public class BoardConstant {
	public static final Board BOARD = new Board();
	public static final Reply REPLY = new Reply();
	public static final BoardServiceImpl IMPL = new BoardServiceImpl();
	public static final BoardDao DAO = new BoardDao();
}
