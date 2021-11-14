<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="index.jsp"><button>Back to Insert</button></a>
<br>
<h3>${msg}</h3>
<table>
<c:choose>
<c:when test="${!empty data}">
<c:if test="${data!=null}">
<tr>
<td>Id</td>
<td>Brand Name</td>
<td>Model Number</td>
<td>Model Name</td>
<td>Type</td>
<td>RAM</td>
<td>ROM</td>
<td>Price</td>
<td>Availability</td>
</tr>
<c:forEach var="item" items="${data}">
<tr>
<td>${item.id}</td>
<td>${item.brandName}</td>
<td>${item.modelNumber}</td>
<td>${item.modelName}</td>
<td>${item.type}</td>
<td>${item.ram}</td>
<td>${item.rom}</td>
<td>${item.price}</td>
<td>${item.availability}</td>
</tr>
</c:forEach>
</c:if>
</c:when>
<c:otherwise>
<h4>Data not found</h4>
</c:otherwise>
</c:choose>
</table>
</body>
</html>