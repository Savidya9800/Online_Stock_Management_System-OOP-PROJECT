<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>

<style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #bfdfed;
}

.login-container {
    width: 400px;
    margin: 100px auto;
    background-color: #f0f8ff; /* Light blue background */
    padding: 60px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.login-container h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #007bff; /* Light blue text color */
}

.input-group {
    margin-bottom: 15px;
}

.input-group label {
    display: block;
    margin-bottom: 5px;
    color: #333; /* Dark text color */
}

.input-group input {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

.forgot-password {
    text-align: right;
    margin-bottom: 10px;
}

.forgot-password a {
    color: #007bff; /* Light blue link color */
    text-decoration: none;
}

.forgot-password a:hover {
    text-decoration: underline;
}

button {
    width: 100%;
    padding: 10px;
    background-color: #007bff; /* Light blue button background */
    border: none;
    color: #fff; /* White button text color */
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

button:hover {
    background-color: #0056b3; /* Darker blue on hover */
}
</style>
<body>
	<div class="login-container">

	<form action="<%=request.getContextPath()%>/LoginServlet" method="POST">
		<div class="input-group">
			<label for="username">Username</label> <input type="text"
				id="username" name="username" required>
		</div>
		<div class="input-group">
			<label for="password">Password</label> <input type="password"
				id="password" name="password" required>
		</div>
		<div class="forgot-password">
			<a href="forgot_password.html">Forgot Password?</a>
		</div>
		<button type="submit" name="submit">Login</button>
	</form>

</div>
</body>


</html>