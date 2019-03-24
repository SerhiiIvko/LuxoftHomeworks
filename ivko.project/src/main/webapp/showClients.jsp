<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of clients</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap-4.1.3/css/bootstrap.min.css">
</head>
<body style="background: lightblue">
<div align="center">
    <div class="body">
        <div class="container">
            <div class="row">
                <div class="col-xs-6 whiteback">
                    <h3 class="text-center">List of clients</h3>
                    <hr>
                    <div align="center">
                        <form method="get" action="/clients?id=${id}">
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
                                    <c:forEach var="client" items="${clients}">
                                        <tr>
                                            <td>
                                                <div class="form-group" class="col-xs-1">
                                                    <input name="id_${client.id}" type="text" class="form-control"
                                                           id="clientId"
                                                           placeholder="id"
                                                           value="${client.id}" readonly>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group" class="col-xs-2">
                                                    <input name="name_${client.id}" type="text" class="form-control"
                                                           id="clientName"
                                                           placeholder="name"
                                                           value="${client.name}" readonly>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group" class="col-xs-2">
                                                    <input name="surname_${client.id}" type="text" class="form-control"
                                                           id="clientSurname"
                                                           placeholder="surname"
                                                           value="${client.surname}" readonly>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group" class="col-xs-2">
                                                    <input name="email_${client.id}" type="email" class="form-control"
                                                           id="clientEmail"
                                                           aria-describedby="emailHelp"
                                                           placeholder="email"
                                                           value="${client.email}" readonly>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group" class="col-xs-1">
                                                    <input name="phone_${client.id}" type="text" class="form-control"
                                                           id="clientPhone"
                                                           placeholder="phone"
                                                           value="${client.phone}" readonly>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group" class="col-xs-1">
                                                    <input name="age_${client.id}" type="text" class="form-control"
                                                           id="clientAge"
                                                           placeholder="age"
                                                           value="${client.age}" readonly>
                                                </div>
                                            </td>

                                            <td>
                                                <div class="col-xs-1">
                                                    <a href="clients?id=${client.id}" type="button"
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
                    <div class="row justify-content-md-center">
                    <div class="col-xs-3">
                        <a href="/createClient.jsp?create=true" type="button" class="btn btn-primary">Add client</a>
                    </div>
                        &emsp; &emsp; &emsp;
                    <div class="col-xs-3">
                        <a href="/menu.jsp" type="button" class="btn btn-primary">Main page</a>
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