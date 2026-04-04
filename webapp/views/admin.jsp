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

<h1>Admin Dashboard</h1>
<a href="/marketplace/logout">Logout</a>