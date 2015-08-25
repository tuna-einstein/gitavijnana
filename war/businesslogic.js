

var prevChapter = 0;
var prevStart = 0;
var prevEnd = 0;

var nextChapter = 0;
var nextStart = 0;
var nextEnd = 0;

function checkSlideEnd() {
	var current = $('#slides').superslides('current');
	var next = $('#slides').superslides('next');
	var prev = $('#slides').superslides('prev');
	if (current > next) {
		console.log(""+ nextChapter + " " + nextStart + " " + nextEnd);
		showDivExtra(nextChapter, nextStart, nextEnd, 1);
	}
}

function checkSlideBegin() {
	var current = $('#slides').superslides('current');
	var next = $('#slides').superslides('next');
	var prev = $('#slides').superslides('prev');
	if (prev > current) {
		console.log(""+ prevChapter + " " + prevStart + " " + prevEnd);
		showDivExtra(prevChapter, prevStart, prevEnd, prevEnd - prevStart + 1);
	}
}

function loadSlokas(containerId, chapter, start, end, startPoint) {
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
	'<a href="#" class="next"  onclick="checkSlideEnd()"> <i class="icon-chevron-right"></i>' +
	'</a> <a href="#" class="prev" onclick="checkSlideBegin()"> <i class="icon-chevron-left"></i>' +
	'</a>' +
	'</nav></div>';

	ele.innerHTML=value;

	for (i = start; i <= end; i++) { 
		if (i == end) {
			$("#" + _getMyId(chapter, i)).load("temp?chapter=" + chapter
					+ "&slokaNum=" + i
					+ "&cs=" + start
					+ "&ce=" + end,
					function() {
				console.log("loaded");
				
//				$('#slides').superslides('start');
//				$('#slides').superslides('animate', 2);
				
				window.location.hash = startPoint;
				$('#slides').superslides({hashchange:true});
			});
		} else {
			$("#" + _getMyId(chapter, i)).load("temp?chapter=" + chapter
					+ "&slokaNum=" + i
					+ "&cs=" + start
					+ "&ce=" + end);
		}
	}
}

function _getMyId(chapter, sloka) {
	return "bg_" + chapter + "_" + sloka;
}




