<%-- 
    Created on : Apr 11, 2016, 10:54:59 AM
    Author     : Rashad Javadov
--%>
<%@page  pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html class="full">
    <head>  
        <script type="text/javascript" src="//code.jquery.com/jquery-1.12.0.min.js"></script>
        <meta name="google-site-verification" content="gCElmRMfRP73YJhZ1RH24U9KKweS1gondBPMhGP4Foo" />
        <link rel="icon"  href="<c:url value="/resources/images/ico.png" />" type="image/png">
        <style> 
            #map {
                margin-top: 20px;
                width: 95%;
                height: 400px;
            } 
        </style>
    </head>

    <body>
        <c:url var="home" value="/" scope="request" />

        <jsp:include page="fragments/header.jsp" />


        <!-- Page Content -->
        <div class="container">

            <div class="row">



                <div class="col-md-9">
                    <jsp:include page="fragments/carousel.jsp" />




                    <!--<div class="row">--> 
                        <div   class="panel panel-default"> 
                            <div class="panel-heading"> 
                             Contact
                            </div>
                            <div class="panel-body">
                                Əlaqə :<br/>
                                Tel: (+99470) 223-44-11, 496-94-38 <br/>
                                E-mail: rashadjavad@gmail.com <br/>
                                Ünvan: AZ1008, Bakı şəhəri, Nərimanov rayonu, Şah İsmayıl Xətai küçəsi 152, Luxen Plaza 6-cı mərtəbə<br/>
                                <div style="height: 40%;width: 100%;" id="map"> 
                                </div>


                            </div>
                        </div>


                        <script>
                            function initMap() {
                                var myLatLng = {lat: 40.3906548, lng: 49.8599175};
                                var mapDiv = document.getElementById('map');
                                var map = new google.maps.Map(mapDiv, {
                                    center: myLatLng,
                                    zoom: 14
                                });
                                var marker = new google.maps.Marker({
                                    position: myLatLng,
                                    map: map,
                                    title: 'Bakuposter LLC'
                                });

                                var infowindow = new google.maps.InfoWindow({
                                    content: "Bakuposter LLC"
                                });

                                marker.addListener('click', function () {
                                    infowindow.open(map, marker);
                                });

                            }
                        </script>
                        <!--<script src="https://maps.googleapis.com/maps/api/js?callback=initMap" async defer></script>-->
                        <!--https://developers.google.com/maps/documentation/javascript/get-api-key-->
                        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAS3mhlssgqW-VAKDv9chhUooeQsdSGoxo&&callback=initMap" async defer></script>



                        <!--end of body-->
                    <!--</div>-->

                </div>


                <div class="col-md-3"> 
                    <jsp:include page="fragments/sidebar.jsp" />
                </div>
            </div>

        </div>
        <!-- /.container -->
        <jsp:include page="fragments/footer.jsp" />











    </body>
</html>
