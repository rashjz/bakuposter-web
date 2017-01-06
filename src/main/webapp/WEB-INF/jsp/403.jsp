<%-- 
    Document   : 403
    Created on : Jun 17, 2016, 1:35:53 AM
    Author     : Rashad Javadov
second step register in controller third step add http 
<access-denied-handler error-page="/403" />
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html class="full">
    <head> 
    </head>
    <body style="text-align: center;color: red;">
        
        <div style="margin-top: 20px;">
             <img width="350"  src= "<c:url value="/resources/images/403.png"></c:url>" /> 
        </div>
        <h1>HTTP Status 403 - Access is denied</h1>
        <h2>${msg}</h2> <a href="<c:url value="/logout" />">Login</a>
    </body>
</html>