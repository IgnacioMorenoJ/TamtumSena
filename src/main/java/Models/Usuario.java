package Models;

public class Usuario {

    private int id;
    private String nombre;
    private String apellidos;
    private String foto;
    private String documento;
    private String correo;
    private String fechaDeNacimiento;
    private String telefono;
    private String clave;
    private Boolean estado;
    private String idTipoDocumento;
    private String idRol;
    private String entidad;
    private String ciudad;

    public Usuario (){}
    
    public Usuario(int id, String nombre, String apellidos, String foto, String documento, String correo, String fechaDeNacimiento, String telefono, String clave, Boolean estado, String idTipoDocumento, String idRol, String entidad, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.foto = foto;
        this.documento = documento;
        this.correo = correo;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.telefono = telefono;
        this.clave = clave;
        this.estado = estado;
        this.idTipoDocumento = idTipoDocumento;
        this.idRol = idRol;
        this.entidad = entidad;
        this.ciudad = ciudad;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(String idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
      
    
}