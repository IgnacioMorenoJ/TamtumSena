
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
        sql = "SELECT id, descripcion, estado FROM roles";
       
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql); 
            rs = ps.executeQuery();
            
            
            while (rs.next()) {
                Roles r = new Roles();
              
                r.setId(rs.getInt("id"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setEstado(rs.getBoolean("estado"));
                rol.add(r);
            }
            ps.close(); 
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("No existen Roles definidos" + e.getMessage());
        } finally {
            con.close(); 
        }
        return rol;
    }

    public int registrarRol (Roles rl) throws SQLException {
        System.out.println("entro al modelo");
       sql="INSERT INTO roles (descripcion,estado) VALUES (?,?)";
        try {
                                       
                con=c.conectar();//abrir conexión
	        ps=con.prepareStatement(sql); //preparación
		ps.setString(1, rl.getDescripcion());
		ps.setBoolean(2, rl.getEstado());
		System.out.println(ps);
		ps.executeUpdate();//Ejecucución sentencia
		ps.close();//cerrar sentencia
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

    public int actualizarRol(Roles  re) throws SQLException {
        sql = "UPDATE roles SET descipcion=?,estado=? WHERE id=" + re.getId();
        System.out.println("Prueba Update");
               
        try {

            con = c.conectar();
            ps = con.prepareStatement(sql); 
            ps.setString(1, re.getDescripcion());
            ps.setBoolean(2, re.getEstado());

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
    
    public int cambiarEstado(Roles rl) throws SQLException {
		sql="UPDATE roles SET estado =?  WHERE id="+rl.getId();
		try {
			
			con=c.conectar();//abrir conexión
			ps=con.prepareStatement(sql); //preparación
			ps.setBoolean(1, rl.getEstado());
			
			System.out.println(sql);
			ps.executeUpdate();//Ejecucución sentencia
			ps.close();//cerrar sentencia
			System.out.println("Se actualizó el estado del rol");
		}catch(Exception e) {
			System.out.println("Error en la actualización del estado rol "+e.getMessage());
		}
		finally {
			con.close();
		}
		return r;
    
    
}
}   