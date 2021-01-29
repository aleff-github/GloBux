


$(".deleteForm").on('submit', function(e){
    e.preventDefault();
    $.ajax({
        type: 'POST',
        url: '/deleteLibro',
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
            if(resp === 'SUCCESS'){
                showPopupSuccess();
                removeNode(e.target);
            
            }else if(resp == 'ERROR'){
                showPopupError();
            }
        }
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

function removeNode(node){
    var parent = node.closest(".cnt-approva");
    parent.remove();
}