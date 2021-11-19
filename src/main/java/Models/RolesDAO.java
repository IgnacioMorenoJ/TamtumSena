
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolesDAO {

    Connection con;
    PreparedStatement ps; 
    ResultSet rs; 
    String sql = null; 

    Conexion c = new Conexion();

    int r;

    public List listar() throws Exception {

        List<Roles> rol = new ArrayList<>();
        sql = "SELECT id, descripcion FROM roles";
       
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql); 
            rs = ps.executeQuery();
            
            
            while (rs.next()) {
                Roles r = new Roles();
              
                r.setId(rs.getInt(1));
                r.setDescripcion(rs.getString(2));
                
            }
            ps.close(); 
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("No existen usuarios definidos" + e.getMessage());
        } finally {
            con.close(); 
        }
        return rol;
    }

    public int registrar(Roles rl) throws SQLException {
        sql = "INSERT INTO roles (id,descripcion) VALUES (?,?)";
        try {
            con = c.conectar();//abrir conexión
            ps = con.prepareStatement(sql); //preparación
                     
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registró un rol");

        } catch (Exception e) {
            System.out.println("Error en el registro del rol " + e.getMessage());
        } finally {
            con.close();
        }
        return r;
    }

    public void eliminar(int id) throws SQLException {
        sql = "DELETE FROM roles WHERE id=" + id;
        System.out.println(sql);
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se eliminó el rol");
        } catch (Exception e) {
            System.out.println("Error en la eliminación del rol " + e.getMessage());
        } finally {
            con.close();
        }
    }

    public Roles consultaporId(int id) throws SQLException {
        Roles r = new Roles();
        sql = "SELECT * FROM roles WHERE id=" + id;
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println(ps);

            while (rs.next()) {
                r.setId(rs.getInt(1));
                r.setDescripcion(rs.getString(2));
               
                System.out.println("Se encontró el rol");

            }
        } catch (Exception e) {
            System.out.println("Error en la consulta del usuario del DAO Roles " + e.getMessage());
        } finally {
            con.close();
        }

        return r;
    }

    public int actualizar(Roles rl) throws SQLException {
        sql = "UPDATE roles SET ,descipcion=?," + "WHERE id=" + rl.getId();
        try {

            con = c.conectar();
            ps = con.prepareStatement(sql); 
            ps.setString(1, rl.getDescripcion());
            

            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se actualizó un rol");
        } catch (Exception e) {
            System.out.println("Error en la actualización del rol " + e.getMessage());
        } finally {
            con.close();
        }
        return r;
    }
    
}
