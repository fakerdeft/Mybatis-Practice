package com.kh.mybatis.member.model.service;

import com.kh.mybatis.member.model.vo.Member;

//인터페이스: 상수필드(static final)
public interface MemberService {
	//회원가입 메서드
	int insertMember(Member m);
	//로그인 메서드
//	Member loginMember(String userId, String userPwd);
	Member loginMember(Member m);
	//회원 정보 수정용 메서드
	int updateMember(Member m);
	//회원 탈퇴 메서드
	int deleteMember(Member m);
}
