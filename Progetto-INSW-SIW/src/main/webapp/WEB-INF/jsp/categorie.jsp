<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(https://source.unsplash.com/collection/228444/1920x1280);">
        <div class="bradcumbContent">
            <p>Scegli fra le migliori categorie</p>
            <h2>Categorie</h2>
        </div>
    </section>
    <!-- ##### Breadcumb Area End ##### -->

    <!-- ##### Album Catagory Area Start ##### -->
    <section class="container-libri">
       

	    <!-- Classici -->
	    <a href="/categoria?cat=Classico">
	       	<div class="cnt-img">
	           	<img src="img/categories/Classici.jpg" alt="#" style="border-radius: 10px 10px 10px 10px;">
	        </div>
	        <h4>Classici</h4>
	 	</a>
	    
	    <!-- Arte -->
	    <a href="/categoria?cat=Arte">
	       	<div class="cnt-img">
	           	<img src="img/categories/Art.jpg" alt="#" style="border-radius: 10px 10px 10px 10px;">
	        </div>
	        <h4>Arte</h4>
	 	</a>
	 
	    <!-- Romanzo -->
	    <a href="/categoria?cat=Romanzo">
	       	<div class="cnt-img">
	           	<img src="img/categories/Romanzo.jpg" alt="#" style="border-radius: 10px 10px 10px 10px;">
	        </div>
	        <h4>Romanzo</h4>
	 	</a>
	 
	    <!-- Religione -->
	    <a href="/categoria?cat=Religione">
	       	<div class="cnt-img">
	           	<img src="img/categories/religione.jpg" alt="#" style="border-radius: 10px 10px 10px 10px;">
	        </div>
	        <h4>Religione</h4>
	 	</a>
	    
	    <!-- Horror -->
	    <a href="/categoria?cat=Horror">
	       	<div class="cnt-img">
	           	<img src="img/categories/Horror.jpg" alt="#" style="border-radius: 10px 10px 10px 10px;">
	        </div>
	        <h4>Horror</h4>
	 	</a>
	 
	    <!-- Musica -->
	    <a href="/categoria?cat=Musica">
	       	<div class="cnt-img">
	           	<img src="img/categories/musica.jpg" alt="#" style="border-radius: 10px 10px 10px 10px;">
	        </div>
	        <h4>Musica</h4>
	 	</a>
	 
	    <!-- Humor -->
	    <a href="/categoria?cat=Humor">
	       	<div class="cnt-img">
	           	<img src="img/categories/Humor.jpg" alt="#" style="border-radius: 10px 10px 10px 10px;">
	        </div>
	        <h4>Humor</h4>
	 	</a> 
              
            </div>
        </div>
    </section>
    <!-- ##### Album Catagory Area End ##### -->

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