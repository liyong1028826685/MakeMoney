<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>

<script type="text/javascript" src="/js/jQuery-1.7.1.js"></script>


<title>用户注册</title>

</head>

<body class="index_bg">

	
 <div class="header">
    <form action="/user/user_register.do" method="post">
    姓名:<input id="name" type="text" name="user.user_name" /></br>
  密码:<input id="password" type="password"  name="user.user_pass" />
  	 <input type="submit" value="提交">
    </form>  
 </div>
 
</body>
</html>
