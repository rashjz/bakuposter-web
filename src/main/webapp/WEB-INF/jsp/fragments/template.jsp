<%-- 
    Document   : bakuposter.com
    Created on : Jun 30, 2016, 2:35:03 PM
    Author     : Rashad Javadov
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/projectsPagingTag.tld"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>


    <body>
        <jsp:include page="fragments/header.jsp" />


        <!-- Page Content -->
        <div class="container">

            <div class="row">

                <div class="col-md-3"> 
                    <jsp:include page="fragments/sidebar.jsp" />
                </div>

                <div class="col-md-9">
                    <jsp:include page="fragments/carousel.jsp" />




                    <div class="row">



                    </div> 
                </div>
            </div>

        </div>
        <!-- /.container -->
        <jsp:include page="fragments/footer.jsp" />
    </body>

</html>
