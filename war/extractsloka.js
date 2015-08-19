function extractSanskritSloka(slokaNum) {
	var content = $("body").html();
	var matchText =  _getMatch(slokaNum);
	start = content.indexOf(matchText);
	end = content.indexOf( _getMatch(slokaNum + 1));
	var result = content.substring(start, end);
	result = $(result).text();

	// remove the first line
	start = result.indexOf("\n");
	return result.substring(start + 1);
}


function extractEnglishSloka(slokaNum) {
	var content = $("body").html();
	var matchText =  _getMatch(slokaNum + 1);
	content = content.substring(content.indexOf(matchText) + matchText.length);

	start = content.indexOf(_getMatch(slokaNum));
	end = content.indexOf( _getMatch(slokaNum + 1));
	var result = content.substring(start, end);
	result = $(result).text();

	// remove the first line
	start = result.indexOf("\n");
	return result.substring(start + 1);
}

function _getMatch(slokaNum) {
	return '<font color="GREEN" size="-1">'+slokaNum+'</font>';
}


function extractEnglishText() {
	console.log("Hello umasankar");
	var result;
	var valid = -1;
	$("#ext_page1").find(".field-item").each(
			function(index) {
				var usp = $(this).text();
				if (valid == index) {
					result = usp;
				}
				if (usp.indexOf("—") > 0) {
					valid = index + 1;
				}
			});
	return result;
}

function extractSanskritToEnglishText() {
	console.log("Hello umasankar");
	var result;
	$("#ext_page1").find(".field-item").each(
			function(index) {
				var usp = $(this).text();
				if (usp.indexOf("—") > 0) {
					result = usp;
				}
			});
	return result;
}


function umasankar(chapter, slokaNum){
	var uuuu= "http://sacred-texts.com/hin/mbs/mbs060"+(22 + chapter)+".htm"
	console.log(uuuu);
	$("#ext_page").load("http://cors.io/?u=" + uuuu,
			function() {
		var sanskrit = extractSanskritSloka(slokaNum);
		$("#sanskrit_id").val(sanskrit);
		var english = extractEnglishSloka(slokaNum);
		$("#english_id").val(english);
		$("#english_translation_id").val(extractEnglishText());
		$("#sanskrit_to_english_id").val(extractSanskritToEnglishText());
	});
}




function umasankar1(chapter, slokaNum){
	//slokaNum = slokaNum - 1;
	var uuuu= "http://www.vedabase.com/en/bg/" + chapter +"/" + slokaNum;
	console.log(uuuu);
	$("#ext_page1").load("http://cors.io/?u=" + uuuu,
			function(responseText, statusText, xhr) {
		console.log("Hello umasankar");
		extractEnglishText();
	});
}