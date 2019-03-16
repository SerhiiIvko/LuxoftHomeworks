<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All clients</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap-4.1.3/css/bootstrap.min.css">
</head>
<body>
<h1>all clients</h1>
<td>
    <div class="col-xs-1">
        <a href="/clients?id=${client.id}" type="button"
           class="btn btn-primary btn-success">Show all clients</a>
    </div>
</td>
<div class="row justify-content-md-center">
    <div class="col-xs-10 table-responsive justify-content-md-center">
        <form class="col-10 justify-content-md-center" action="/clients" method="get">
            <table class="table" id="table">
                <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>surname</th>
                    <th>email</th>
                    <th>phone</th>
                    <th>age</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <input type="hidden" name="saveList" value="true">
                <input type="hidden" name="_method" value="put">
                <c:forEach var="client" items="${client}">
                    <tr>
                        <td>
                            <div class="form-group" class="col-xs-1">
                                <input name="id_${client.id}" type="text" class="form-control"
                                       id="clientId"
                                       placeholder="id" value="${client.id}" readonly>
                            </div>
                        </td>
                        <td>
                            <div class="form-group" class="col-xs-2">
                                <input name="name_${client.id}" type="text" class="form-control"
                                       id="clientName"
                                       placeholder="name" value="${client.name}">
                            </div>
                        </td>
                        <td>
                            <div class="form-group" class="col-xs-2">
                                <input name="surname_${client.id}" type="text" class="form-control"
                                       id="clientSurname" placeholder="surname"
                                       value="${client.surname}">
                            </div>
                        </td>
                        <td>
                            <div class="form-group" class="col-xs-2">
                                <input name="email_${client.id}" type="email" class="form-control"
                                       id="clientEmail"
                                       aria-describedby="emailHelp" placeholder="email"
                                       value="${client.email}">
                            </div>
                        </td>
                        <td>
                            <div class="form-group" class="col-xs-1">
                                <input name="age_${client.id}" type="number" class="form-control"
                                       id="clientAge"
                                       placeholder="age" value="${client.age}">
                            </div>
                        </td>

                        <td>
                            <div class="col-xs-1">
                                <a href="/clients?id=${client.id}" type="button"
                                   class="btn btn-primary btn-success">Show</a>
                            </div>
                        </td>
                        <td>
                            <div class="col-xs-1">
                                <a href="/clients?id=${client.id}&_method=delete" type="button"
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
</body>
</html>