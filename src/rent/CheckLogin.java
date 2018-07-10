package rent;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import DAO.PersonDAO;
import DAO.PersonDAOImp;

import domain.Person;


public class CheckLogin extends ActionSupport {
	Person pers;


	public Person getPers() {
		return pers;
	}


	public void setPers(Person pers) {
		this.pers = pers;
	}
	
	
	public String checkInDB()throws Exception{
		 PersonDAO dao=new PersonDAOImp();
		 boolean isHave=dao.check(pers.getUsername());

		 
		 if(isHave){
		   Map session=ActionContext.getContext().getSession();
		   session.put("username", pers.getUsername());
	
		   return "suc";//自定义指向的页面
		 }else
			 return "fail";
	}

	@Override
	public String execute() {
		
	return SUCCESS;
	}

}
