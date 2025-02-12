<%-- 在庫編集画面 --%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>在庫編集</title>
<link rel="stylesheet" type="text/css"
	href="<%= request.getContextPath() %>/css/style.css">
	
</head>
<body>
	<h2>在庫編集</h2>
	<!-- エラーメッセージ表示 -->
	<c:if test="${not empty errorMessage}">
		<p style="color: red;">${errorMessage}</p>
	</c:if>
	<form action="inventoryEdit" method="post">
		<label for="coffeeId">商品ID</label> <input type="text" id="coffeeId"
			name="coffeeId" required><br> <label for="coffeeName">商品名</label>
		<input type="text" id="coffeeName" name="coffeeName"><br>
		<br> <input type="submit" value="検索">
	</form>
	<br>
	<a href="adminMenu">メニューに戻る</a>
</body>
</html>
