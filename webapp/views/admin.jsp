<%@ page import="model.User" %>

<%
    User user = (User) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("/marketplace/views/login.html");
        return;
    }

    if (!"admin".equals(user.getRole())) {
        response.sendRedirect("/marketplace/views/dashboard.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>

    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background-color: #f4f8fb;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: white;
            padding: 40px 50px;
            border-radius: 12px;
            width: 360px;
            text-align: center;
            box-shadow: 0 8px 20px rgba(0,0,0,0.08);
        }

        h1 {
            color: #4a90a4;
            font-weight: 500;
            margin-bottom: 20px;
        }

        p {
            color: #666;
            font-size: 14px;
            margin-bottom: 25px;
        }

        .btn {
            display: block;
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border-radius: 8px;
            background-color: #a8d0e6;
            color: #033b4a;
            text-decoration: none;
            font-size: 15px;
        }

        .btn:hover {
            background-color: #8fc3db;
        }

        .logout {
            margin-top: 10px;
            font-size: 13px;
            color: #4a90a4;
            text-decoration: none;
        }
    </style>
</head>

<body>

<div class="container">
    <h1>Admin Dashboard</h1>

    <p>Manage platform overview and monitor services.</p>

    <a href="/marketplace/viewServices" class="btn">View All Services</a>

    <a href="/marketplace/logout" class="logout">Logout</a>
</div>

</body>
</html>