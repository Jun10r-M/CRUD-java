
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Producto;
import modelo.ProductoDAO;


public class actualizarProducto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            int id = Integer.parseInt(request.getParameter("id2"));
            String codigo = request.getParameter("codigo2");
            String descripcion = request.getParameter("descripcion2");
            String unidad = request.getParameter("unidad2");
            String precio = request.getParameter("precio2");
            String peso = request.getParameter("peso2");
            String volumen  = request.getParameter("volumen2");
            
            Producto e = new Producto();
            e.setProducto_id(id);
            e.setCodigo(codigo);
            e.setDescripcion(descripcion);           
            e.setPeso(peso);
            e.setPrecio(precio);
            e.setUnidad(unidad);            
            e.setVolumen(volumen);
            int status = ProductoDAO.actualizarProducto(e);
            if(status > 0){
                 response.sendRedirect("listaProducto.jsp");
             }else{
                 response.sendRedirect("error.jsp");
             }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
