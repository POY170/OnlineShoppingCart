<%-- 
    Document   : shoppingCart
    Created on : Nov 21, 2020, 1:39:32 AM
    Author     : POY
--%>

<%@page import="java.util.List"%>
<%@page import="model.CartTable"%>
<%@page import="model.Cart"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Vector"%>
<%@page import="model.DvdTable"%>
<%@page import="model.Dvd"%>
<%@page import="model.Dvd"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="cart" class="model.Cart" scope="request"/>
    <%
            EntityManager em = (EntityManager) session.getAttribute("entitymanager");
            List<Cart> cartList = CartTable.findAllCart();
            Iterator<Cart> itr = cartList.iterator();
     %>
    <body>
        <center>
            <h1>Shopping Cart</h1>
            <table border="1">
                     <tr>                       
                       <th>DVD Names</th>
                       <th>Rate</th>
                       <th>Year</th>
                       <th>Price</th>
                       <th>Quantity</th>
                       <th>Remove</th>
                     </tr>
                     
                     <%
                          while(itr.hasNext()) {
                              cart = itr.next();
                              out.println("<tr>");
                              out.println("<td> "+ cart.getName() + "</td>");
                              out.println("<td> "+ cart.getRate() + "</td>");
                              out.println("<td> "+ cart.getYr() + "</td>");
                              out.println("<td> "+ cart.getPrice() + "</td>");                                                
                              out.println("<td> "+ cart.getQty() + "</td>"); 
                     %>
                     <form name="remove" action="RemoveController" method="POST">                        
                        <input type="hidden" name="id" value="<%=cart.getId()%>" size="10" />
                        <td><input type="submit" value="Remove" name="remove" /></td>
                     </form>
                        <tr></tr>
                     <%}%>
                    
            </table>
            <form name="check" action="CheckOutController" method="POST">
               <td><input type="submit" value="Check out" name="checkout" /></td>
            </form>
                     <a href="catalog.jsp">Catalog</a>
         </center>
    </body>
</html>
