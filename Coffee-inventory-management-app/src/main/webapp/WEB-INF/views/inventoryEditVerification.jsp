<%-- 在庫編集内容確認画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>在庫編集内容確認</title>
</head>
<body>
	<h1>在庫編集内容を確認</h1>

<form action="editComplete" method="post">
    <label>商品ID:</label>
    <input type="text" name="coffeeId" value="${coffeeId}" readonly><br>

    <label>商品名:</label>
    <input type="text" name="coffeeName" value="${coffeeName}"><br>

    <label>価格:</label>
    <input type="text" name="price" value="${price}"><br>

    <label>個数:</label>
    <input type="text" name="number" value="${number}"><br>
    
    <label>閾値:</label>
	<input type="number" id="threshold" name="threshold" value="${coffee.threshold}"><br>
    <input type="submit" value="編集">
</form>

		<button type="submit">編集完了</button>
	</form>
</body>
</html>
