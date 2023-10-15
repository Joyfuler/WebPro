function noImage(imageElement) {
 imageElement.src = "../../img/noimg.jpg";
}
  
  $(document).ready(function() {    
    $('#closeMenuButton').click(function() {
      $('.navbar-collapse').collapse('hide');
    });
  });