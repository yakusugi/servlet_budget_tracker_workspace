<%@ page language="java" contentType="text/html;charset=Windows-31J"%>

<html>
<body>
	<br> ������������͂��Ă��������B
	<br>�i�������͂��Ȃ��ƑS�����o���܂��j
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
	
	<br> ���͉�ʂֈړ�
	<a href="./insert.jsp">���͉�ʂֈړ�</a>
	

</body>
</html>