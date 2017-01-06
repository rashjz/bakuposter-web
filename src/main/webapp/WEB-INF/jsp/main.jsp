<%-- 
    Created on : Apr 11, 2016, 10:54:59 AM
    Author     : Rashad Javadov
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/mainPagingTag.tld"%>
<html>
    <head>  
        <meta name="google-site-verification" content="gCElmRMfRP73YJhZ1RH24U9KKweS1gondBPMhGP4Foo" />
        <link rel="shortcut icon"  href="<c:url value="/resources/images/ico.png" />" type="image/png">
    </head>

    <body>
        <jsp:include page="fragments/header.jsp" />



        <div class="container">
            <div class="row">   


                <div class="container"> 
                    <ul style="margin-top: 20px;" class="list-inline">
                        <li><a  href="<c:url value="view/add"/>" class="btn btn-info">Add Content</a></li>
                        <li><a  href="<c:url value="location"/>" class="btn btn-info">Add Location</a></li>

                    </ul>
                </div>


                <c:if test="${not empty msg}">
                    <div class="alert alert-${css} alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert"
                                aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                        <strong>${msg}</strong>
                    </div>
                </c:if>

                <form:form action="main"    method="GET">


                    <table style="margin-top: 20px;" class="table table-striped table-hover dt-responsive">
                        <tr>
                            <th>Id</th>
                            <th>title</th>
                            <th>genre</th>
                            <th>date</th>
                            <th>price</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach items="${contents}" var="cnt" varStatus="itr">
                            <tr>
                                <!--<td>$!{offset + itr.index +1 }</td>-->
                                <td>${cnt.recId }</td>
                                <td>${cnt.title }</td>
                                <td>${cnt.genre }</td>
                                <td>${cnt.endDate}</td>
                                <td>${cnt.price }</td>
                                <td>
                                    <a   href="<c:url value="event?c=${cnt.recId }"/>" class="btn btn-success"> <span class="glyphicon glyphicon-zoom-in"></span></a>
                                    <a   href="<c:url value="view/${cnt.recId }"/>" class="btn btn-info"><span class="glyphicon glyphicon-edit"></span></a>
                                    <a   href="<c:url value="view/${cnt.recId }/delete"/>" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></a> 
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <tag:paginate max="15" offset="${offset}" count="${count}" uri="main" next="&raquo;" previous="&laquo;" />

                </form:form>
            </div> 
        </div>



        <jsp:include page="fragments/footer.jsp" />
    </body>
</html>