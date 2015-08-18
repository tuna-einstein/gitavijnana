
function loadSlokas(containerId, chapter, start, end) {
	var ele = document.getElementById(containerId);
	var value = '<div id="slides" class="main_container">' +
	'<div class="slides-container" id="slides_container">';
	
	for (i = start; i <= end; i++) {
		value += "<div>";
	    value += '<div id="'+ _getMyId(chapter, i) + '">Uma Sankar </div>'; 
	    value += '</div>';
	}
	
	
	value += '</div>'+
	'<nav class="slides-navigation">' +
	'<a href="#" class="next"> <i class="icon-chevron-right"></i>' +
	'</a> <a href="#" class="prev"> <i class="icon-chevron-left"></i>' +
	'</a>' +
	'</nav></div>';
	
	ele.innerHTML=value;
	
	for (i = start; i <= end; i++) { 
		$("#" + _getMyId(chapter, i)).load("temp?chapter=" + chapter + "&slokaNum=" + i);
	}
	
	$('#slides').superslides({
		hashchange: true
	});
	
}

function _getMyId(chapter, sloka) {
	return "bg_" + chapter + "_" + sloka;
}




