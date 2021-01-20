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
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/breadcumb3.jpg);">
        <div class="bradcumbContent">
            <p>Scegli fra le migliori categorie</p>
            <h2>Categorie</h2>
        </div>
    </section>
    <!-- ##### Breadcumb Area End ##### -->

    <!-- ##### Album Catagory Area Start ##### -->
    <section class="album-catagory section-padding-100-0">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="browse-by-catagories catagory-menu d-flex flex-wrap align-items-center mb-70">
                        <a href="#" data-filter="*">Browse All</a>
                        <a href="#" data-filter=".a" class="active">A</a>
                        <a href="#" data-filter=".b">B</a>
                        <a href="#" data-filter=".c">C</a>
                        <a href="#" data-filter=".d">D</a>
                        <a href="#" data-filter=".e">E</a>
                        <a href="#" data-filter=".f">F</a>
                        <a href="#" data-filter=".g">G</a>
                        <a href="#" data-filter=".h">H</a>
                        <a href="#" data-filter=".i">I</a>
                        <a href="#" data-filter=".j">J</a>
                        <a href="#" data-filter=".k">K</a>
                        <a href="#" data-filter=".l">L</a>
                        <a href="#" data-filter=".m">M</a>
                        <a href="#" data-filter=".n">N</a>
                        <a href="#" data-filter=".o">O</a>
                        <a href="#" data-filter=".p">P</a>
                        <a href="#" data-filter=".q">Q</a>
                        <a href="#" data-filter=".r">R</a>
                        <a href="#" data-filter=".s">S</a>
                        <a href="#" data-filter=".t">T</a>
                        <a href="#" data-filter=".u">U</a>
                        <a href="#" data-filter=".v">V</a>
                        <a href="#" data-filter=".w">W</a>
                        <a href="#" data-filter=".x">X</a>
                        <a href="#" data-filter=".y">Y</a>
                        <a href="#" data-filter=".z">Z</a>
                        <a href="#" data-filter=".number">0-9</a>
                    </div>
                </div>
            </div>

            <div class="row oneMusic-albums">

                <!-- Classici -->
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item t c p">
                    <div class="single-album">
                        <img src="img/categories/Classici.jpg" alt="#" style="border-radius: 10px 10px 10px 10px;">
                        <div class="album-info">
                            <a href="categoria?cat=classici">
                                <h5>Classici</h5>
                            </a>
                            <p>Grandi classici della letteratura</p>
                        </div>
                    </div>
                </div>
                
                <!-- Art -->
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item t c p">
                    <div class="single-album">
                        <img src="img/categories/Art.jpg" alt="#" style="border-radius: 10px 10px 10px 10px;">
                        <div class="album-info">
                            <a href="arte">
                                <h5>Arte</h5>
                            </a>
                            <p>Libri sull'Arte</p>
                        </div>
                    </div>
                </div>
                <!-- Categoria -->
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item t c p">
                    <div class="single-album">
                        <img src="img/categories/" alt="#" style="border-radius: 10px 10px 10px 10px;">
                        <div class="album-info">
                            <a href="categoria" name="isbn" value="9780786102563">
                                <h5>Classici</h5>
                            </a>
                            <p>Grandi classici della letteratura</p>
                        </div>
                    </div>
                </div>
                <!-- Categoria -->
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item t c p">
                    <div class="single-album">
                        <img src="img/categories/" alt="#" style="border-radius: 10px 10px 10px 10px;">
                        <div class="album-info">
                            <a href="categoria" name="isbn" value="9780786102563">
                                <h5>Classici</h5>
                            </a>
                            <p>Grandi classici della letteratura</p>
                        </div>
                    </div>
                </div>
                <!-- Categoria -->
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item t c p">
                    <div class="single-album">
                        <img src="img/categories/" alt="#" style="border-radius: 10px 10px 10px 10px;">
                        <div class="album-info">
                            <a href="categoria" name="isbn" value="9780786102563">
                                <h5>Classici</h5>
                            </a>
                            <p>Grandi classici della letteratura</p>
                        </div>
                    </div>
                </div>
                <!-- Categoria -->
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item t c p">
                    <div class="single-album">
                        <img src="img/categories/" alt="#" style="border-radius: 10px 10px 10px 10px;">
                        <div class="album-info">
                            <a href="categoria" name="isbn" value="9780786102563">
                                <h5>Classici</h5>
                            </a>
                            <p>Grandi classici della letteratura</p>
                        </div>
                    </div>
                </div>
                <!-- Categoria -->
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item t c p">
                    <div class="single-album">
                        <img src="img/categories/" alt="#" style="border-radius: 10px 10px 10px 10px;">
                        <div class="album-info">
                            <a href="categoria" name="isbn" value="9780786102563">
                                <h5>Classici</h5>
                            </a>
                            <p>Grandi classici della letteratura</p>
                        </div>
                    </div>
                </div>
                <!-- Categoria -->
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item t c p">
                    <div class="single-album">
                        <img src="img/categories/" alt="#" style="border-radius: 10px 10px 10px 10px;">
                        <div class="album-info">
                            <a href="categoria" name="isbn" value="9780786102563">
                                <h5>Classici</h5>
                            </a>
                            <p>Grandi classici della letteratura</p>
                        </div>
                    </div>
                </div>
                <!-- Categoria -->
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item t c p">
                    <div class="single-album">
                        <img src="img/categories/" alt="#" style="border-radius: 10px 10px 10px 10px;">
                        <div class="album-info">
                            <a href="categoria" name="isbn" value="9780786102563">
                                <h5>Classici</h5>
                            </a>
                            <p>Grandi classici della letteratura</p>
                        </div>
                    </div>
                </div>
                <!-- Categoria -->
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item t c p">
                    <div class="single-album">
                        <img src="img/categories/" alt="#" style="border-radius: 10px 10px 10px 10px;">
                        <div class="album-info">
                            <a href="categoria" name="isbn" value="9780786102563">
                                <h5>Classici</h5>
                            </a>
                            <p>Grandi classici della letteratura</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>
    <!-- ##### Album Catagory Area End ##### -->

    <!-- ##### Contact Area Start ##### -->
    <section class="contact-area section-padding-100 bg-img bg-overlay bg-fixed has-bg-img" style="background-image: url(img/bg-img/bg-2.jpg);">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="section-heading white">
                        <p>Contattaci tramite questo form, risponderemo al più presto!</p>
                        <h2>Contatti</h2>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <!-- Contact Form Area -->
                    <div class="contact-form-area">
                        <form action="#" method="post">
                            <div class="row">
                                <div class="col-md-6 col-lg-4">
                                    <div class="form-group">
                                        <input type="text" class="form-control" id="name" placeholder="Name">
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-4">
                                    <div class="form-group">
                                        <input type="email" class="form-control" id="email" placeholder="E-mail">
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group">
                                        <input type="text" class="form-control" id="subject" placeholder="Subject">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <textarea name="message" class="form-control" id="message" cols="30" rows="10" placeholder="Message"></textarea>
                                    </div>
                                </div>
                                <div class="col-12 text-center">
                                    <button class="btn oneMusic-btn mt-30" type="submit">Send <i class="fa fa-angle-double-right"></i></button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ##### Contact Area End ##### -->

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