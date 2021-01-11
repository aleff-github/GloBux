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
    <title>La tua libreria</title>

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

    <!-- ##### Header Area Start ##### -->
    <header class="header-area">
        <!-- Navbar Area -->
        <div class="oneMusic-main-menu">
            <div class="classy-nav-container breakpoint-off">
                <div class="container">
                    <!-- Menu -->
                    <nav class="classy-navbar justify-content-between" id="oneMusicNav">

                        <!-- Nav brand -->
                        <a href="/" class="nav-brand logo">GLOBUX</a>

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
                            </div>
                            <!-- Nav End -->

                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- ##### Header Area End ##### -->

    <!-- ##### Breadcumb Area Start ##### -->
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(https://source.unsplash.com/collection/228444/1920x1280);">
        <div class="bradcumbContent">
            <p>Gestisci</p>
            <h2>La tua libreria personale</h2>
        </div>
    </section>
    <!-- ##### Breadcumb Area End ##### -->

	<!-- CARDS AREA START  -->
		<c:forEach items="${listaLibri}" var="item">
        <!-- Single Post Start -->
           <div class="single-blog-post mb-100 wow fadeInUp" data-wow-delay="100ms">
          <!-- Post Thumb -->
          	<div class="col-12 col-md-6 col-lg-4">
	        	<div class="single-event-area mb-30">
    	        	<div class="event-thumbnail">
        	        	<img src="img/9780786102563.jpg" alt="">
                	</div>
                	<form action="deleteLibro" method="post">
	                	<div class="event-text">
	            	    	<h4>Divina Commedia</h4>
	                    	<div class="event-meta-data">
	                	    	<a href="#" class="event-place">${item.autore }</a>
	                        	<a href="#" class="event-place">${item.isbn}</a>
                   				<a href="#" class="event-place">${item.titolo}</a>
	                        	<input type="text" id="libro" name="libro" class="event-date" class="event-place" value="9788804668237" hidden="true"></input>
	                        	<input type="text" id="libreria" name="libreria" value="user1" class="event-place" hidden="true"></input>
	                    	</div>
	                    	<button class="btn see-more-btn" type="submit" >Elimina libro</button>
	                	</div>
	             	</form>
             	</div>
         	</div>-
               <div class="blog-post-thumb mt-30">
                   
                   
        			
               </div>
           </div>
		</c:forEach>
		
		<!-- Single Event Area 
        <div class="col-12 col-md-6 col-lg-4">
	        <div class="single-event-area mb-30">
    	        <div class="event-thumbnail">
        	        <img src="img/9780786102563.jpg" alt="">
                </div>
                <form action="deleteLibro" method="post">
	                <div class="event-text">
	            	    <h4>Divina Commedia</h4>
	                    <div class="event-meta-data">
	                	    <a href="#" class="event-place">Dante Alighieri</a>
	                        <a href="#" class="event-date">548416546841</a>
	                        <input type="text" id="libro" name="libro" class="event-date" class="event-place" value="548416546841" hidden="true"></input>
	                        <input type="text" id="libreria" name="libreria" value="user1" class="event-place" hidden="true"></input>
	                    </div>
	                    <button class="btn see-more-btn" type="submit" >Elimina libro</button>
	                </div>
	             </form>
             </div>
         </div>-->
	    
	    
	
	<!-- CARDS AREA END -->
   
    <!-- ##### Footer Area Start ##### -->
    <footer class="footer-area">
        <div class="container">
            <div class="row d-flex flex-wrap align-items-center">
                <div class="col-12 col-md-6">
                    <a href="/" class="nav-brand logo">GLOBUX</a>
                    <p class="copywrite-text"><a href="#"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                </div>

                <div class="col-12 col-md-6">
                    <div class="footer-nav">
                        <ul>
                            <li><a href="#">Home</a></li>
                            <li><a href="#">Novità</a></li>
                            <li><a href="#">Contatti</a></li>
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

</html>