
package Models;

public class Empresa extends Usuario {
private String nombreRepresentante;
private int nit;
private String razonSocial;

    public Empresa(String nombreRepresentante, int nit, String razonSocial, int id, String nombre, String apellidos, String foto, String documento, String correo, String fechaDeNacimiento, String telefono, String clave, Boolean estado, String idTipoDocumento, String idRol, String entidad, String ciudad) {
        super(id, nombre, apellidos, foto, documento, correo, fechaDeNacimiento, telefono, clave, estado, idTipoDocumento, idRol, entidad, ciudad);
        this.nombreRepresentante = nombreRepresentante;
        this.nit = nit;
        this.razonSocial = razonSocial;
    }

    public Empresa(String nombreRepresentante, int nit, String razonSocial) {
        this.nombreRepresentante = nombreRepresentante;
        this.nit = nit;
        this.razonSocial = razonSocial;
    }

    public String getNombreRepresentante() {
        return nombreRepresentante;
    }

    public void setNombreRepresentante(String nombreRepresentante) {
        this.nombreRepresentante = nombreRepresentante;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
}
