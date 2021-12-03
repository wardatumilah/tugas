<%-- 
    Document   : home
    Created on : Nov 26, 2021, 9:33:45 PM
    Author     : wardatumilah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="contend-type="content="text/htm;" charset="UTF-8">
        <title>JSP PAGE</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <h1>Listkas</h1>
        <p>
            <button class ="btn btn-primary"
                    onclick="window.location.href = 'uangkas-form.htm'">
                Add uangkas 
            </button>
        </p>
        <table class="table table-striped table-bordered">
        </table>
    </body>
    <body>
        <h1>Listkas</h1>
        <table class="table table-striped table-bordered">
            <tr class="table-dark">
                <th>id</th>
                <th>nim</th>
                <th>nama</th>
                <th>bulan</th>
                <th>bayar</th>
                <th>action</th>
            </tr>
            <c:forEach items="${listKas}" var="kas">
                <tr>
                    <td>${kas.id}</td>
                    <td>${kas.nim}</td>
                    <td>${kas.nama}</td>
                    <td>${kas.bulan}</td>
                    <td>${kas.bayar}</td>
                    <td>
                        <button class ="btn btn-warning"
                                onclick="window.location.href = 'uangkas-form.htm?action=edit&id=${kas.id}'">
                            edit
                        </button>
                        <button class ="btn btn-danger"
                                onclick="window.location.href = 'uangkas-form.htm?action=delete&id=${kas.id}'">
                            delete 
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html'
