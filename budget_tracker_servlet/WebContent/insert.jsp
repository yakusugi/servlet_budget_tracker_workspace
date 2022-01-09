<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br> 入力画面
	<form action="/budget_tracker_servlet/Insert" method="POST">

		ID: <input type="number" name="id"> 
		<br><br>
		Date: <input type="text" name="date">
		<br><br>
		Store Name: <input type="text" name="storeName">
		<br><br>
		Product Name: <input type="text" name="productName">
		<br><br>
		Product Type: <input type="text" name="productType">
		<br><br>
		Price : <input type="number" name="price">
		
		<br><br> <input type="submit" value="Insert">
	</form>
</body>
</html>