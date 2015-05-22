package gt.bbs.action;

import gt.bbs.db.DB;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("gutao")
@Namespace("/")
@Action(value="delete",results={@Result(name="succ",location="/article.jsp"),@Result(name="succ1",location="/article.jsp")})
public class DeleteAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private boolean isLeaf;
	private int pid;
	private int pageNumber;
	
  public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		System.out.println(id);
	}



	public boolean isLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
		System.out.println(isLeaf);
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
		System.out.println(pid);
	}

public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

  public String deleteDetail(){
	  delete(id, isLeaf);
	  comp();
	  return "succ";
  }
  public String deleteTitle(){
	  delete(id, isLeaf);
	  return "succ1";
  }
  public void delete(int id,boolean isleaf){
	  String sql="select *from article where pid="+id;
	  try {
		if(!isLeaf){
		ResultSet rs=DB.getCreateStm().executeQuery(sql);
		while(rs.next()){
			delete(rs.getInt("id"),rs.getInt("isLeaf")==0?true:false);
		}
		}
		DB.getCreateStm().executeUpdate("delete from article where id="+id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  public void comp(){
	  int cop=1;
	  try {
		ResultSet rs=DB.getCreateStm().executeQuery("select count(*)from article where pid="+pid);
	    rs.next();
	    cop=rs.getInt(1);
	    //System.out.println(cop);
	  } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	if(cop==0){
		 try {
			DB.getCreateStm().executeUpdate("update article set isLeaf="+0+" where id="+pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  }
}
