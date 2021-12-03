<%-- 
    Document   : login
    Created on : Nov 26, 2021, 9:52:09 PM
    Author     : wardatumilah
--%>

<%@include file="include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN TO APLIKASI</title>
    </head>
    <body>
        <form:form method="POST" modelAttribute="emp"> 
            <table align="center">
                <tr>
                    <td>username</td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>password</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td clospan="2">
                        <!--                    <input type="submit" value="login"/>-->
                        <input type="submit" value="Login" />
                    </td>
                </tr>
                <tr>
                    <td clospan="2">${message}</td>
                </tr>
            </table>
        </form:form>
    </body>
</html>

