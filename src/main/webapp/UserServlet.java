package com.revature.berhanu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.berhanu.models.*;

public class UserServlet extends HttpServlet {
    
    

protected void doGet (HttpServletRequest req,   HttpServletResponse resp) throws ServletException, IOException
{
   String method = req.getMethod();
   tbluser objTblUser = new tbluser();  
    
   resp.getWriter().write(objTblUser.getList.get(0).userid);
   resp.getWriter().write(objTblUser.getList.get(0).ssn);
   resp.getWriter().write(objTblUser.getList.get(0).firstname);
   resp.getWriter().write(objTblUser.getList.get(0).middleName);
   resp.getWriter().write(objTblUser.getList.get(0).lastname);
   resp.getWriter().write(objTblUser.getList.get(0).dob);
   resp.getWriter().write(objTblUser.getList.get(0).gender);
   resp.getWriter().write(objTblUser.getList.get(0).email);
   resp.getWriter().write(objTblUser.getList.get(0).phonenumber);

    

}
protected void doPost(HttpServletRequest req,  HttpServletResponse resp)throws ServletException, IOException{
   // it is used to submit data from the browser

   tbluser objTblUser = new tbluser();
   BufferedReader reader = req.getReader();

   PrinterWriter writer = resp.getWriter();
   String requestBody = reader.readLine();
   writer.write (" Please put in the user information  " + requestBody );
    
 
      String userSSN = req.getParameter("SSN");
      String FirstName = req.getParameter("FirstName");
      String MiddleName = req.getParameter("MiddleName");
      String LastName = req.getParameter("LastName");
      String DOB = req.getParameter("dob");
      String Gennder = req.getParameter("gender");
      String email = req.getParameter("email");
      String phoneNumber = req.getParameter("phoneNumber");
      String password = req.getParameter("password");
      tbluser objTblUserCreate = new tbluser();
      objTblUserCreate.create  (userSSN, FirstName, MiddleName,LastName,DOB, Gennder, email,  phoneNumber,  password);

    
 }
    protected void doPut(HttpServletRequest req,  HttpServletResponse resp)throws ServletException, IOException{

      BufferedReader reader = req.getReader();

      PrinterWriter writer = resp.getWriter();
      String requestBody = reader.readLine();
      writer.write (" Please put in the ID  number of the User " + requestBody );
       if (requestBody.equals("UserID")){

      tbluser objTblUser = new tbluser();
      Long UserID = Long.parseLong(requestBody); 
      String userSSN = req.getParameter("SSN");
      String FirstName = req.getParameter("FirstName");
      String MiddleName = req.getParameter("MiddleName");
      String LastName = req.getParameter("LastName");
      String DOB = req.getParameter("dob");
      String Gennder = req.getParameter("gender");
      String email = req.getParameter("email");
      String phoneNumber = req.getParameter("phoneNumber");
      String password = req.getParameter("password");
      tbluser objTblUserUpdate = new tbluser();

      objTblUserUpdate.update( UserID,userSSN, FirstName, MiddleName, LastName, DOB,Gennder, email, phoneNumber, password);

    }
    
   }

    protected void doDelete(HttpServletRequest req,  HttpServletResponse resp)throws ServletException, IOException{
      BufferedReader reader = req.getReader();

      PrinterWriter writer = resp.getWriter();
      String requestBody = reader.readLine();
      writer.write (" Please put in the ID  number of the User " + requestBody );
       if (requestBody.equals("UserID")){

      tbluser objTblUserDelete = new tbluser();
      Long UserID = Long.parseLong(requestBody); 
      objTblUserDelete.delete (UserID);

}

    }

   }