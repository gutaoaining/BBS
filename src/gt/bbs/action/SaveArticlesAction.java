package gt.bbs.action;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import gt.bbs.beans.Article;
import gt.bbs.db.DB;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("gutao")
@Namespace("/")
@Action(value="saveaction",results={@Result(name="success",location="/replayOK.jsp"),@Result(name="success1",location="/article.jsp"),@Result(name="succ",location="/articleFlat.jsp")})
public class SaveArticlesAction extends ActionSupport implements ModelDriven<Article>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Article a=new Article();
	@Override
    public String execute(){
    	String sql="insert into article values(null,?,?,?,?,now(),?)";
    	String sql1="update article set isLeaf="+1+" where id="+a.getPid();
    	System.out.println(sql1);
    	try {
    		PreparedStatement pstm=DB.getPreStmt(sql);
    		pstm.setInt(1, a.getPid());
    		pstm.setInt(2, a.getRootId());
    		pstm.setString(3, a.getTitle());
    		pstm.setString(4, a.getCont());
    		pstm.setInt(5, 0);
    		pstm.executeUpdate();
    		DB.getCreateStm().execute(sql1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	DB.close();
		return "success";
    }
    public String SaveNewArticle(){
    	String sql="insert into article values(null,?,?,?,?,now(),?)";
    	try {
    		PreparedStatement pstm=DB.getPreStmt(sql,Statement.RETURN_GENERATED_KEYS);
    		pstm.setInt(1, 0);
    		pstm.setInt(2, -1);
    		pstm.setString(3, a.getTitle());
    		pstm.setString(4, a.getCont());
    		pstm.setInt(5, 0);
    		pstm.executeUpdate();
    		ResultSet reset=pstm.getGeneratedKeys();
    		reset.next();
    		int rootid=reset.getInt(1);
    		String sql1="update article set rootId="+rootid+" where id="+rootid;
    		DB.getCreateStm().execute(sql1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	DB.close();
		return "success1";
    }
    public String editArticle(){
    	String sql="update article set title=?,cont=? where id="+a.getId();
    	try {
			PreparedStatement ptmt=DB.getPreStmt(sql);
			ptmt.setString(1, a.getTitle());
			ptmt.setString(2, a.getCont());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 HttpServletRequest request = ServletActionContext.getRequest();
    	 System.out.println("页好："+a.getPageNumber());
    	 request.setAttribute("pageNumber", a.getPageNumber());
    	return "succ";
    }
	@Override
	public Article getModel() {
		// TODO Auto-generated method stub
		return a;
	}
}
