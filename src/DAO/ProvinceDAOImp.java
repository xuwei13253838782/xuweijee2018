package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import domain.Province;
public class ProvinceDAOImp implements ProvinceDAO {
	String url = "jdbc:hsqldb:hsql://localhost";
	String driver = "org.hsqldb.jdbcDriver";
	String user = "sa";
	String pass = "";
	
	/*
	 * (non-Javadoc)查看市级
	 * @see DAO.ProvinceDAO#check(java.lang.String)
	 */
	@Override
	public boolean check(String shi) throws Exception {
		Class.forName(driver);
		String sql = "select * from pro_shi_info where shi =?";
		boolean isHave = false;
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, shi);
			try (ResultSet rs = pstmt.executeQuery();) {
				isHave = rs.next();
			}
		}
		return isHave;
	}
	
	/*
	 * (non-Javadoc)保存市级信息
	 * @see DAO.ProvinceDAO#save_shi(domain.Province)
	 */
	public boolean save_shi(Province pro) throws Exception {
		boolean isSuc = false;
		boolean isHave = false;
		Class.forName(driver);
		String sql = "insert into pro_shi_info(shi) values(?)";
		String sql2 = "select * from pro_shi_info where shi =?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);
				PreparedStatement pstmt2 = con.prepareStatement(sql2);) {
			pstmt2.setString(1, pro.getShi());
			ResultSet rs = pstmt2.executeQuery();
			isHave = rs.next();
			if (isHave == true) {
				return !isHave;
			} else {
				pstmt.setInt(1, pro.getShi_id());
				pstmt.setString(1, pro.getShi());
				int row = pstmt.executeUpdate();
				isSuc = row > 0;
				return isSuc;
			}
		}
	}
	
	/*
	 * (non-Javadoc)市级信息浏览
	 * @see DAO.ProvinceDAO#getAllPros_shi()
	 */
	public List<String[]> getAllPros_shi() throws Exception {
		List<String[]> pros_shi = new ArrayList<>();
		Class.forName(driver);
		String sql = "select * from pro_shi_info order by shi_id asc";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {// 保存每行的数据
					String[] row = new String[2];
					row[0] = rs.getString("shi_id");
					row[1] = rs.getString("shi");
					pros_shi.add(row);

				}
			}
		}
		return pros_shi;
	}

	/*
	 * (non-Javadoc)修改市级信息
	 * @see DAO.ProvinceDAO#update_shi(domain.Province)
	 */
	public boolean update_shi(Province pro) throws Exception {
		boolean isSuc = false;
		boolean isHave = false;
		boolean isqu = false;
		
		Class.forName(driver);
		String sql = "update pro_shi_info set shi=? where shi_id=?";
		String sql2 = "select * from pro_shi_info where shi =?";
		String sql3 = "select * from pro_qu_info where shi=?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);
				PreparedStatement pstmt2 = con.prepareStatement(sql2);
				PreparedStatement pstmt3 = con.prepareStatement(sql3);
				) {
			
			pstmt2.setString(1, pro.getShi());
			ResultSet rs = pstmt2.executeQuery();
			isHave = rs.next();      //从市级数据库查找更新的是否存在该市   如果存在 不能修改 
			
			pstmt3.setString(1, pro.getShi());
			ResultSet rs3 = pstmt3.executeQuery();
			isqu = rs3.next();      //从区级数据库查找更新的是否存在该市   如果存在 不能修改
			if (isHave == true || isqu==true) {   //两个查找  若存在一个为真  则无法进行修改
				return !(isHave||isqu);
			} else {
				pstmt.setString(1, pro.getShi());
				pstmt.setInt(2, pro.getShi_id());
				int row = pstmt.executeUpdate();
				isSuc = row > 0;
			}
			return isSuc;

		}
	}
	
	/*
	 * (non-Javadoc)根据市序号 查找市级信息
	 * @see DAO.ProvinceDAO#findById_shi(int)
	 */
	@Override
	public Province findById_shi(int shi_id) throws Exception {
		Province pro = new Province();
		Class.forName(driver);
		String sql = "select * from pro_shi_info where shi_id=?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
				pstmt.setInt(1, shi_id);
			try (ResultSet rs = pstmt.executeQuery();) {
				rs.next();
				pro.setShi_id(rs.getInt("shi_id"));
				pro.setShi(rs.getString("shi"));

			}
		}
		return pro;
	}
	
	/*
	 * (non-Javadoc)区级信息保存
	 * @see DAO.ProvinceDAO#save_qu(domain.Province)
	 */
	public boolean save_qu(Province pro) throws Exception {
		boolean isSuc = false;
		boolean isHave = false;
		boolean isHave2 = false;
		Class.forName(driver);
		String sql = "insert into pro_qu_info(shi,qu) values(?,?)";
		String sql2 = "select * from pro_qu_info where shi=? and qu =?";
		String sql3 = "select * from pro_shi_info where shi =?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);
				PreparedStatement pstmt2 = con.prepareStatement(sql2);
				PreparedStatement pstmt3 = con.prepareStatement(sql3);) {
			pstmt3.setString(1, pro.getShi());
			ResultSet rs3 = pstmt3.executeQuery();
			isHave2 = rs3.next();
			if (isHave2 == false) {
				return isHave2;
			} else {
				pstmt2.setString(1, pro.getShi());
				pstmt2.setString(2, pro.getQu());
				ResultSet rs = pstmt2.executeQuery();
				isHave = rs.next();
				if (isHave == true) {
					return !isHave;
				} else {
					pstmt.setInt(1, pro.getQu_id());
					pstmt.setString(1, pro.getShi());
					pstmt.setString(2, pro.getQu());
					int row = pstmt.executeUpdate();
					isSuc = row > 0;
					return isSuc;
				}
			}
		}

	}
	
	/*
	 * (non-Javadoc)区级信息列表
	 * @see DAO.ProvinceDAO#getAllPros_qu()
	 */
	public List<String[]> getAllPros_qu() throws Exception {
		List<String[]> pros_qu = new ArrayList<>();
		Class.forName(driver);
		String sql = "select * from pro_qu_info order by qu_id asc";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {// 保存每行的数据
					String[] row = new String[3];
					row[0] = rs.getString("qu_id");
					row[1] = rs.getString("shi");
					row[2] = rs.getString("qu");
					pros_qu.add(row);

				}
			}
		}
		return pros_qu;
	}
	
	/*
	 * (non-Javadoc)区级信息更新
	 * @see DAO.ProvinceDAO#update_qu(domain.Province)
	 */
	public boolean update_qu(Province pro) throws Exception {
		boolean isSuc = false;
		boolean isHave = false;
		Class.forName(driver);
		String sql = "update pro_qu_info set qu=? where qu_id=?";
		String sql2 = "select * from pro_qu_info where shi=? and qu =?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);
				PreparedStatement pstmt2 = con.prepareStatement(sql2);) {
			pstmt2.setString(1, pro.getShi());
			pstmt2.setString(2, pro.getQu());
			ResultSet rs = pstmt2.executeQuery();
			isHave = rs.next();
			if (isHave == true) {
				return !isHave;
			} else {
				pstmt.setString(1, pro.getQu());
				pstmt.setInt(2, pro.getQu_id());
				int row = pstmt.executeUpdate();
				isSuc = row > 0;
			}
			return isSuc;
		}
	}
	
	/*
	 * (non-Javadoc)根据区ID 查找区级信息
	 * @see DAO.ProvinceDAO#findById_qu(int)
	 */
	@Override
	public Province findById_qu(int qu_id) throws Exception {
		Province pro = new Province();
		Class.forName(driver);
		String sql = "select * from pro_qu_info where qu_id=?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, qu_id);
			try (ResultSet rs = pstmt.executeQuery();) {
				rs.next();
				pro.setQu_id(rs.getInt("qu_id"));
				pro.setShi(rs.getString("shi"));
				pro.setQu(rs.getString("qu"));

			}
		}
		return pro;
	}

}
