
package Models;

public class Roles {
    
private int id;
private String descripcion;
private Boolean estado;

    public Roles(){}

    public Roles(int id, String descripcion, Boolean estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}