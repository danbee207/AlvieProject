/**
 * 	index java script
 */

function layer_open(el){
	var temp=$('#'+el);
	var bg= temp.prev().hasClass('bg');
	
	if(bg){
		$('.layer').fadeIn();
		
	}else{
		temp.fadeIn();
	}
	
	if(temp.outerHeight()<$(document).height()) temp.css('margin-top','-'+temp.outerHeight()/2+'px');
	else temp.css('top','0px');
	
	if(temp.outerWidth()<$(document).width()) temp.css('margin-left','-'+temp.outerWidth()/2+'px');
	else temp.css('left','0px');
	
	temp.find('a.cbtn').click(function(e){
		if(bg){
			$('.layer').fadeOut();
		}else{
			temp.fadeOut();
		}
		e.preventDefault();
		
	});
	
	$('.layer.bg').click(function(e){
		$('.layer').fadeOut();
		e.preventDefault();
	});
}

function eachFileCheck(upfile){
	
	var fileExt = upfile.substring(upfile.lastIndexOf('.')+1);
	
		
	if(!upfile){
		console.log("File blank");
		alert("Choose Excel file");
		return -1;
	}
	
	if(fileExt.toUpperCase()=="XLS" || fileExt.toUpperCase()=="XLSX"){
		
		return 0;
		
	}else{
		console.log("not excel format");
		return 1;
	}
	
}

function fileCheck(frm){
	
	var num=parseInt(frm.fileNum.value);
	var bsubmitCheck = true;
	
	for(var i=1;i<=num;i++){
		var file1 = document.getElementById("upfile"+i).value;
		if(i<num){
			var file2 = document.getElementById("upfile"+(i+1)).value;
			if(!file1.localeCompare(file2))
				return;
		}
		
		var check =eachFileCheck(file1);
		if(check==1){
			return;
		}else if(check==-1){
			frm.removeChild(upFile);
		}
		console.log("check : " + check + " file name : " + "upfile" + i);
	}
	alert("!");
	frm.submit();
	
	
	
}

function addInputfile(frm){

	
	var fileNum = parseInt(frm.fileNum.value);
	var file = document.createElement("INPUT");
	file.setAttribute("type", "file");
	file.setAttribute("name	", "upfile"+(fileNum+1));
	file.setAttribute("id","upfile"+(fileNum+1));
	file.setAttribute("size",100);
	

	var files = document.getElementById("files");
	var brEl = document.createElement('br');
	files.appendChild(brEl);
	files.appendChild(file);
	
	frm.fileNum.value++;
	
	console.log("hidden : "+frm.fileNum.value);


	return;
	
}