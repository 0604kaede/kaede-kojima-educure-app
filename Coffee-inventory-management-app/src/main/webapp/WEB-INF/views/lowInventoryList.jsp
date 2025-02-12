<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>低在庫一覧</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<h2>低在庫リスト一覧</h2>

	<!-- 画像の追加 -->
	<img src="<%=request.getContextPath()%>/images/08_coffee101.gif"
		alt="コーヒー画像" class="inventory-image">

	<!-- 低在庫情報テーブル -->
	<table border="1">
		<thead>
			<tr>
				<th>商品ID</th>
				<th>商品名</th>
				<th>価格</th>
				<th>在庫数</th>
				<th>閾値</th>
			</tr>
		</thead>
		<tbody>
			<!-- 低在庫商品一覧をループで表示 -->
			<c:forEach var="coffee" items="${lowInventoryList}">
				<tr>
					<td>${coffee.coffeeId}</td>
					<td>${coffee.coffeeName}</td>
					<td>${coffee.price}</td>
					<td>${coffee.number}</td>
					<td>${coffee.threshold}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br>
	<a href="adminMenu">メニューに戻る</a>
</body>
</html>
