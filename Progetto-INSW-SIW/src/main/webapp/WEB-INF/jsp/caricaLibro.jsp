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
		<!-- form -->
		<form action="/caricaLibro/up" method="post" enctype="multipart/form-data">
			<div class="container-main-book-1 mt-5" >
				<!-- Image -->
				<section class="container-main-book-first jc-c">	
					<div class="row min-h-100">
				        <div class="">
				
				            <!-- Upload image input-->
				            <input id="upload" name="image" type="file" onchange="readURL(this); removeBrdUpImage()" class="form-control border-0" hidden >
				            
				            <!-- Uploaded image area-->
				            <label id="lbl_image" for="upload" class="image-area image-area-glo">
				            	<img id="imageResult" src="#" alt="" class="img-fluid shadow-sm mx-auto d-block">
				            </label>
				        </div>
				    </div> 
				
				</section>

					<!-- Info book -->
					<section class="container-main-book-second cnt-main-up-book-second">
					
						<!-- titolo -->
						<div class="form-group">
						    <input name="titolo" type="text" class="form-control fc-color" placeholder="Titolo">
					  	</div>
					  	<!-- autore -->
					  	<div class="form-group">
						    <input name="autore" type="text" class="form-control fc-color" placeholder="Autore">
					  	</div>
					  	<!-- editore -->
					  	<div class="form-group">
						    <input name="editore" type="text" class="form-control fc-color" placeholder="Editore">
					  	</div>
					  	<!-- isbn -->
					  	<div class="form-group">
						    <input name="isbn" type="text" class="form-control fc-color" placeholder="ISBN">
					  	</div>
					  	<!-- data -->
					  	<div class="form-group">
						    <input name="data" type="date" class="form-control fc-color" placeholder="Data">
					  	</div>
					  	<br> <br>
					  	<!-- genere -->
					  	<div class="form-group">
						    <input name="genere" type="text" class="form-control fc-color" placeholder="Genere">
					  	</div>
					  	<!-- sottogeneri -->
					  	<div class="form-group">
						    <input name="sottogenere" type="text" class="form-control fc-color" placeholder="Sottogenere">
					  	</div>
					  	<br> <br>
					  	<!-- sinossi -->
					  	<div class="form-group">
						    <textarea name="sinossi" type="text" class="form-control fc-color" placeholder="Sinossi" rows="4"></textarea>
					  	</div>
					  	<br> <br>
					  	<!-- Contenuto -->
					  	<div class="form-group" style="color: #7f8182">	
					  		Seleziona contenuto
							<input id="file" name ="file" type="file" class="form-control fc-color" style="padding-left:0; border:none; " >
						</div>
					  	
					  	
					</section>
		
			</div>
		
			<span class="line-hor" ></span>
		
			<div class="bar-options bar-up-book">
				
				<button type="submit" class="btn-option-book btn-pr">
					<i class="fas fa-plus"></i>
					<nobr>Aggiungi</nobr>
				</button>
			
			</div>
			
			<span class="line-hor" ></span>
			
		</form>
	
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

	function removeBrdUpImage(){
		console.log('ci sono');
		document.querySelector("#lbl_image").setAttribute('style', 'border:none');
	}

</script>


</html>