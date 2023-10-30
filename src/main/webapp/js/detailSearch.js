$(function() {
  $("#show").click(function(e) {
    e.preventDefault();
    $(".background").addClass(" show"); // Remove the "show" class
    $('.detailSearch').stop().show();
  });

  $('.background').click(function(e) {
    if ($(e.target).hasClass('background')) { // Check if the click was on the .background element
      $('.detailSearch').stop().hide(300);
      $(".background").removeClass(" show"); // Add the "show" class back
    }
  });
});

function closeButton(e){
	if ($(e.target).hasClass('background'))  // Check if the click was on the .background element
      $('.detailSearch').stop().hide(300);
      $(".background").removeClass(" show"); // Add the "show" class back
}