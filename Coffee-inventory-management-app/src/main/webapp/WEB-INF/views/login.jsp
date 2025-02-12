<%--ログイン画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body class="login-page">
	<!-- ログイン画像 -->
	<div class="login-image">
		<img src="<%= request.getContextPath() %>/images/08_coffee013.gif" alt="ログイン画像">
	</div>

	<!-- エラーメッセージ表示 -->
	<c:if test="${not empty errorMessage}">
		<p style="color: red;">${errorMessage}</p>
	</c:if>

	<form:form action="/login" modelAttribute="loginForm" method="post">
		<div>
			<label for="userId">ユーザーID</label>
			<form:input path="userId" id="userId" />
			<form:errors path="userId" cssClass="error" />
		</div>

		<div>
			<label for="password">パスワード</label>
			<form:password path="password" id="password" />
			<form:errors path="password" cssClass="error" />
		</div>
<br>
		<button type="submit">ログイン</button>
	</form:form>
</body>
</html>
