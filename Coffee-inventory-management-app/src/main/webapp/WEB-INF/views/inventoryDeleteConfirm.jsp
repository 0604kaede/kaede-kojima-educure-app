<%-- 在庫削除確認画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>在庫削除確認</title>
</head>
<body>
	<h2>在庫削除確認</h2>

	<form action="inventoryDelete" method="post">
		<input type="hidden" name="coffeeId" value="${coffee.coffeeId}" />
		<p>商品名: ${coffee.coffeeName}</p>
		<p>価格: ${coffee.price}</p>
		<p>在庫数: ${coffee.number}</p>
		<p>閾値: ${coffee.threshold}</p>

		<p>この商品を削除しますか？</p>
		<input type="submit" value="削除" />
	</form>

	<br>
	<a href="adminMenu">メニューに戻る</a>
</body>
</html>
