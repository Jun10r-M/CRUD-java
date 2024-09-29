
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.PersonaDAO"%>
<%@page import="modelo.Persona"%>

<!DOCTYPE html>
<html>
    <head>
        <title>DESARROLLO ADAPTATIVO</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="container">
            <div class="editarPersona"></div>
            <form method="post" name="actualizarPersona" action="actualizarPersona">  
                    <table border="2">
                        <%
                            int id= Integer.parseInt(request.getParameter("id"));
                            Persona e = PersonaDAO.buscar(id);
                        %>
                        <tr>
                            <td>ID</td>
                            <td><input type="text" name="id2" value="<%=e.getPersona_id()%>"></td>
                        </tr>
                        <tr>
                            <td>Nombre</td>
                            <td><input type="text" name="nombres2" value="<%=e.getNombres()%>"></td>
                        </tr>
                        <tr>
                            <td>Apellidos</td>
                            <td><input type="text" name="apellidos2" value="<%=e.getApellidos()%>"></td>
                        </tr>
                        <tr>
                            <td>DNI</td>
                            <td><input type="text" name="dni2" value="<%=e.getDni()%>"></td>
                        </tr>
                        <tr>
                            <td>Direccion</td>
                            <td><input type="text" name="direccion2" value="<%=e.getDireccion()%>"></td>
                        </tr>
                        <tr>
                            <td>Edad</td>
                            <td><input type="text" name="edad2" value="<%=e.getEdad()%>"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Actualizar persona"><td>
                        </tr>
                    </table>
                </form>
            <br>
        </div>
    </body>
</html>
