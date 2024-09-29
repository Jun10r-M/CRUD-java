<%-- 
    Document   : listarProducto
    Created on : 26 sept 2024, 16:45:42
    Author     : UPSJB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.ProductoDAO"%>
<%@page import="modelo.Producto"%>
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
                    <th>CODIGO</th>                    
                    <th>DESCRI</th>
                    <th>UNIDAD</th>
                    <th>PRECIO</th>
                    <th>PESO</th>                 
                    <th>VOLUMEN</th>
                    <th colspan="2">OPERACIONES</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Producto> lista = ProductoDAO.listartodo();
                    for(Producto e : lista){
                %>
                <tr>
                    <th><%=e.getProducto_id()%></th>
                    <th><%=e.getCodigo()%></th>                    
                    <th><%=e.getDescripcion()%></th>
                    <th><%=e.getPeso()%></th>
                    <th><%=e.getPrecio()%></th>
                    <th><%=e.getUnidad()%></th>                   
                    <th><%=e.getVolumen()%></th>
                    <th><a id ="edit" href="editarProducto.jsp?id=<%=e.getProducto_id()%>">Editar</a></th>
                    <th><a class="delete" href="borrarProducto?id=<%=e.getProducto_id()%>">Eliminar</a></th>               
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
            <br>
            <a class="btn_page" href="index.html">INICIO</a>
    <script>
      const deleteLinks = document.querySelectorAll('.delete');
        
        deleteLinks.forEach(link => {   
            link.addEventListener('click', function(event) {
                event.preventDefault(); // Evita la acción predeterminada

                if (confirm("¿Seguro que quieres eliminar este producto?")) {
                    // Si el usuario confirma, redirigir a la URL del enlace
                    window.location.href = this.href;
                }
            });
        });
    </script>   
    </body>
</html>
