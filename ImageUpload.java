/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Vivek
 */
public class ImageUpload extends HttpServlet {

    private final String UPLOAD_DIRECTORY="D:/NetBeans Project/college/web/upload";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
            
            String fname="k";
            PrintWriter out=response.getWriter();
            if(ServletFileUpload.isMultipartContent(request)){
               
             try
             {
                 
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mit","root","root");
                Statement st=con.createStatement();
                List<FileItem> multiparts;
                multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                    
                for (FileItem item : multiparts) {
                    if(!item.isFormField()){
                        fname=new File(item.getName()).getName();
                        item.write(new File(UPLOAD_DIRECTORY +File.separator +fname));
                        st.executeUpdate("insert into upload(image1)values('"+fname+"')");
                    }
                }  
                //out.println("File upload successfully <br />" +UPLOAD_DIRECTORY +File.separator +fname);
                request.getRequestDispatcher("imagedemo.jpg").include(request, response);
                
                
                
              }
              catch(Exception e)
              {
                  out.println("File Upload Fail" +e);
				}
              }
    }

   
}
    


