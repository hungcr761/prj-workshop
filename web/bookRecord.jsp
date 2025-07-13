<%-- 
    Document   : myBooks
    Created on : Jul 11, 2025, 4:00:06 PM
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
                            <-<!-- ?=true :=false -->
                            <option value="all">All</option>
                            <option value="title">Title</option>
                            <option value="author">Author</option>
                            <option value="category">Category</option>
                        </select>
                        <input type="text" name="search" placeholder="Search" required>
                        <button type="submit" name="action" value="search">🔍</button>
                    </form>
                </div>
                <div class="dropdown">
                    <button class="dropdown-btn" style="font-weight: bold">👤 ${sessionScope.loggedUser.name}</button>
                    <div class="dropdown-content">
                        <a href="profile.jsp">View Profile</a>
                        <a href="myBooks.jsp">Book History</a>
                        <a href="LogoutController">Logout</a>
                    </div>
                </div>
            </nav>
        </header>

        <main style="height: 100%; flex: 1;">
            <section class="container">
                <c:if test="${not empty msg}">
                    <h2 style="padding: 20px 0px">You haven't borrow any book!</h2>
                </c:if>
                <c:if test="${empty msg}">
                    <h2 style="padding: 20px 0px">Books borrowed </h2>
                    <div class="books-grid" style="grid-template-columns: repeat(1, 1fr);">
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

