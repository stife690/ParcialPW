<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>
	<html lang="es">

	<head>
		<meta charset="UTF-8">
		<title>Pagina principal</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
			integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
		
	</head>

	<body>

		<div class="container grid gap-3">
			<h2>Bienvenido, ${usuario.username}!</h2>
			<p>Tu rol es: <c:choose><c:when test="${usuario.roles[0].rol_nombre == 'ROLE_RECTOR'}">Rector</c:when><c:otherwise>Docente</c:otherwise></c:choose></p>
			<div>
				<a type="button" class="btn btn-primary" href="/logout">Cerrar sesión</a>
            </div>
		</div>
		
			<div class="container mt-3">
		<c:if test="${usuario.roles[0].rol_nombre == 'ROLE_RECTOR'}">
			<div>
				<a type="button" class="btn btn-primary" href="/nueva">Adicionar clase</a>
			</div>
		</c:if>
		<br>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3>Lista de clases</h3>
			</div>
			<div class="panel-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nombre de la Asignatura</th>
							<th>Descripcion</th>
							<th>Hora de Inicio</th>
							<th>Hora de Finalizacion</th>
							<ht>Salon</ht>
							<th>Estado</th>
							<c:if test="${usuario.roles[0].rol_nombre == 'ROLE_RECTOR'}">
								<th>Acciones</th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clases}" var="clase">
							<tr>
								<td>${clase.id}</td>
								<td>${clase.nombreAsignatura}</td>
								<td>${clase.descripcion}</td>
								<td>${clase.horaInicio}</td>
								<td>${clase.horaFinalizacion}</td>
								<td>${clase.salon}</td>
								<td>${clase.estado.estado}</td>
								<td>
									<c:if test="${usuario.roles[0].rol_nombre == 'ROLE_RECTOR'}">
										<div style="display: inline-block;">
											<a type="button" class="btn btn-success"
												href="/actualizar?id=${clase.id}">Actualizar</a>
										</div>
										<div style="display: inline-block;">
											<form action="/eliminar" method="post">
												<input type="hidden" name="id" value="${clase.id}" />
												<button type="submit" class="btn btn-warning">Eliminar</button>
											</form>
										</div>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
			crossorigin="anonymous"></script>
	</body>

	</html>