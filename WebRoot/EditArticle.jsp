<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="gt.bbs.action.*"%>
<%@page import="gt.bbs.beans.*"%>
<%
String id=request.getParameter("id");
String title=request.getParameter("title");
String cont=request.getParameter("cont");
String pageNumber=request.getParameter("pagenumber");
if(id==null||id.trim().equals("")||title==null||title.trim().equals("")){
	out.println("Error ID");
	return;
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>Java</title>
<meta http-equiv="content-type" content="text/html; charset=GBK">

<link rel="stylesheet" href="sample.css">
<link rel="stylesheet" type="text/css" href="images/style.css" title="Integrated Styles">
<script src="ckeditor/ckeditor.js"></script>
<script language="JavaScript" type="text/javascript" src="images/global.js"></script>
<link rel="alternate" type="application/rss+xml" title="RSS" href="http://bbs.chinajavaworld.com/rss/rssmessages.jspa?threadID=744236">
</head>
<body>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tbody>
    <tr>
      <td width="140"><a href="http://bbs.chinajavaworld.com/index.jspa"><img src="images/header-left.gif" alt="Java|Java世界_中文论坛|ChinaJavaWorld技术论坛" border="0"></a></td>
      <td><img src="images/header-stretch.gif" alt="" border="0" height="57" width="100%"></td>
      <td width="1%"><img src="images/header-right.gif" alt="" border="0"></td>
    </tr>
  </tbody>
</table>
<br>
<div id="jive-flatpage">
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tbody>
      <tr valign="top">
        <td width="99%"><p class="jive-breadcrumbs"> <a href="http://bbs.chinajavaworld.com/index.jspa">首页</a> &#187; <a href="http://bbs.chinajavaworld.com/forumindex.jspa?categoryID=1">ChinaJavaWorld技术论坛|Java世界_中文论坛</a> &#187; 
        <a href="http://bbs.chinajavaworld.com/category.jspa?categoryID=2">Java 2 Platform, Standard Edition (J2SE)</a> &#187; <a href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=0">Java语言*初级版</a> </p>
          <p class="jive-page-title"> 主题:<%=title%></p></td>
        <td width="1%"><div class="jive-accountbox"></div></td>
      </tr>
    </tbody>
  </table>
  <br>
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tbody>
      <tr valign="top">
        <td width="99%"><div id="jive-message-holder">
            <div class="jive-message-list">
              <div class="jive-table">
                <div class="jive-messagebox">
                   <form action="saveaction!editArticle" method="post" >
                     <input type="hidden" name="id" value="<%=id%>">
                     <input type="hidden" name="title" value="<%=title%>">
                     <input type="hidden" name="pageNumber" value="<%=pageNumber%>">
                     <br/>
                      <span class="jive-page-title"> 内容:</span>
                      <textarea class="ckeditor" name="cont" rows="15" cols="80"><%=cont%></textarea><br/> 
                     <input type="submit" value="修改">                           
                   </form>
                </div>
              </div>
            </div>
            <div class="jive-message-list-footer">
              <table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tbody>
                  <tr>
                    <td nowrap="nowrap" width="1%"></td>
                    <td align="center" width="98%"><table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                          <tr>
                            <td><a href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20"><img src="images/arrow-left-16x16.gif" alt="返回到主题列表" border="0" height="16" hspace="6" width="16"></a> </td>
                            <td><a href="article.jsp">返回到主题列表</a> </td>
                          </tr>
                        </tbody>
                      </table></td>
                    <td nowrap="nowrap" width="1%">&nbsp;</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div></td>
        <td width="1%"></td>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>