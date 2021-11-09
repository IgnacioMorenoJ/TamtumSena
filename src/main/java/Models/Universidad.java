
package Models;

public class Universidad extends Usuario {
 
private String nombreUniversidad;
private int nit;
   
    
    public Universidad(int id, String nombre, String apellidos, String foto, String documento, String correo, String fechaDeNacimiento, String telefono, String clave, Boolean estado, String idTipoDocumento, String idRol, String entidad, String ciudad) {
        super(id, nombre, apellidos, foto, documento, correo, fechaDeNacimiento, telefono, clave, estado, idTipoDocumento, idRol, entidad, ciudad);
    }
   public Universidad(String nombreUniversidad, int nit) {
        this.nombreUniversidad = nombreUniversidad;
        this.nit = nit;
    }
        
    public Universidad() {
    }
 //universidad prueba
    public String getNombreUniversidad() {
        return nombreUniversidad;
    }

    public void setNombreUniversidad(String nombreUniversidad) {
        this.nombreUniversidad = nombreUniversidad;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }
       
    
}
