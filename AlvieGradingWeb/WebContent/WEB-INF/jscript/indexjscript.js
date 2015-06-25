/**
 * 	index java script
 */

console.log("here");
function filecheck(frm){
	
	console.log("here");
	
	var file = frm.upfile.value;
	var fileExt = file.substring(file.lastIndexOf('.')+1);
	var bsubmitCheck = true;
	
	if(!file){
		return;
	}
	if(fileExt.toUpperCase()=="XLS" || fileExt.toUpperCase()=="XLSX"){
		frm.sumbit();
		 
	}
	
}