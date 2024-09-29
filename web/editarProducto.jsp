
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.ProductoDAO"%>
<%@page import="modelo.Producto"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="style.css" type="text/css" rel="stylesheet">
    </head>
    <body>
         <div class="container">
            <form method="post" name="registroProducto" action="actualizarProducto">  
                <table cellspacing="0" style="width: 400px">
                        <%
                            int id= Integer.parseInt(request.getParameter("id"));
                            Producto e = ProductoDAO.buscar(id);
                        %>
                        <thead>
                            <th>ID</th>
                            <th>CODIGO</th>                    
                            <th>DESCRI</th>
                            <th>UNIDAD</th>
                            <th>PRECIO</th>
                            <th>PESO</th>                 
                            <th>VOLUMEN</th>
                            <th>OPERACIONES</th>
                        </thead>
                        <tbody>
                            <td>
                                <input type="text" name="id2" value="<%=e.getProducto_id()%>"
                            </td>
                            <td>
                                <input type="text" name="codigo2" value="<%=e.getCodigo()%>">
                            </td>
                            <td>
                                <input type="text" name="descripcion2" value="<%=e.getDescripcion()%>">
                            </td>
                            <td>
                                <input type="text" name="unidad2" value="<%=e.getUnidad()%>">
                            </td>
                            <td>
                                <input type="text" name="precio2" value="<%=e.getPrecio()%>">
                            </td>
                            <td>
                                <input type="text" name="peso2" value="<%=e.getPeso()%>">
                            </td>
                            <td>
                                <input type="text" name="volumen2" value="<%=e.getVolumen()%>">
                            </td>
                            <td>
                                <input class="inp_regis" type="submit" value="Actualizar producto">
                            </td>
                        </tbody>
                    </table>
                </form>
            <br>
            <br>
            
            <a class="btn_page" href="listaProducto.jsp">LISTAR</a>
        </div>
    </body>
</html>
