<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }
        .form-register {
            max-width: 330px;
            padding: 15px;
            margin: auto;
        }
        .form-register .form-control {
            position: relative;
            height: auto;
            padding: 10px;
            font-size: 16px;
        }
        .form-register .form-control:focus {
            z-index: 2;
        }
        .form-register input[type="text"],
        .form-register input[type="email"],
        .form-register input[type="password"],
        .form-register select {
            margin-bottom: 10px;
        }
    </style>
</head>
<body class="text-center">
    <form class="form-register" action="RegisterServlet" method="post">
        <img class="mb-4" src="images/logo.jpg" alt="" width="72" height="72"> <!-- Your logo here -->
        <h1 class="h3 mb-3 font-weight-normal">Create your account</h1>
        <input type="text" id="inputName" class="form-control" placeholder="Full Name" name="name" required autofocus>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="email" required>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
        <select class="form-control" id="inputUserType" name="userType" required>
            <option value="consumer">Consumer</option>
            <option value="retailer">Retailer</option>
            <option value="charitable_organization">Charitable Organization</option>
        </select>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2024</p>
    </form>
</body>
</html>
