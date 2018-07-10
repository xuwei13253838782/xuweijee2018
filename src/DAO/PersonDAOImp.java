package DAO;

import java.sql.*;

import domain.Person;

public class PersonDAOImp implements PersonDAO {
	String url = "jdbc:hsqldb:hsql://localhost";
	String driver = "org.hsqldb.jdbcDriver";
	String user = "sa";
	String pass = "";

	@Override
	public boolean check(String username) throws Exception {
		Class.forName(driver);
		String sql = "select * from person_info where username =?";
		boolean isHave = false;
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, username);
			try (ResultSet rs = pstmt.executeQuery();) {
				isHave = rs.next();
			}
		}
		return isHave;
	}

	public boolean save(Person pers) throws Exception {
		boolean isSuc = false;
		boolean isHave = false;
		boolean isHave2= false;
		Class.forName(driver);
		String sql = "insert into person_info(phone_number,username,pass) values(?,?,?)";
		String sql2 = "select * from person_info where username =?";
		String sql3 = "select * from person_info where phone_number =?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);
				PreparedStatement pstmt2 = con.prepareStatement(sql2);
				PreparedStatement pstmt3 = con.prepareStatement(sql3);) {

			pstmt2.setString(1, pers.getUsername());
			pstmt3.setString(1, pers.getPhone_number());
			ResultSet rs2 = pstmt2.executeQuery();
			ResultSet rs3 = pstmt3.executeQuery();
			isHave = rs2.next();
			isHave2= rs3.next();
			if(isHave==true || isHave2==true ) {
				return !(isHave||isHave2);
			}else {
			pstmt.setString(1, pers.getPhone_number());
			pstmt.setString(2, pers.getUsername());
			pstmt.setString(3, pers.getPass());
			int row = pstmt.executeUpdate();
			isSuc = row > 0;

			return isSuc;
			}
		}
		
	}

}
