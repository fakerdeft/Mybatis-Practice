package com.kh.mybatis.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.member.model.vo.Member;
import com.kh.mybatis.member.util.MemberConstant;

/**
 * Servlet implementation class MemberLoginController
 */
@WebServlet("/login.me")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLoginController() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		Member m = MemberConstant.MEMBER;
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		Member loginUser = MemberConstant.IMPL.loginMember(m);
		if(loginUser != null) {//로그인 유저 정보 있을 때
			request.getSession().setAttribute("loginUser", loginUser);
			response.sendRedirect(request.getHeader("referer"));
		}
		if(loginUser == null) {//로그인 정보 없음
			request.setAttribute("errorMsg", "로그인 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
		}
	}
}

























