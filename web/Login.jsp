<%-- 
    Document   : Login
    Created on : Jun 18, 2025, 4:31:58 PM
    Author     : hungc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <form action="LoginController" method="post">
            <p><input type="text" name="txtemail" required=""/>*</p>
            <p><input type="password" name="txtpassword" required=""/>*</p>
            <p><input type="submit" value="login"/></p>
        </form>
 
        <%
           if(request.getAttribute("ERROR")!=null){
               out.print(request.getAttribute("ERROR"));
           
            }
        %>
    </body>
</html>
