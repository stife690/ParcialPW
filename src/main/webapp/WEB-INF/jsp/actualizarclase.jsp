<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <!DOCTYPE html>
    <html>

    <head>
        <title>Actualizar Clase</title>
    </head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <body>
            <h1>Actualizar Clase</h1>
            <form:form method="post" modelAttribute="clase" accept-charset="UTF-8">
                <form:hidden path="id" />
                <table>
                    <tr>
                        <td>
                            <form:label path="nombre">Nombre Asignatura</form:label>
                        </td>
                        <td>
                            <form:input path="nombre" type="text" class="form-control" required="required" />
                        </td>
                        <td>
                            <form:errors path="nombre" cssClass="text-warning" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="descripcion">Descripcion</form:label>
                        </td>
                        <td>
                            <form:input path="descripcion" type="number" class="form-control" required="required" />
                        </td>
                        <td>
                            <form:errors path="descripcion" cssClass="text-warning" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="HoraI">Hora de Inicio</form:label>
                        </td>
                        <td>
                            <form:input path="HoraI" type="text" class="form-control" required="required" />
                        </td>
                        <td>
                            <form:errors path="HoraI" cssClass="text-warning" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="HoraF">Hora de Finalizacion</form:label>
                        </td>
                        <td>
                            <form:input path="HoraF" type="text" class="form-control" required="required" />
                        </td>
                        <td>
                            <form:errors path="HoraF" cssClass="text-warning" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="salon">Salón</form:label>
                        </td>
                        <td>
                            <form:input path="salon" type="text" class="form-control" required="required" />
                        </td>
                        <td>
                            <form:errors path="salon" cssClass="text-warning" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="estado">estado</form:label>
                        </td>
                        <td>
                            <form:select path="estado" class="form-control" required="required">
                                <form:options items="${estadoClases}" itemValue="id" itemLabel="estado" />
                            </form:select>
                        </td>
                        <td>
                            <form:errors path="estado" cssClass="text-warning" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <input type="submit" value="Actualizar Clase" />
                        </td>
                    </tr>
                </table>
            </form:form>
            <a href="/home" type="button" class="mt-3">Regresar</a>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>