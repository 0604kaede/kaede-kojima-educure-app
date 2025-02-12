<%--削除完了画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>削除完了</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
	<h2>削除完了</h2>

	<p>${message}</p>

	<br>
	<a href="userList">ユーザー 一覧ページ</a>
</body>
</html>
