package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardService;
import com.kh.mybatis.board.model.util.BoardConstant;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.model.vo.PageInfo;
import com.kh.mybatis.common.template.Pagination;

/**
 * Servlet implementation class BoardSearchController
 */
@WebServlet("/search.bo")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSearchController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService boardService = BoardConstant.IMPL;
		String category = request.getParameter("category");
		String keyword = request.getParameter("keyword");
		Map<String,String> map = new HashMap<>();
		map.put("category",category);
		map.put("keyword",keyword);
		//페이징 처리
//		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int searchCount = BoardConstant.IMPL.searchCount(map); //검색결과의 총 개수를 알아와야 함
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageLimit = 10;
		int boardLimit = 5;
		PageInfo pi = Pagination.getPageinfo(searchCount, currentPage, pageLimit, boardLimit);
		//조회
		ArrayList<Board> searchList = BoardConstant.IMPL.searchList(map,pi);
		request.setAttribute("list", searchList);
		request.setAttribute("pi", pi);
		
		//검색 조회시 사용된 category와 keyword를 같이 view로 보내주기
		request.setAttribute("category", category);
		request.setAttribute("keyword", keyword);
		request.getRequestDispatcher("WEB-INF/views/board/boardSearchListView.jsp").forward(request, response);
	}
}
















