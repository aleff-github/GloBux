
var categoria = document.querySelector('#categoria').textContent;

console.log(categoria)

/* $(document).ready(function() {
  $.ajax(
    {
      'url': 'https://www.googleapis.com/books/v1/volumes?q=religion',
      'method': 'GET',
      'success': function(risposta){		
	  var ordinato = risposta.results.sort(maggiore);
	  leggiDati(ordinato);
      },
      'error':function(){
         alert('errore!');
       }
     }
   );



   $('#sigle').click(function(){
	var filtro = $(this).val();
	console.log(filtro);
	$('.stato').hide();
	$('.stato.'+ filtro).show();
   });

}); */