package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.*;

public class Conexion {

    private static final String bbdd = "jdbc:mysql://localhost:3306/tamtumbd";
    private static final String usuario = "root";
    private static final String clave = "";
    private static Connection con;

    public Connection conectar() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(bbdd, usuario, clave);
            System.out.println("Conexión Exitosa");
        } catch (Exception e) {
            System.out.println("Error de conexión a la base de datos " + e.getMessage().toString());
        }
        return con;

    }

}
