<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <input type="text" name="username" placeholder="Username" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="text" name="phoneNumber" placeholder="Phone Number" required>
        <input type="text" name="address" placeholder="Address" required>
        <input type="text" name="pinCode" placeholder="Pin Code" required>
        <input type="text" name="city" placeholder="City" required>
        <input type="text" name="country" placeholder="Country" required>
        <button type="submit">Register</button>
    </form>
</body>
</html>