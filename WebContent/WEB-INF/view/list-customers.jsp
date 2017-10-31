<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
							
				  <!--  add a search box -->
            	<form:form action="searchCustomer" method="POST">
               	 Search customer: <input type="text" name="theSearchName" />
                
                	<input type="submit" value="Search" class="add-button" />
            	</form:form>
							
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
						
						<!-- construct an delete link with customer id -->
						<c:url var="deleteLink" value="/customer/deleteCustomer">
							<c:param name="customerId" value="${tempCusotmer.id}"/>
						</c:url>
						<tr>
							<td>${tempCusotmer.firstName}</td>
							<td>${tempCusotmer.lastName}</td>
							<td>${tempCusotmer.email}</td>
							<td>
							<!--  display the update link -->
							<a href="${updateLink}">Update</a>
							|
							</td>
							<td>
							<!--  display the delete link -->
							<a href="${deleteLink}"
							onClick="if(!(confirm('Are You sure want Delete?'))) return false">Delete </a>
							</td>
						</tr>
					
					</c:forEach>
				</table>
			</div>
		</div>
	</body>

</html>