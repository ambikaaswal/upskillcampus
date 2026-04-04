<%@ page import="java.util.*, model.Service" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Services</title>

<style>
    body {
        margin: 0;
        font-family: 'Segoe UI', sans-serif;
        background-color: #f4f8fb;
    }

    h2 {
        text-align: center;
        color: #4a90a4;
        margin-top: 30px;
        font-weight: 500;
    }

    .container {
        width: 90%;
        max-width: 900px;
        margin: 20px auto;
    }

    .card {
        background-color: white;
        padding: 20px;
        margin: 15px 0;
        border-radius: 12px;
        box-shadow: 0 6px 15px rgba(0,0,0,0.06);
    }

    .card h3 {
        margin: 0;
        color: #4a90a4;
    }

    .card p {
        margin: 8px 0;
        color: #444;
        font-size: 14px;
    }

    .price {
        font-weight: bold;
        color: #033b4a;
    }

    button {
        padding: 10px 15px;
        border: none;
        border-radius: 8px;
        background-color: #a8d0e6;
        color: #033b4a;
        cursor: pointer;
        margin-top: 10px;
    }

    button:hover {
        background-color: #8fc3db;
    }

    .empty {
        text-align: center;
        color: #777;
        margin-top: 30px;
    }
</style>

</head>
<body>

<h2>Available Services</h2>

<%
    String success = request.getParameter("success");
    if ("1".equals(success)) {
%>
    <script>
        alert("Booking successful!");
    </script>
<%
    }
%>

<div class="container">

<%
    List<Service> services = (List<Service>) request.getAttribute("services");

    if (services != null && !services.isEmpty()) {
        for(Service s : services) {
%>

    <div class="card">
        <h3><%= s.getTitle() %></h3>
        <p><%= s.getDescription() %></p>
        <p class="price">₹<%= s.getPrice() %></p>

        <form action="/marketplace/bookService" method="post">
            <input type="hidden" name="serviceId" value="<%= s.getId() %>">
            <button type="submit">Book Service</button>
        </form>
    </div>

<%
        }
    } else {
%>
    <p class="empty">No services available</p>
<%
    }
%>

</div>

</body>
</html>
