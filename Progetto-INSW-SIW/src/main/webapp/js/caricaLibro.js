/* ==========================================
SHOW UPLOADED IMAGE
* ========================================== */

window.onload = registraListener;

function registraListener() {

    document.querySelector('#upload').addEventListener('change', readImage, removeBrdUpImage);
    document.querySelector('#file').addEventListener('change', readFile);

}


function readImage() {
    if (this.files && this.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#imageResult')
                .attr('src', e.target.result);
        };
        reader.readAsDataURL(this.files[0]);
        
    }
}

function readFile() {
    document.querySelector("#nameFile").innerText = this.files[0].name;
}


/* change color select */
function changeColorSelect(node) {
    node.setAttribute('style', 'color:#fff');
}

function removeBrdUpImage(){
    document.querySelector("#lbl_image").setAttribute('style', 'border:none');
}

$(document).ready(function(){
    // File upload via Ajax
    $("#uploadForm").on('submit', function(e){
        e.preventDefault();
        $.ajax({
            xhr: function() {
                var xhr = new window.XMLHttpRequest();
                xhr.upload.addEventListener("progress", function(evt) {
                    if (evt.lengthComputable) {
                        var percentComplete = ((evt.loaded / evt.total) * 100);
                        console.log(percentComplete)
                        $(".progress-bar").width(percentComplete + '%');
                        $(".progress-bar").html(percentComplete+'%');
                    }
                }, false);
                return xhr;
            },
            type: 'POST',
            url: '/caricaLibro/up',
            data: new FormData(this),
            contentType: false,
            cache: false,
            processData:false,
            beforeSend: function(){
                $(".progress-bar").width('0%');
            },
            fail:function(){
                showPopupError();
            },
            success: function(resp){
                console.log(resp)
                if(resp === 'SUCCESS'){
                   showPopupSuccess();
                   setTimeout(() =>{ window.location.reload()}, 800); 
                   
                }else if(resp == 'ERROR'){
                    showPopupError();
                }
            }
        });
    });

});


/* POPUP */

function showPopupSuccess(){
    document.querySelector("#popup-success").style.display = "";
}

function showPopupError(){
    document.querySelector("#popup-error").style.display = "";
}

function removePopup(node){
    node.style.display = "none";
}