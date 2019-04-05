<%@ page errorPage="error-invalid-data.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Main menu</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="resources/bootstrap-4.1.3/css/bootstrap.min.css">
</head>
<body style="background: aqua">
<h1 align="center" style="color: #155724">Main menu. Choose action.</h1>
<br>
<div align="center">
    <form class="col-6" action=<spring:url value= "/clients"/>>
        <button type="submit" class="btn btn-dark">1. Clients</button>
    </form>
</div>
<br>
<div align="center">
    <form class="col-6" action="<spring:url value= "/products"/>">
        <button type="submit" class="btn btn-dark">1. Products</button>
    </form>
</div>
<br>
</body>
</html>