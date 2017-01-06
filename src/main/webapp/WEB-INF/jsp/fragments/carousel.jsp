<%-- 
    Document   : carousel
    Created on : Jun 30, 2016, 3:26:59 PM
    Author     : Mobby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div style="margin-top: 20px;" class="panel panel-default panel-table"> 
    <div class="panel-heading">
        <!--Offical Facebook Page-->
    </div>
    <div class="panel-body">
        <div class="row carousel-holder">

            <div class="col-md-12">
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="item active">
                            <img class="slide-image"  src="${pageContext.request.contextPath}/resources/images/gallery3.jpg" alt="">
                            <div class="carousel-caption">
                                <!--<h3 style="color: #5bc0de">Android Application</h3>-->
                                <!--<p style="color: #5bc0de">A full schedule of movies, concerts, clubs and theater</p>-->
                            </div>
                        </div>
                        <div class="item">
                            <img class="slide-image" src="${pageContext.request.contextPath}/resources/images/gallery2.jpg" alt="">
                            <div class="carousel-caption">
                                <!--<h3 style="color: #5bc0de">Responsible Web Application</h3>-->
                                <!--<p style="color: #00b4e0">Reviews reviewers and users of posters for movies, performances and exhibitions</p>-->
                            </div> 
                        </div>
                        <div class="item">
                            <img class="slide-image" src="${pageContext.request.contextPath}/resources/images/gallery1.jpg" alt="">
                            <div class="carousel-caption">
                                <!--<h3 style="color: #5bc0de">BakuPoster</h3>-->
                                <!--<p style="color: #5bc0de">Bookmark your favorite places and events</p>-->
                            </div>
                        </div>
                    </div>
                    <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                    </a>
                </div>
            </div>

        </div>
    </div>
</div>




