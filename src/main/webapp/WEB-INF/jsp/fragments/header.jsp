<%-- 
    Created on : Apr 11, 2016, 10:54:59 AM
    Author     : Rashad Javadov
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head> 
    <meta name="google-site-verification" content="gCElmRMfRP73YJhZ1RH24U9KKweS1gondBPMhGP4Foo" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1"> 

    <c:choose>
        <c:when test="${content.title==null || content.title=='' }">
            <title>BakuPoster</title>
        </c:when>
        <c:otherwise>
            <title>${content.title}</title>
        </c:otherwise>
    </c:choose>
</title> 
<link rel="shortcut icon"  href="${pageContext.request.contextPath}/resources/images/ico.png" type="image/png">
<script type="text/javascript" src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" > 
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"> 
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" /> 


<!-- Google Analytics -->
<script>
    (function (i, s, o, g, r, a, m) {
        i['GoogleAnalyticsObject'] = r;
        i[r] = i[r] || function () {
            (i[r].q = i[r].q || []).push(arguments);
        }, i[r].l = 1 * new Date();
        a = s.createElement(o),
                m = s.getElementsByTagName(o)[0];
        a.async = 1;
        a.src = g;
        m.parentNode.insertBefore(a, m);
    })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');

    ga('create', 'UA-84582617-1', 'auto');
    ga('send', 'pageview');

</script>
<!-- End Google Analytics -->
<link href="${pageContext.request.contextPath}/resources/css/the-big-picture.css" rel="stylesheet">
</head>

<spring:url value="/main" var="urlHome" />
<spring:url value="/projects" var="projects"/>
<spring:url value="/about" var="about" />
<spring:url value="/contact" var="contact" />

<c:choose>
    <c:when test="${typeId==1}">
        <c:set value="active" var="moviemenuclass"></c:set>
        <c:set value="active" var="movieListActiveClass"></c:set>  
    </c:when>
    <c:when test="${typeId==2}">
        <c:set value="active" var="concertmenuclass"></c:set>
        <c:set value="active" var="concertlistclass"></c:set>
    </c:when>
    <c:when test="${typeId==3}">
        <c:set value="active" var="theatermenuclass"></c:set>
        <c:set value="active" var="theaterListActiveClass"></c:set>
    </c:when>
    <c:when test="${typeId==4}">
        <c:set value="active" var="aboutmenuclass"></c:set>  
    </c:when>
    <c:when test="${typeId==5}">
        <c:set value="active" var="contactmenuclass"></c:set>  
    </c:when>
    <c:otherwise>
        <c:set  value="nav-link" var="menuclass"></c:set> 
    </c:otherwise>
</c:choose>

<!-- Navigation -->
<nav class="navbar navbar-fixed-top  navbar-default" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${projects}?typeId=1">BakuPoster</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="${moviemenuclass}"><a class="nav-link" href="${projects}?typeId=1"><spring:message code="movie"/><span class="sr-only">(current)</span></a></li>
                <li class="${concertmenuclass}"><a class="nav-link" href="${projects}?typeId=2"><spring:message code="concert"/></a></li>
                <li class="${theatermenuclass}"><a class="nav-link" href="${projects}?typeId=3"><spring:message code="theater"/></a></li>
                <li class="${aboutmenuclass}"><a class="nav-link" href="${about}"><spring:message code="about"/></a></li> 
                <li class="${contactmenuclass}"><a href="${contact}"><spring:message code="contact"/></a></li>  
            </ul>



            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${dataCode!=null}">
                        <li><a href="<c:url   value="/event?c=${dataCode}&&lang=az" />">AZ</a></li>
                        <li><a href="<c:url   value="/event?c=${dataCode}&&lang=ru" />">RU</a></li>
                        <li><a href="<c:url   value="/event?c=${dataCode}&&lang=en" />">EN</a></li>
                        </c:when>    
                        <c:otherwise>
                        <li><a href="<c:url   value="?lang=az" />">AZ</a></li>
                        <li><a href="<c:url   value="?lang=ru" />">RU</a></li>
                        <li><a href="<c:url   value="?lang=en" />">EN</a></li>
                        </c:otherwise>
                    </c:choose> 


                <sec:authorize access="isAuthenticated()">
                    <sec:authentication var="imgUrlProfile" scope="request" property="principal.users.note"/>
                    <li><a style="padding-top : 2px  ! important; padding-bottom: 2px ! important;" href="<c:url value="/profile" />">
                            <img style="height: 40px;border: 2px solid;border-radius: 25px;" 
                                 onerror="http://www.brentfordfc.co.uk/images/common/bg_player_profile_default_big.png"  src="${imgUrlProfile}">
                        </a>
                    </li> 

                    <li><a href="<c:url value="/logout" />">Log Out</a></li>  
                    </sec:authorize>
                <!--<if not loggenin then show login >-->
                <sec:authorize access="!isAuthenticated()">
                    <li><a href="<c:url value="/login" />">Sign In</a></li>  
                    </sec:authorize> 
            </ul>


            <form action="projects" method="GET" class="navbar-form navbar-right">
                <div class="form-group has-feedback">
                    <label for="search" class="sr-only">Search</label>
                    <input  id="keyValue" name="keyValue"  type="text" class="form-control" name="search"   id="search" placeholder="Açar söz">
                    <span class="glyphicon glyphicon-search form-control-feedback"></span>
                </div>
            </form>


        </div>



        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>


<div id="fb-root"></div> 
<script>
    window.fbAsyncInit = function () {
        FB.init({
            appId: '888848437872798',
            xfbml: true,
            version: 'v2.5'
        });
    };

    (function (d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {
            return;
        }
        js = d.createElement(s);
        js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));


    $(function () {//andoid find us on 
        $('#playapplink').hover(function () {
            $('#playapplink').fadeTo('fast', 0.5);
        }, function () {
            $('#playapplink').fadeTo('fast', 1);
        });
    });
</script>
