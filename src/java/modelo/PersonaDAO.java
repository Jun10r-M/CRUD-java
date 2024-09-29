package modelo;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PersonaDAO {

    // TABLA PERSONA

    public static int agregar(Persona persona){
        Conexion con = new Conexion();

        int status = 0;
        String consulta = "insert into persona (nombres, apellidos, dni, direccion, edad)" +
                "values (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.conectar().prepareStatement(consulta);
            ps.setString(1, persona.getNombres());
            ps.setString(2, persona.getApellidos());
            ps.setString(3, persona.getDni());
            ps.setString(4, persona.getDireccion());
            ps.setInt(5, persona.getEdad());
            status = ps.executeUpdate();
            ps.close();

        }catch (SQLException e){
            e.printStackTrace();
           
        }
        return status;
    }
    
    public static int actualizarPersona(Persona persona){
        Conexion con = new Conexion();
        int status = 0;
        try {
            String consulta = "UPDATE Persona SET nombres = ?, apellidos =?, dni =?, direccion=?, edad=? WHERE persona_id=?";
            PreparedStatement ps = con.conectar().prepareStatement(consulta);
            ps.setString(1, persona.getNombres());
            ps.setString(2, persona.getApellidos());
            ps.setString(3, persona.getDni());
            ps.setString(4, persona.getDireccion());
            ps.setInt(5, persona.getEdad());
            ps.setInt(6, persona.getPersona_id());
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static List<Persona>listartodo(){
        Conexion con = new Conexion();

        List<Persona> persona = new ArrayList<Persona>();
        try
        {
            String consulta = "SELECT * FROM producto";
            PreparedStatement ps = con.conectar().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Persona person = new Persona();
                person.setPersona_id(rs.getInt("producto_id"));
                person.setNombres(rs.getString("nombres"));
                person.setApellidos(rs.getString("apellidos"));
                person.setDni(rs.getString("dni"));
                person.setDireccion(rs.getString("direccion"));
                person.setEdad(rs.getInt("edad"));
                persona.add(person);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return persona;
    }
    
    public static int eliminar(int persona_id){
        Conexion con = new Conexion();
        int status = 0;
        String consulta = "DELETE FROM producto WHERE producto_id=?";
        try {
               PreparedStatement ps = con.conectar().prepareStatement(consulta);
               ps.setInt(1, persona_id);
               status = ps.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
            return status;
    }
   
    public static Persona buscar(int id){
        Persona e = new Persona();
        Conexion con = new Conexion();
        int status = 0;
        try {
            String consulta = "SELECT * FROM Persona WHERE persona_id=?";
            PreparedStatement ps = con.conectar().prepareStatement(consulta);
            ps.setInt(1,id);
            ResultSet rs =ps.executeQuery();
            if(rs.next()){
                e.setPersona_id(rs.getInt("persona_id"));                
                e.setNombres(rs.getString("nombres"));
                e.setApellidos(rs.getString("apellidos"));
                e.setDni(rs.getString("dni"));
                e.setDireccion(rs.getString("direccion"));               
                e.setEdad(rs.getInt("edad"));
            }
            ps.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return e;
    }
/*
    public static void main(String[] args){
        Persona persona = new Persona();
        PersonaDAO personaDAO = new PersonaDAO();
        persona.setNombres("Junior");
        persona.setApellidos("Mendoza");
        persona.setDni("73362100");
        persona.setDireccion("UPSJB");
        persona.setEdad(22);
        personaDAO.agregar(persona);
//        personaDAO.eliminar(1);
//        persona.setPersona_id(1);
//        persona.setNombres("Junior2");
//        persona.setApellidos("Mendoza2");
//        persona.setDni("73362100");
//        persona.setDireccion("UPSJB2");
//        persona.setEdad(22);
//        personaDAO.actualizar(persona);
    }
*/
}
