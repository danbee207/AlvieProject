/**
 * 	index java script
 */

function eachFileCheck(upfile){
	
	var fileExt = upfile.substring(upfile.lastIndexOf('.')+1);
	
		
	if(!upfile){
		console.log("File blank");
		alert("Choose Excel file");
		return false;
	}
	
	if(fileExt.toUpperCase()=="XLS" || fileExt.toUpperCase()=="XLSX"){
		
		return true;
		
	}else{
		console.log("not excel format");
		return false;
	}
	
}

function fileCheck(frm){
	
	var num=frm.fileNum.value;
	var bsubmitCheck = true;
	
	for(var i=1;i<=num;i++){
		if(i<num){
			var file1 = document.getElementById("upfile"+i).value;
			var file2 = document.getElementById("upfile"+(i+1)).value;
			if(!file1.localeCompare(file2))
				return;
		}
		var check =eachFileCheck(document.getElementById("upfile"+i));
		if(!check)
			return;
	}
	
	frm.submit();
	
	
	
}

function addInputfile(frm){

	var fileNum = parseInt(frm.fileNum.value);
	var file = document.createElement("INPUT");
	file.setAttribute("type", "file");
	file.setAttribute("id", "upfile"+(fileNum+1));
	file.setAttribute("size",100);
	

	var files = document.getElementById("files");
	var brEl = document.createElement('br');
	files.appendChild(brEl);
	files.appendChild(file);
	
	frm.fileNum.value++;
	
	console.log("hidden : "+frm.fileNum.value);


	return;
	
}