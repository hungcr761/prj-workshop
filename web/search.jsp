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
                <div class="m_book"><a href="MainController?action=record">My Books</a></div>
                <div class="search-bar">
                    <form action="MainController" method="GET">
                        <select class="dropbox" name="filter">
                            <-<!-- ?=true :=false -->
                            <option value="all" ${filter == 'all' ? 'selected' : ''}>All</option>
                            <option value="title" ${filter == 'title' ? 'selected' : ''}>Title</option>
                            <option value="author" ${filter == 'author' ? 'selected' : ''}>Author</option>
                            <option value="category" ${filter == 'category' ? 'selected' : ''}>Category</option>
                        </select>
                        <input type="text" name="search" placeholder="Search" value="${search}" required>
                        <button type="submit" name="action" value="search">🔍</button>
                    </form>
                </div>
                <c:if test="${empty sessionScope.loggedUser}">
                    <div class="log_reg"><a href="login.jsp">Login</a> / <a href="register.jsp">Register</a></div>
                </c:if>
                <c:if test="${not empty sessionScope.loggedUser}">
                    <div class="dropdown">
                        <button class="dropdown-btn" style="font-weight: bold">👤 ${sessionScope.loggedUser.name}</button>
                        <div class="dropdown-content">
                            <a href="profile.jsp">View Profile</a>
                            <a href="MainController?action=record">Book Record</a>
                            <a href="MainController?action=logout">Logout</a>
                        </div>
                    </div>
                </c:if>
            </nav>
        </header>

        <main style="height: 100%; flex: 1;">
            <section class="container">
                <c:if test="${not empty msg}">
                    <h2 style="padding: 20px 0px">Book not found</h2>
                </c:if>
                <c:if test="${empty msg}">
                    <h2 style="padding: 20px 0px">Search books</h2>
                    <div class="books-grid"">
                        <c:forEach var="book" items="${result}">
                            <div class="book-card">
                                <div>
                                    <div class="book-meta">
                                        <h3 title="${book.title}">${book.title}</h3>
                                        <strong>Author:</strong>${book.author}<br>
                                        <strong>Category:</strong>${book.category}<br>
                                        <strong>Year:</strong> ${book.published_year}
                                    </div>
                                    <c:if test="${not empty sessionScope.loggedUser}">
                                        <p style="margin-top: 10px;">Copies Available: ${book.available_copies}</p>
                                        <button onclick="" class="borrow-btn">Borrow Book</button>
                                    </c:if>
                                </div>
                                <img src="${book.url}" alt="book cover">
                            </div>
                        </c:forEach>
                    </div>
                </c:if>
            </section>
        </main>

        <footer>
            <div class="container">
                <p>&copy; 2025 Online Library. All rights reserved.</p>
            </div>
        </footer>
    </body>
</html>
