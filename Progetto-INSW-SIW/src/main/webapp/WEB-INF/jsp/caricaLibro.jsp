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

	<c:if test="${not loggato}">
		<jsp:include page="partials/index/menuIndex.jsp" />
	</c:if>
	<c:if test="${loggato and not loggatoAdmin}">
		<jsp:include page="partials/user/menuUser.jsp" />
	</c:if>
	<c:if test="${loggatoAdmin}">
		<jsp:include page="partials/admin/menuAdmin.jsp" />
	</c:if>

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
				            <input id="upload" name="image" type="file" onchange="readURL(this); removeBrdUpImage()" class="form-control border-0" hidden required>

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
						    <input name="titolo" type="text" class="form-control fc-color" placeholder="Titolo" required>
					  	</div>
					  	<!-- autore -->
					  	<div class="form-group">
						    <input name="autore" type="text" class="form-control fc-color" placeholder="Autore" required>
					  	</div>
					  	<!-- editore -->
					  	<div class="form-group">
						    <input name="editore" type="text" class="form-control fc-color" placeholder="Editore" required>
					  	</div>
					  	<!-- isbn -->
					  	<div class="form-group">
						    <input name="isbn" type="text" class="form-control fc-color" placeholder="ISBN" required>
					  	</div>
					  	<!-- anno -->
					  	<div class="form-group">
						    <input name="anno" type="number" class="form-control fc-color" placeholder="Anno di pubblicazione" required>
					  	</div>
					  	<br> <br>
					  	<!-- genere -->
					  	<!-- 	<div class="form-group">
						    <input name="genere" type="text" class="form-control fc-color" placeholder="Genere">
						</div> -->
						<select type="text" class="form-select form-control form-group" required onchange="changeColorSelect(this)" name="genere">
							<option value="" selected disabled>Seleziona Genere</option>
							<option value="Classici">Classici</option>
							<option value="Arte">Arte</option>
							<option value="Romanzo">Romanzo</option>
							<option value="Religione">Religione</option>
							<option value="Horror">Horror</option>
							<option value="Musica">Musica</option>
							<option value="Humor">Humor</option>
						  </select>
					  	<!-- sottogeneri -->
					  	<div class="form-group">
						    <input name="sottogenere" type="text" class="form-control fc-color" placeholder="Sottogenere">
					  	</div>
					  	<br> <br>
					  	<!-- sinossi -->
					  	<div class="form-group">
						    <textarea name="sinossi" type="text" class="form-control fc-color" placeholder="Sinossi" rows="4" required></textarea>
					  	</div>
					  	<br> <br>
					  	<!-- Contenuto -->
					  	<div class="form-group" style="color: #7f8182">
					  		Seleziona contenuto
							<input id="file" name ="file" type="file" class="form-control fc-color" style="padding-left:0; border:none; " required>
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

<script type="text/javascript">
	function removeBrdUpImage(){
		document.querySelector("#lbl_image").setAttribute('style', 'border:none');
	}

</script>


</html>
