package gt.bbs.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("gutao")
@Namespace("/")
@Action(value="login",results={@Result(name="success",location="/articleFlat.jsp")})
public class LoginAction extends ActionSupport {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String user;
  private String password;
  
	
	public String getUser() {
	return user;
}


public void setUser(String user) {
	this.user = user;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


	@Override
public String execute() throws Exception {
	// TODO Auto-generated method stub
	if(user.equals("m")&&password.equals("m")){
		HttpSession session=ServletActionContext.getRequest().getSession();
	    System.out.println("验证成功");
		session.setAttribute("user", "gutao");
	}
	System.out.println(user+"----"+password);
	return "success";
}
}
