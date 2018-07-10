package rent;


import com.opensymphony.xwork2.ActionSupport;

public class CheckLogin_admin extends ActionSupport {
	String admin_pass;
	String admin_name;

	public String getAdmin_pass() {
		return admin_pass;
	}

	public void setAdmin_pass(String admin_pass) {
		this.admin_pass = admin_pass;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	@Override
	public String execute() {
		if ("徐伟".equals(admin_name) && "123456".equals(admin_pass)) {
			
			return "SUCCESS";// 自定义指向的页面
		} else
			return "fail";

	}

}
