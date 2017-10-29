<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
				List of Customers	
		</title>
		
		<!--  refernce to css style sheet -->
		<link
			type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css"/>
			
	</head>

	<body>
		<div id="wrapper">
			<div id="header">
				<h2> CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
			
				<!-- put new button: add button -->
				<input type="button" value="Add Customer"
							onClick="window.location.href='showFormForAdd'; return false;"
							class="add-button">
							
				<!-- add our html table here -->
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					
					<!--  loop over the customer model and print data -->
					<c:forEach var = "tempCusotmer" items="${customers}">
					
						<!-- construct an update link with customer id -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCusotmer.id}"/>
						</c:url>
						<tr>
							<td>${tempCusotmer.firstName}</td>
							<td>${tempCusotmer.lastName}</td>
							<td>${tempCusotmer.email}</td>
							<td>
							<!--  display the update link -->
							<a href="${updateLink}">Update</a>
							</td>
						</tr>
					
					</c:forEach>
				</table>
			</div>
		</div>
	</body>

</html>