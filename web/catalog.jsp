<%-- 
    Document   : catalog
    Created on : Nov 19, 2020, 11:05:32 PM
    Author     : POY
--%>

<%@page import="model.DvdTable"%>
<%@page import="model.Dvd"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="dvd" class="model.Dvd" scope="request"/>
    <%
            EntityManager em = (EntityManager) session.getAttribute("entitymanager");
            Vector<Dvd> empList = DvdTable.findAllDvd(em);
            Iterator<Dvd> itr = empList.iterator();
//            Dvd dvd = (Dvd )session.getAttribute("dvd");
     %>
    <body>
        <center>
            <h1>DVD Catalog</h1>
            <table border="1">
                     <tr>                       
                       <th>DVD Names</th>
                       <th>Rate</th>
                       <th>Year</th>
                       <th>Price</th>
                       <th>Quantity</th>
                       <th>Add Cart</th>
                     </tr>
                     
                     <%
                          while(itr.hasNext()) {
                              dvd = itr.next();                        
                     %>
                            <form name="addToCart" action="AddToCartController" method="POST">
                               <input type="hidden" name="id" value="<%=dvd.getId()%>" size="10" />
                               <td><input type="text" name="name" value="<%=dvd.getName()%>" size="10" readonly/></td>
                               <td><input type="text" name="rate" value="<%=dvd.getRate()%>" size="10" readonly/></td>
                               <td><input type="text" name="year" value="<%=dvd.getYr()%>" size="10" readonly/></td>
                               <td><input type="text" name="price" value="<%=dvd.getPrice()%>" size="10" readonly/></td>
                               <td><input type="text" name="qty" value="" size="10" /></td>
                               <td><input type="submit" value="AddToCart" name="submit" /></td>
                            </form>
                               <tr></tr>
                        <%}%>
                     
            </table>
            <a href="cart.jsp">Your Cart</a>
         </center>
    </body>
</html>
