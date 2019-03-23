<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of products</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="../../libs/bootstrap-4.1.3/css/bootstrap.min.css">
</head>
<body style="background: lightblue">
<div align="center">
    <div class="body">
        <div class="container">
            <div class="row">
                <div class="col-xs-6 whiteback">
                    <h3 class="text-center">List of products</h3>
                    <hr>
                    <div align="center">
                        <form method="get" action="/products?id=${id}">
                            <div class="col-xs-3">
                                <input type="search" name="id">
                            </div>
                            <br>
                            <div align="center" class="col-xs-3">
                                <input align="center" type="submit" value="Search by id"
                                       class="btn btn-primary btn-success"
                                       placeholder="Search by id">
                            </div>
                        </form>
                    </div>
                    <hr>
                    <div class="row justify-content-md-center">
                        <div class="col-xs-10 table-responsive justify-content-md-center">
                            <form class="col-10 justify-content-md-center" action="/products" method="get">
                                <table class="table" id="table">
                                    <thead>
                                    <tr>
                                        <th>id</th>
                                        <th>name</th>
                                        <th>price</th>
                                        <th>product type</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <input type="hidden" name="saveList" value="true">
                                    <input type="hidden" name="_method" value="put">
                                    <c:forEach var="product" items="${products}">
                                        <tr>
                                            <td>
                                                <div class="form-group" class="col-xs-1">
                                                    <input name="id_${product.id}" type="text" class="form-control"
                                                           id="productId"
                                                           placeholder="id" value="${product.id}" readonly>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group" class="col-xs-2">
                                                    <input name="name_${product.id}" type="text" class="form-control"
                                                           id="productName"
                                                           placeholder="name" value="${product.name}">
                                                </div>
                                            </td>

                                            <td>
                                                <div class="form-group" class="col-xs-2">
                                                    <input name="productType_${product.id}" type="productType" class="form-control"
                                                           id="productType"
                                                           placeholder="productType"
                                                           value="${product.productType}">
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group" class="col-xs-2">
                                                    <input name="price_${product.id}" type="text" class="form-control"
                                                           id="price" placeholder="price"
                                                           value="${product.price}">
                                                </div>
                                            </td>
                                            <td>
                                                <div class="col-xs-1">
                                                    <a href="/products?id=${product.id}" type="button"
                                                       class="btn btn-primary btn-success">Show details</a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="col-xs-1">
                                                    <a href="/products?id=${product.id}&_method=delete" type="button"
                                                       class="btn btn-primary">Delete</a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </form>
                        </div>
                    </div>
                    <br/>
                    <div class="row justify-content-md-center">
                        <div class="col-xs-3">
                            <a href="/WEB-INF/views/addProduct.jspct.jsp?create=true" type="button" class="btn btn-primary">Add product</a>
                        </div>
                        &emsp; &emsp; &emsp;
                        <div class="col-xs-3">
                            <a href="/WEB-INF/views/menu.jsp" type="button" class="btn btn-primary">Main page</a>
                        </div>
                        <br/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>