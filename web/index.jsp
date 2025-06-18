<%-- 
    Document   : index
    Created on : Jun 13, 2025, 7:01:07 PM
    Author     : h761
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Library - Home</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                font-family: Arial, sans-serif;
                line-height: 1.6;
            }

            .container {
                max-width: 1200px;
                margin: 0 auto;
                padding: 0 20px;
            }

            .container-header {
                max-width: 1200px;
                margin: 0 auto;
                padding: 0 20px;
                display: flex;
                justify-content: space-between;
            }

            .container-header a {
                text-decoration: none;
                color: white;
            }

            header {
                background: #2c3e50;
                color: white;
                padding: 1rem 0;
            }

            nav {
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            .logo a {
                font-size: 1.5rem;
                font-weight: bold;
                text-decoration: none;
                color: white
            }

            .nav-links {
                display: flex;
                list-style: none;
                gap: 20px;
            }

            .hero {
                background: #ecf0f1;
                padding: 3rem 0;
                text-align: center;
            }

            .hero h1 {
                font-size: 2.5rem;
                margin-bottom: 1rem;
                color: #2c3e50;
            }

            .search-bar {
                display: flex;
                background-color: white;
                border: 1px solid #ccc;
                border-radius: 4px;
                height: 40px;
                overflow: hidden;
                position: relative;
            }

            .dropbox {
                flex: 0 0 auto;
                border: none;
                padding-left: 5px;
                height: 100%;
                min-width: 70px;
                background-color: white;
                font-size: 14px;
                border-right: 1px solid #ccc;
                cursor: pointer;
            }

            .search-bar input {
                padding: 10px 0 0 0;
                border: none;
                outline: none;
                background-color: white;
                font-size: 14px;
                max-width: 75%;
            }

            .search-bar button {
                position: absolute;
                right: 8px;
                top: 50%;
                transform: translateY(-50%);
                background: none;
                border: none;
                cursor: pointer;
                font-size: 20px;
            }



            .books-grid {
                display: grid;
                grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
                gap: 20px;
                margin: 2rem 0;
            }

            .book-card {
                border: 1px solid #ddd;
                padding: 20px;
                background: white;
                border-radius: 5px;
            }

            .book-card h3 {
                color: #2c3e50;
                margin-bottom: 10px;
            }

            .book-meta {
                color: #666;
                font-size: 0.9rem;
                margin-bottom: 10px;
            }

            .book-status {
                padding: 3px 8px;
                border-radius: 3px;
                font-size: 0.8rem;
            }

            .available {
                background: #d4edda;
                color: #155724;
            }

            .unavailable {
                background: #f8d7da;
                color: #721c24;
            }

            .new-badge {
                background: #28a745;
                color: white;
                padding: 2px 6px;
                border-radius: 3px;
                font-size: 0.7rem;
            }

            footer {
                background: #2c3e50;
                color: white;
                text-align: center;
                padding: 2rem 0;
                margin-top: 3rem;
            }
        </style>
    </head>

    <body>
        <header>
            <nav class="container-header">
                <div class="logo">
                    <a href="index.jsp">📚 Online Library </a>
                </div>
                <div style="margin-left: 30%;"><a href="borrow_history.jsp">My Books</a></div>
                <div class="search-bar">
                    <select class="dropbox">
                        <option value="all">All</option>
                        <option value="title">Title</option>
                        <option value="author">Author</option>
                        <option value="category">Category</option>>
                    </select>
                    <form action="">
                        <input type="text" name="search" placeholder="Search" required>
                        <button type="submit">🔍</button>
                    </form>
                </div>
                <div><a href="login.jsp">Login</a> / <a href="register.jsp">Register</a></div>
            </nav>
        </header>

        <main>
            <section class="hero">
                <div class="container">
                    <h1>Welcome to Our Digital Library</h1>
                    <p>Discover thousands of books at your fingertips</p>
                </div>
            </section>

            <section class="container">
                <h2>📖 New Arrivals</h2>
                <div class="books-grid">
                    <div class="book-card">
                        <h3>title</h3>
                        <div class="book-meta">
                            <strong>Author:</strong><br>
                            <strong>Category:</strong> <br>
                            <strong>Year:</strong>
                        </div>
                        <div>
                            <span class="new-badge">NEW</span>
                            <span class="book-status ">

                            </span>
                        </div>
                        <p style="margin-top: 10px;">...</p>
                        <a href="book_detail.jsp?id=" style="display: inline-block; margin-top: 10px; color: #3498db;">View Details</a>
                    </div>
                </div>
            </section>
        </main>

        <footer>
            <div class="container">
                <p>&copy; 2024 Online Library. All rights reserved.</p>
            </div>
        </footer>
    </body>
</html>