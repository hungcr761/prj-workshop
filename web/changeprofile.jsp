<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Change Profile</title>
</head>
<body>
    <h2>Change Profile</h2>
    <form action="ChangeProfileServlet" method="post">
        Name: <input type="text" name="name" required><br>
        Email: <input type="email" name="email" required><br>
        <input type="submit" value="Update Profile">
    </form>
</body>
</html>

