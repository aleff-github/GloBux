var idVar = document.getElementById('id');
if(idVar != null){
    var id = idVar.value;
    ricerca = 'https://www.googleapis.com/books/v1/volumes?q=' + id;
    $(document).ready(function () {
        $.ajax(
            {
                'url': ricerca,
                'method': 'GET',
                'success': function (risposta) {
                    riempiScaffali(risposta.items[0]);
                },
                'error': function () {
                    alert('errore!');
                }
            }
        );
    });
}
function riempiScaffali(risposta) {
    var libro = {
        autore: risposta.volumeInfo.authors ? risposta.volumeInfo.authors : "Autore non disponibile",
        titolo: risposta.volumeInfo.title ? risposta.volumeInfo.title : "Titolo non disponibile",
        immagine: risposta.volumeInfo.imageLinks.thumbnail ? risposta.volumeInfo.imageLinks.thumbnail : "https://glo-2020.s3.eu-central-1.amazonaws.com/image/imageNotFound.png",
        id: risposta.id,
        categoria: risposta.volumeInfo.categories ? risposta.volumeInfo.categories : "Categoria non disponibile",
        sinossi: risposta.volumeInfo.description ? risposta.volumeInfo.description : "Sinossi non disponibile",
        valutazione: risposta.volumeInfo.averageRating,
        voti: risposta.volumeInfo.ratingsCount,
        editore: risposta.volumeInfo.publisher ? risposta.volumeInfo.publisher : "Editore non disponibile",
        data: risposta.volumeInfo.publishedDate ? risposta.volumeInfo.publishedDate : "Data non disponibile",
        pdf_link: risposta.accessInfo.webReaderLink,
        pdf: risposta.accessInfo.pdf.isAvailable};

        document.getElementById('immagine').setAttribute("src", libro.immagine);
        document.getElementById('titolo').innerText = libro.titolo;
        document.getElementById('autore').innerText = libro.autore;
        document.getElementById('editore').innerText = libro.editore;
        document.getElementById('genere').innerText = libro.categoria;
        document.getElementById('sottogenere').innerText = "Avventura";
        document.getElementById('data').innerText = libro.data;
        if(libro.valutazione == undefined)
            document.getElementById('valutazione').parentNode.innerText = "Valutazione non disponibile";
        else
            document.getElementById('valutazione').innerText = libro.valutazione;
        document.getElementById('sinossi').innerText = libro.sinossi;

        if(libro.pdf == true)
            document.getElementById('pdf_link').setAttribute("href", libro.pdf_link);
        else
            document.getElementById('pdf_link').setAttribute("href", "/404");
        return;
}
