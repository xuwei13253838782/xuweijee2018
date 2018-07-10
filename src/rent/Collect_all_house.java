package rent;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import DAO.HouseInfoDAO;
import DAO.HouseInfoDAOImp;
import domain.HouseInfo;

public class Collect_all_house extends ActionSupport {
	HouseInfo hf;
	List<String[]> hfs;
	

	public HouseInfo getHf() {
		return hf;
	}

	public void setHf(HouseInfo hf) {
		this.hf = hf;
	}

	public List<String[]> getHfs() {
		return hfs;
	}

	public void setHfs(List<String[]> hfs) {
		this.hfs = hfs;
	}

	public String execute() throws Exception {
		HouseInfoDAO dao = new HouseInfoDAOImp();
		hfs = dao.getAllcollect_info();
		return SUCCESS;
	}
	
	public String del_collect() throws Exception{
	    HouseInfoDAO dao=new HouseInfoDAOImp();
	    boolean isSuc=dao.collect_del(hf.getCollect_id());
	    return isSuc?SUCCESS:ERROR;
	  }
	
	
	public String collect() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username2 = (String) session.get("username");
		HouseInfoDAO dao = new HouseInfoDAOImp();
		boolean isSuc = dao.save_collect(hf);
		if (username2 == null || isSuc == false) {

			return "fail";

		} else {

			return "suc";
		}

	}

}
