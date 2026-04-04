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

<h1>Merchant Dashboard</h1>
<form action="/marketplace/addService" method="post">
    Title: <input type="text" name="title"><br>
    Description: <input type="text" name="description"><br>
    Price: <input type="number" name="price"><br>
    <button type="submit">Add Service</button>
</form>
<a href="/marketplace/logout">Logout</a>