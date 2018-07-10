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
import DAO.ProvinceDAO;
import DAO.ProvinceDAOImp;
import domain.HouseInfo;

public class image extends ActionSupport {

	File rent_image;
	String rent_imageContentType;
	String rent_imageFileName;

	HouseInfo hf;
	List<String[]> hfs;

	public File getRent_image() {
		return rent_image;
	}

	public void setRent_image(File rent_image) {
		this.rent_image = rent_image;
	}

	public String getRent_imageContentType() {
		return rent_imageContentType;
	}

	public void setRent_imageContentType(String rent_imageContentType) {
		this.rent_imageContentType = rent_imageContentType;
	}

	public String getRent_imageFileName() {
		return rent_imageFileName;
	}

	public void setRent_imageFileName(String rent_imageFileName) {
		this.rent_imageFileName = rent_imageFileName;
	}

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

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public String image_save() throws Exception {

		String path1 = ServletActionContext
	 			.getServletContext().getRealPath("/upload");
		File destFile = new File(path1, rent_imageFileName);
		Files.copy(rent_image.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		HouseInfoDAO dao = new HouseInfoDAOImp();
		hf.setImage_name(rent_imageFileName);
		boolean isSuc = dao.save_image(hf);
		return isSuc ? SUCCESS : ERROR;
	}
	
	public String look_image() throws Exception{
		 HouseInfoDAO dao=new HouseInfoDAOImp();
		 hf=dao.findImage(hf.getId());
		 if(hf.getImage_name()==null)
		 {
			 return ERROR;
		 }else {
		
	     return SUCCESS;
	  }
	}
	public String execute() throws Exception {

		return SUCCESS;

	}

}
