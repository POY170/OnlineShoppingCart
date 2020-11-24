<%-- 
    Document   : checkOut
    Created on : Nov 21, 2020, 2:52:08 AM
    Author     : POY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your Order is Confirmed!</h1>
        <h1>The total amount is $<%session.getAttribute("total");%></h1>
        <br><br>
        <a href="catalog.jsp">Catalog</a>
    </body>
</html>
