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

/* ==========================================
SHOW UPLOADED IMAGE NAME
* ========================================== */
var input = document.getElementById('upload');
var infoArea = document.getElementById('upload-label');

/*input.addEventListener('change', showFileName);
function showFileName(event) {
    var input = event.srcElement;
    var fileName = input.files[0].name;
    infoArea.textContent = 'File name: ' + fileName;
}*/

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
            <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item t c p">
                <div class="single-album">
                    <img src="${element.immagine}" alt="#" style="border-radius: 10px 10px 10px 10px;">
                    <div class="album-info">
                        <h4>${element.titolo}</h4>
                        <h6>${element.autore}</h6>
                    </div>
                </div>
            </div>
        </a>`)
    });
}