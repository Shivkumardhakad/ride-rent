<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register - RideRent</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-header bg-primary text-white text-center">
                    <h3>Create Account</h3>
                </div>
                <div class="card-body">
                
                    <% 
                        String msg = (String)request.getAttribute("msg");
                        if(msg != null) {
                    %>
                        <div class="alert alert-danger text-center"><%= msg %></div>
                    <% } %>

                    <form action="RegisterServlet" method="post">
                        <div class="mb-3">
                            <label>Full Name</label>
                            <input type="text" name="name" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label>Email Address</label>
                            <input type="email" name="email" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label>Phone Number</label>
                            <input type="text" name="phone" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label>Password</label>
                            <input type="password" name="password" class="form-control" required>
                        </div>
                        
                        <div class="text-center">
                            <button type="submit" class="btn btn-success w-100">Register Now</button>
                        </div>
                    </form>
                    
                    <div class="text-center mt-3">
                        <a href="login.jsp">Already have an account? Login here</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>