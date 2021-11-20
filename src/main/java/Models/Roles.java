
package Models;

public class Roles {

    static void add(String r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

private int id;
private String descripcion;

    public Roles(){}
    public Roles(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
      
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
}
