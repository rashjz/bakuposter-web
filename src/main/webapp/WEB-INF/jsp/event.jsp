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

<html class="full">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <spring:url value="/resources/css/social-share-kit.css" var="socialShare"/>
    <meta name="google-site-verification" content="gCElmRMfRP73YJhZ1RH24U9KKweS1gondBPMhGP4Foo"/>
    <link rel="icon" href="<c:url value="/resources/images/ico.png" />" type="image/png">
    <link href="${socialShare}" rel="stylesheet"/>
    <spring:url value="/resources/js/social-share-kit.js" var="socialShareJS"/>
    <script type="text/javascript" src="${socialShareJS}"></script>

</head>

<body>


<script type="text/javascript">
    SocialShareKit.init({
        onBeforeOpen: function (targetElement, network, paramsObj) {
            console.log(arguments);
        },
        onOpen: function (targetElement, network, networkUrl, popupWindow) {
            console.log(arguments);
        },
        onClose: function (targetElement, network, networkUrl, popupWindow) {
            console.log(arguments);
        }
    });
</script>


<jsp:include page="fragments/header.jsp"/>


<!-- Page Content -->
<div class="container">

    <div class="row">


        <div class="col-md-9">
            <jsp:include page="fragments/carousel.jsp"/>


            <div style="margin-top: 5%" class="panel panel-default">
                <div class="panel-heading">
                    <div style="font-weight: bolder;" class="panel-title pull-left">
                        ${content.title}
                    </div>
                    <div class="panel-title pull-right">${content.insDate}</div>
                    <div class="clearfix"></div>
                </div>

                <div class="panel-body">


                    <div class="row">
                        <div class="col-md-5">
                            <img onerror="this.src='${pageContext.request.contextPath}/resources/images/noimage.jpg'"
                                 src="${content.imgUrl}" border="0" class="img-responsive"
                                 style="border-color: #7C7C7C; margin-right: 4px;max-width: 350px;"/>
                        </div>

                        <div style="margin-left: 2%" class="col-md-5">
                            <b style="color: #008bad"><spring:message code="additional"/>
                                : </b> ${content.description} </br>

                            <b style="color: #008bad"><spring:message code="enddate"/> :</b> ${content.endDate}  </br>

                            <b style="color: #008bad"><spring:message code="genre"/> :</b> ${content.genre}   </br>

                            <b style="color: #008bad"><spring:message code="producer"/>
                                :</b> ${content.producer}   </br>

                            <b style="color: #008bad"><spring:message code="writer"/> :</b> ${content.writer}   </br>

                            <b style="color: #008bad"><spring:message code="price"/> :</b> ${content.price} AZN  </br>

                            <b style="color: #008bad"><spring:message code="added"/> :</b> ${content.insDate}   </br>

                            <!-- public shares -->

                            <div style="margin-top: 5%" class="ssk-sm ssk-group"
                                 data-url="bakuposter.com/event?c=${dataCode}"
                                 data-text="${content.description}"
                                 data-title="${content.title}" data-image="${content.imgUrl}">
                                <a class="ssk ssk-facebook"></a>
                                <a class="ssk ssk-twitter"></a>
                                <a class="ssk ssk-google-plus"></a>
                            </div>

                            <div style="margin-top: 5%" data-send="true"
                                 class="fb-like"
                                 data-share="true"
                                 data-width="350"
                                 data-show-faces="true">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <c:choose>
                <c:when test="${content.videoUrl!=null && content.videoUrl!=''}">
                    <div style="margin-top: 2%;" class="panel panel-default">
                        <div class="panel-heading">Video</div>
                        <div class="panel-body">
                            <center>
                                <div style="border: none;margin-top: 2%;"
                                     class="embed-responsive embed-responsive-16by9">
                                    <iframe class="embed-responsive-item" allowfullscreen="true"
                                            src="https://www.youtube.com/embed/${content.videoUrl}"></iframe>
                                </div>
                            </center>
                        </div>
                    </div>
                </c:when>
            </c:choose>


            <div style="margin-top: 2%;" class="panel panel-default">
                <div class="panel-heading">Map</div>
                <div class="panel-body">

                    <div style="height: 40%;width: 100%;" id="map">
                    </div>

                </div>
            </div>


            <script>
                function initMap() {
                    var title = '<c:out value="${location.title}"/>';
                    var latitude =<c:out value="${location.latitude}"/>;
                    var longitude =<c:out value="${location.longitude}"/>;

//                            console.log(paramOne);
                    var myLatLng = {lat: latitude, lng: longitude};
                    var mapDiv = document.getElementById('map');
                    var map = new google.maps.Map(mapDiv, {
                        center: myLatLng,
                        zoom: 14
                    });
                    var marker = new google.maps.Marker({
                        position: myLatLng,
                        map: map,
                        title: title
                    });
                }
            </script>

            <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAS3mhlssgqW-VAKDv9chhUooeQsdSGoxo&&callback=initMap"
                    async defer></script>


            <div class="fb-comments" data-href="bakuposter.com/event?c=${dataCode}#configurator" data-mobile="true"
                 data-numposts="5"></div>
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
