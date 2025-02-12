<%-- ユーザー一覧画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>ユーザー一覧</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
	<h2>ユーザー一覧</h2>

	<table border="1">
		<thead>
			<tr>
				<th>ユーザーID</th>
				<th>ユーザー名</th>
				<th>権限</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.userId}</td>
					<td>${user.userName}</td>
					<td><c:choose>
							<c:when test="${user.roleId == 1}">管理者</c:when>
							<c:when test="${user.roleId == 2}">一般</c:when>
							<c:otherwise>不明</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br>
	<a href="adminMenu">メニューに戻る</a>
</body>
</html>
