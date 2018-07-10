package rent_house;

import java.util.List;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
//import java.nio.file.Files;
//import java.nio.file.StandardCopyOption;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import DAO.HouseInfoDAO;
import DAO.HouseInfoDAOImp;

import domain.HouseInfo;
public class Up_rent_house_info extends ActionSupport {

	HouseInfo hf;
	List<String[]> hfs;
	
	
	public List<String[]> getHfs() {
		return hfs;
	}
	public void setHfs(List<String[]> hfs) {
		this.hfs = hfs;
	}
	public HouseInfo getHf() {
		return hf;
	}
	public void setHf(HouseInfo hf) {
		this.hf = hf;
	}
	String path;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String rent_save() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username2 = (String)session.get("username");
		HouseInfoDAO dao = new HouseInfoDAOImp();
		boolean isSuc = dao.save_rent(username2,hf);
		return isSuc ? SUCCESS : ERROR;
	}
	/*
	 * 过期标志 删除
	 */
	public String mark() throws Exception{
	    HouseInfoDAO dao=new HouseInfoDAOImp();
	    boolean isSuc=dao.mark_del(hf.getId());
	    return isSuc?SUCCESS:ERROR;
	  }

	
	
	public String execute() throws Exception{
		Map session = ActionContext.getContext().getSession();
		String username2 = (String)session.get("username");
		HouseInfoDAO dao=new HouseInfoDAOImp();
		hfs=dao.getAllrent_house(username2);
		return SUCCESS;
		

	}

}
