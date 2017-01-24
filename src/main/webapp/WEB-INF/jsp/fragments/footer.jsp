<%-- 
    Created on : Apr 11, 2016, 10:54:59 AM
    Author     : Rashad Javadov
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    .footer a img {
        display: block;
        width: 24px;
        margin-left: 10px;
        margin-top: 5px;
        height: 16px;
        width: 16px;
    }
</style>

<footer class="site-footer">

    <div class="container">
        <div class="row">
            <div class="col-md-2">
                <div class="widget">
                    <h3 class="widget-title">About Us</h3>
                    <p>Yeni filmlər, tamaşalar, sərgilərdən xəbərdar olmaq istəyirsinizsə o zaman bizi izləyin</p>
                </div>
            </div>
            <div class="col-md-2">
                <div class="widget">
                    <h3 class="widget-title">Menu</h3>
                    <ul class="no-bullet">
                        <li><a href="${projects}?typeId=1"><spring:message code="movie"/></a></li>
                        <li><a href="${projects}?typeId=2"><spring:message code="concert"/></a></li>
                        <li><a href="${projects}?typeId=3"><spring:message code="theater"/></a></li>
                        <li><a href="${about}"><spring:message code="about"/></a></li>
                        <li><a href="${contact}"><spring:message code="contact"/></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md-2">
                <div class="widget">
                    <h3 class="widget-title">Social</h3>
                    <ul class="no-bullet">
                        <li><a target="_blank" href="https://www.facebook.com/bakuposter">
                            <img border="0" src="<c:url value="/resources/images/social/facebook.png" />"/>
                        </a>
                        </li>
                        <li>
                            <a target="_blank" href="http://twitter.com/rashjz">
                                <img border="0" src="<c:url value="/resources/images/social/twitter.png" />"/>
                            </a>
                        </li>
                        <li>
                            <a target="_blank" href="https://www.linkedin.com/in/rashjz/">
                                <img border="0" src="<c:url value="/resources/images/social/linkedin.png" />"/>
                            </a>
                        </li>
                        <li>
                            <a target="_blank" href="https://plus.google.com/u/0/+rashadjavadov/">
                                <img border="0" src="<c:url value="/resources/images/social/google.png" />"/>
                            </a>
                        </li>
                        <li>
                            <a target="_blank" href="https://www.instagram.com/rashjz/">
                                <img border="0" src="<c:url value="/resources/images/social/instagram.png" />"/>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="col-md-2">
                <div class="widget">
                    <h3 class="widget-title">Newsletter</h3>
                    <form action="#" class="subscribe-form">
                        <input type="text" placeholder="Email Address">
                    </form>
                </div>
            </div>
        </div>

        <div class="colophon"> © 2016 Bütün hüquqlar qorunur. (<a href="http://rashjz.info" target="_blank">http://rashjz.info</a>)
        </div>
    </div>
</footer>


<!-- /.container -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" charset="UTF-8"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.1/js/bootstrap-datepicker.js"
        charset="UTF-8"/>

<script type="text/javascript">
    $(function () {
        $('#datetimepicker1').datepicker({
            language: 'pt-BR'
        });
    });
</script> 
 