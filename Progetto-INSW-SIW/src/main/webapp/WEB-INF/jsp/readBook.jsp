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
    <link rel="stylesheet" href="css/styleBook.css">
    <link rel="stylesheet" href="css/styleUpBook.css">
    
    <!-- My script -->
    <script src="js/scriptUpBook.js" type="text/javascript"></script>
	
	<!-- Icon search -->
	<script src="https://kit.fontawesome.com/445f803675.js" crossorigin="anonymous"></script>

</head>

<style>

.container-main-book{
	padding: 0 15px; 
}

iframe{
    height: 85vh;
    border: none;
    border-radius: 12px;
}

.bar-function{
	display: flex;
    width: 100%;
    justify-content: space-between;
    align-items: flex-end;
    height: 180px;
    margin-bottom: 15px;
}

.bar-function button{
    background: transparent;
    border: none;
    font-size: 29px;
    padding: 10px;
    color: lightgray;
    outline: none;
}

@media (min-width: 996px){

/* width */
::-webkit-scrollbar {
  width: 5px;
}

/* Track */
::-webkit-scrollbar-track {
  background: #f1f1f1; 
}
 
/* Handle */
::-webkit-scrollbar-thumb {
  background: #888; 
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
  background: #555; 
}

}



.dark{
	filter: invert(0.87);
}
</style>

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

    <!-- ##### Header Area Start ##### -->
    <header class="header-area">
        <!-- Navbar Area -->
        <div class="oneMusic-main-menu">
            <div class="classy-nav-container breakpoint-off">
                <div class="container">
                    <!-- Menu -->
                    <nav class="classy-navbar justify-content-between" id="oneMusicNav">

                        <!-- Nav brand -->
                        <a href="index.html" class="nav-brand logo">GLOBUX</a>

                        <!-- Navbar Toggler -->
                        <div class="classy-navbar-toggler">
                            <span class="navbarToggler"><span></span><span></span><span></span></span>
                        </div>

                        <!-- Menu -->
                        <div class="classy-menu">

                            <!-- Close Button -->
                            <div class="classycloseIcon">
                                <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                            </div>

                            <!-- Nav Start -->
                            <div class="classynav">
                                <ul>
                                    <li><a href="albums-store.html">Categorie</a></li>
                                    <li><a href="blog.html">Novità</a></li>
                                    <li><a href="contact.html">Contatti</a></li>
                                </ul>

                                <!-- Login/Register -->
                                <div class="login-register-cart-button d-flex align-items-center">
                                    <!-- Login/Register -->
                                    <div class="login-register-btn mr-50">
                                        <a href="login" id="loginBtn" style="width: 20px; height: 20px;"><i class="fas fa-user"></i></a>
                                    </div>
                                </div>
                            </div>
                            <!-- Nav End -->

                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- ##### Header Area End ##### -->




	<!-- ##### START BOOK ##### -->
	<main class="container-main-book">
	
	<div class="bar-function">
		<h1>Titolo</h1>
		
		<button type="button" onclick="invertColor()">
			<i class="fas fa-adjust"></i>
		</button>
	
	</div>
		
	<iframe id="content-2" src="https://glo-2020.s3.eu-central-1.amazonaws.com/ebook/uno-studio-in-rosso.pdf#toolbar=0" class="">
		
    </iframe>
	
	</main>
	<!-- ##### END BOOK ##### -->







    <!-- ##### Footer Area Start ##### -->
    <footer class="footer-area">
        <div class="container">
            <div class="row d-flex flex-wrap align-items-center">
                <div class="col-12 col-md-6">
                    <a href="/index" style="color: white; font-size: 24px">GLOBUX</a>
                    <p class="copywrite-text"><a href="#"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                </div>

                <div class="col-12 col-md-6">
                    <div class="footer-nav">
                        <ul>
                            <li><a href="/categorie">Categorie</a></li>
                            <li><a href="/novita">Novità</a></li>
                            <li><a href="/contatti">Contatti</a></li>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- ##### Footer Area Start ##### -->

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

<script type="text/javascript">

	function invertColor(){
		document.querySelector("iframe").classList.toggle("dark");	
	}
	
	$(function() {
		  /* Rounded Dots Dark */
		  $("#content-1").mCustomScrollbar({
		    theme: "rounded-dots-dark"
		  });

		  /* Rounded Dark */
		  $("#content-2").mCustomScrollbar({
		    theme: "rounded-dark"
		  });

		  /* Inset Dark */
		  $("#content-3").mCustomScrollbar({
		    theme: "inset-3-dark"
		  });

		  /* 3d Dark */
		  $("#content-4").mCustomScrollbar({
		    theme: "3d-dark"
		  });

		  /* Dark Thin */
		  $("#content-5").mCustomScrollbar({
		    theme: "dark-thin"
		  });
		});
	

</script>


</html>