<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="../../libs/bootstrap-4.1.3/css/bootstrap.min.css">
    <title>View product details</title>
</head>
<body style="background: palevioletred">
<div align="center">
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-auto">
                <h3>View product details</h3>
            </div>
        </div>
        <div class="col-6">
            <%
                String createParam = request.getParameter("create");
                pageContext.setAttribute("create", createParam != null && Boolean.valueOf(createParam));
            %>
            <form class="col-6" action="/products" method="post">
                <input type="hidden" name="_method" value="${create?'post':'put'}">
                <c:if test="${!create}">
                    <div class="form-group">
                        <label for="productId">id</label>
                        <input name="id" type="text" class="form-control" id="productId" placeholder="id"
                               value="${create ? '': product.id}" readonly>
                    </div>
                </c:if>
                <div class="form-group">
                    <label for="productName">Name</label>
                    <input name="name" type="text" class="form-control" id="productName" placeholder="name"
                           value="${create ? '': product.name}">
                </div>
                <div class="form-group">
                    <label for="productType">Product type</label>
                    <input name="productType" type="text" class="form-control" id="productType" placeholder="Product type"
                           value="${create ? '': product.productType}">
                </div>

                <div class="form-group">
                    <label for="price">Price</label>
                    <input name="price" type="number" step="0.01" min="0" class="form-control" id="price" placeholder="price"
                           value="${create ? '': product.price}">
                </div>
                <button type="submit" class="btn btn-primary">Save</button>
            </form>
            <br>
            <div class="row justify-content-md-center">
                <div class="col-xs-3">
                    <a href="/WEB-INF/views/index.jsp" type="button" class="btn btn-primary">Main page</a>
                </div>
                <br/>
            </div>
        </div>
    </div>
</div>
</body>
</html>