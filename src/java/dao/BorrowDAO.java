/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.BorrowRecord;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author hungc
 */
public class BorrowDAO {

    public ArrayList<BorrowRecord> getBookRecord(int uID) { //for register
        ArrayList<BorrowRecord> list=new ArrayList<>();
        //buoc 1: ket noi
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                //b2: viet query va execute
                String sql = "SELECT bR.book_id, br.borrow_date, br.due_date, br.return_date, br.status \n"
                   + "FROM borrow_records br JOIN books b ON bh.book_id = b.id \n"
                   + "WHERE bh.user_id = ? \n"
                   + "ORDER BY br.borrow_date DESC";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, uID);
                ResultSet table = pst.executeQuery();
                //bc3:lay data trong bien table
                if (table != null && table.next()) {
                    int bID=table.getInt("book_id");
                    Date bDate=table.getDate("borrow_date");
                    Date dDate=table.getDate("due_date");
                    Date rDate=table.getDate("return_date");
                    String status=table.getString("status");
                    BorrowRecord br=new BorrowRecord(uID,bID,bDate,dDate,rDate,status);
                    list.add(br);
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
        return list;
    }
}
