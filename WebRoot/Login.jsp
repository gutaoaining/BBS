<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
	<link rel="stylesheet" type="text/css" href="CSS/form.css">
	

  </head>
  
  <body>
  <div class="div1">
   <form method="post" action="login">
	   <table>
	   <tr>
	   <th>登录名:</th>
	   <td><input type="text" name="user" class="text1"></td></tr>
       <tr>
	    <th>密  码:</th>
	    <td><input type="text" name="password" class="text1"></td>
	   </tr>
	   <tr>
		<td align="center">	
		<input type="submit" class="bnt" value="登录"></td>
		<td align="center">	<input class="bnt" type="submit" value="注册"></td>
      </tr>
	  </table>
	</form>
	</div>
  </body>
</html>
