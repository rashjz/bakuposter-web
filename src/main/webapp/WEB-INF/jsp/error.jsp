<%-- 
    Created on : Apr 11, 2016, 10:54:59 AM
    Author     : Rashad Javadov
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html class="full">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
        <link rel="shortcut icon"  href="<c:url value="/resources/images/ico.png" />" type="image/png">
    </head>
    <body style="text-align: center">
        <h1 style="color: red;margin-top: 220px;">UPSS Something went wrong!</h1>
        <p>
            ${exception}
        </p> 
        <img width="250" src= "<c:url value="/resources/images/404.gif"></c:url>" /> 






        <%--<spring:url value="/resources/core/js/hello.js" var="coreJs" />--%>
        <%--<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />--%>

        <script src="${coreJs}"></script>
        <script src="${bootstrapJs}"></script>
    </body>
</html>
