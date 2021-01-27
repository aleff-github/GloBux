<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
    <title>GloBux Login</title>

    <!-- Favicon -->
    		<link rel="icon" href="img/webapp/GloBuxLogo.png">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="css/style.css">

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
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(https://source.unsplash.com/collection/228444/1920x1280);">
       <!--  <div class="bradcumbContent">
            <p>Hai effettuato una ricerca tramite GloBux!</p>
            <h2 id="ricerca">${ricerca}</h2>
        </div> -->
    </section>
    <!-- ##### Breadcumb Area End ##### -->

    <section class="cnt-center" style="margin-top: 35px;">
        <div class="container">
            <h2 id="ricerca">Risultati per: "<strong style="color: #ff9a05;">${ricerca}</strong>"</h2>
            <div class="container-libri" id="libriDisponibili">
                <c:forEach items="${libri}" var="item">
                    <a href="/libro?isbn=${item.isbn}">
                        <div class="cnt-img">
                            <img src="https://glo-2020.s3.eu-central-1.amazonaws.com/image/${item.image}"
                                alt="#" style="border-radius: 10px 10px 10px 10px;">
                        </div>
                        <h4>${item.titolo}</h4>
                        <h6>${item.autore}</h6>
                    </a>
                </c:forEach>
            </div>
            <div class="row">
                <div class="col-12">
                    <div class="load-more-btn text-center wow fadeInUp" data-wow-delay="300ms">
                        <input type="number" id="index" value="10" hidden=true>
                        <a onclick="altriRisultati(ricerca)" class="btn oneMusic-btn">Carica Altro...</a>
                    </div>
                </div>
            </div>
        </div>
        </div>
        <br><br>
    </section>

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
    <!-- Active js -->
    <script src="js/ricerca.js"></script>
</body>

</html>