<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forgot Password</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/forgot-password" method="post">
        <input type="email" name="email" placeholder="Email" required>
        <button type="submit">Reset Password</button>
    </form>
</body>
</html>