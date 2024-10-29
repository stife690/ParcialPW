<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <!DOCTYPE html>
    <html>

    <head>
        <title>Nueva Clase</title>
    </head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <body>
            <h1>Nueva Clase</h1>
            <c:if test="${not empty successMessage}">
                <div>
                    ${successMessage}
                </div>
            </c:if>
            <form:form action="/guardar" method="post" modelAttribute="claseDTO" accept-charset="UTF-8">
                <table>
                    <tr>
                        <td>NombreAsignatura:</td>
                        <td>
                            <form:input path="nombre" class="form-control" />
                        </td>
                    </tr>
                    
                    
                    <tr>
                        <td>Horario Inicio:</td>
                        <td>
                            <form:input type="number" path="horario" class="form-control" />
                        </td>
                    </tr>
                    
                     
                    <tr>
                        <td>Hora de Finalización:</td>
                        <td>
                            <form:input type="number" path="horario" class="form-control" />
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Descripcion</td>
                        <td>
                            <form:input type="String" path="horario" class="form-control" />
                        </td>
                    </tr>
                    
                    <tr>
                   
                        <td>Salón:</td>
                        <td>
                            <form:input path="salon" class="form-control"/>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Estado de la clase:</td>
                        <td>
                            <form:select path="estado" class="form-control">
                                <form:options items="${estadoClases}" itemValue="estado" itemLabel="estado" class="form-control" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Guardar" />
                        </td>
                    </tr>
                </table>
            </form:form>
            <a href="/home" type="button" class="mt-3">Regresar</a>
    </body>

    </html>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>