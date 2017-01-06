<%-- 
    Created on : Apr 11, 2016, 10:54:59 AM
    Author     : Rashad Javadov
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/mainPagingTag.tld"%>
<html >
    <head>  
        <script type="text/javascript" src="//code.jquery.com/jquery-1.12.0.min.js"></script>  
        <link rel="shortcut icon"  href="<c:url value="/resources/images/ico.png" />" type="image/png">
        <meta name="google-site-verification" content="gCElmRMfRP73YJhZ1RH24U9KKweS1gondBPMhGP4Foo" />
    </head>

    <body>
        <jsp:include page="fragments/header.jsp" />



        <div class="container">
            <div class="row">  


                <div style="height: 100%;width: 100%;" id="map"> 
                </div>


                <script>
                    function initMap() {
                        var myLatLng = {lat: 40.3906548, lng: 49.8599175};
                        var mapDiv = document.getElementById('map');
                        var map = new google.maps.Map(mapDiv, {
                            center: myLatLng,
                            zoom: 13
                        });
                    <c:forEach var="bulkItem" items="${listLocation}">
 
                        var marker = new google.maps.Marker({
                            position: {lat: <c:out value="${bulkItem.latitude}"/>, lng: <c:out value="${bulkItem.longitude}"/>},
                            map: map,
                            title: '<c:out value="${bulkItem.title}"/>'
                        });
                    </c:forEach>


                        google.maps.event.addListener(map, "click", function (event) {
                            var myLatLng = event.latLng;
                            var lat = myLatLng.lat();
                            var lng = myLatLng.lng();
                            var contentString = "<form method='get' id='add-card-form' action='newlocation'  ><table>" +
                                    "<tr><td>Name:</td> <td><input  type='text' id='title' name='title'/> </td> </tr>" +
                                    "<tr><td>Lat:</td> <td><input  id='latitude' name='latitude' value='" + lat + "' readonly/> </td> </tr>" +
                                    "<tr><td>Long:</td> <td><input   id='longitude' name='longitude' value='" + lng + "' readonly/> </td> </tr>" +
                                    "<tr><td></td><td><input type='submit' value='Save & Close'/></td></tr></form><div style='color:red;' id='feedback'></div>";
                            var infowindow = new google.maps.InfoWindow({
                                content: contentString
                            });
                            var marker = new google.maps.Marker({
                                position: event.latLng,
                                map: map
                            });
                            marker.addListener('click', function () {
                                infowindow.open(map, marker);
                            });


                            ///start  action 
                            $(document).on('submit', '#add-card-form', function (e) {
                                var frm = $('#add-card-form');
                                e.preventDefault();
                                var Form = this;
                                var location = {};
                                $.each(this, function (i, v) {
                                    var input = $(v);
                                    location[input.attr("name")] = input.val();
                                    delete location["undefined"];
                                });
                                //temporary solution
                                location["latitude"] = parseFloat(location["latitude"]);
                                location["longitude"] = parseFloat(location["longitude"]);

                                if (location.title !== null && location.title !== '') {
                                    $.ajax({
                                        contentType: "application/json; charset=utf-8",
                                        dataType: "json",
                                        type: frm.attr('method'),
//                                        beforeSend: function (xhr) {
//                                            xhr.setRequestHeader("Access-Control-Allow-Origin", "*");
//                                            xhr.setRequestHeader("Access-Control-Allow-Header", "Authorization, Origin, X-Requested-With, Content-Type");
//                                            xhr.setRequestHeader("Access-Control-Allow-Methods", "POST, PUT, GET, DELETE, HEAD, OPTIONS");
//                                            xhr.setRequestHeader("Accept", "application/json");
//                                            xhr.setRequestHeader("Content-Type", "application/json");
//                                        },
                                        url: "${pageContext.request.contextPath}/newlocation/" + location["title"]
                                                + "/" + location["latitude"] + "/" + location["longitude"],
//                                        data: JSON.stringify({username: "mkyong", email: "mkyong@yahoo.com"}),
//                                        {"recId":1,"title":"TEST","note":"123","insDate":1473788186977,"status":"a","latitude":40.384018,"longitude":40.384018}
//                            {username: "mkyong", email: "mkyong@yahoo.com"}
                                        success: function (data) {
                                            console.log("SUCCESS: ", data);
                                            infowindow.close();
                                        },
                                        error: function (callback) {
                                            console.log(callback);
                                        },
                                        done: function (e) {
                                            console.log("DONE");
                                        }
                                    });
//                                    refreshForm(frm);
                                } else {
                                    console.log('value is null in title ');
                                    $('#feedback').html('      Title cant be empty!');
                                }
                            });
                            //end action

                        });
                    }
                </script>
                <!--<script src="https://maps.googleapis.com/maps/api/js?callback=initMap" async defer></script>-->
                <!--https://developers.google.com/maps/documentation/javascript/get-api-key-->
                <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAS3mhlssgqW-VAKDv9chhUooeQsdSGoxo&&callback=initMap" async defer></script>

            </div> 
        </div>



        <jsp:include page="fragments/footer.jsp" />
    </body>
</html>