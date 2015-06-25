<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Alvie's Grading System</title>


</head>
<body>
My Alvie's Grading System

<form action = "ExcelServlet" method="post" enctype="multipart/form-data">
<input type = "file" name="upfile" size="100"/><br/>
<input type = "button" value="Upload file" onclick="fileCheck(this.form)"/>

</form>

<script type="text/javascript" src="./js/indexjs.js"  ></script>
</body>
</html>