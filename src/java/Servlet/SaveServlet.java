/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import dao.EmpDao;
import emp.Emp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CAVAD
 */
@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        int password=Integer.parseInt(request.getParameter("password"));  
        String email=request.getParameter("email");  
        String country=request.getParameter("usur");  
          
        Emp e=new Emp();  
        e.setUname(name);  
        e.setUpass(password);  
        e.setUemail(email);  
        e.setUsur(country);  
          
        int status=EmpDao.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
