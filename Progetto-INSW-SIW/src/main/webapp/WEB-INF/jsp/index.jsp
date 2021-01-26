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
    		<link rel="icon" href="img/webapp/GloBuxLogo.png">

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

            <!-- ##### Hero Area Start ##### -->
            <section class="hero-area">
                <!-- Single Hero Slide -->
                <div class="single-hero-slide d-flex align-items-center justify-content-center">
                    <!-- Slide Img -->
                    <div class="slide-img bg-img"
                        style="background-image: url(/img/bg-img/libri.jpg);"></div>
                    <!-- Slide Content -->
                    <div class="container">
                        <div class="row">
                            <div class="col-12">
                                <div class="hero-slides-content text-center">
                                    <h6 data-animation="fadeInUp" data-delay="100ms">Scegli fra 700.000 volumi</h6>
                                    <h2 data-animation="fadeInUp" data-delay="300ms" style="font-weight: 800;">GLOBUX
                                        <span>GLOBUX </span>
                                    </h2>
                                </div>
								<form action="ricerca-libro" method="get">
	                                <div class="input-group md-form form-sm form-2 pl-0">
	                                
	                                    <input class="form-control my-0 py-1 red-border" type="text"
	                                        placeholder="Ricerca per titolo..." name="ricerca" aria-label="Search">
	                                    <div class="input-group-append">
	                                        <span class="input-group-text red lighten-3 border-r-tbr-icon-search"
	                                            id="basic-text1" ><i class="fas fa-search text-grey"
	                                                aria-hidden="true"></i></span>
	                                    </div>
	                                </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- ##### Hero Area End ##### -->

            <!-- ##### Latest Book Area Start ##### -->
            <section class="latest-albums-area section-padding-100">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="section-heading style-2">
                                <p>Gli ultimi libri caricati</p>
                                <h2>Ultime Novità</h2>
                            </div>
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-12 col-lg-9">
                            <div class="ablums-text text-center mb-70">
                                <p>Nam tristique ex vel magna tincidunt, ut porta nisl finibus. Vivamus eu dolor eu quam
                                    varius rutrum. Fusce nec justo id sem aliquam fringilla nec non lacus. Suspendisse
                                    eget lobortis nisi, ac cursus odio. Vivamus nibh velit, rutrum at ipsum ac,
                                    dignissim iaculis ante. Donec in velit non elit pulvinar pellentesque et non eros.
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <div class="albums-slideshow owl-carousel carouselIndex" >
                                <c:forEach items="${libri}" var="item">
                                    <!-- Single Album -->
                                    <div class="single-album">
                                        <a href="/libro?isbn=${item.isbn}">
                                            <img src="https://glo-2020.s3.eu-central-1.amazonaws.com/image/${item.image}"
                                                alt="">
                                            <div class="album-info">
                                                <h5>${item.titolo}</h5>
                                                <p>${item.autore}</p>
                                            </div>
                                        </a>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- ##### Latest book Area End ##### -->

            <!-- ##### Categories Area Start ##### -->
            <section class="oneMusic-buy-now-area has-fluid bg-gray section-padding-100">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">
                            <div class="section-heading style-2">
                                <p>Naviga tra le categorie consigliate</p>
                                <h2>Categorie</h2>
                            </div>
                        </div>
                    </div>

 

                    <div class="row">
                        <div class="col-12">
                            <div class="albums-slideshow owl-carousel carouselIndex container-libri" >
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
                    </div>
                </div>
            </section>
            <!-- ##### Categories Now Area End ##### -->



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