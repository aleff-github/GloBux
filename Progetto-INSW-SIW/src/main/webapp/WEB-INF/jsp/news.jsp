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
                                        <a href="login" id="loginBtn" style="width: 20px; height: 20px;"><img src="img/icons/user.svg" alt="Login" ></a>
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

    <!-- ##### Breadcumb Area Start ##### -->
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/deAndre.jpg);">
        <div class="bradcumbContent">
            
            <h2>News</h2>
        </div>
    </section>
    <!-- ##### Breadcumb Area End ##### -->

    <!-- ##### Blog Area Start ##### -->
    <div class="blog-area section-padding-100">
        <div class="container">
            <div class="row">
                <div class="col-12 col-lg-12">
                	
		                <c:forEach items="${newss}" var="item">
			                <!-- Single Post Start -->
		                    <div class="single-blog-post mb-100 wow fadeInUp" data-wow-delay="100ms">
					                <!-- Post Thumb -->
		                        <div class="blog-post-thumb mt-30">
		                            <a href="#"><img src=${item.immagine } alt="" width="1200" height="635"></a>
		                            <!-- Post Date --> 
		                            <div class="post-date">
		                                <h6>${item.data}</h6>
		                            </div>
		                        </div>
	                        	<!-- Blog Content -->
		                        <div class="blog-content">
		                            <!-- Post Title -->
		                            <a href="#" class="post-title">${item.titolo}</a>
		                            <!-- Post Meta -->
		                            <div class="post-meta d-flex mb-30">
		                                <p class="post-author">By<a href="#">${item.username}</a></p>
		                            </div>
		                            <!-- Post Excerpt -->
		                            <p> ${item.contenuto} </p>
		                        </div>
		                    </div>
						</c:forEach>
	                </div>
            </div>
        </div>
    </div>
    <!-- ##### Blog Area End ##### -->

    

    <!-- ##### Footer Area Start ##### -->
    <footer class="footer-area">
        <div class="container">
            <div class="row d-flex flex-wrap align-items-center">
                <div class="col-12 col-md-6">
                    <a href="#"><img src="img/core-img/logo.png" alt=""></a>
                    <p class="copywrite-text"><a href="#"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved 
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                </div>
                 <div class="col-12 col-md-6">
                	
					<!-- Icon-only Branded Twitter button -->
					<a class="share-btn share-btn-branded share-btn-twitter"
					   href="https://twitter.com/share?url=http%3A%2F%2Flocalhost:8080%2FSoundSIW%2F&text=SoundSIW è il miglior sito di musica del momento!&via=SoundSIW"
					   title="Share on Twitter">
						<span class="share-btn-icon"></span>
						<span class="share-btn-text-sr">Twitter</span>
					</a>
				
					<!-- Icon-only Branded Facebook button -->
					<a class="share-btn share-btn-branded share-btn-facebook"
					   href="https://www.facebook.com/sharer/sharer.php?u=http%3A%2F%2Flocalhost:8080%2FSoundSIW%2F"
					   title="Share on Facebook">
						<span class="share-btn-icon"></span>
						<span class="share-btn-text-sr">Facebook</span>
					</a>
						<!-- Icon-only More/share button -->
					<a class="share-btn share-btn-more"
					   href="https://www.addtoany.com/share_save?linkurl=http%3A%2F%2Flocalhost:8080%2FSoundSIW%2F"
					   title="More share options">
						<span class="share-btn-icon"></span>
						<span class="share-btn-text-sr">More</span>
					</a>
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