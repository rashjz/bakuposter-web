<%-- 
    Created on : Apr 11, 2016, 10:54:59 AM
    Author     : Rashad Javadov
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html class="full">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <meta name="google-site-verification" content="gCElmRMfRP73YJhZ1RH24U9KKweS1gondBPMhGP4Foo"/>
    <link rel="icon" href="<c:url value="/resources/images/ico.png" />" type="image/png">
</head>

<body>

<jsp:include page="fragments/header.jsp"/>


<!-- Page Content -->
<div class="container">

    <div class="row">


        <div class="col-md-9">
            <jsp:include page="fragments/carousel.jsp"/>


            <div style=";margin-top: 5%" class="panel panel-default panel-table">
                <div class="panel-heading">User Details</div>
                <div class="panel-body">


                    <!--<div class="row">-->
                    <div class="col-md-5">
                        <div class="row">
                            <img onerror="this.src='http://www.brentfordfc.co.uk/images/common/bg_player_profile_default_big.png'"
                                 src="${imgUrlProfile}" border="0"
                                 style="border-color: #7C7C7C; margin-right: 4px;max-width: 350px;margin-left: 20px;"/>
                        </div>


                        <div style="margin-top: 5px;" class="row">
                            <form:form method="POST" action="uploadimage" enctype="multipart/form-data">
                                <div class="col-sm-10">
                                    <input type="file" id="imagefile" name="imagefile" accept="image/*"
                                           class="form-control input-sm"/>
                                    <div class="has-error">
                                            <%--<form:errors path="imagefile" class="control-label" />--%>
                                    </div>
                                </div>
                                <!--</div>-->
                                <div class="form-actions panel-primary">
                                    <input type="submit" value="Save" class="btn-primary btn-sm pull-right">
                                </div>
                            </form:form>
                        </div>

                    </div>


                    <div class="col-md-5">
                        <b style="color: #008bad">Username : </b> <sec:authentication
                            property="principal.users.username"/>   </br>
                        <hr/>
                        <b style="color: #008bad">Name :</b> <sec:authentication
                            property="principal.users.firstname"/>   </br>
                        <hr/>
                        <b style="color: #008bad">Last Name :</b> <sec:authentication
                            property="principal.users.lastname"/>  </br>
                    </div>

                </div>
            </div>

        </div>


        <div class="col-md-3">
            <jsp:include page="fragments/sidebar.jsp"/>
        </div>
    </div>
</div>


<!-- /.container -->
<jsp:include page="fragments/footer.jsp"/>

</body>
</html>
