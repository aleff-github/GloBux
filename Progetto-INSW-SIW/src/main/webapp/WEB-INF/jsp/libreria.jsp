<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="description" content="">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

            <!-- Title -->
            <title>La tua libreria</title>

            <!-- Favicon -->
    		<link rel="icon" href="img/webapp/GloBuxLogo.png">


            <!-- Stylesheet -->
            <link rel="stylesheet" href="css/style.css">
            <link rel="stylesheet" href="css/styleBook.css">
            <link rel="stylesheet" href="css/styleUpBook.css">

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
            <section class="breadcumb-area bg-img bg-overlay"
                style="background-image: url(https://source.unsplash.com/collection/228444/1920x1280);">
            </section>
            <!-- ##### Breadcumb Area End ##### -->

            <section class="container-libri" style="margin-top: 80px;">
                <c:forEach items="${listaLibri}" var="item">
                    <div class="cnt-approva">
                        <div class="cnt-approva-first">
                            <a href="/libro?isbn=${item.isbn}">
                                <div class="cnt-img">
                                    <img src="https://glo-2020.s3.eu-central-1.amazonaws.com/image/${item.image}"
                                        alt="#" style="border-radius: 10px 10px 10px 10px;">
                                </div>
                            </a>
                            <form action="deleteLibro" method="POST">
                                <div class="libro-info">
                                    <h4>${item.titolo}</h4>
                                    <h6>${item.autore}</h6>
                                    <input type="text" id="libro" name="libro" class="event-date" class="event-place"
                                        value=${item.isbn} hidden="true"></input>
                                    <input type="text" id="libreria" name="libreria" value=${username}
                                        class="event-place" hidden="true"></input>
                                    <button class="btn see-more-btn" type="submit">Elimina libro</button>
                                </div>
                            </form>
                        </div>
                    </div>

                    <span class="line-hor"></span>

                </c:forEach>
            </section>
            
            <c:forEach items="${listaId}" var="item">
                <input class="listaId" value=${item } hidden="true"></input>
            </c:forEach>

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
            <!-- Libro js -->
            <script src="js/libro.js"></script>
            <!-- Active js -->
            <script src="js/scriptUpBook.js"></script>
        </body>

        </html>