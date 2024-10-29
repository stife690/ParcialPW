<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html lang="es">

		<head>
			<meta charset="UTF-8">
			<title>Signup</title>
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
				crossorigin="anonymous">
		</head>

		<body>
			<div class="container">
				<h2>Registrarse</h2>
				<form action="/signup" method="post">
					<c:if test="${not empty errorMessage}">
						<div class="alert alert-danger">${errorMessage}</div>
					</c:if>
					<div class="form-group">
						<label for="username">Nombre de usuario:</label> <input type="text" id="username"
							name="username" required>
					</div>
					<div class="form-group">
						<label for="password">Contraseña:</label> <input type="password" id="password" name="password"
							required>
					</div>
					<input type="submit" class="btn btn-primary" value="Register">
					<hr>
					<c:if test="${not empty successMessage}">
						<div class="alert alert-success">${successMessage}</div>
					</c:if>
				</form>
				<div class="form-group">
					<span><a href="/login">Iniciar sesión</a></span>
				</div>
			</div>

			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
				crossorigin="anonymous"></script>
		</body>