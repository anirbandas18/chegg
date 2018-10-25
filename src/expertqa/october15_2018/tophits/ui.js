function parseAction() {
	var top30List = document.getElementById('top-30-file').files;
	var file = top30List[0];
	if(file) {
		var reader = new FileReader();
		reader.onload = function(e) { 
			var content = e.target.result;
			var xmlParser = new DOMParser();
			var xmlFile = xmlParser.parseFromString(content, "text/xml");
			console.log(xmlFile);
			var hitList = xmlFile.getElementsByTagName('Hit');
			var table = document.getElementById("top-30-list");
			console.log(hitList.length);
			var i = 0;
			while(i < 5) {
				var hit = hitList[i];
				
				var row = table.insertRow(1 + i++);
				var rank = row.insertCell(0);
				var song = row.insertCell(1);
				var artist = row.insertCell(2);
				var duration = row.insertCell(3);
				
				rank.innerHTML = i;
				song.innerHTML = hit.getElementsByTagName('Song')[0].childNodes[0].nodeValue;
				artist.innerHTML = hit.getElementsByTagName('Artist')[0].childNodes[0].nodeValue;
				duration.innerHTML = hit.getElementsByTagName('Duration')[0].childNodes[0].nodeValue;
			}
		}
		reader.readAsText(file);
	} else { 
		alert("Failed to load file");
	}
}
