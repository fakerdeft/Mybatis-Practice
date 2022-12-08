package com.kh.mybatis.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberLogoutController
 */
@WebServlet("/logout.me")
public class MemberLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLogoutController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.getSession().removeAttribute("loginUser");
//				response.sendRedirect(request.getHeader("referer"));
				response.sendRedirect(request.getContextPath());
				
	}


}
