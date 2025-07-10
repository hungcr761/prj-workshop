<%-- 
    Document   : register
    Created on : Jun 20, 2025, 7:52:42 PM
    Author     : hungc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login - Online Library</title>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                font-family: Arial, sans-serif;
                background: #ecf0f1;
                overflow-y: hidden;
            }

            .container {
                max-width: 400px;
                margin: 100px auto;
                padding: 20px;
                background: white;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .logo a {
                display: flex;
                margin: 30px;
                font-size: 1.5rem;
                font-weight: bold;
                text-decoration: none;
                color: black
            }

            h2 {
                text-align: center;
                margin-bottom: 20px;
                color: #2c3e50;
            }

            .form-group {
                margin-bottom: 15px;
            }

            label {
                display: block;
                margin-bottom: 5px;
                color: #333;
            }

            input[type="text"],
            input[type="password"] {
                width: 100%;
                padding: 10px;
                border: 1px solid #ddd;
                border-radius: 5px;
            }

            button {
                width: 100%;
                padding: 12px;
                background: #3498db;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px;
            }

            button:hover {
                background: #2980b9;
            }

            .error {
                color: #e74c3c;
                text-align: center;
                margin-bottom: 15px;
            }

            .links {
                text-align: center;
                margin-top: 20px;
            }

            .links a {
                color: #3498db;
                text-decoration: none;
            }
        </style>
    </head>

    <body>
        <header>
            <div class="logo">
                <a href="index.jsp">📚 Online Library </a>
            </div>
        </header>
        <div class="container">
            <h2>📚 Register</h2>
            <form method="POST" action="MainController">
<!--                <input type="hidden" name="action" value="register">-->
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" name="username" value="${username}">
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" name="email" value="${email}" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" name="password" required>
                </div>
                <div class="form-group">
                    <label for="cpassword">Confirm password:</label>
                    <input type="password" name="cpassword" required>
                </div>
                <c:if test="${not empty error}">
                    <p style="color: red">${error}</p> 
                </c:if>
                <button type="submit" name="action" value="register">Register</button>
            </form>
            <div class="links">
                <p>Already have an account?<a href="login.jsp"> Log in</a><br></p>
                <a href="index.jsp">← Back to Home</a>
            </div>
        </div>
    </body>

</html>