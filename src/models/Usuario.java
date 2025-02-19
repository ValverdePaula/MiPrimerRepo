package models;
import  java.util.Date;
public class Usuario {

    private int idUsuario;  // este dato no lo pido para ingresar
    private String nombreUsuario;  // este si
    private String contrasenia;  // este si
    private Date fechaAlta;  //  se calcula no se pido
    private Date fechaModificacion;  // se calcula no se pide
    private Date fechaNacimiento;  // se pide


    public Usuario(int idUsuario, String nombreUsuario, String contrasenia, Date fechaAlta, Date fechaModificacion, Date fechaNacimiento) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.fechaAlta = fechaAlta;
        this.fechaModificacion = fechaModificacion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
