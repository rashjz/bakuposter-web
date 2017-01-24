<%-- 
    Created on : Apr 11, 2016, 10:54:59 AM
    Author     : Rashad Javadov
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html class="full">
<head>
    <script type="text/javascript" src="//code.jquery.com/jquery-1.12.0.min.js"></script>
    <meta name="google-site-verification" content="gCElmRMfRP73YJhZ1RH24U9KKweS1gondBPMhGP4Foo"/>
    <link rel="icon" href="<c:url value="/resources/images/ico.png" />" type="image/png">
    <meta name="description" content="Online film portalı">
    <meta name="author" content="Rashad Javadov">
    <script type="text/css">
        html, body {
            height: 100%
        }

        .sidebar {
            background-color: #eee;
            position: absolute;
            top: 0;
            bottom: 0;
            right: 0;
            width: 30%;
        }

        .wrap {
            min-height: 100%;
            position: relative;
        }
    </script>

</head>

<body>
<jsp:include page="fragments/header.jsp"/>


<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-md-9">
            <jsp:include page="fragments/carousel.jsp"/>


            <!--<div class="row">-->

            <div class="panel panel-default panel-table">
                <div class="panel-heading">
                    About
                </div>
                <center>
                    <div class="embed-responsive embed-responsive-16by9">
                        <iframe class="embed-responsive-item" allowfullscreen="true"
                                src="https://www.youtube.com/embed/14p_FLcC5WE"></iframe>
                    </div>
                </center>
                <div class="panel-body">

                    <p style="margin-top: 20px;font-weight:  bold;">The most convenient way to choose how to spend free
                        time in Baku. A full schedule of movies, concerts, clubs and theater. Reviews reviewers and
                        users of posters for movies, performances and exhibitions. Bookmark your favorite places and
                        events. Buy movie tickets directly in the application will support soon.
                        <br/>
                        The program is available for use by persons 12 years of age or older.
                        <br/>
                        Functionality of android application
                        <br/>
                        * Watch to trailer and poster
                        <br/>
                        * Read description
                        <br/>
                        * Find on map
                        <br/>
                        * Vote or like selected post
                        <br/>
                        * Comment on post
                        <br/>
                        * Event save to calendar feature
                        <br/>
                        * Support google plus and Facebook authorization for user profile for sing in
                        <br/>
                        * Advanced search functionality
                        <br/>
                        * Supporting notification via GCM service
                        <br/>
                        * Current Version 3.7
                        <br/>
                        * Requires Android 4.1 and up </p>


                </div>
            </div>


            <!--</div>-->
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
