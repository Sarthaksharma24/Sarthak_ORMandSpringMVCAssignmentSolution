<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<!-- Style for colouring table rows on the odd child and skipping the heading -->
<style>
tr:nth-child(odd) {
	background-color: #D3D3D3;
}

tr:first-child {
	background: #00FF00;
}
</style>
<head>
<meta charset="UTF-8">
<title>Customer Relationship Management</title>
</head>
<body>

	<div style="background-color: #00FF00">
		<hr width="100%" size="0" />
		<h1 align="middle">CUSTOMER RELATIONSHIP MANAGEMENT</h1>
		<hr width="100%" size="0" />
	</div>
	<br>
	<br>
	<br>
	<div>

		<input type=button
			onClick="location.href='/CustomerRelationshipManagement/addform'"
			value='Add Customer'>
	</div>

	<br>
	<div>

		<table style="width: 100%" cellspacing="0" cellpadding="10">
			<colgroup>
				<col span="1" style="width: 15%;">
				<col span="1" style="width: 15%;">
				<col span="1" style="width: 55%;">
				<col span="1" style="width: 15%;">
			</colgroup>

			<tr bgcolor="#00FF00">
				<th style="text-align: center">First Name</th>
				<th style="text-align: center">Last Name</th>
				<th style="text-align: center">Email</th>
				<th style="text-align: center">Action</th>
			</tr>
			<c:forEach items="${customers}" var="s">
				<tr>
					<td style="text-align: center">${s.firstName}</td>
					<td style="text-align: center">${s.lastName}</td>
					<td style="text-align: center">${s.emailId}</td>
					<td style="text-align: center"><a
						href="/CustomerRelationshipManagement/update?id=${s.id}">Update</a>&nbsp|&nbsp
						<a href="#" onclick="myFunction(${s.id})"> Delete</a></td>
				</tr>

			</c:forEach>
		</table>

	</div>
	<script>

		function myFunction(id) {
			  let text;
			  if (confirm("Are you sure you want to delete?") == true) {
			    text = "You pressed OK!";
			    location.href = '/CustomerRelationshipManagement/delete?id='+id;
			  } else {
			    text = "You canceled!";
			  }
			  document.getElementById("demo").innerHTML = text;
			}
	</script>
</body>
</html>