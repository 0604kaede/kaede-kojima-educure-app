<%-- ユーザー編集確認画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー編集確認</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<h1>ユーザー編集確認</h1>
	<p>以下の内容で削除します。よろしいですか？</p>

	<p>ユーザーID:${user.userId}</p>
	<p>ユーザー名:${user.userName}</p>

	<form action="userDelete" method="post">
		<input type="hidden" name="userId" value="${user.userId}">  <input
			type="hidden" name="userName" value="${user.userName}">
		<button type="submit">削除</button>
	</form>

	<br>
	<a href="userEdit?userId=${user.userId}">戻る</a>
</body>
</html>
