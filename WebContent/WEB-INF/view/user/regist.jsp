<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script type="text/javascript" src="<%=path%>/resources/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
function zhuce(){
	
	$.ajax({
		type:'POST',
		url:'<%=path%>/user/check_regist.html',
		data:{
			username:document.getElementById("username").value,
			password:document.getElementById("password").value,
			sex:document.getElementById("sex").value,
			age:document.getElementById("age").value,
			phoneno:document.getElementById("phoneno").value
		},
		dataType:'json',
		beforeSend : function(XMLHttpRequest) {
		},
		success : function(data, textStatus) {
			
			if(data.errcode == 1){
				alert("注册成功!");
				window.location.href = "<%=path%>/user/success.html";
			}else{
				alert("用户名已存在");
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
			<td>性别：</td>
			<td><input type="radio" id="sex" value="1">男<input type="radio" id="sex" value="2">女</td>
		</tr>
		<tr>
			<td>年龄：</td>
			<td><input type="text" id="age"></td>
		</tr>
		<tr>
			<td>电话号：</td>
			<td><input type="text" id="phoneno"></td>
		</tr>
		<tr>
			<td colspan="2"><button onclick="zhuce()" style="width: 100%;height: 30px">注册</button></td>
		</tr>
	</table>
</body>
</html>