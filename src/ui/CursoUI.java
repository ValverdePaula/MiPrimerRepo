package ui;

import models.Curso;
import models.Usuario;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CursoUI {
    //lista de cursos
    private ArrayList<Curso> misCursos = new ArrayList<>();
    //contador para el idCurso
    private int contador = 0;

    public CursoUI(){
        //menú
        int opcion;
        while(true){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    " 1. Nuevo Curso" + "\n" +
                    " 2. Modificar curso" + "\n" +
                    " 3. Dar de Baja Curso" + "\n" +
                    " 4. Buscar Curso" + "\n" +
                    " 5. Listado de Cursos" + "\n" +
                    " 6. Salir" + "\n" +
                    " 100. Carga para TEST"
            ));

            switch (opcion) {
                case 1:  altaCurso(); break;
                case 2:  modificarCurso(); break;
                case 3:  eliminarCurso(); break;
                case 4:  buscarCurso(); break;
                case 5:  listadoCurso(); break;
                case 6:  System.exit(0);
                case 100: cargaTest(); break;
                default:
                    JOptionPane.showConfirmDialog(null,"Ingresó una opción inválida");
            }
        }
    }
    //pedir datos del curso + validacion + crear un objeto Curso + agregarlo a la lista
    public void altaCurso(){
        int idCurso = 0;
        String nombreCurso = "";
        String nombreProfesor = "";
        String fechaInicioStr = "";
        Date fechaInicio = new Date();
        contador = contador + 1;
        idCurso = contador;

        //validaciones
        boolean datovalido = false;
        while(!datovalido){
            nombreCurso = JOptionPane.showInputDialog("Ingrese el nombre del curso:");
            datovalido = validarNombreCurso(nombreCurso);
        }
        datovalido = false;
        while(!datovalido){
            nombreProfesor = JOptionPane.showInputDialog("Ingrese el nombre del profesor:");
            datovalido = validarNombreProfesor(nombreProfesor);
        }

        datovalido = false;
        while(!datovalido){
            fechaInicioStr = JOptionPane.showInputDialog("Ingrese la fecha de inicio del curso (en formato dd/mm/yyyy):");
            datovalido = validarFechaInicio(fechaInicioStr);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try{
            fechaInicio = dateFormat.parse(fechaInicioStr);
        }catch(Exception e){
            System.out.println(e);
        }
        //creo el objeto miCurso y lo agrego a la lista
        Curso miCurso = new Curso(idCurso,nombreCurso,fechaInicio,nombreProfesor);
        misCursos.add(miCurso);
        JOptionPane.showMessageDialog(null, "El curso fue creado exitosamente.");


    }
    //métodos de validación
    private boolean validarNombreCurso(String nombreCurso) {
        if(nombreCurso.length() == 0 || nombreCurso.length() < 2){
            return false;
        }else{
            return true;
        }
    }
    private boolean validarNombreProfesor(String nombreProfesor) {
        if(nombreProfesor.length() == 0 || nombreProfesor.length() < 2){
            return false;
        }else{
            return true;
        }
    }
    private boolean validarFechaInicio(String fechaInicioStr) {
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaInicio = dateFormat.parse(fechaInicioStr);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //pedir el idCurso + buscarlo, pedir los nuevos datos y actualizar la lista
    public void modificarCurso(){
        int seleccionarCurso;
        seleccionarCurso = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del curso que desea modificar:"));

        Curso cursoActualizar = null;
        String nombreCurso = "";
        String nombreProfesor = "";
        boolean existe = false;
        Date fechaInicio = new Date();
        String fechaInicioStr = "";

        //busco qué curso voy a actualizar en funcion al id del curso que ingresaron
        for(Curso c: misCursos){
            if(c.getIdCurso() == seleccionarCurso){
                cursoActualizar = c; //modifico el objeto directamente
                existe = true;
                break; //salgo del bucle una vez que encuentro el curso
            }
        }
        if(existe){
            //pido los datos para actualizar
            boolean datovalido = false;
            while(!datovalido){
                nombreCurso = JOptionPane.showInputDialog("Ingrese el nombre del curso:");
                datovalido = validarNombreCurso(nombreCurso);
            }
            cursoActualizar.setNombreCurso(nombreCurso);

            datovalido = false;
            while(!datovalido){
                nombreProfesor = JOptionPane.showInputDialog("Ingrese el nombre del profesor:");
                datovalido = validarNombreProfesor(nombreProfesor);
            }
            cursoActualizar.setNombreProfesor(nombreProfesor);

            datovalido = false;
            while(!datovalido){
                fechaInicioStr = JOptionPane.showInputDialog("Ingrese la fecha de inicio del curso (en formato dd/mm/yyyy):");
                datovalido = validarFechaInicio(fechaInicioStr);
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try{
                fechaInicio = dateFormat.parse(fechaInicioStr);
            }catch(Exception e){
                System.out.println(e);
            }
            cursoActualizar.setFechaInicio(fechaInicio);
        }else{
            System.out.println("No se encontró un curso con el id proporcionado.");
        }
    }

    private int buscarPosicionDelIdCurso(int idCurso){
        int posicion = -1;
        for(int i= 0 ; i< misCursos.size(); i++){
            Curso c = misCursos.get(i);
            if(c.getIdCurso() == idCurso){
                posicion = i;
                break;
            }
        }
        return posicion;
    }
    //mostrar la lista de cursos
    public void listadoCurso(){
        String salida = "";
        for(Curso u: misCursos){
            salida = salida + u.toString() + "\n";
        }
        JOptionPane.showConfirmDialog(null,salida);
    }
    //pido el idCurso, lo busco y lo elimino
    public void eliminarCurso(){
        int idCurso = Integer.parseInt(JOptionPane.showInputDialog(" Ingrese el id del curso que desea eliminar"));
        int posicion = buscarPosicionDelIdCurso(idCurso);
        misCursos.remove(posicion);
    }
    //pido el idCurso, lo busco y lo muestro
    public void buscarCurso(){
        int idCurso = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del curso que desea buscar"));
        int posicion = buscarPosicionDelIdCurso(idCurso);
        Curso c = misCursos.get(posicion);
        JOptionPane.showConfirmDialog(null,c.toString());
    }
    //creo varios cursos fijos (no pido por teclado) y los meto a la lista
    public void cargaTest(){
        Curso curso1 = new Curso(1,"Programación Java", parseFecha("01/01/2023"),"Juan Perez");
        Curso curso2 = new Curso(2, "Diseño Web", parseFecha("15/02/2023"), "Maria Rodriguez");
        Curso curso3 = new Curso(3, "Base de Datos", parseFecha("10/03/2023"), "Carlos Gomez");

        misCursos.add(curso1);
        misCursos.add(curso2);
        misCursos.add(curso3);

        System.out.println("Cursos de prueba cargados exitosamente.");
    }
    private static Date parseFecha(String fechaStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(fechaStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}

//https://youtu.be/IGxQDPVCyeQ?si=uYiYJppMH-bCR72d&t=3330