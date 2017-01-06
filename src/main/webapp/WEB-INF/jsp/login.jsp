<%-- 
    Document   : logintemplate
    Created on : Jul 4, 2016, 4:54:51 PM
    Author     : Mobby
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
        <link href="${bootstrapCss}" rel="stylesheet" />
        <meta name="google-site-verification" content="gCElmRMfRP73YJhZ1RH24U9KKweS1gondBPMhGP4Foo" />

        <script type="text/javascript" src="//code.jquery.com/jquery-1.12.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" charset="UTF-8"></script>
        <link rel="shortcut icon"  href="<c:url value="/resources/images/ico.png" />" type="image/png">

        <link href='http://fonts.googleapis.com/css?family=Buenard:700' rel='stylesheet' type='text/css'>
        <script src="http://pupunzi.com/mb.components/mb.YTPlayer/demo/inc/jquery.mb.YTPlayer.js"></script>
        <style>
            .video-section .pattern-overlay {
                background-color: rgba(71, 71, 71, 0.59);
                padding: 110px 0 32px;
                min-height: 496px; 
                /* Incase of overlay problems just increase the min-height*/
            }
            .video-section h1, .video-section h3{
                text-align:center;
                color:#000;
            }
            .video-section h1{
                font-size:110px;
                font-family: 'Buenard', serif;
                font-weight:bold;
                text-transform: uppercase;
                margin: 40px auto 0px;
                text-shadow: 1px 1px 1px #000;
                -webkit-text-shadow: 1px 1px 1px #000;
                -moz-text-shadow: 1px 1px 1px #000;
            }
            .video-section h3{
                font-size: 25px;
                font-weight:lighter;
                margin: 0px auto 15px;
            }
            .video-section .buttonBar{display:none;}
            .player {font-size: 1px;}
        </style>

    </head>



    <body style="background: #101010;">










    </div> 
    <!--</div>-->

    <section class="content-section video-section">
        <div class="pattern-overlay">
            <a id="bgndVideo" class="player" data-property="{videoURL:'https://www.youtube.com/watch?v=C0P-16UCrvY',containment:'.video-section', quality:'large', autoPlay:true, mute:true, opacity:1}">bg</a>
            <div class="container">
                <div class="row">
                    <script type="text/javascript">
                        $(document).ready(function () {
                            $(".player").mb_YTPlayer();
                        });
                    </script>  
                </div>


                <spring:url value="/register" var="registerUrl"/>
                <!--<div class="container">-->    
                <div id="loginbox" style="margin-top:15%; "  class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
                    <div class="panel panel-primary" >
                        <div class="panel-heading">
                            <div class="panel-title">Sign In</div>
                            <!--<div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a></div>-->
                        </div>     
                        <!--background-image: url(resources/images/gallery2.jpg);-->
                        <div style="padding-top:30px;" class="panel-body" >

                            <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                            <spring:url var="loginUrl" value="/login" />
                            <form id="loginform" action="${loginUrl}" method="post" class="form-horizontal" role="form">

                                <c:if test="${param.error != null}">
                                    <div class="alert alert-danger">
                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                        <p>Invalid username and password.</p>
                                    </div>
                                </c:if>
                                <c:if test="${param.logout != null}">
                                    <div class="alert alert-success">
                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                        <p>You have been logged out successfully.</p>
                                    </div>
                                </c:if>

                                <div style="margin-bottom: 25px" class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                    <input id="username" type="text" class="form-control" name="ssoId" value="" placeholder="username or email">                                        
                                </div>

                                <div style="margin-bottom: 25px" class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                    <input id="password" type="password" class="form-control" name="password" placeholder="password">
                                </div>



                                <div class="input-group">
                                    <div class="checkbox">
                                        <label>
                                            <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
                                        </label>
                                    </div>
                                </div>

                                <input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />

                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                        <input id="btn-login" type="submit" value="Login" class="btn btn-success">   
                                        <a id="btn-fblogin" href="<c:url value="/facebook/signin"/>" class="btn btn-primary">
                                            Login with Facebook
                                        </a>
                                        <a id="btn-twtlogin" href="<c:url value="/twitter/signin"/>"   class="btn btn-info">
                                            Login with Twitter
                                        </a>

                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                            Don't have an account! 
                                            <a href="#" onClick="$('#loginbox').hide();
                                                    $('#signupbox').show()">
                                                Sign Up Here
                                            </a>
                                        </div>
                                    </div>
                                </div>    
                            </form>     



                        </div>                     
                    </div>  
                </div>










                <div id="signupbox" style="display:none; margin-top:15%" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="panel-title">Sign Up</div>
                            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" style="color: white;font-weight: bold;" onclick="$('#signupbox').hide();
                                    $('#loginbox').show()">Sign In</a></div>
                        </div>  


                        <div  class="panel-body" >
                            <form:form id="signupform" class="form-horizontal"  method="post" modelAttribute="userReg" action="${registerUrl}">

                                <div id="signupalert" style="display:none" class="alert alert-danger">
                                    <p>Error:</p>
                                    <span></span>
                                </div>

                                <spring:bind path="email">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label for="email" class="col-md-3 control-label">Email</label>
                                        <div class="col-md-9">
                                            <form:input path="email" type="text"  class="form-control "  placeholder="Email Address" />
                                            <form:errors path="email" class="control-label" />
                                        </div>
                                    </div>
                                </spring:bind>



                                <spring:bind path="firstName">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label for="firstName" class="col-md-3 control-label">FirstName</label>
                                        <div class="col-md-9">
                                            <form:input path="firstName" type="text"  class="form-control "  placeholder="FirstName" />
                                            <form:errors path="firstName" class="control-label" />
                                        </div>
                                    </div>
                                </spring:bind>

                                <spring:bind path="lastName">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label for="lastName" class="col-md-3 control-label">LastName</label>
                                        <div class="col-md-9">
                                            <form:input path="lastName" type="text"  class="form-control "  placeholder="LastName" />
                                            <form:errors path="lastName" class="control-label" />
                                        </div>
                                    </div>
                                </spring:bind>

                                <spring:bind path="passwd">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label for="passwd" class="col-md-3 control-label">Password</label>
                                        <div class="col-md-9">
                                            <form:input path="passwd" type="password"  class="form-control "  placeholder="Password" />
                                            <form:errors path="passwd" class="control-label" />
                                        </div>
                                    </div>
                                </spring:bind>

                                <spring:bind path="repasswd">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label for="repasswd" class="col-md-3 control-label">Re Password</label>
                                        <div class="col-md-9">
                                            <form:input path="repasswd" type="password"  class="form-control "  placeholder="Re Password" />
                                            <form:errors path="repasswd" class="control-label" />
                                        </div>
                                    </div>
                                </spring:bind>

                                <spring:bind path="phoneno">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label for="phoneno" class="col-md-3 control-label">Mobile</label>
                                        <div class="col-md-9">
                                            <form:input path="phoneno" type="text"  class="form-control "  placeholder="Mobile" />
                                            <form:errors path="phoneno" class="control-label" />
                                        </div>
                                    </div>
                                </spring:bind>


                                <div class="form-group">
                                    <!-- Button -->                                        
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-signup" type="submit" class="btn btn-info"><i class="icon-hand-right"></i> &nbsp Sign Up</button>
                                        <span style="margin-left:8px;">or</span>  
                                    </div>
                                </div>

                                <div style="border-top: 1px solid #999; padding-top:20px"  class="form-group">

                                    <div class="col-md-offset-3 col-md-9">
                                        <!--<button id="btn-fbsignup" type="button"  class="btn btn-primary"><i class="icon-facebook"></i>   Sign Up with Facebook</button>-->
                                        <a id="btn-fblogin" href="<c:url value="/facebook/signin"/>" class="btn btn-primary">
                                            Sign Up  with Facebook
                                        </a>
                                    </div>    
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
                </section>



                <div class="row">
                    <div style="color: #9d9d9d" class="col-lg-6 pull-left"> 
                        © 2016 Bütün hüquqlar qorunur. (<a href="http://rashjz.info/"  target="_blank"><font color="#9d9d9d">rashjz.info</font></a>)  
                    </div>
                    <div class=" col-lg-2 pull-right"> 
                        <h4 style="color: #9d9d9d">Bakuposter.com</h4>
                    </div> 
                </div>
                </body>
                </html>