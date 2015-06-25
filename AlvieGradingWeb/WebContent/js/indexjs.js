/**
 * 	index java script
 */

function fileCheck(frm){
	
	var file = frm.upfile.value;
	var fileExt = file.substring(file.lastIndexOf('.')+1);
	var bsubmitCheck = true;
	
	console.log("file format : " + file);
	
	if(!file){
		console.log("file blank");
		alert("Choose Excel file");
		return;
	}
	if(fileExt.toUpperCase()=="XLS" || fileExt.toUpperCase()=="XLSX"){
		frm.submit();
		 
	}else{
		console.log("not excel format");
		
	}
	
}