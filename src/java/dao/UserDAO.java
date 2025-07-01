/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import mylib.DBUtils;

/**
 *
 * @author hungc
 */
public class UserDAO {
//ham nay de check email la duy nhat trong bang User
//tra ve :record(dong/User) trung email
public User getUserByEmail(String email){
   User result=null;
   //buoc 1: ket noi
   Connection cn=null;
   try{
       cn=DBUtils.getConnection();
       if(cn!=null){
          //b2: viet query va execute
           String sql = "select id,name,email,password,role,status\n"
                   + "from dbo.users\n"
                   + "where email='"+ email +"'";
           Statement st=cn.createStatement();
           ResultSet table= st.executeQuery(sql);
          //bc3:lay data trong bien table
           if(table!=null && table.next()){
              int id=table.getInt("id");
              String name=table.getString("name");
              //String email=table.getString("email");
              String password=table.getString("password");
              String role=table.getString("role");
              String status=table.getString("status");
              result=new User(id, name, email, password, role, status);
           }
       }
   }catch(Exception e){
       e.printStackTrace();
   }
   finally{
       try {
           if(cn!=null) cn.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   return result;
}
//ham nay de insert 1 dong moi vao bang User
//tra ve: 1/0
public int insertNewUser(String name,String email,String password){
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
               String sql="insert dbo.users values(?,?,?,'user','active')";
                PreparedStatement st=cn.prepareStatement(sql);
                st.setString(1, name); //1 la vitri dau ? dau tien
                st.setString(2, email);
                st.setString(3, password);
                result=st.executeUpdate();
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

    //ham nay de lay thong tin user dua vao email va password
 public User getUser(String email, String password) {
        User result = null;
        //buoc 1: ket noi
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                //b2: viet query va execute
                String sql = "select id,name,email,password,role,status\n"
                        + "from dbo.users\n"
                        + "where email=? and password=?  COLLATE Latin1_General_CS_AS";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, email);
                st.setString(2, password);

                ResultSet table = st.executeQuery();
                //bc3:lay data trong bien table
                if (table != null && table.next()) {
                    int id = table.getInt("id");
                    String name = table.getString("name");
                    //String email=table.getString("email");
                    //String password = table.getString("password");
                    String role = table.getString("role");
                    String status = table.getString("status");
                    result = new User(id, name, email, password, role, status);
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

 //ham nay de sua thong tin user
 //input: name, password , id
 //output: 1/0
    public int updateUser(int id, String name, String password) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update dbo.users\n"
                        + "set name=? , password=?\n"
                        + "where id=?";
                PreparedStatement st=cn.prepareStatement(sql);
                st.setString(1, name);
                st.setString(2, password);
                st.setInt(3, id);
                result=st.executeUpdate();
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


}
