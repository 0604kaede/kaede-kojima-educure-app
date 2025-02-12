<%-- 在庫編集内容確認画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>在庫編集内容確認</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
	<h1>在庫編集内容を確認</h1>

	<form action="inventoryEditVerification" method="post">
	<label>商品ID</label>
	<input type="hidden" name="coffeeId" value="${coffee.coffeeId}">
	<br>
	<label for="coffeeName">商品名</label>
	<input type="text" id="coffeeName" name="coffeeName" value="${coffee.coffeeName}"> 
	<br> 
	<label for="price">価格</label> 
	<input type="number" id="price" name="price" value="${coffee.price}"> 
	<br> 
	<label for="number">在庫数</label>
	<input type="number" id="number" name="number" value="${coffee.number}"> 
	<br> 
	<label for="threshold">閾値</label> 
	<input type="number" id="threshold" name="threshold" value="${coffee.threshold}">
	 <br>
	<button type="submit">編集</button>
	</form>

	<br>

	<form action="inventoryDelete" method="post">
		<input type="hidden" name="coffeeId" value="${coffee.coffeeId}" />
		<button type="submit" onclick="return confirm('本当に削除しますか？');">削除</button>
	</form>

	<br>

	<a href="inventoryEdit">在庫編集画面へ戻る(検索)</a>

</body>
</html>
