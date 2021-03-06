package com.cos.hello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cos.hello.config.DBConn;
import com.cos.hello.model.Users;

public class UsersDao {
	public int insert(Users user) {

		// 2번 DB에 연결해서 3가지 값을 INSERT 하기
		StringBuffer sb = new StringBuffer(); // String전용 컬렉션(동기화)
		sb.append("INSERT INTO users(username, password, email) ");
		sb.append("VALUES(?,?,?)");
		String sql = sb.toString(); // String으로 만듦.
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			// 변경된 행의 개수를 리턴
			int result = pstmt.executeUpdate(); // DML 문장은 다 executeUpdate
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}
}
