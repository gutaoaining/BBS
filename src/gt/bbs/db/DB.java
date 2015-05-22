package gt.bbs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class DB {
   public static Connection getConn() throws Exception{
	   Connection conn=null;
	   Class.forName("com.mysql.jdbc.Driver");
	   conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs","root", "root");
	   return conn;
   }
   public static Statement getCreateStm() throws SQLException, Exception{
	   return getConn().createStatement();
   }
   public static PreparedStatement getPreStmt(String sql) throws SQLException, Exception{
	   PreparedStatement pstm=(PreparedStatement) getConn().prepareStatement(sql); 
	   return pstm;
   }
   public static PreparedStatement getPreStmt(String sql,int autoPrimaryKey) throws SQLException, Exception{
	   PreparedStatement pstm=(PreparedStatement) getConn().prepareStatement(sql,autoPrimaryKey); 
	   return pstm;
   }
   public static ResultSet executequery(Statement stmt,String sql){
	   ResultSet rs=null;
	   try {
		rs=stmt.executeQuery(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return rs;   
   }
   public static void close(){
	   try {
		getCreateStm().close();
		getConn().close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
}
