<%-- 
    Document   : search
    Created on : Jul 7, 2025, 3:06:27 PM
    Author     : hungc
--%>

<%@page import="dto.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page  import="dto.User" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Library - Home</title>
        <link rel="stylesheet" href="index.css">
    </head>

    <body>
        <header>
            <nav class="container-header">
                <div class="logo">
                    <a href="MainController">📚 Online Library </a>
                </div>
                <div class="m_book"><a href="borrow_history.jsp">My Books</a></div>
                <div class="search-bar">
                    <form action="MainController" method="GET">
                        <select class="dropbox" name="filter">
                            <option value="all" >All</option>
                            <option value="title" >Title</option>
                            <option value="author" >Author</option>
                            <option value="category" >Category</option>>
                        </select>
                        <input type="text" name="search" placeholder="Search" required>
                        <button type="submit" name="action" value="search">🔍</button>
                    </form>
                </div>
                <c:if test="${empty sessionScope.loggedUser}">
                    <div class="log_reg"><a href="login.jsp">Login</a> / <a href="register.jsp">Register</a></div>
                </c:if>
                <c:if test="${not empty sessionScope.loggedUser}">
                    <div class="dropdown">
                        <button class="dropdown-btn">User 🔽</button>
                        <div class="dropdown-content">
                            <a href="profile.jsp">View Profile</a>
                            <a href="LogoutController">Logout</a>
                        </div>
                    </div>
                </c:if>
            </nav>
        </header>

        <main>
            <section class="hero welcome">
                <div class="container">
                    <h1>Welcome to Our Online Library</h1>
                    <p>Discover thousands of books at your fingertips</p>
                </div>
            </section>

            <section class="container">
                <h2 style="padding-top: 10px">📖 Recommended</h2>
                <div class="books-grid">
                    <div class="book-card">
                        <div>
                            <div class="book-meta">
                                <h3>title</h3>
                                <strong>Author:</strong><br>
                                <strong>Category:</strong> <br>
                                <strong>Year:</strong>
                            </div>
                            <p style="margin-top: 10px;">...</p>
                            <a href="book_detail.jsp?id=" style="display: inline-block; margin-top: 10px; color: #3498db;">View Details</a>
                        </div>
                        <img src="image/GoT.jpg" alt="book cover">
                    </div>
                </div>
            </section>
        </main>

        <footer>
            <div class="container">
                <p>&copy; 2025 Online Library. All rights reserved.</p>
            </div>
        </footer>
    </body>
</html>
