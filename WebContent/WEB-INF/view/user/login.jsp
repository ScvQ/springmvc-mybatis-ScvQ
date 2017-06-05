<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<script type="text/javascript" src="<%=path %>/resources/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	function zhuce(){
		window.location.href = "<%=path%>/user/regist.html";
	}
	function denglu(){
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		$.ajax({
			type:"POST",
			url:"<%=path%>/user/check_login.html",
			data:{
				username:username,
				password:password
			},
			dataType:'json',
			beforeSend : function(XMLHttpRequest) {
			},
			success : function(data, textStatus) {
				
				if(data.errcode == 1){
					alert("登陆成功!");
					window.location.href = "<%=path%>/user/success.html";
				}
			
			},
			complete : function(XMLHttpRequest, textStatus) {
			},
			error : function() {
			}
		});
	}
</script>
</head>
<body>
	<table align="center">
		<tr>
			<td>用户名：</td>
			<td><input type="text" id="username"></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" id="password"></td>
		</tr>
		<tr>
			<td colspan="2"><button onclick="denglu()" style="width: 100%;height: 30px">登录</button></td>
		</tr>
		<tr>
			<td colspan="2"><button onclick="zhuce()" style="width: 100%;height: 30px">注册</button></td>
		</tr>
	</table>
</body>
</html>