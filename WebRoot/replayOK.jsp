<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
  回复成功，<span id="t" style="color:red">5</span>秒后跳转如果不跳转，请点击下面链接<br/>
  
<script type="text/javascript">

function delayURL(url) {
	var t=document.getElementById("t").innerHTML;
	 if(t>0){
		t--;
		document.getElementById("t").innerHTML=t;
	 }else{
		 window.top.location.href=url;
	 }       
	setTimeout("delayURL('" + url + "')", 1000);
}
</script>
<a href="article.jsp">回到主题列表</a>
  <script type="text/javascript">
   delayURL("article.jsp");
</script>
  </body>
</html>
