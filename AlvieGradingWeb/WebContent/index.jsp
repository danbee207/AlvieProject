
<%@ page import="java.lang.Boolean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="isBack" type="java.lang.Boolean" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Alvie's Grading System</title>

<link href="./css/index.css" rel="stylesheet">
</head>
<%
	if (isBack == null) {
		isBack = false;
		%>
<body>
	<% 
	} else if (isBack == true) {  isBack=false; %>

<body onload="layer_open('layer2');return false;">
	<% 
	}
%>

	My Alvie's Grading System

	<form action="ExcelServlet" method="post" enctype="multipart/form-data">
		<input type="button" id="moreAdd" value="+"
			onclick="addInputfile(this.form);" />

		<div id="files">
			<input type="file" id="upfile1" name="upfile1" size="100" />
		</div>
		<input type="button" value="Upload file"
			onclick="fileCheck(this.form)" /> <input type="hidden" value="1"
			name="fileNum">

	</form>
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="./js/indexjs.js"></script>
	<div class="layer">
		<div class="bg"></div>
		<div id="layer2" class="pop-layer">
			<div class="pop-container">
				<div class="pop-conts">
					<p class="ctxt mb20">Reading file(s) is failed.</p>
					<div class="btn-r">
						<a href="#" class="cbtn">close</a>
					</div>
				</div>
			</div>

		</div>
	</div>


</body>
</html>