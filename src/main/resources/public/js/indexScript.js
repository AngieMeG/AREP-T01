function switchPage(){
    var identifier = $("#identifier").val();
    if (identifier !== ""){
        document.cookie = "id="+identifier;
        window.location.replace("consult.html");
    }
}

document.getElementById("submit").addEventListener("click", switchPage);
