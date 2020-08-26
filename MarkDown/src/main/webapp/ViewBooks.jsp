
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="java.util.Iterator" %>

<%@ page import="models.Characters" %>
<%@ page import="Beans.CharacterBean" %>

<%@ page import="Tasks.CharacterTask" %>
<%@ page import="javax.ejb.EJB" %>
<%@ page import="models.Books" %>
<%@ page import="Tasks.BooksTask" %>
<%@page errorPage="ErrorPage.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: faima
  Date: 2/27/17
  Time: 7:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<style>
		table {
			font-family: arial, sans-serif;
			border-collapse: collapse;
			width: 100%;
		}

		td, th {
			border: 1px solid #dddddd;
			text-align: left;
			padding: 8px;
		}

		tr:nth-child(even) {
			background-color: #dddddd;
		}
	</style>
</head>
<body>

<%
	BooksTask characterTask = (BooksTask) request.getAttribute("BooksTask");

	Iterator<Books> i = characterTask.viewDetails().iterator();
    while (i.hasNext()){
        Books e = i.next();

%>
<table>
	<tr>
		<th>Book ID</th>
		<th>Book Name</th>
		<th>Book Number</th>
		<th>Book Desc</th>



	</tr>

	<tr>
        <td><%=e.getBookId()%></td>
		<td><%=e.getBookName() %></td>
        <td><%=e.getBookNumber()%></td>
		<td><%=e.getDescription()%></td>


	</tr>
	<%}%>
</table>

</body>
</html>
