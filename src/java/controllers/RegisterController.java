/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllers;

import dao.UserDAO;
import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author hungc
 */
public class RegisterController extends HttpServlet {
   
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("txtname");
        String email=request.getParameter("txtemail");
        String password=request.getParameter("txtpassword");
        UserDAO d=new UserDAO();
        User us=d.getUserByEmail(email);
        if(us==null){
              int result=d.insertNewUser(name, email, password);
              if(result==1){
                   out.print("<p>Da them user moi</p>");
                   out.print("<p><a href='index.jsp'>home</p>");
              }else{
                  out.print("<p>Not Insert</p>");
                  out.print("<p><a href='index.jsp'>home</p>");
              }
        }
        else{ 
             out.print("<p>duplicate email</p>");
             out.print("<p><a href='index.html'>home</p>");          
        }     
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
