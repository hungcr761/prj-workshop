/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllers;

import dao.BookDAO;
import dto.Book;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author hungc
 */
public class SearchBookController extends HttpServlet {
   
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String search=request.getParameter("search");
        String filter=request.getParameter("filter");
        PrintWriter out=response.getWriter();
        response.setCharacterEncoding("utf-8");
        if(search!=null && !search.isEmpty()){
            BookDAO d=new BookDAO();
            ArrayList<Book> result=d.getBooksByFilter(search, filter);
            if(result.isEmpty()){
                //cach 1 de giu title va xuat no ra trang index.jsp
                //request.setAttribute("FINDTITLE",title);
                request.setAttribute("msg","Book not found");
                //request.getRequestDispatcher("index.jsp?txtsearch="+title);
                request.getRequestDispatcher("search.jsp").forward(request, response);
            }
            else{
               request.setAttribute("RESULT",result);
               request.getRequestDispatcher("search.jsp").forward(request, response);
            }
        }else{
           request.setAttribute("MSG","no data");
           request.getRequestDispatcher("index.jsp");
        }
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
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
