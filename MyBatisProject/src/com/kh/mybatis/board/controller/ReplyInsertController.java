package com.kh.mybatis.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.board.model.util.BoardConstant;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.member.model.vo.Member;

/**
 * Servlet implementation class ReplyInsertController
 */
@WebServlet("/rinsert.bo")
public class ReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplyInsertController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String content = request.getParameter("content");
		int bno = Integer.parseInt(request.getParameter("bno"));
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		int userNo = loginUser.getUserNo();
		Reply reply = BoardConstant.REPLY;
		reply.setReplyContent(content);
		reply.setRefBno(bno);
		reply.setReplyWriter(String.valueOf(userNo));
		int result = BoardConstant.IMPL.insertReply(reply);
		response.getWriter().print(result);
	}

}
