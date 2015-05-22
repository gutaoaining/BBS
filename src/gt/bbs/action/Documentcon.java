package gt.bbs.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gt.bbs.beans.Article;
import gt.bbs.db.DB;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Documentcon{
	List<Article> articles=new ArrayList<Article>();
	int pagesize=5;
public List<Article> tree(int id,int grade){
	 String sql="select *from article where pid="+id;
	 try {
		 ResultSet rs=DB.executequery(DB.getCreateStm(), sql);
		 while(rs.next()){
			 Article a = SearchConment(rs);
			 a.setGrade(grade);
			 articles.add(a);
			 if(!a.isLeaf()){
				 tree(a.getId(),grade+1);
			 }
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	DB.close();
	return articles;
	 
}
public Article SearchConment(ResultSet rs) throws SQLException {
	 Article a=new Article();
	 a.setId(rs.getInt("id"));
	 a.setPid(rs.getInt("pid"));
	 a.setTitle(rs.getString("title"));
	 a.setPdate(rs.getTimestamp("pdate"));
	 a.setRootId(rs.getInt("rootId"));
	 a.setCont(rs.getString("cont"));	
	 a.setLeaf(rs.getInt("isleaf")==0? true:false);
	 DB.close();
	 return a;
}
public Article SearchArticle(int id){
	System.out.println("id======"+id);
	String sql= "select *from article where id="+id;
	Article a=new Article();
	try {
		ResultSet rs=DB.getCreateStm().executeQuery(sql);
	    while(rs.next()){
	    	 a=SearchConment(rs);
	    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	DB.close();
	return a;
}
public List<Article> searchTitle(int pageNumber){
	int startRow=(pageNumber-1)*pagesize;
	String sql="select *from article where pid=0 order by pdate desc limit "+startRow+","+pagesize;
	try {	
		System.out.println(countAll());
		ResultSet rs=DB.getCreateStm().executeQuery(sql);
		while(rs.next()){
			Article a=SearchConment(rs);
			 articles.add(a);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	DB.close();
	return articles;
}
public List<Article> treeALl(int id){
	 String sql="select *from article where rootId="+id+" order by pdate asc";
	 try {
		 ResultSet rs=DB.executequery(DB.getCreateStm(), sql);
		 while(rs.next()){
			 Article a = SearchConment(rs);
			 articles.add(a);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 DB.close();
	return articles;
	 
}
public int countAll() throws SQLException, Exception{
	
	String sql="select count(*)from article where pid=0";
	ResultSet rs=DB.getCreateStm().executeQuery(sql);
	rs.next();
	int allrecords=rs.getInt(1);
	int totalpage=(allrecords+pagesize-1)/pagesize;
	DB.close();
	return  totalpage;
}
}
