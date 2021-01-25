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
    <link rel="icon" href="img/core-img/favicon.ico">

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
    <!-- ##### Header Area End ##### -->

<!-- ##### Breadcumb Area Start ##### -->
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(https://source.unsplash.com/collection/228444/1920x1280);">
        <div class="bradcumbContent">
            <p>See what’s new</p>
            <h2>News</h2>
        </div>
    </section>
    <!-- ##### Breadcumb Area End ##### -->

    <!-- ##### News Area Start ##### -->
    <section class="login-area section-padding-100">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-8">
                    <div class="login-content">
                        <h3>Aggiungi News</h3>
                        <!-- Login Form -->
                        <div class="login-form">
                            <form action="addNews" method="post">
                                <div class="form-group">
                                    <label for="exampleInputTitolo">Titolo</label>
                                    <input type="text" class="form-control" name="titolo" id="titolo" aria-describedby="titoloHelp" placeholder="Inserisci titolo news">
                                </div>
                                <div class="form-group">
                                    <label for="date">Data</label>
                                    <input type="date" class="form-control"  name="data" id="data" placeholder="Inserisci data news">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputContenuto">
                                    Contenuto
                                    <textarea class="form-control" name="contenuto" id="contenuto" cols="120" placeholder="Inserisci contenuto news"></textarea>
                                    </label>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputLinkImg">Link Immagine</label>
                                    <input type="text" class="form-control" name="immagine" id="immagine" aria-describedby="linkImgHelp" placeholder="Inserisci link immagine">
                                </div>
                                <button type="submit" class="btn oneMusic-btn mt-30">Aggiungi</button>
                                	
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ##### Login Area End ##### -->
    
    
   <section class="login-area section-padding-100">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-8">
                    <div class="login-content">
                        <h3>Elimina</h3>
                        <!-- Login Form -->
                        <div class="login-form">
                            <form action="deleteNews" method="post">
                                <div class="form-group">
                                    <label for="exampleInputTitolo">Titolo</label>
                                    <input type="text" class="form-control" name="titolo" id="titolo" aria-describedby="titoloHelp" placeholder="Inserisci titolo news">
                                </div>
                                <button type="submit" class="btn oneMusic-btn mt-30">Elimina</button>
                                	
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    

    <!-- ##### Footer Area Start ##### -->
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