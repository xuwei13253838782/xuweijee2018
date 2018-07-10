package rent_house;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import DAO.HouseInfoDAO;
import DAO.HouseInfoDAOImp;
import domain.HouseInfo;

public class Up_rent_needHouse_info extends ActionSupport {

	HouseInfo hf;

	public HouseInfo getHf() {
		return hf;
	}

	public void setHf(HouseInfo hf) {
		this.hf = hf;
	}

	public String need_save() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username2 = (String) session.get("username");
		HouseInfoDAO dao = new HouseInfoDAOImp();
		boolean isSuc = dao.save_need(username2, hf);
		return isSuc ? SUCCESS : ERROR;
	}



	public String execute() {
		return "SUCCESS";

	}

}
