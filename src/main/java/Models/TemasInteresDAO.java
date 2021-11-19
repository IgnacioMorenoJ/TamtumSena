
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TemasInteresDAO {

    Connection con;
    PreparedStatement ps; 
    ResultSet rs; 
    String sql = null; 

    Conexion c = new Conexion();

    int t;

    public List listar() throws Exception {

        List<TemasInteres> tem = new ArrayList<>();
        sql = "SELECT id, descripcion FROM temasinteres";
       
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql); 
            rs = ps.executeQuery();
            
            
            while (rs.next()) {
               TemasInteres t = new TemasInteres();
              
                t.setId(rs.getInt(1));
                t.setDescripcion(rs.getString(2));
                
            }
            ps.close(); 
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("No existen temas definidos" + e.getMessage());
        } finally {
            con.close(); 
        }
        return tem;
    }

    public int registrar(TemasInteres ti) throws SQLException {
        sql = "INSERT INTO roles (id,descripcion) VALUES (?,?)";
        try {
            con = c.conectar();//abrir conexión
            ps = con.prepareStatement(sql); //preparación
                     
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registró un tema de interes");

        } catch (Exception e) {
            System.out.println("Error en el registro del tema de interes " + e.getMessage());
        } finally {
            con.close();
        }
        return t;
    }

    public void eliminar(int id) throws SQLException {
        sql = "DELETE FROM roles WHERE id=" + id;
        System.out.println(sql);
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se eliminó el tema de interes ");
        } catch (Exception e) {
            System.out.println("Error en la eliminación del tema de interes  " + e.getMessage());
        } finally {
            con.close();
        }
    }

    public TemasInteres consultaporId(int id) throws SQLException {
        TemasInteres t = new TemasInteres();
        sql = "SELECT * FROM temasinteres WHERE id=" + id;
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println(ps);

            while (rs.next()) {
                t.setId(rs.getInt(1));
                t.setDescripcion(rs.getString(2));
               
                System.out.println("Se encontró el tema de interes");

            }
        } catch (Exception e) {
            System.out.println("Error en la consulta del usuario del DAO Tema de Interes " + e.getMessage());
        } finally {
            con.close();
        }

        return t;
    }

    public int actualizar(Roles rl) throws SQLException {
        sql = "UPDATE temasinteres SET ,descipcion=?," + "WHERE id=" + rl.getId();
        try {

            con = c.conectar();
            ps = con.prepareStatement(sql); 
            ps.setString(1, rl.getDescripcion());
            

            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se actualizó un tema de interes");
        } catch (Exception e) {
            System.out.println("Error en la actualización del tema de interes" + e.getMessage());
        } finally {
            con.close();
        }
        return t;
    }
    
}
