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
            <p>See what’s new</p>
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
		                                <p class="post-author">By <a href="#">Admin</a></p>
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