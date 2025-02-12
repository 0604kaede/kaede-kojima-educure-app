<%-- ユーザー登録画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
	<h1>ユーザー登録</h1>
	<form action="/userRegister" method="post">
		<label for="userName">名前</label> 
		<input type="text" id="userName" name="userName" required><br> 
		<label for="roleId">権限</label><br>
		<select id="roleId" name="roleId" required><br>
			<option value="1">管理者</option>
			<option value="2">一般ユーザー</option>
		</select><br> <label for="password">パスワード</label> 
		<input type="password" id="password" name="password" required><br>
	<br>
		<button type="submit">登録</button>
	</form>
	<br>
	<a href="/adminMenu">メニューに戻る</a>
</body>
</html>
