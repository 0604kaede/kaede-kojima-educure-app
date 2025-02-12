<%-- ユーザー削除確認画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>ユーザー削除確認</title>
</head>
<body>
	<h2>ユーザー削除確認</h2>

	<form action="userDelete" method="post">
		<input type="hidden" name="userId" value="${user.userId}" />
		<p>ユーザー名: ${user.userName}</p>
		<p>権限: ${user.roleName}</p>
		<p>このユーザーを削除しますか？</p>
		<input type="submit" value="削除" />
	</form>

	<br>
	<a href="userList">ユーザー一覧に戻る</a>
</body>
</html>
