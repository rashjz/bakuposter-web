<%-- 
    Created on : Apr 11, 2016, 10:54:59 AM
    Author     : Rashad Javadov
--%>
<%@ page contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="google-site-verification" content="gCElmRMfRP73YJhZ1RH24U9KKweS1gondBPMhGP4Foo"/>
    <link rel="shortcut icon" href="<c:url value="/resources/images/ico.png" />" type="image/png">
</head>
<body>
<jsp:include page="../fragments/header.jsp"/>
<spring:url value="/view" var="actionUrl"/>


<div class="container">

    <div class="row">

        <ul style="margin-top: 20px;" class="list-inline">
            <a href="<c:url value="/main"/>" class="btn btn-info">Back</a>
        </ul>


        <!--for to get message on action-->
        <c:if test="${not empty msg}">
            <div class="alert alert-${css} alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <strong>${msg}</strong>
            </div>
        </c:if>


        <form:form class="form-horizontal" method="post" style="margin-top: 20px;" modelAttribute="content"
                   action="${actionUrl}">

            <spring:bind path="typeId">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Type</label>
                    <div class="col-sm-10">
                        <form:select id="docNo" class="form-control" path="typeId">
                            <form:option value="0" label="--- Seçim Et ---"/>
                            <form:options items="${contentTypeList}"/>
                        </form:select>
                        <form:errors path="typeId" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="locationId">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Location </label>
                    <div class="col-sm-10">
                        <form:select id="docNo" class="form-control" path="locationId">
                            <form:option value="0" label="--- Seçim Et ---"/>
                            <form:options itemValue="recId" itemLabel="title" items="${locationList}"/>
                        </form:select>
                        <form:errors path="locationId" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="title">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Title</label>
                    <div class="col-sm-10">
                        <form:input path="title" type="text" class="form-control " placeholder="Title"/>
                        <form:errors path="title" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="description">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Description</label>
                    <div class="col-sm-10">
                        <form:textarea path="description" type="text" class="form-control " placeholder="Description"/>
                        <form:errors path="description" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="releaseYear">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Release Year</label>
                    <div class="col-sm-10">
                        <form:input path="releaseYear" type="text" class="form-control " placeholder="Release Year"/>
                        <form:errors path="releaseYear" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="rating">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Rating</label>
                    <div class="col-sm-10">
                        <form:input path="rating" type="text" class="form-control " placeholder="Rating"/>
                        <form:errors path="rating" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="genre">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Genre</label>
                    <div class="col-sm-10">
                        <form:input path="genre" type="text" class="form-control " placeholder="Genre"/>
                        <form:errors path="genre" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="price">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Price</label>
                    <div class="col-sm-10">
                        <form:input path="price" type="text" class="form-control " placeholder="Price"/>
                        <form:errors path="price" class="control-label"/>
                    </div>
                </div>
            </spring:bind>


            <spring:bind path="imgUrl">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Image URL</label>
                    <div class="col-sm-10">
                        <form:input path="imgUrl" type="text" class="form-control " placeholder="Imgage Url"/>
                        <form:errors path="imgUrl" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="videoUrl">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Video URL </label>
                    <div class="col-sm-10">
                        <form:input path="videoUrl" type="text" class="form-control " placeholder="Video URL "/>
                        <form:errors path="videoUrl" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="recId">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">ID</label>
                    <div class="col-sm-10">
                        <form:input path="recId" type="text" class="form-control " placeholder="Record ID "/>
                        <form:errors path="recId" class="control-label"/>
                    </div>
                </div>
            </spring:bind>


            <spring:bind path="endDate">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">End Date</label>
                    <div class="col-sm-10">
                        <div class="input-group date" id="datetimepicker1">
                            <form:input path="endDate" class="form-control" type="text"/>
                            <form:errors path="endDate" class="control-label"/>
                            <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                        </div>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="writer">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Writer</label>
                    <div class="col-sm-10">
                        <form:input path="writer" placeholder="Writer" class="form-control" type="text"/>
                        <form:errors path="writer" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="producer">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Producer</label>
                    <div class="col-sm-10">
                        <form:input path="producer" placeholder="Producer" class="form-control" type="text"/>
                        <form:errors path="producer" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <button type="submit" class="btn-lg btn-primary pull-right">Update</button>


            <script>
                $(function () {
                    $("#datetimepicker1").datepicker({
                        format: 'dd-mm-yyyy',
                        autoclose: true,
                        todayBtn: false,
                        startDate: "01/01/2016"
                    });
                });
            </script>
        </form:form>
    </div>
</div>


<%--<jsp:include page="../fragments/footer.jsp"/>--%>
</body>
</html>
