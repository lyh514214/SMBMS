<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <style type="text/css">
        body{
            background: #3a8dc1;
        }
    </style>
</head>
<body>
<h1 style="text-align: center;">请登录后再访问该页面！</h1>
<a href="${pageContext.request.contextPath }/user/logout">
    <p style="text-align: center ; font-size: 35px">返回</p>
</a>
</body>
</html>