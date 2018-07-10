package rent;

import com.opensymphony.xwork2.ActionSupport;

import DAO.PersonDAO;
import DAO.PersonDAOImp;

import domain.Person;

public class CheckRegister extends ActionSupport {
	
	String repass;
	

	public String getRepass() {
		return repass;
	}

	public void setRepass(String repass) {
		this.repass = repass;
	}

	
	Person pers;

	public Person getPers() {
		return pers;
	}

	public void setPers(Person pers) {
		this.pers = pers;
	}
	
	

	 public String execute() throws Exception {
			
			return SUCCESS;
		}
	
	public String save() throws Exception {
		PersonDAO dao = new PersonDAOImp();
		boolean isSuc = dao.save(pers);
		return isSuc ? SUCCESS : ERROR;
		
	}


}
