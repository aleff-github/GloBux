window.onload = initialize;

function initialize(){
    ricercaPerId();
    setTimeout(() => {ricercaPerAutore()}, 600);
    setTimeout(() => {ricercaPerGenere()}, 800);

}

/* function altriRisultati(){
    var index = document.getElementById('index').value;
    var idVar = document.getElementById('id');
    if(idVar != null){
        chiamaAPI(idVar.value, riempiLibro, index);
    }
} */

function chiamaAPI(param, action){
    url = 'https://www.googleapis.com/books/v1/volumes?q=' + param;
    $(document).ready(function () {
        $.ajax(
            {
                'url': url,
                'method': 'GET',
                'success': function (risposta) {
                    action(risposta.items);
                },
                'error': function () {
                    //alert('Non sono disponibili altri libri!');
                }
            }
        );
    });
    //document.getElementById('id').value = index + 10;
}

function ricercaPerId(){
    var idVar = document.getElementById('id');
    if(idVar != null){
        chiamaAPI(idVar.value, riempiLibro);
    }
}

function ricercaPerAutore(){
    var autore = document.getElementById('autore').textContent;
    if(autore != null){
        chiamaAPI(autore, riempiScaffaleAutore);
    }
}

function ricercaPerGenere(){
    var genere = document.getElementById('genere').textContent;
    if(genere != null){
        chiamaAPI(genere, riempiScaffaleGenere);
    }
}

function riempiLibro(libri) {
    libri = libri[0];
    var libro = {
        autore: libri.volumeInfo.authors ? libri.volumeInfo.authors : "Autore non disponibile",
        titolo: libri.volumeInfo.title ? libri.volumeInfo.title : "Titolo non disponibile",
        immagine: libri.volumeInfo.imageLinks ? libri.volumeInfo.imageLinks.thumbnail : "https://glo-2020.s3.eu-central-1.amazonaws.com/image/imageNotFound.png",
        id: libri.id,
        categoria: libri.volumeInfo.categories ? libri.volumeInfo.categories : "Categoria non disponibile",
        sinossi: libri.volumeInfo.description ? libri.volumeInfo.description : "Sinossi non disponibile",
        valutazione: libri.volumeInfo.averageRating,
        voti: libri.volumeInfo.ratingsCount,
        editore: libri.volumeInfo.publisher ? libri.volumeInfo.publisher : "Editore non disponibile",
        data: libri.volumeInfo.publishedDate ? libri.volumeInfo.publishedDate : "Data non disponibile",
        pdf_link: libri.accessInfo.webReaderLink,
        pdf: libri.accessInfo.pdf.isAvailable
    };

    document.getElementById('immagine').setAttribute("src", libro.immagine);
    document.getElementById('titolo').innerText = libro.titolo;
    document.getElementById('autore').innerText = libro.autore;
    document.getElementById('editore').innerText = libro.editore;
    document.getElementById('genere').innerText = libro.categoria;
    document.getElementById('sottogenere').innerText = "Avventura";
    document.getElementById('data').innerText = libro.data;
    
    if(libro.valutazione != undefined){
        document.getElementById('valutazione').innerText = `Valutazione Utenti: ${libro.valutazione}/5`;
    }

    document.getElementById('sinossi').innerText = libro.sinossi;

    console.log(libro.pdf_link);
    console.log(typeof(libro.pdf));

    if(libro.pdf)
        document.getElementById('pdf_link').setAttribute("href", libro.pdf_link);
    else
        document.getElementById('pdf_link').setAttribute("href", "/404");

}

function riempiScaffaleAutore(libriAPI){
    scaffale = document.getElementById('scaffaleAutore');

    Array.from(libriAPI).forEach(item => {
        var libro = {
            titolo: item.volumeInfo.title ? item.volumeInfo.title : "Titolo non disponibile",
            genere: item.volumeInfo.categories ? item.volumeInfo.categories : "Genere non disponibile",
            immagine:  item.volumeInfo.imageLinks ? item.volumeInfo.imageLinks.thumbnail : "https://glo-2020.s3.eu-central-1.amazonaws.com/image/imageNotFound.png",
            autore: item.volumeInfo.authors ? item.volumeInfo.authors : "Autore non disponibile",
            id: item.id,
        }

        scaffale.insertAdjacentHTML('beforeend',
            `<a href="/libro?isbn=${libro.id}">
                <div class="single-album">
                    <img src="${libro.immagine}"
                        alt="">
                    <div class="album-info">
                        <h5>${libro.titolo}</h5>
                        <p>${libro.genere}</p>
                    </div>
                </div>
            </a>`)

    })


    creaCarosello($('.carouselAutore'));

}

function riempiScaffaleGenere(libriAPI){

    scaffale = document.getElementById('scaffaleGenere');

    Array.from(libriAPI).forEach(item => {
        var libro = {
            titolo: item.volumeInfo.title ? item.volumeInfo.title : "Titolo non disponibile",
            genere: item.volumeInfo.categories ? item.volumeInfo.categories : "Genere non disponibile",
            immagine:  item.volumeInfo.imageLinks ? item.volumeInfo.imageLinks.thumbnail : "https://glo-2020.s3.eu-central-1.amazonaws.com/image/imageNotFound.png",
            autore: item.volumeInfo.authors ? item.volumeInfo.authors : "Autore non disponibile",
            id: item.id,
        }

        scaffale.insertAdjacentHTML('beforeend',
            `<a href="/libro?isbn=${libro.id}">
                <div class="single-album">
                    <img src="${libro.immagine}"
                        alt="">
                    <div class="album-info">
                        <h5>${libro.titolo}</h5>
                        <p>${libro.genere}</p>
                    </div>
                </div>
            </a>`)

    })


    creaCarosello($('.carouselGenere'));
}



function creaCarosello(carousel){
    carousel.owlCarousel({
        items: 1,
        margin: 30,
        loop: false,
        nav: false,
        dots: false,
        autoplay: true,
        autoplayTimeout: 5000,
        smartSpeed: 750,
        responsive: {
            0: {
                items: 1
            },
            400: {
                items: 2,
                margin: 15
            },
            768: {
                items: 3
            },
            992: {
                items: 4
            },
            1200: {
                items: 5
            }
        }
    });
}