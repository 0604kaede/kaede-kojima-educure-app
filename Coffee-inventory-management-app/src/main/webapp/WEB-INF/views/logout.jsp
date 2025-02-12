<%-- ログアウト画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
	<h1>ログアウトしました</h1>
	<p>3秒後にログイン画面に遷移します。</p>
	<script>
		setTimeout(function() {
			window.location.href = "login";
		}, 3000);
	</script>
</body>
</html>