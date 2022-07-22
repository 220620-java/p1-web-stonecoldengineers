package com.revature.berhanu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.berhanu.models.*;

public class Hello extends HttpServlet {
    @Override
   // protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
     //   tbluser objTblUser = new tbluser();

       // resp.getWriter().write(objTblUser.getList.get(0).firstname);

    

protected void service(HttpServletRequest req,   HttpServletResponse resp) throws ServletException, IOException
{
   String method = req.getMethod();
   tbluser objTblUser = new tbluser();

   if (method.equals(METHOD_GET)) 
   {
         
     resp.getWriter().write(objTblUser.getList.get(0).firstname);


     //doGet(req, resp);


   } else if (method.equals(METHOD_POST)) 
   
   {
            String ID = req.getParameter("ID");
            BufferedReader reader = req.getReader();
            String requestBody = "";
            String line = "";
            while ((line=reader.readLine())!=null) {
                requestBody += objTblUser.getSingle(ID);
            }
         PrintWriter writeto = resp.getWriter(requestBody);


     //objTblUser.getSingle.getList.get(0).firstname);
        //doPost(req, resp);
            
         writeto.write(requestBody); 

   } else if (method.equals(METHOD_PUT)) 
   {
     doPut(req, resp);

   } else if (method.equals(METHOD_DELETE)) 
    {
        
         doDelete(req, resp);(req, resp);

   
   }else {

    // Servlet doesn't currently support 
    // other types of request.
    String errMsg = "Method Not Supported";
    resp.sendError(
      HttpServletResponse.SC_NOT_IMPLEMENTED, errMsg);
   }
   
}

}
