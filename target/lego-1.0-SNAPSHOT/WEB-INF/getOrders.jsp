<%-- 
    Document   : orderpage
    Created on : 17-10-2018, 20:04:04
    Author     : frederik
--%>

<%@page import="java.util.List"%>
<%@page import="Data.user"%>
<%@page import="Data.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <%
            String user = (String) session.getAttribute("email");
            out.print("Orders for:" + user);
            %>
            
            <table class="table table-striped">
                <thead><tr><th>x1</th><th>x2</th><th>x4</th><th>OrderID</th></tr></thead> <tbody>
                    <%
            List<Order> o = (ArrayList<Order>) session.getAttribute("order");
            for (Order or : o) {
            %>
             <tr>
                    <td><%= or.getX1()%></td><td><%= or.getX2()%></td><td><%= or.getX4()%></td><td><%= or.getOrderID()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
