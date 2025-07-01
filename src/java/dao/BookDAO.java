/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author hungc
 */
public class BookDAO {
    //ham nay de lay all books trong db dua vao title can tim
    public ArrayList<Book> getBooksByTitle(String findtitle) {
        ArrayList<Book> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select id,title,author,isbn,category,published_year,total_copies,available_copies,status,url\n"
                        + "from dbo.books\n"
                        + "where title like ?";
                PreparedStatement st=cn.prepareStatement(sql);
                st.setString(1, "%"+findtitle+"%");
                ResultSet table=st.executeQuery();
                if(table!=null){
                    while(table.next()){
                        int id=table.getInt("id");
                        String title=table.getString("title");
                        String author=table.getString("author");
                        String isbn=table.getString("isbn");
                        String category=table.getString("category");
                        int year=table.getInt("published_year");
                        int total=table.getInt("total_copies");
                        int avaibleCopy=table.getInt("available_copies");
                        String status=table.getString("status");
                        String url=table.getString("url");
                        Book b=new Book(id, title, author, isbn, category, year, total, avaibleCopy, status,url);
                        result.add(b);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public Book getBook(int id){
        Book b=null;
        Connection cn=null;
        try {
            cn=DBUtils.getConnection();
            if(cn!=null){
               String sql = "SELECT [id]\n"
                    + "      ,[title]\n"
                    + "      ,[author]\n"
                    + "      ,[isbn]\n"
                    + "      ,[category]\n"
                    + "      ,[published_year]\n"
                    + "      ,[total_copies]\n"
                    + "      ,[available_copies]\n"
                    + "      ,[status]\n"
                    + "      ,[url]\n"
                    + "  FROM [dbo].[books]\n"
                    + "  WHERE ID=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet table=st.executeQuery();
            if(table!=null && table.next()){
                String title = table.getString("title");
                String author = table.getString("author");
                String isbn = table.getString("isbn");
                String category = table.getString("category");
                int year = table.getInt("published_year");
                int total = table.getInt("total_copies");
                int avaibleCopy = table.getInt("available_copies");
                String status = table.getString("status");
                String url = table.getString("url");
                b=new Book(id, title, author, isbn, category, year, total, avaibleCopy, status, url);
            }
          }
        } catch (Exception e) {
            
        }finally{
            
        }
        
        return b;
    }
}
