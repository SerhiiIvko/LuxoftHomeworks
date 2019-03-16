<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap-4.1.3/css/bootstrap.min.css">
    <title>View client Info</title>
</head>
<body>
<div>
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-auto">
                <h3>View client Info</h3>
            </div>
        </div>
        <div class="col-6">
            <%
                String createParam = request.getParameter("create");
                pageContext.setAttribute("create", createParam != null && Boolean.valueOf(createParam));
            %>
            <form class="col-6" action="/clients" method="post">
                <input type="hidden" name="_method" value="${create?'post':'put'}">
                <c:if test="${!create}">
                    <div class="form-group">
                        <label for="clientId">id</label>
                        <input name="id" type="text" class="form-control" id="clientId" placeholder="id"
                               value="${create ? '': client.id}" readonly>
                    </div>
                </c:if>
                <div class="form-group">
                    <label for="clientName">Name</label>
                    <input name="name" type="text" class="form-control" id="clientName" placeholder="name"
                           value="${create ? '': client.name}">
                </div>
                <div class="form-group">
                    <label for="clientSurname">Surname</label>
                    <input name="surname" type="text" class="form-control" id="clientSurname" placeholder="surname"
                           value="${create ? '': client.surname}">
                </div>

                <div class="form-group">
                    <label for="clientEmail">Email</label>
                    <input name="email" type="email" class="form-control" id="clientEmail" aria-describedby="emailHelp"
                           placeholder="email" value="${create ? '': client.email}">
                </div>
                <div class="form-group">
                    <label for="clientPhone">Phone</label>
                    <input name="phone" type="text" class="form-control" id="clientPhone" placeholder="phone"
                           value="${create ? '': client.phone}" readonly>
                </div>
                <div class="form-group">
                    <label for="clientAge">Age</label>
                    <input name="age" type="text" class="form-control" id="clientAge" placeholder="age"
                           value="${create ? '': client.age}" readonly>
                </div>
                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>