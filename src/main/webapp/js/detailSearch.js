$(function() {
	$("#show").click(function(e) {
		e.preventDefault(); document.querySelector(".background").className = "background show";
		$('.detailSearch').stop().show(500);
	})
})