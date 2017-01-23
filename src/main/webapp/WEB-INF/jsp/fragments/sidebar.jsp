<%-- 
    Document   : sidebar
    Created on : Apr 23, 2016, 11:26:55 AM
    Author     : Rashad Javadov
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html> 

<script type="text/javascript">
    $(function () {
        $('#playapplink').hover(function () {
            $('#playapplink').fadeTo('fast', 0.5);
        }, function () {
            $('#playapplink').fadeTo('fast', 1);
        });
    });

</script> 

<!--list group--> 
<div style="margin-top: 20px;" class="list-group"> 
    <a id="listgroup1" href="projects?typeId=1" class="list-group-item ${movieListActiveClass}"><spring:message code="movie"/><span class="sr-only">(current)</span></a>
    <a id="listgroup2" href="projects?typeId=2" class="list-group-item ${concertlistclass}"><spring:message code="concert"/><span class="sr-only">(current)</span></a>
    <a id="listgroup3" href="projects?typeId=3" class="list-group-item ${theaterListActiveClass}"><spring:message code="theater"/><span class="sr-only">(current)</span></a>
</div>


<div style="margin-top: 20px;border: none;background: transparent" class="panel panel-primary">
    <div class="panel panel-default panel-table"> 
        <div class="panel-heading">
            Offical Facebook Page
        </div>
        <div class="panel-body">
            <div class="fb-page" 
                 data-href="https://www.facebook.com/bakuposter/" 
                 data-small-header="false" data-adapt-container-width="true" 
                 data-hide-cover="false" data-show-facepile="true">
                <blockquote cite="https://www.facebook.com/bakuposter/" class="fb-xfbml-parse-ignore">
                    <a href="https://www.facebook.com/bakuposter/">BakuPoster</a>
                </blockquote>
            </div>
        </div>
    </div>


    <br/>

    <div class="panel panel-default panel-table" >  
        <div class="panel-heading">
            Bakuposter Android Application
        </div>
        <div class="panel-body">
            <a id="playapplink"   target="_blank"  href='https://play.google.com/store/apps/details?id=rashjz.info.bakuposter.com'>
                <img width="260" style="max-width:  100%;width: available" class="img-responsive"   src='https://play.google.com/intl/en_us/badges/images/generic/az_badge_web_generic.png'/>
            </a> 
        </div>
    </div>
    <br/>  

    <div class="panel panel-default panel-table" >  
        <div class="panel-heading">
            Opal.az - Əl işləri
        </div>
        <div class="panel-body" >
            <a    target="_blank" s  href='http://opal.az'>
                <img width="230" style="max-width:  100%;width: available;" class="img-responsive"   src='${pageContext.request.contextPath}/resources/images/opal.jpg'/>
            </a>
        </div>
    </div>

    <br/> 
</div>


<!--
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
 webbakuposterads 
<ins class="adsbygoogle"
     style="display:block"
     data-ad-client="ca-pub-9257288331240431"
     data-ad-slot="5937615804"
     data-ad-format="auto"></ins>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({});
</script>-->

<script>
    //menu activate script
    $('#menulink'+${typeId}).addClass(' active');
    $('#listgroup'+${typeId}).addClass(' active');
</script>
