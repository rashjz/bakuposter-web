<%-- 
    Created on : Apr 11, 2016, 10:54:59 AM
    Author     : Rashad Javadov
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/projectsPagingTag.tld" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html class="full">
<head>
    <script type="text/javascript" src="//code.jquery.com/jquery-1.12.0.min.js"></script>
    <meta name="google-site-verification" content="gCElmRMfRP73YJhZ1RH24U9KKweS1gondBPMhGP4Foo"/>
    <meta name="description" content="Online film portalı">
    <meta name="author" content="Rəşad Cavadov">

    <link href="${pageContext.request.contextPath}/resources/css/projectGrid.css" rel="stylesheet">


    <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
    <script>
        (adsbygoogle = window.adsbygoogle || []).push({
            google_ad_client: "ca-pub-9257288331240431",
            enable_page_level_ads: true
        });
    </script>
</head>

<body>
<jsp:include page="fragments/header.jsp"/>


<!-- Page Content -->
<div class="container">
    <div class="row">


        <div class="col-md-9">
            <jsp:include page="fragments/carousel.jsp"/>


            <div class="row">

                <c:if test="${not empty clist}">
                    <c:forEach var="content" items="${clist}">
                        <div class="col-sm-4 col-lg-4 col-md-4">
                            <div class="thumbnail">

                                <div class="hovereffect">
                                    <img src="${content.imgUrl}" style="max-height: 400px;min-height: 400px;"
                                         onerror="this.src='${pageContext.request.contextPath}/resources/images/noimage.jpg'"
                                         class="img-responsive ">
                                    <div class="overlay">
                                        <h2></h2>
                                        <p style="margin-top: 5px;">
                                            <a href="<c:url value="/event?c=${content.recId}" />">
                                                    ${content.title}
                                            </a>
                                        </p>
                                    </div>
                                </div>

                                <div class="caption">
                                    <h4>
                                        <a href="<c:url value="/event?c=${content.recId}" />">
                                            <c:set var="shortDesc" value="${fn:substring(content.title,0,28)}"/>
                                                ${shortDesc}
                                        </a>
                                    </h4>
                                </div>
                                <div class="ratings">
                                    <p class="pull-right">${content.insDate}</p>
                                    <p>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star-empty"></span>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>


            <div style="margin-left: 10px;margin-top: 10px;background: transparent;" class="panel">
                <tag:paginate max="15" offset="${offset}" count="${count}" uri="projects" typeId="${typeId}"
                              keyValue="${keyValue}" next="&raquo;" previous="&laquo;"/>
            </div>


        </div>

        <div style="background: transparent;" class="col-md-3">
            <jsp:include page="fragments/sidebar.jsp"/>
        </div>
    </div>

</div>


<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
