<%@ page import="model.User" %>

<%
    User user = (User) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("/marketplace/views/login.html");
        return;
    }

    if (!"merchant".equals(user.getRole())) {
        response.sendRedirect("/marketplace/views/dashboard.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Merchant Dashboard</title>

    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background-color: #f4f8fb;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            background-color: white;
            padding: 40px;
            border-radius: 12px;
            width: 360px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.08);
            text-align: center;
        }

        h1 {
            color: #4a90a4;
            font-weight: 500;
            margin-bottom: 25px;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #dbe7ef;
            border-radius: 8px;
            font-size: 14px;
        }

        button {
            width: 100%;
            padding: 12px;
            margin-top: 12px;
            border: none;
            border-radius: 8px;
            background-color: #a8d0e6;
            color: #033b4a;
            font-size: 15px;
            cursor: pointer;
        }

        button:hover {
            background-color: #8fc3db;
        }

        .logout {
            margin-top: 15px;
            display: block;
            font-size: 13px;
            color: #4a90a4;
            text-decoration: none;
        }
    </style>
</head>

<body>

<div class="container">
    <h1>Merchant Dashboard</h1>

    <form action="/marketplace/addService" method="post">
        <input type="text" name="title" placeholder="Service Title" required>
        <input type="text" name="description" placeholder="Description" required>
        <input type="number" name="price" placeholder="Price" required>

        <button type="submit">Add Service</button>
    </form>

    <a href="/marketplace/logout" class="logout">Logout</a>
</div>

</body>
</html>
