<%-- 
    Document   : uangkas-form
    Created on : Nov 28, 2021, 7:39:19 PM
    Author     : wardatumilah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>add uang kas ${message}</h1><hr/>
            <div class="row">
                <div class ="col-md-4">
                    <form action="uangkas-form.htm"
                          modelAttribute="kas" method="POST">
                        <!--                        <div class ="form-group">
                                                    <input type="text" class ="form-control" name="id"  placeholder="id"/>
                                                </div>-->
                        <div class ="from-group">
                            <input type="text" class="from-control" name ="nim" placeholder="nim" value="${kas.nim}"/>

                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="nama" placeholder="nama" value="${kas.nama}"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="bulan" placeholder="bulan" value="${kas.bulan}"/>
                        </div>
                        <div class="from-group">
                            <input type="txt" class="form-control"  name="bayar" placeholder="bayar" value="${kas.bayar}"/>
                        </div>
                        <input type="hidden" name ="id" value="${kas.id != null ? kas.id : 0}"/>
                        <button type="submit" class="btn btn-primary">save</button>           
                    </form>
                </div>
            </div>
            <a href="${pageContext.request.contextPath}/home.htm">Back to List</a>
        </div>
    </body>
</html>
