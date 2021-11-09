package Models;

public class Prueba {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Conexion con = new Conexion();

        if (con.conectar() != null) {
            System.out.println("Conexion establecida");
        } else {

            System.out.println("No se pudo conectar a la base de datos");
        }
    }
}
