
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.PersonaDAO"%>
<%@page import="modelo.Persona"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="style.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <h1>LISTAR ATRIBUTOS</h1>
        
        <br>
        <table cellspacing="0">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>                    
                    <th>APELLIDO</th>
                    <th>DNI</th>
                    <th>DIRECCION</th>
                    <th>EDAD</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Persona> lista = PersonaDAO.listartodo();
                    for(Persona e : lista){
                %>
                <tr>
                    <th><%=e.getPersona_id()%></th>
                    <th><%=e.getNombres()%></th>                    
                    <th><%=e.getApellidos()%></th>
                    <th><%=e.getDni()%></th>
                    <th><%=e.getDireccion()%></th>
                    <th><%=e.getEdad()%></th>
                    <th><a id ="edit" href="editarProducto.jsp?id=<%=e.getPersona_id()%>">Editar</a></th>
                    <th><a id="delete" href="borrarProducto?id=<%=e.getPersona_id()%>">Eliminar</a></th>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
            <br>
            <a id="inicio" href="index.html">INICIO</a>
    </body>
</html>
