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
            <!-- ##### Breadcumb Area Start ##### -->
            <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/breadcumb3.jpg);">
                <div class="bradcumbContent">
                    <h2 id="username" style="color: black;">${username}</h2>
                    <br>
                    <a href="/logout" class="btn oneMusic-btn mt-30">Logout</a>
                </div>
            </section>
            <!-- ##### Breadcumb Area End ##### -->
            
            <section class="container-libri" id="libriDisponibili">
                <c:forEach items="${libri}" var="item">
                    <a href="/libro?isbn=${item.isbn}">
                        <div class="cnt-img">
                            <img src="https://glo-2020.s3.eu-central-1.amazonaws.com/image/${item.image}" alt="#" style="border-radius: 10px 10px 10px 10px;">
                        </div>
                        <h4>${item.titolo}</h4>
                        <h6>${item.autore}</h6>
                    <a href="/approva?isbn=${item.isbn}"  class="btn oneMusic-btn mt-30">Approva</a>
                    <a href="/non-approvare?isbn=${item.isbn}"  class="btn oneMusic-btn mt-30">Elimina</a>
                    </a>
                </c:forEach>
                <c:if test="${not libriDaApprovare}">
                    <h1 style="color: black;">Non ci sono libri da approvare!</h1>
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