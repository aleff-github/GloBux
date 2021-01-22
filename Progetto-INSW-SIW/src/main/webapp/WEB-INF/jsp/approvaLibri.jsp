<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="X-UA-Compatible" content="ie=edge">
            <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

            <!-- Title -->
            <title>GloBux</title>

            <!-- Favicon -->
            <link rel="icon" href="img/core-img/favicon.ico">

            <!-- Stylesheet -->
            <link rel="stylesheet" href="css/style.css">
            <link rel="stylesheet" href="css/styleBook.css">
            <link rel="stylesheet" href="css/styleUpBook.css">

            <!-- My script -->
            <script src="js/scriptUpBook.js" type="text/javascript"></script>

            <!-- Icon search -->
            <script src="https://kit.fontawesome.com/445f803675.js" crossorigin="anonymous"></script>

        </head>

        <body>
            <!-- Preloader -->
            <div class="preloader d-flex align-items-center justify-content-center">
                <div class="lds-ellipsis">
                    <div></div>
                    <div></div>
                    <div></div>
                    <div></div>
                </div>
            </div>

            <c:if test="${not loggato}">
                <jsp:include page="partials/index/menuIndex.jsp" />
            </c:if>
            <c:if test="${loggato and not loggatoAdmin}">
                <jsp:include page="partials/user/menuUser.jsp" />
            </c:if>
            <c:if test="${loggatoAdmin}">
                <jsp:include page="partials/admin/menuAdmin.jsp" />
            </c:if>
            
            <section class="container-libri" id="libriDisponibili" style="margin-top: 80px;">
                <c:forEach items="${libri}" var="item">
                    <div  class="cnt-approva">
                        <div class="cnt-approva-first">
                            <a href="/libro?isbn=${item.isbn}">
                                <img src="https://glo-2020.s3.eu-central-1.amazonaws.com/image/${item.image}" alt="#" style="border-radius: 10px 10px 10px 10px;">
                            </a>
                            <div class="libro-info">
                                <h4>${item.titolo}</h4>
                                <h6>${item.autore}</h6>
                            </div>
                        </div>
                        <div class="libro-action">
                            <a href="/approva?isbn=${item.isbn}" ><i class="far fa-check-circle"></i></a>
                            <a href="/non-approvare?isbn=${item.isbn}"><i class="far fa-trash-alt"></i></a>         
                        </div>
                    </div>

                    <span class="line-hor"></span>

                </c:forEach>
                <c:if test="${not libriDaApprovare}">
                    <h1 style="color: #fff;">Non ci sono libri da approvare!</h1>
                </c:if> 
            </section>

            <!-- ##### Events Area End ##### -->
            
            <jsp:include page="partials/index/footer.jsp" />

        <!-- ##### All Javascript Script ##### -->
        <!-- jQuery-2.2.4 js -->
        <script src="js/jquery/jquery-2.2.4.min.js"></script>
        <!-- Popper js -->
        <script src="js/bootstrap/popper.min.js"></script>
        <!-- Bootstrap js -->
        <script src="js/bootstrap/bootstrap.min.js"></script>
        <!-- All Plugins js -->
        <script src="js/plugins/plugins.js"></script>
        <!-- Active js -->
        <script src="js/active.js"></script>
        </body>


        </html>