package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	/*
	 * 기존 JDBC
	 * public static Connection getConnection(){
	 * 	//driver.properties 파일 읽어서 해당 DB와 접속된 connection 객체 생성 및 반환
	 * }
	 * 
	 * public static void close(jdbc용 객체 some){
	 *  //전달받은 connection 객체를 반납시키는 구문
	 * }
	 * 
	 */
	
	//마이바티스
	
	public static SqlSession getSqlSession() {
		//mybatis-config 파일을 읽어서 해당 db와 연결된 sqlSession을 생성하여 반환
		SqlSession sqlSession = null;
		
		//SqlSession 객체를 생성하기 위해선 SqlSessionFactory 객체가 필요
		//SqlSessionFactory 객체를 생성하기 위해선 SqlSessionFactoryBuilder객체가 필요
		
		// /는 최상위 폴더를 의미한다.
		String resource = "/mybatis-config.xml"; //mybatis-config 파일을 읽어야하니 경로 설정.
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource); //자원으로부터 통로를 열겠다.
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			/*
			 * 순서
			 * 1.mybatis-config.xml 파일 경로 지정
			 * 2.inputStream생성 (config파일로부터 통로를 얻어내겠다)
			 * 3.얻어낸 stream으로 builder를 이용하여 sessionFactory객체 생성
			 * 4.생성된 sessionFactory객체로 sqlSession객체 생성	
			 */
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
	
}


























