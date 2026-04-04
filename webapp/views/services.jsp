<%@ page import="java.util.*, model.Service" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<meta charset="UTF-8">
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
<%
    List<Service> services = (List<Service>) request.getAttribute("services");

    if (services != null && !services.isEmpty()) {
        for(Service s : services) {
%>
    <div style="border:1px solid black; padding:10px; margin:10px;">
        <h3><%= s.getTitle() %></h3>
        <p><%= s.getDescription() %></p>
        <p>Price: ₹<%= s.getPrice() %></p>
        <p>User ID: <%= s.getUserId() %></p>

        <!-- ✅ form inside div -->
        <form action="/marketplace/bookService" method="post">
            <input type="hidden" name="serviceId" value="<%= s.getId() %>">
            <button type="submit">Book Service</button>
        </form>
    </div>
<%
        }
    } else {
%>
    <p>No services available</p>
<%
    }
%>

</body>
</html>