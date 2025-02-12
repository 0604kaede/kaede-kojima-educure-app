<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>メニュー</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<h2>menu</h2>
	<img src="<%=request.getContextPath()%>/images/08_coffee102.gif"
		alt="コーヒー画像" class="admin-menu-image">

	<!-- 管理者用メニュー -->
	<c:choose>
		<c:when test="${sessionScope.roleId == 1}">
			<p>
				<a href="inventoryList">・在庫一覧</a><br>
				<a href="lowInventoryList">・低在庫リスト一覧</a><br>
				<a href="userList">・ユーザー一覧</a><br> 
				<a href="inventoryRegister1">・在庫登録</a><br>
				<a href="inventoryEdit">・在庫編集</a><br> 
				<a href="userRegister">・ユーザー登録</a><br>
				<a href="userEdit?userId=${sessionScope.userId}">・ユーザー編集</a><br> 
				<br>
				<a href="logout">ログアウト</a><br>
			</p>
		</c:when>
		<c:otherwise>
			<p>
				<a href="inventoryList">在庫一覧</a><br> <a href="lowInventoryList">低在庫リスト一覧</a><br>
				<a href="logout">ログアウト</a><br>
			</p>
		</c:otherwise>
	</c:choose>
</body>
</html>