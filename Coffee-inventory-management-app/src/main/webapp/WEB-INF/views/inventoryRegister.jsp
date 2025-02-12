<%-- 在庫登録画面 --%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>在庫登録</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
	<h2>在庫登録情報を入力してください</h2>
	<!-- エラーメッセージの表示 -->
	<c:if test="${not empty errorMessage}">
		<div style="color: red;">
			<p>${errorMessage}</p>
		</div>
	</c:if>
	<form:form action="/insert" method="post" modelAttribute="insertForm">

		<div>
			<label>名前</label>
			<form:input path="coffeeName" />
			<form:errors path="coffeeName" cssClass="error" />
		</div>
		<div>
			<label>個数</label>
			<form:input path="number" />
			<form:errors path="number" cssClass="error" />
		</div>
		<div>
			<label>価格</label>
			<form:input path="price" />
			<form:errors path="price" cssClass="error" />
			<br>
		</div>
<br>
		<button type="submit">登録</button>
		<br>
		<br>
			<a href="adminMenu">メニューに戻る</a>
			
		</div>
	</form:form>
</body>
</html>