/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class MainController extends HttpServlet {
   
   public void processRequest(HttpServletRequest request, HttpServletResponse response){
    String url=""; 
    try{
         String act=request.getParameter("action");
         if(act==null) act="home";
         switch(act){
             case "home":
                 url="index.jsp";
                 break;
             case "login":
                 url="LoginController";
                 break;
             case "logout":
                 url="LogoutController";
                 break;
             case "search":
                 url="SearchBookController";
                 break;
             case "delete":
                 url="DeleteController";
                 break;
             case "register":
                 url="RegisterController";
                 break;
             case "history":
                 url="BookRecordController";
                 break;
         }
     }finally{
         try {
             request.getRequestDispatcher(url).forward(request, response);
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
   }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request,response);
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
          processRequest(request,response);
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
