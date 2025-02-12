<%--在庫編集完了画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>編集完了</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
	<h2>編集完了</h2>

	<p>${message}</p>

	<br>
	<a href="inventoryList">在庫一覧ページ</a>
</body>
</html>
