<%-- ユーザー編集画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー編集</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<h1>ユーザー編集</h1>

	<!-- エラーメッセージの表示 -->
	<c:if test="${not empty errorMessage}">
		<div style="color: red;">
			<p>${errorMessage}</p>
		</div>
	</c:if>

	<!-- ユーザー情報の編集フォーム -->
	<form action="userEditConfirm" method="post">
		<%-- <input type="hidden" name="userId" value="${user.userId}" /> --%> <label
			for="userName">ユーザー名</label> <input type="text" id="userName"
			name="userName" required /> <br /> <label for="password">パスワード</label>
		<input type="password" id="password" name="password" required /> <br />
		<br> <input type="submit" value="検索" />
	</form>


	<br>
	<a href="adminMenu">メニューに戻る</a>
</body>
</html>