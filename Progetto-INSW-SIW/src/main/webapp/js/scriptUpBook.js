/* ==========================================
SHOW UPLOADED IMAGE
* ========================================== */
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#imageResult')
                .attr('src', e.target.result);
        };
        reader.readAsDataURL(input.files[0]);
    }
}


$(function () {
    $('#upload').on('change', function () {
        readURL(input);
    });
});

/* change color select */
function changeColorSelect(node) {
    node.setAttribute('style', 'color:#fff');
}

var categoria = document.getElementById('categoria');
if(categoria != null || categoria != undefined){
    categoria = categoria.textContent;
}
window.onload = initialize;

function initialize() {
    ricerca = 'https://www.googleapis.com/books/v1/volumes?q=' + categoria + '&startIndex=0&maxResults=10';
    $(document).ready(function () {
        $.ajax(
            {
                'url': ricerca,
                'method': 'GET',
                'success': function (risposta) {
                    riempiScaffali(risposta.items);
                },
                'error': function () {
                    alert('Non sono disponibili altri libri!');
                }
            }
        );
    });
}

function altriRisultati(categoria) {
    var index = document.getElementById("index").value;
    var max_index = parseInt(index) + 10;
    ricerca = 'https://www.googleapis.com/books/v1/volumes?q=' + categoria + '&startIndex='+index+'&maxResults='+max_index;
    $(document).ready(function () {
        $.ajax(
            {
                'url': ricerca,
                'method': 'GET',
                'success': function (risposta) {
                    console.log(risposta)
                    riempiScaffali(risposta.items);
                },
                'error': function () {
                    alert('Non sono disponibili altri libri!');
                }
            }
        );
    });
    document.getElementById("index").value = parseInt(index) + 10;
}

function riempiScaffali(risposta) {
    var libri = [];
    risposta.forEach(item => {
        var libro = {
            autore: item.volumeInfo.authors ? item.volumeInfo.authors : "Autore non disponibile",
            titolo: item.volumeInfo.title ? item.volumeInfo.title : "Titolo non disponibile",
            immagine: item.volumeInfo.imageLinks ? item.volumeInfo.imageLinks.thumbnail : "https://glo-2020.s3.eu-central-1.amazonaws.com/image/imageNotFound.png",
            id: item.id
        };
        libri.push(libro);
    });
    caricaLibri(libri);
}

function caricaLibri(libri) {
    var libriDisponibili = document.getElementById('libriDisponibili');
    libri.forEach(item => {
        libriDisponibili.insertAdjacentHTML('beforeend',
            `<a href="/libro?isbn=${item.id}">
                <div class="cnt-img">
                    <img src="${item.immagine}" alt="" style="border-radius: 10px 10px 10px 10px;">
                </div>
                <h4>${item.titolo}</h4>
                <h6>${item.autore}</h6>
            </a>`)
    });
}







// function sleep(s){
//     var now = new Date().getTime();
//     while(new Date().getTime() < now + (s*1000)){
//          /* non faccio niente */ 
//     }
// }



// function recuperaLibri(){
    
//     var listaId = document.getElementsByClassName('listaId');
    
//     if(listaId != null || listaId != undefined ){
        
//         Array.from(listaId).forEach(item => {
//             var param = item.value;
//             chiamaAPI(param, riempiLibreria, 0);
//             sleep(2);
//         })
        
//     }
    
// }



// function riempiLibreria(libriAPI){
//     scaffale = document.getElementById('scaffaleLibreria');

//     Array.from(libriAPI).forEach(item => {
//         var libro = {
//             titolo: item.volumeInfo.title ? item.volumeInfo.title : "Titolo non disponibile",
//             genere: item.volumeInfo.categories ? item.volumeInfo.categories : "Genere non disponibile",
//             immagine:  item.volumeInfo.imageLinks ? item.volumeInfo.imageLinks.thumbnail : "https://glo-2020.s3.eu-central-1.amazonaws.com/image/imageNotFound.png",
//             autore: item.volumeInfo.authors ? item.volumeInfo.authors : "Autore non disponibile",
//             id: item.id,
//         }

//         scaffale.insertAdjacentHTML('beforeend',
//             `<div  class="cnt-approva">
// 	            <div class="cnt-approva-first">
// 	                <a href="/libro?isbn=${libro.id}">
// 	                    <img src="${libro.immagine}" alt="#" style="border-radius: 10px 10px 10px 10px;">
// 	                </a>
// 	                <div class="libro-info">
// 	                    <h4>${libro.titolo}</h4>
// 	                    <h6>${libro.autore}</h6>
// 	                </div>
// 	            </div>
// 	            <div class="libro-action">
// 	                <a href="/approva?isbn=${libro.id}" ><i class="far fa-check-circle"></i></a>
// 	                <a href="/non-approvare?isbn=${libro.id}"><i class="far fa-trash-alt"></i></a>         
// 	            </div>
// 	        </div>
	
// 	        <span class="line-hor"></span>`)

        
//     })


//     //creaCarosello($('.carouselAutore'));

// }



// recuperaLibri();
