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
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author hungc
 */
public class LoginController extends HttpServlet {
   
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       String email=request.getParameter("txtemail");
       String password=request.getParameter("txtpassword");
       if(email!=null && password!=null){
           //lay thong tin user dua vao email, password trong db
           UserDAO d=new UserDAO();
           User us=d.getUser(email, password);
           if(us==null || !us.getStatus().equalsIgnoreCase("active")){
               request.setAttribute("ERROR", "email or password is invalid");
               request.getRequestDispatcher("Login.jsp").forward(request, response);
           }else{
               //de lam chuc nang welcom ....: coming soon
               //luu us vao session de su dung no cho cac tinh nang: welcome, send request borrow, change profile
               HttpSession s=request.getSession();
               s.setAttribute("loginedUser", us);               
               
               if(us.getRole().equalsIgnoreCase("admin")){
                   response.sendRedirect("AdminDashboard.jsp");
               }else{
                    response.sendRedirect("UserDashboard.jsp");
               }
           }
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
