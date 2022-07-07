<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Customer</title>
</head>
<body>

	<div style="background-color: #00FF00">
		<hr width="100%" size="0" />
		<h2 style="color: #FFFFFF">CUSTOMER RELATIONSHIP MANAGEMENT</h2>
		<hr width="100%" size="0" />
	</div>

	<br>
	<br>
	<div>
		<h3>${mode} CustomerDetails</h3>
		<form action="save" method="post">
			<table style="width: 100%">
				<tr>
					<td><input type="hidden" name="id" value="${customerObj.id}"></td>
				</tr>
				<tr>
					<td style="width: 15%; text-align: right"><label
						style="text-align: right">First Name:</label></td>
					<td style="width: 5%"></td>
					<td style="width: 80%"><input type="text" name="firstName"
						value="${customerObj.firstName}"></input></td>
				</tr>
				<tr>
					<td style="width: 15%; text-align: right"><label
						style="text-align: right">Last Name:</label></td>
					<td style="width: 5%"></td>
					<td style="width: 80%"><input type="text" name="lastName"
						value="${customerObj.lastName}"></input></td>
				</tr>
				<tr>
					<td style="width: 15%; text-align: right"><label
						style="text-align: right">Email:</label></td>
					<td style="width: 5%"></td>
					<td style="width: 80%"><input type="text" name="emailId"
						value="${customerObj.emailId}"></input></td>
				</tr>

			</table>
			<br> 
			<button Style="margin-left: 20%; background-color: #D3D3D3; border: 0px;width:90px;border-radius: 4px;" type="submit" value="Save">
				Save
			</button>
		</form>
		<br> <a href="/CustomerRelationshipManagement">Back to List</a>
	</div>
</body>
</html>