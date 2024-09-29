package modelo;
import org.xml.sax.SAXException;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;
import modelo.ProductoDAO;

public class ProductoDAO {
    Conexion con = new Conexion();
    
    public static int insertar(Producto producto){
        int status = 0;
        Conexion co = new Conexion();

        String consulta ="INSERT INTO Producto (codigo,descripcion,unidad,precio,peso,volumen)" +
                "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = co.conectar().prepareStatement(consulta);
            ps.setString(1,producto.getCodigo());
            ps.setString(2,producto.getDescripcion());
            ps.setString(3,producto.getUnidad());
            ps.setString(4,producto.getPrecio());
            ps.setString(5,producto.getPeso());
            ps.setString(6,producto.getVolumen());
            status = ps.executeUpdate();
            ps.close();
            co.desconectar();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }
   
    public static int eliminar(int producto_id){
        Conexion con = new Conexion();
        int status = 0;
        String consulta = "DELETE from Producto WHERE producto_id = ?";
        try{
            PreparedStatement ps = con.conectar().prepareStatement(consulta);
               ps.setInt(1, producto_id);
               status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int actualizarProducto (Producto producto){
        Conexion con = new Conexion();
        int status = 0;
        try {
            String consulta = "UPDATE producto SET codigo = ?, descripcion =?, unidad =?, precio=?, peso=?, volumen=? WHERE producto_id=?";
            PreparedStatement ps = con.conectar().prepareStatement(consulta);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getUnidad());
            ps.setString(4, producto.getPrecio());
            ps.setString(5, producto.getPeso());
            ps.setString(6, producto.getVolumen());
            ps.setInt(7, producto.getProducto_id());
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static List<Producto>listartodo(){
                Conexion con = new Conexion();

        List<Producto> productos = new ArrayList<Producto>();
        try
        {
            String consulta = "SELECT * FROM Producto";
            PreparedStatement ps = con.conectar().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Producto produc = new Producto();
                produc.setProducto_id(rs.getInt("producto_id"));
                produc.setCodigo(rs.getString("codigo"));
                produc.setDescripcion(rs.getString("descripcion"));
                produc.setUnidad(rs.getString("unidad"));
                produc.setPrecio(rs.getString("precio"));
                produc.setPeso(rs.getString("peso"));
                produc.setVolumen(rs.getString("volumen"));
                productos.add(produc);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return productos;
    }
    
    public static Producto buscar(int id){
        Producto e = new Producto();
        Conexion con = new Conexion();
        int status = 0;
        try {
            String consulta = "SELECT * FROM producto WHERE producto_id=?";
            PreparedStatement ps = con.conectar().prepareStatement(consulta);
            ps.setInt(1,id);
            ResultSet rs =ps.executeQuery();
            if(rs.next()){
                e.setProducto_id(rs.getInt("producto_id"));                
                e.setCodigo(rs.getString("codigo"));
                e.setDescripcion(rs.getString("descripcion"));
                e.setPeso(rs.getString("peso"));
                e.setPrecio(rs.getString("precio"));               
                e.setUnidad(rs.getString("unidad"));
                e.setVolumen(rs.getString("volumen"));
            }
            ps.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return e;
    }
/*
    public static void main(String[] args){
//        Producto producto = new Producto();
        ProductoDAO productoDAO = new ProductoDAO();

        List<Producto> productos = productoDAO.listar();

        for (Producto producto : productos) {
            System.out.println("ID: " + producto.getProducto_id());
            System.out.println("Código: " + producto.getCodigo());
            System.out.println("Descripción: " + producto.getDescripcion());
            System.out.println("Unidad: " + producto.getUnidad());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Peso: " + producto.getPeso());
            System.out.println("Volumen: " + producto.getVolumen());
            System.out.println("---------------");
        }

        //insertar
//        producto.setCodigo("15AO");
//        producto.setDescripcion("info");
//        producto.setUnidad("primera2");
//        producto.setPrecio(25.80);
//        producto.setPeso(18.5);
//        producto.setVolumen(10.23);
//        productoDAO.insertar(producto);

        //actualizar
//        producto.setProducto_id(1);
//        producto.setCodigo("15PO");
//        producto.setDescripcion("datos");
//        producto.setUnidad("segunda");
//        producto.setPrecio(25.65);
//        producto.setPeso(22.0);
//        producto.setVolumen(22.56);
//        productoDAO.actualizar(producto);

        //eliminar
//        productoDAO.eliminar(1);
    }
*/
 
}
