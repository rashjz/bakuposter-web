<%--
    Created on : Jan 24, 2017, 10:54:59 AM
    Author     : Rashad Javadov
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/mainPagingTag.tld" %>
<html>
<head>
    <meta name="google-site-verification" content="gCElmRMfRP73YJhZ1RH24U9KKweS1gondBPMhGP4Foo"/>
    <link rel="shortcut icon" href="<c:url value="/resources/images/ico.png" />" type="image/png">
</head>

<body>
<jsp:include page="../fragments/header.jsp"/>


<div class="container">
    <div class="row">


            <ul style="margin-top: 20px;" class="list-inline">
                <li><a href="<c:url value="/main"/>" class="btn btn-info">Back</a></li>
            </ul>


        <c:if test="${not empty msg}">
            <div class="alert alert-${css} alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <strong>${msg}</strong>
            </div>
        </c:if>

        <form:form action="main" method="GET">


            <table style="margin-top: 20px;" class="table table-striped table-hover dt-responsive">
                <tr>
                    <th>Id</th>
                    <th>email</th>
                    <th>name</th>
                    <th>date</th>
                    <th>status</th>
                </tr>
                <c:forEach items="${users}" var="cnt" varStatus="itr">
                    <tr>
                        <!--<td>$!{offset + itr.index +1 }</td>-->
                        <td>${cnt.id }</td>
                        <td>${cnt.email }</td>
                        <td>${cnt.name }</td>
                        <td>${cnt.createdAt }</td>
                        <td>${cnt.status}</td>

                    </tr>
                </c:forEach>
            </table>
        </form:form>
    </div>
</div>


<%--<jsp:include page="../fragments/footer.jsp"/>--%>
</body>
</html>