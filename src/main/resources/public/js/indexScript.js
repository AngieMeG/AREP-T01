function switchPage(){
    var identifier = $("#identifier").val();
    console.log(identifier);
    if (identifier !== ""){
        document.cookie = "id="+identifier;
        window.location.replace("consult.html");
    }
}

document.getElementById("submit").addEventListener("click", switchPage);
