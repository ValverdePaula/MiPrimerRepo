package ui;

import models.Curso;
import models.Usuario;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UsuarioUI {
    private ArrayList<Usuario> misUsuarios = new ArrayList<Usuario>();
    private int contador = 0;

    public UsuarioUI() {
        int opcion;
        while(true){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    " 1. Nuevo Usuario" + "\n" +
                            " 2. Modificar Usuario" + "\n" +
                            " 3. Dar de Baja Usuario" + "\n" +
                            " 4. Listado de Usuarios" + "\n" +
                            " 5. Buscar un Usuario" + "\n" +
                            " 6. Salir"  + "\n" +
                            " 100. Carda datos para TEST"

            ));

            switch (opcion) {
                case 1:  altaUsuario(); break;
                case 2:  modificarUsuario(); break;
                case 3:  eliminarUsuario(); break;
                case 4:  listarUsuarios(); break;
                case 5:  buscarUsuario(); break;
                case 6:  System.exit(0);break;
                case 100:  cargaPreviaDeUsuarios(); break;
                default: JOptionPane.showConfirmDialog(null,"opcion invalida");
            }
        }
    }

    public void altaUsuario(){
        contador = contador +1;
        int id =  contador;
        String nombre= "";
        Date fechaAlta = new Date();
        Date fechaModificacion = new Date();
        Date fechaNacimiento = new Date();
        String contrasenia ="";
        String fechaNacimentoStr = "";
        boolean valido = false;
        while(!valido){
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
            valido = validarNombreUsuario(nombre);
        }
        valido = false;
        while(!valido){
            fechaNacimentoStr = JOptionPane.showInputDialog("Ingrese la fecha de inicio del curso (en formato dd/MM/yyyy):");
            valido = validarFechaNacimiento(fechaNacimentoStr);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            fechaNacimiento = dateFormat.parse(fechaNacimentoStr);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        valido = false;
        while(!valido){
            contrasenia = JOptionPane.showInputDialog("Ingrese la contraseña");
            valido = validarContrasenia(contrasenia);
        }
        Usuario miUsuario = new Usuario(id,nombre,contrasenia,fechaAlta,fechaModificacion,fechaNacimiento);
        misUsuarios.add(miUsuario);

        JOptionPane.showMessageDialog(null, "El usaurio fue creado exitosamente.");


    }

    public boolean validarNombreUsuario(String nombre){
        if(nombre.length() < 2){
            return false;
        }else{
            return true;
        }
    }
    public boolean validarContrasenia(String contrasenia){
        if (contrasenia.length() <2){
            return false;
        }else {
            return true;
        }
    }
    public boolean validarFechaNacimiento(String fecha){
        Date fechaDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            fechaDate = dateFormat.parse(fecha);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public void modificarUsuario(){}

    public void listarUsuarios(){
        String salida = "";
        for(Usuario  u: misUsuarios){
            salida = salida + u.toString() + "\n";
        }
        JOptionPane.showConfirmDialog(null,salida);
    }
    private int buscarPosicionIdUsuario( int idUsuario){
        int posicion = -1;
        for(int i= 0 ; i< misUsuarios.size(); i++){
            Usuario c = misUsuarios.get(i);
            if(c.getIdUsuario() == idUsuario){
                posicion = i;
                break;
            }
        }
        return posicion;
    }
    public void eliminarUsuario(){
        int idUsuario = Integer.parseInt(JOptionPane.showInputDialog(" INGRESE EL id del curso que desea eliminar"));
        int posicion = buscarPosicionIdUsuario(idUsuario);
        misUsuarios.remove(posicion);
    }
    public void buscarUsuario(){
        int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("ingrese el id del usuario que desea buscar"));
        int posicion = buscarPosicionIdUsuario(idUsuario);
        Usuario c = misUsuarios.get(posicion);
        JOptionPane.showConfirmDialog(null,c.toString());
    }
    public void cargaPreviaDeUsuarios(){}
}

