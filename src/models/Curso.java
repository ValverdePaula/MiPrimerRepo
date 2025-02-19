package models;

import java.util.Date;

public class Curso {
    //Constructor
    private int idCurso;   //no se pide
    private String nombreCurso;  // se pide
    private Date fechaInicio;  // se pide
    private String nombreProfesor;  // se pide
    //Constructor
    public Curso(int idCurso, String nombreCurso, Date fechaInicio, String nombreProfesor) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.fechaInicio = fechaInicio;
        this.nombreProfesor = nombreProfesor;
    }

    //Getter and Setter
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    //toString
    @Override
    public String toString() {
        return "Curso{" +
                "idCurso=" + idCurso +
                ", nombreCurso='" + nombreCurso + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", nombreProfesor='" + nombreProfesor + '\'' +
                '}';
    }
}
