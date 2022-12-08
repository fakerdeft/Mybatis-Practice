package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.mybatis.board.model.util.BoardConstant;
import com.kh.mybatis.board.model.vo.Reply;

/**
 * Servlet implementation class ReplyListController
 */
@WebServlet("/rlist.bo")
public class ReplyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplyListController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		ArrayList<Reply> list = BoardConstant.IMPL.selectReplyList(bno);
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(list,response.getWriter());
	}
}
