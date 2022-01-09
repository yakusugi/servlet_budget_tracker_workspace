<%@ page language="java" contentType="text/html;charset=Windows-31J"%>
<%@page import="java.sql.*"%>

<html>
<head>
<title></title>
</head>
<body>
	<br>

	<%
		ResultSet rset = (ResultSet) request.getAttribute("result");
	%>
	<table border="1">
		<tr bgcolor="#cccccc">
			<td><b>ID</b></td>
			<td><b>Date</b></td>
			<td><b>Store Name</b></td>
			<td><b>Product Name</b></td>
			<td><b>Product Type</b></td>
			<td><b>Price</b></td>
		</tr>
		<%
			while (rset.next()) {
		%>
		<tr>
			<td><%=rset.getInt(1)%></td>
			<td><%=rset.getDate(2)%></td>
			<td><%=rset.getString(3)%></td>
			<td><%=rset.getString(4)%></td>
			<td><%=rset.getString(5)%></td>
			<td><%=rset.getInt(6)%></td>
		</tr>
		<%
			}
		%>
	</table>

	<br>

	<a href="./index.jsp">ƒgƒbƒv‚É–ß‚é</a>

</body>
</html>
