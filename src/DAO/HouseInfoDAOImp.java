package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.HouseInfo;
import domain.Province;

public class HouseInfoDAOImp implements HouseInfoDAO {
	String url = "jdbc:hsqldb:hsql://localhost";
	String driver = "org.hsqldb.jdbcDriver";
	String user = "sa";
	String pass = "";
	/*
	 * (non-Javadoc)浏览自己的出租信息
	 * @see DAO.HouseInfoDAO#getAllrent_house(java.lang.String)
	 */
	public List<String[]> getAllrent_house(String username) throws Exception {
		List<String[]> hfs = new ArrayList<>();
		Class.forName(driver);
		String sql = "select * from rent_house_info where username=?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, username);
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {// 保存每行的数据
					String[] row = new String[20];
					row[0] = rs.getString("id");
					row[1] = rs.getString("username");
					row[2] = rs.getString("house_various");
					row[3] = rs.getString("house_address_shi");
					row[4] = rs.getString("house_address_qu");
					row[5] = rs.getString("house_shi");
					row[6] = rs.getString("house_ting");
					row[7] = rs.getString("house_wei");
					row[8] = rs.getString("house_area");
					row[9] = rs.getString("house_cost");
					row[10] = rs.getString("house_title");
					row[11] = rs.getString("ruzhu_time");
					row[12] = rs.getString("contact");
					hfs.add(row);

				}
			}
		}
		return hfs;
	}
	/*
	 * (non-Javadoc)浏览所有出租信息
	 * @see DAO.HouseInfoDAO#getAllrent_all_house()
	 */
	public List<HouseInfo> getAllrent_all_house(int pageSize, int pageNow) throws Exception {
		List<HouseInfo> hfs = new ArrayList<HouseInfo>();
		
		Class.forName(driver);
		String sql = String.format("select limit %d %d * from rent_house_info",((pageNow-1)*pageSize),pageSize);
		try (
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {// 保存每行的数据
					HouseInfo hf=new HouseInfo();
					hf.setId(rs.getInt("id"));
					
					hf.setUsername(rs.getString("username"));
					hf.setHouse_various(rs.getString("house_various"));
					hf.setHouse_address_shi(rs.getString("house_address_shi"));
					hf.setHouse_address_qu(rs.getString("house_address_qu"));
					hf.setHouse_shi(rs.getString("house_shi"));
					hf.setHouse_ting(rs.getString("house_ting"));
					hf.setHouse_wei(rs.getString("house_wei"));
					hf.setHouse_area(rs.getInt("house_area"));
					hf.setHouse_cost(rs.getInt("house_cost"));
					hf.setHouse_title(rs.getString("house_title"));
					hf.setRuzhu_time(rs.getString("ruzhu_time"));
					hf.setContact(rs.getString("contact"));
					hfs.add(hf);
				

				}
			}
		
			return hfs;
		}
	}
	
	/*
	 * (non-Javadoc)出租信息发布保存
	 * @see DAO.HouseInfoDAO#save_rent(java.lang.String, domain.HouseInfo)
	 */
	@Override
	public boolean save_rent(String username,HouseInfo hf) throws Exception {
		boolean isSuc = false;
		boolean isHave=false;
		Class.forName(driver);
		String sql = "insert into rent_house_info(username,house_various,house_address_shi,house_address_qu,"
				+ "house_shi,house_ting,house_wei,"
				+ "house_area,house_cost,"
				+ "house_title,ruzhu_time,contact) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql2 = "select * from pro_qu_info where shi=? and qu =?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);
				PreparedStatement pstmt2 = con.prepareStatement(sql2);
				) {
			pstmt2.setString(1, hf.getHouse_address_shi());
			pstmt2.setString(2, hf.getHouse_address_qu());
			ResultSet rs = pstmt2.executeQuery();
			isHave = rs.next();
			if (isHave == false) {
				return isHave;
			} else {
			pstmt.setString(1, username);
			pstmt.setString(2,hf.getHouse_various());
			pstmt.setString(3, hf.getHouse_address_shi());
			pstmt.setString(4, hf.getHouse_address_qu());
			pstmt.setString(5, hf.getHouse_shi());
			pstmt.setString(6, hf.getHouse_ting());
			pstmt.setString(7, hf.getHouse_wei());
			pstmt.setInt(8, hf.getHouse_area());
			pstmt.setInt(9, hf.getHouse_cost());
			pstmt.setString(10, hf.getHouse_title());
			pstmt.setString(11, hf.getRuzhu_time());
			pstmt.setString(12, hf.getContact());
			int row = pstmt.executeUpdate();
			isSuc = row > 0;
			return isSuc;
			}		
	}
	}
	/*
	 * (non-Javadoc)出租发布信息 标志过期
	 * @see DAO.HouseInfoDAO#mark_del(int)
	 */
	
	public boolean mark_del(int id) throws Exception {
	    boolean isSuc=false;
	    Class.forName(driver);
	    String sql = "delete from rent_house_info where id=?";
	    try (Connection con = DriverManager.getConnection(url, user, pass);
	        PreparedStatement pstmt = con.prepareStatement(sql);) {
	      pstmt.setInt(1,id);
	      int row=pstmt.executeUpdate();
	      isSuc=row>0;
	    }
	    return isSuc;
	  }
	
	
	
	
	
	
	
	
	
	
	/*
	 * (non-Javadoc)求租信息发布保存
	 * @see DAO.HouseInfoDAO#save_need(java.lang.String, domain.HouseInfo)
	 */
	
	public boolean save_need(String username,HouseInfo hf) throws Exception {
		boolean isSuc = false;
		Class.forName(driver);
		String sql = "insert into need_house_info(username,house_various,"
				+ "house_address_shi,house_address_qu,"
				+ "house_shi, house_ting,house_wei,"
				+ "house_area,house_cost,house_title,ruzhu_time,contact) values(?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);
				) {
			pstmt.setString(1, username);
			pstmt.setString(2,hf.getHouse_various());
			pstmt.setString(3, hf.getHouse_address_shi());
			pstmt.setString(4, hf.getHouse_address_qu());
			pstmt.setString(5, hf.getHouse_shi());
			pstmt.setString(6, hf.getHouse_ting());
			pstmt.setString(7, hf.getHouse_wei());
			pstmt.setInt(8, hf.getHouse_area());
			pstmt.setInt(9, hf.getHouse_cost());
			pstmt.setString(10, hf.getHouse_title());
			pstmt.setString(11, hf.getRuzhu_time());
			pstmt.setString(12, hf.getContact());
			int row = pstmt.executeUpdate();
			isSuc = row > 0;
			return isSuc;
			}
	}
	
	/*
	 * (non-Javadoc)收藏信息保存
	 * @see DAO.HouseInfoDAO#save_collect(domain.HouseInfo)
	 */
	@Override
	public boolean save_collect(HouseInfo hf) throws Exception {
		boolean isSuc = false;
		boolean isHave=false;
		Class.forName(driver);
		String sql = "insert into collect_info(rent_id,username,house_various,house_address_shi,house_address_qu,"
				+ "house_shi,house_ting,house_wei,"
				+ "house_area,house_cost,"
				+ "house_title,ruzhu_time,contact) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql2 = "select * from collect_info where rent_id =?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);
				PreparedStatement pstmt2 = con.prepareStatement(sql2);
				
				){
			pstmt2.setInt(1, hf.getId());
			ResultSet rs = pstmt2.executeQuery();
			isHave = rs.next();
			if (isHave == true) {
				return !isHave;
			} else {
		
			pstmt.setInt(1, hf.getId());
			pstmt.setString(2, hf.getUsername());
			pstmt.setString(3,hf.getHouse_various());
			pstmt.setString(4, hf.getHouse_address_shi());
			pstmt.setString(5, hf.getHouse_address_qu());
			pstmt.setString(6, hf.getHouse_shi());
			pstmt.setString(7, hf.getHouse_ting());
			pstmt.setString(8, hf.getHouse_wei());
			pstmt.setInt(9, hf.getHouse_area());
			pstmt.setInt(10, hf.getHouse_cost());
			pstmt.setString(11, hf.getHouse_title());
			pstmt.setString(12, hf.getRuzhu_time());
			pstmt.setString(13, hf.getContact());
			int row = pstmt.executeUpdate();
			isSuc = row > 0;
			return isSuc;
			}		
	}}
	/*
	 * (non-Javadoc)收藏信息展示
	 * @see DAO.HouseInfoDAO#getAllcollect_info()
	 */
	public List<String[]> getAllcollect_info() throws Exception {
		List<String[]> hfs = new ArrayList<>();
		Class.forName(driver);
		String sql = "select * from collect_info ";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {// 保存每行的数据
					String[] row = new String[20];
					row[0] = rs.getString("collect_id");
					row[1] = rs.getString("rent_id");
					row[2] = rs.getString("username");
					row[3] = rs.getString("house_various");
					row[4] = rs.getString("house_address_shi");
					row[5] = rs.getString("house_address_qu");
					row[6] = rs.getString("house_shi");
					row[7] = rs.getString("house_ting");
					row[8] = rs.getString("house_wei");
					row[9] = rs.getString("house_area");
					row[10] = rs.getString("house_cost");
					row[11] = rs.getString("house_title");
					row[12] = rs.getString("ruzhu_time");
					row[13] = rs.getString("contact");
					hfs.add(row);
					
				}
			}
		}
		return hfs;
	}
	
	/*
	 * (non-Javadoc)收藏信息的删除
	 * @see DAO.HouseInfoDAO#collect_del(int)
	 */
	
	public boolean collect_del(int id) throws Exception {
	    boolean isSuc=false;
	    Class.forName(driver);
	    String sql = "delete from collect_info where collect_id=?";
	    try (Connection con = DriverManager.getConnection(url, user, pass);
	        PreparedStatement pstmt = con.prepareStatement(sql);) {
	      pstmt.setInt(1,id);
	      int row=pstmt.executeUpdate();
	      isSuc=row>0;
	    }
	    return isSuc;
	  }
	
	/*
	 * (non-Javadoc)添加保存图片
	 * @see DAO.HouseInfoDAO#save_image(domain.HouseInfo)
	 */
	@Override
	public boolean save_image(HouseInfo hf) throws Exception {
		boolean isSuc = false;
		boolean isHave=false;
		Class.forName(driver);
		String sql = "insert into image_info(rent_id,image_name) values(?,?)";
		String sql2 = "select * from image_info where rent_id =?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);
				PreparedStatement pstmt2 = con.prepareStatement(sql2);){
			
			pstmt2.setInt(1, hf.getId());
			ResultSet rs = pstmt2.executeQuery();
			isHave = rs.next();
			if (isHave == true) {
				return !isHave;
			} else {
			pstmt.setInt(1, hf.getId());
			pstmt.setString(2, hf.getImage_name());
			int row = pstmt.executeUpdate();
			isSuc = row > 0;
			return isSuc;
			}		
	}	
}
	@Override
	public HouseInfo findImage(int id) throws Exception {
		HouseInfo img = new HouseInfo();
		Class.forName(driver);
		String sql = "select * from image_info where rent_id=?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery();) {
				rs.next();
				img.setImage_id(rs.getInt("image_id"));
				img.setId(rs.getInt("rent_id"));
				img.setImage_name(rs.getString("image_name"));
			}
		}
		return img;
	}


}
