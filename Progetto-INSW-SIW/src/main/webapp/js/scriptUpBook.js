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
function changeColorSelect(node){
    node.setAttribute('style', 'color:#fff');
    console.log(node)
}

var categoria = document.getElementById('categoria').textContent;
/* for(i = 0; i < 100; i += 10){ */

ricerca = 'https://www.googleapis.com/books/v1/volumes?q=' + categoria + '&startIndex=0&maxResults=40';
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
                alert('errore!');
            }
        }
    );
});

/* } */


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