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
ricerca = 'https://www.googleapis.com/books/v1/volumes?q=' + categoria;
$(document).ready(function () {
    $.ajax(
        {
            'url': ricerca,
            'method': 'GET',
            'success': function (risposta) {
                riempiScaffali(risposta.items);
            },
            'error': function () {
                alert('errore!');
            }
        }
    );
});

function riempiScaffali(risposta) {
    var libri = [];
    risposta.forEach(element => {
        var libro = {
            autore: element.volumeInfo.authors,
            titolo: element.volumeInfo.title,
            immagine: element.volumeInfo.imageLinks.thumbnail,
            id: element.id
        };
        libri.push(libro);
    });
    caricaLibri(libri);
}

function caricaLibri(libri) {
    var libriDisponibili = document.getElementById('libriDisponibili');
    libri.forEach(element => {
        libriDisponibili.insertAdjacentHTML('beforeend',
            `<a href="/libro?isbn=${element.id}">
                <div class="cnt-img">
                    <img src="${element.immagine}" alt="" style="border-radius: 10px 10px 10px 10px;">
                </div>
                <h4>${element.titolo}</h4>
                <h6>${element.autore}</h6>
            </a>`)
    });
}