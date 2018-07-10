package rent;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import DAO.HouseInfoDAO;
import DAO.HouseInfoDAOImp;
import domain.HouseInfo;
public class Browse_all_house extends ActionSupport {
	
	int pageNow=1;
	int pageSize=5;
	HouseInfo hf;
	List<HouseInfo> hfs;

	 public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public HouseInfo getHf() {
		return hf;
	}
	public void setHf(HouseInfo hf) {
		this.hf = hf;
	}
	public List<HouseInfo> getHfs() {
		return hfs;
	}
	public void setHfs(List<HouseInfo> hfs) {
		this.hfs = hfs;
	}

	public String execute() throws Exception {
			HouseInfoDAO dao=new HouseInfoDAOImp();
			if(pageNow>0) {
			hfs=dao.getAllrent_all_house(pageSize, pageNow);
			return SUCCESS;
			}else {
				return ERROR;
			}
		
			}
	
	
	
	
	
	

	
}
