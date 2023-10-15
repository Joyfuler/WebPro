function noImage(imageElement) {
 imageElement.src = "img/noimg.jpg";
}

function emptyChk(){
    if (document.getElementsByName("comment")[0].value ==""){
        alert("내용이 없습니다.");
        return false;
    } else {
        document.evalFrm.submit();
    }
}