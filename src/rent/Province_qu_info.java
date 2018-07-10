package rent;


import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import DAO.ProvinceDAO;
import DAO.ProvinceDAOImp;
import domain.Province;

public class Province_qu_info extends ActionSupport {
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

	
	
		public String save_qu() throws Exception {
			
			ProvinceDAO dao = new ProvinceDAOImp();
			boolean isSuc = dao.save_qu(pro);
			System.out.println(isSuc);
			return isSuc ? SUCCESS : ERROR;
			
		}

	
		@Override
		public String execute() throws Exception {
			ProvinceDAO dao = new ProvinceDAOImp();
			pros = dao.getAllPros_qu();
			return SUCCESS;
			
		}

		public String update_qu() throws Exception{
		    ProvinceDAO dao=new ProvinceDAOImp();
		    boolean isSuc=dao.update_qu(pro);
		    return isSuc?SUCCESS:ERROR;
		  }
		
		public String edit_qu() throws Exception{
	    ProvinceDAO dao=new ProvinceDAOImp();
	    pro=dao.findById_qu(pro.getQu_id());
	    return SUCCESS;
	  }

		
		
}
