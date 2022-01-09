<%@ page language="java" contentType="text/html;charset=Windows-31J"%>

<html>
<body>
	<br> 検索条件を入力してください。
	<br>（何も入力しないと全件抽出します）
	<br>
	<br>

	<form action="/budget_tracker_servlet/Search" method="POST">

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
		
		<br><br> <input type="submit" value="Search">
	</form>
	
	<br> 入力画面へ移動
	<a href="./insert.jsp">入力画面へ移動</a>
	

</body>
</html>