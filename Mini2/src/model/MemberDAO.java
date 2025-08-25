package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	private PreparedStatement psmt = null;
	private Connection conn = null;
	private ResultSet rs = null;

	//드라이버로딩
	private void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-cgi.smhrd.com:1524:xe";
	        String user = "CGI_25IS_GA_P1_4";
	        String password = "smhrd4";
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//자원반납
	private void getClose() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//회원가입 메소드
	public int Join(MemberVO mvo) {
		int row = 0;
		try {
			String sql = "INSERT INTO NUMBASE (ID,PW,NAME) VALUES(?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mvo.getId());
			psmt.setString(2, mvo.getPw());
			psmt.setString(3, mvo.getName());
			row = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;
	}
	//로그인 메소드
	public String login(MemberVO mvo) {
		String name = null;
		try {
			getConn();
			String sql = "SELECT ID,NAME FROM MEMBER WHERE ID = ? AND PW = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mvo.getId());
			psmt.setString(2, mvo.getPw());
			rs = psmt.executeQuery();
			
			if(rs.next() == true) {
				name = rs.getString("name");
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return name;
	}
	
	//게임이 종료되었을 떄 점수가 디비에 들어가야되는지?
	//만들어보니 느낀건 성별이 굳이 필요한지?
	//erd쪽은 다시 얘기 나눠봐야될듯
	
	
}