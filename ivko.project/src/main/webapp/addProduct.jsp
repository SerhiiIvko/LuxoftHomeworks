<%@ page errorPage="WEB-INF/error-invalid-data.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add product</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap-4.1.3/css/bootstrap.min.css">
</head>
<body style="background: tomato">
<div align="center">
    <div class="row justify-content-md-center">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-md-auto">
                    <h1 align="center">Add new product</h1>
                </div>
            </div>
            <div align="center">
                <form class="col-6" action="/addProduct" method="post">
                    <div class="form-group">
                        <label for="productName">Name</label>
                        <input name="name" type="text" class="form-control" id="productName"
                               placeholder="Name">
                    </div>
                    <div class="form-group">
                        <label for="productType">Product type</label>
                        <input name="productType" type="text" class="form-control" id="productType"
                               placeholder="Product type">
                    </div>
                    <div class="form-group">
                        <label for="productPrice">Price</label>
                        <input name="price" type="number" step="0.01" min="0" class="form-control" id="productPrice"
                               placeholder="Price">
                    </div>
                    <button type="submit" class="btn btn-primary">Add product</button>
                </form>
            </div>
            <br>
            <div class="row justify-content-md-center">
                <div class="col-xs-3">
                    <a href="/menu.jsp" type="button" class="btn btn-primary">Main page</a>
                </div>
                <br/>
            </div>
        </div>
    </div>
</div>
</body>
</html>