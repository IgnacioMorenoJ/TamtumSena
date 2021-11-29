package Models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    Connection con; 
    PreparedStatement ps; 
    ResultSet rs; 
    String sql = null; 

    Conexion c = new Conexion();

    int r;

    public Usuario validarUsuario(String correo, String passw) throws SQLException {
        Usuario u = new Usuario();
        sql = "SELECT id,Nombres,Apellidos,Documento,Correo,Fecha_Nacimiento,Teléfono,Estado FROM usuarios ";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, passw);
            rs = ps.executeQuery();

            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setApellidos(rs.getString(3));
                u.setDocumento(rs.getString(4));
                u.setCorreo(rs.getString(5));
                u.setFechaDeNacimiento(rs.getString(6));
                u.setTelefono(rs.getString(7));
                u.setEstado(rs.getBoolean(8));
                System.out.println("Se encontró el usuario");

            }
        } catch (Exception e) {
            System.out.println("Error en la consulta del usuario" + e.getMessage());
        } finally {
            con.close();
        }

        return u;
    }

    public List listar() throws Exception {

        List<Usuario> usu = new ArrayList<>();
        sql = "SELECT id,Nombres,Apellidos,Documento,Correo,Fecha_Nacimiento,Teléfono,Estado FROM usuarios ";
        //sql="SELECT Id, Nombres, Apellidos, Foto, Documento, Correo, Fecha_Nacimiento, Teléfono, Clave, Estado, IdTipoDocumento, IdRol, IdEntidad, IdCiudad FROM usuarios";

        try {
            con = c.conectar(); //abrir conexion
            ps = con.prepareStatement(sql); //preparando la sentencia
            //ejecutamos la consulta y guardamos en el objeto rs
            rs = ps.executeQuery();
            //procesamos el resultado de la consulta
            while (rs.next()) {
                Usuario u = new Usuario();
                //Escribir en el setter de cada objeto
                u.setId(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setApellidos(rs.getString(3));
                u.setDocumento(rs.getString(4));
                u.setCorreo(rs.getString(5));
                u.setFechaDeNacimiento(rs.getString(6));
                u.setTelefono(rs.getString(7));
                u.setEstado(rs.getBoolean(8));
                usu.add(u);
            }
            ps.close(); //cerrar sentencia
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("No existen usuarios definidos" + e.getMessage());
        } finally {
            con.close(); //cerrar conexión
        }
        return usu;
    }

    public int registrar (Usuario us) throws SQLException {
        sql = "INSERT INTO usuarios (nombres,apellidos,documento,correo,fechaDeNacimiento,telefono,Clave,Estado,IdTipoDocumento,IdRol,IdEntidad,IdCiudad) VALUES (?,?,?,?,?,?,?,1,1,1,1,1)";
        try {
            con = c.conectar();//abrir conexión
            ps = con.prepareStatement(sql); //preparación
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getApellidos());
            ps.setString(3, us.getDocumento());
            ps.setString(4, us.getCorreo());
            ps.setString(5, us.getFechaDeNacimiento());
            ps.setString(6, us.getTelefono());
            ps.setString(7, us.getClave());
            //ps.setInt(7, us.getRolUs().getIdRol());

            System.out.println(ps);
            ps.executeUpdate();//Ejecucución sentencia
            ps.close();//cerrar sentencia
            System.out.println("Se registró un usuario");

        } catch (Exception e) {
            System.out.println("Error en el registro del usuario " + e.getMessage());
        } finally {
            con.close();
        }
        return r;
    }

    public void eliminar(int id) throws SQLException {
        sql = "DELETE FROM usuario WHERE id=" + id;
        System.out.println(sql);
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se eliminó el usuario");
        } catch (Exception e) {
            System.out.println("Error en la eliminación del registro " + e.getMessage());
        } finally {
            con.close();
        }
    }

    public Usuario consultaporId(int id) throws SQLException {
        Usuario u = new Usuario();
        sql = "SELECT * FROM usuario WHERE id=" + id;
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println(ps);

            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setDocumento(rs.getString(2));
                u.setNombre(rs.getString(3));
                u.setApellidos(rs.getString(4));
                u.setCorreo(rs.getString(5));
                u.setFechaDeNacimiento(rs.getString(6));
                u.setTelefono(rs.getString(7));
                u.setClave(rs.getString(8));
                u.setEstado(rs.getBoolean(9));
                System.out.println("Se encontró el usuario");

            }
        } catch (Exception e) {
            System.out.println("Error en la consulta del usuario del DAO Usuario " + e.getMessage());
        } finally {
            con.close();
        }

        return u;
    }

    public int actualizar(Usuario us) throws SQLException {
        sql = "UPDATE usuario SET ,Documento=?,Nombre=?,Apellidos=?,Correo=?,FechaDeNacimiento=?, Telefono=?,Clave=?,Estado=?"
                + "WHERE id=" + us.getId();
        try {

            con = c.conectar();//abrir conexión
            ps = con.prepareStatement(sql); //preparación
            ps.setString(1, us.getDocumento());
            ps.setString(2, us.getNombre());
            ps.setString(3, us.getApellidos());
            ps.setString(4, us.getCorreo());
            ps.setString(4, us.getFechaDeNacimiento());
            ps.setString(6, us.getTelefono());
            ps.setString(7, us.getClave());
            ps.setBoolean(8, us.getEstado());

            System.out.println(ps);
            ps.executeUpdate();//Ejecucución sentencia
            ps.close();//cerrar sentencia
            System.out.println("Se actualizó un usuario");
        } catch (Exception e) {
            System.out.println("Error en la actualización del usuario " + e.getMessage());
        } finally {
            con.close();
        }
        return r;
    }

    public int cambiarEstado(Usuario u) throws SQLException {
        sql = "UPDATE usuario SET estado=? "
                + "WHERE id=" + u.getId();
        try {

            con = c.conectar();//abrir conexión
            ps = con.prepareStatement(sql); //preparación
            ps.setBoolean(1, u.getEstado());

            System.out.println(ps);
            ps.executeUpdate();//Ejecucución sentencia
            ps.close();//cerrar sentencia
            System.out.println("Se actualizó el estado del usuario");
        } catch (Exception e) {
            System.out.println("Error en la actualización del estado usuario " + e.getMessage());
        } finally {
            con.close();
        }
        return r;
    }

public int changePassword(Usuario us) throws SQLException {
	sql="UPDATE usuario SET passwordUsuario=? WHERE idUsuario="+us.getId();
	try {
		
		con=c.conectar();//abrir conexión
		ps=con.prepareStatement(sql); //preparación
		ps.setString(1, us.getClave());
		
		
		System.out.println(ps);
		ps.executeUpdate();//Ejecucución sentencia
		ps.close();//cerrar sentencia
		System.out.println("Se actualizó el password del usuario");
	}catch(Exception e) {
		System.out.println("Error en la actualización del password usuario "+e.getMessage());
	}
	finally {
		con.close();
	}
	return r;
}
  

}
