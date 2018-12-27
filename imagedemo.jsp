<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
                    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>File Upload to Database</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>File Upload to Database</h1>
        <form id="UploadForm" method="post" action="ImageUpload" enctype="multipart/form-data">
            
            
            <input type="file" name="file" id="myfile"/><br><br>
            <input type="submit" value="upload">
        </form>
    </body>
</html>