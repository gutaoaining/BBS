<%@page import="java.text.SimpleDateFormat"%>
<%@page import="gt.bbs.action.*"%>
<%@page import="gt.bbs.beans.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
int pageNumber=1;
String strpageNumber=request.getParameter("pageno");
if(strpageNumber!=null&&!strpageNumber.trim().equals("")){
	try{
		pageNumber=Integer.parseInt(strpageNumber);
	}catch(NumberFormatException e){
		pageNumber=1;
	}
}else{
	try{
		pageNumber=(Integer)request.getAttribute("pageNumber");
	}catch(NullPointerException e){
		pageNumber=1;
	}  
}
Documentcon doc=new Documentcon();
int allpage=doc.countAll();
if(pageNumber>allpage||pageNumber<=0){
	pageNumber=1;
}
List<Article> list=new ArrayList<Article>();
list=doc.searchTitle(pageNumber);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>Java|Java世界_中文论坛|ChinaJavaWorld技术论坛 : Java语言*初级版--顾涛</title>
<meta http-equiv="content-type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="images/style.css" title="Integrated Styles">
<script language="JavaScript" type="text/javascript" src="images/global.js"></script>
<link rel="alternate" type="application/rss+xml" title="RSS" href="http://bbs.chinajavaworld.com/rss/rssmessages.jspa?forumID=20">
<script language="JavaScript" type="text/javascript" src="images/common.js"></script>
<script type="text/javascript" src="js/document.js"></script>

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
<div id="jive-forumpage">
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tbody>
      <tr valign="top">
        <td width="98%"><p class="jive-breadcrumbs">论坛: Java语言*初级版
            (顾涛)</p>
          <p class="jive-description"> 探讨Java语言基础知识,基本语法等 大家一起交流 共同提高！谢绝任何形式的广告 </p>
          </td>
      </tr>
    </tbody>
  </table>
  <div class="jive-buttons">
    <table summary="Buttons" border="0" cellpadding="0" cellspacing="0">
      <tbody>
        <tr>
          <td class="jive-icon"><a href="http://bbs.chinajavaworld.com/post%21default.jspa?forumID=20"><img src="images/post-16x16.gif" alt="发表新主题" border="0" height="16" width="16"></a></td>
          <td class="jive-icon-label"><a id="jive-post-thread" href="createArticle.jsp">发表新主题</a> <a href="article.jsp">所有评论</a></td>
        </tr>
      </tbody>
    </table>
  </div>
  <br>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tbody>
      <tr valign="top">
        <td><span class="nobreak">共<%=allpage%>页:
          <span class="jive-paginator"> [ <a href="articleFlat.jsp?pageno=1">第一页</a> | <a href="articleFlat.jsp?pageno=<%=pageNumber-1%>">上一页</a> <a href="" class="jive-current">当前是第<%=pageNumber%>页</a> <a href="articleFlat.jsp?pageno=<%=pageNumber+1%>" class="">下一页</a> | <a href="articleFlat.jsp?pageno=<%=allpage%>>">未页</a> ] </span> </span> </td>
      </tr>
    </tbody>
  </table>
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tbody>
      <tr valign="top">
        <td width="99%"><div class="jive-thread-list">
            <div class="jive-table">
              <table summary="List of threads" cellpadding="0" cellspacing="0" width="100%">
                <thead>
                  <tr>
                    <th class="jive-first" colspan="3"> 主题 </th>
                    <th class="jive-author"> <nobr> 作者
                      &nbsp; </nobr> </th>
                    <th class="jive-view-count"> <nobr> 浏览
                      &nbsp; </nobr> </th>
                    <th class="jive-msg-count" nowrap="nowrap"> 回复 </th>
                    <th class="jive-last" nowrap="nowrap"> 最新帖子 </th>
                  </tr>
                </thead>
                <tbody>
                 <%
                 int i=0;
                 for(Iterator<Article> it=list.iterator();it.hasNext();){
                 Article a=it.next();
                   String styleclass=i%2==0?"jive-even":"jive-odd";
                 %>
               
                  <tr class=<%=styleclass%>>
                    <td class="jive-first" nowrap="nowrap" width="1%"><div class="jive-bullet"> <img src="images/read-16x16.gif" alt="已读" border="0" height="16" width="16">
                        <!-- div-->
                      </div></td>
                    <td nowrap="nowrap" width="1%">
                    <% String user=(String)session.getAttribute("user");
                       if(user!=null&&!user.trim().equals("")){
                    %>
                    <a href="EditArticle.jsp?id=<%=a.getId()%>&title=<%=a.getTitle()%>&cont=<%=a.getCont()%>&pagenumber=<%=pageNumber%>">修改</a>
                    <a href="delete!deleteDetail?id=<%=a.getId()%>&pid=<%=a.getPid()%>&isLeaf=<%=a.isLeaf()%>">删除</a>
                    <%}%>
                    </td>
                    <td class="jive-thread-name" width="95%"><a id="jive-thread-1" href="articleFlatDetail.jsp?id=<%=a.getId()%>"><%=a.getTitle()%></a></td>
                    <td class="jive-author" nowrap="nowrap" width="1%"><span class=""> <a href="http://bbs.chinajavaworld.com/profile.jspa?userID=226030">gutao</a> </span></td>
                    <td class="jive-view-count" width="1%"> 104</td>
                    <td class="jive-msg-count" width="1%"> 5</td>
                    <td class="jive-last" nowrap="nowrap" width="1%"><div class="jive-last-post"><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(a.getPdate())%><br>
                        by: <a href="http://bbs.chinajavaworld.com/thread.jspa?messageID=780182#780182" title="jingjiangjun" style="">gutao &#187;</a> </div></td>
                  </tr>
                  <%
                  i++;
                 }%>
                </tbody>
              </table>
            </div>
          </div>
          <div class="jive-legend"></div></td>
      </tr>
    </tbody>
  </table>
  <br>
  <br>
</div>
</body>
</html>
