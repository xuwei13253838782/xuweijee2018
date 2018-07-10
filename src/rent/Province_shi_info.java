package rent;


import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import DAO.ProvinceDAO;
import DAO.ProvinceDAOImp;
import domain.Province;

public class Province_shi_info extends ActionSupport {
		Province pro;
		List<String[]> pros;

		public List<String[]> getPros() {
			return pros;
		}

		public void setPros(List<String[]> pros) {
			this.pros = pros;
		}

		public Province getPro() {
			return pro;
		}

		public void setPro(Province pro) {
			this.pro = pro;
		}

		
	
		public String execute() throws Exception {
			ProvinceDAO dao = new ProvinceDAOImp();
			pros = dao.getAllPros_shi();
			
			return SUCCESS;
			
		}
		
		public String save_shi() throws Exception {
			ProvinceDAO dao = new ProvinceDAOImp();
			boolean isSuc = dao.save_shi(pro);
			return isSuc ? SUCCESS : ERROR;
			
		}

		public String update_shi() throws Exception{
	    ProvinceDAO dao=new ProvinceDAOImp();
	    boolean isSuc=dao.update_shi(pro);
	    if(isSuc==true) {
	    
	    }else {
	    	
	    }
	    return isSuc?SUCCESS:ERROR;
	  }
		
		
		public String edit_shi() throws Exception{
	    ProvinceDAO dao=new ProvinceDAOImp();
	    pro=dao.findById_shi(pro.getShi_id());
	    return SUCCESS;
	  }

}
