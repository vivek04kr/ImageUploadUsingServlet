<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import=" java.sql.*, java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String connectionURL = "jdbc:mysql://localhost:3306/img";
java.sql.Connection con=null;
try{  
Class.forName("com.mysql.jdbc.Driver").newInstance();
con=DriverManager.getConnection(connectionURL,"root","tamtam");  
Statement st1=con.createStatement();
ResultSet rs1 = st1.executeQuery("select * from im111");
String imgLen="";
while(rs1.next())
    {
	 //int len=imgLen.length();
	 //byte []rb=new  byte[len];
	 String img=rs1.getString("name");
	%>
	<table>
	<tr>
	<th>id</th>
	<th>name</th>
	</tr>
	<tr>
	<td><%=rs1.getInt("id")%></td>
	<td><img src="img1/<%=img %>" height="50px" width="100px" ></td>
	</tr>
	</table>
	<%
	}
}catch(Exception e)
{
 out.println(e);
}
%>
</body>
</html>