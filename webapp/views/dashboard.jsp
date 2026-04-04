<%@ page import="model.User" %>

<%
    User user = (User) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("/marketplace/views/login.html");
        return;
    }
%>

<h2>Welcome, <%= user.getName() %>!</h2>
<a href="/marketplace/viewServices">View Services</a>
<a href="/marketplace/logout">Logout</a>