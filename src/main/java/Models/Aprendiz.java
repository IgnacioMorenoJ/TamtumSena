
package Models;

/**
 *  prueba git
 * @author usuario
 */
public class Aprendiz extends Usuario {

    private int identificacion;
    private String nombre;  //Sena 08-11-2021-
    private String apellido;
    private int edad;

    public Aprendiz(int id, String nombre, String apellidos, String foto, String documento, String correo, String fechaDeNacimiento, String telefono, String clave, Boolean estado, String idTipoDocumento, String idRol, String entidad, String ciudad) {
        super(id, nombre, apellidos, foto, documento, correo, fechaDeNacimiento, telefono, clave, estado, idTipoDocumento, idRol, entidad, ciudad);
    }

      public Aprendiz(int identificacion, String nombre, String apellido, int edad) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
      }
    
    public Aprendiz() {
    }
   
    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}