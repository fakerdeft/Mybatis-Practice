package com.kh.mybatis.member.util;

import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.service.MemberServiceImpl;
import com.kh.mybatis.member.model.vo.Member;

public class MemberConstant {
	public static final Member MEMBER = new Member();
	public static final MemberServiceImpl IMPL = new MemberServiceImpl();
	public static final MemberDao DAO = new MemberDao();
	
}
