package controllers;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ChangeProfileServlet", urlPatterns = {"/ChangeProfileServlet"})
public class ChangeProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/yourdbname", "username", "password");

            PreparedStatement ps = con.prepareStatement(
                "UPDATE users SET name=?, email=? WHERE id=?");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, 1); // replace with session userId

            ps.executeUpdate();
            con.close();

            response.sendRedirect("profile.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
