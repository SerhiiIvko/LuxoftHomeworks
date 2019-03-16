<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap-4.1.3/css/bootstrap.min.css">
    <title>Modify client</title>
</head>

<body>
<div>
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-auto">
                <h3>View Manager Info</h3>
            </div>
        </div>
        <div class="col-6">
            <%
                String createParam = request.getParameter("create");
                pageContext.setAttribute("create", createParam != null && Boolean.valueOf(createParam));
            %>
            <form class="col-6" action="/managers" method="post">
                <input type="hidden" name="_method" value="${create?'post':'put'}">
                <c:if test="${!create}">
                    <div class="form-group">
                        <label for="managerId">id</label>
                        <input name="id" type="text" class="form-control" id="managerId" placeholder="id"
                               value="${create ? '': manager.id}" readonly>
                    </div>
                </c:if>
                <div class="form-group">
                    <label for="managerName">Name</label>
                    <input name="name" type="text" class="form-control" id="managerName" placeholder="name"
                           value="${create ? '': manager.name}">
                </div>
                <div class="form-group">
                    <label for="managerSurname">Surname</label>
                    <input name="surname" type="text" class="form-control" id="managerSurname" placeholder="surname"
                           value="${create ? '': manager.surname}">
                </div>
                <div class="form-group">
                    <label for="managerAge">Age</label>
                    <input name="age" type="number" class="form-control" id="managerAge" placeholder="age"
                           value="${create ? '': manager.age}">
                </div>
                <div class="form-group">
                    <label for="managerEmail">Email</label>
                    <input name="email" type="email" class="form-control" id="managerEmail" aria-describedby="emailHelp"
                           placeholder="email" value="${create ? '': manager.email}">
                </div>
                <div class="form-group">
                    <label for="managerPassword">Password</label>
                    <input name="password" type="password" class="form-control" id="managerPassword"
                           placeholder="new password">
                </div>
                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>