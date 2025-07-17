/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.sql.Date;

/**
 *
 * @author hungc
 */
public class BorrowRecord {

    private int uID;
    private int bID;
    private Date borrowDate;
    private Date dueDate;
    private Date returnDate;
    private String status;
    private String title;
    private String author;
    private String url;

    public BorrowRecord(int uID, int bID, Date borrowDate, Date dueDate, Date returnDate, String status, String title, String author, String url) {
        this.uID = uID;
        this.bID = bID;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
        this.title = title;
        this.author = author;
        this.url=url;
    }

    public BorrowRecord() {
        uID = 0;
        bID = 0;
        borrowDate = null;
        dueDate = null;
        returnDate = null;
        status = "";
        title = "";
        author = "";
        url="";
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getuID() {
        return uID;
    }

    public int getbID() {
        return bID;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public void setbID(int bID) {
        this.bID = bID;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
