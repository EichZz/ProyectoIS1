package Aplicacion;

import java.util.*;

public class Controladora {

    private Grupo grupoActual;
    private Alumno alumnoActual;
    private Asignatura asignatura;
    private Nota notaActual;
    private Prueba pruebaActual;

    public void añadirPrueba() {
        pruebaActual = new Prueba();
    }

    public void introducirDatosPrueba(int id_prueba, String nomb, String desc, double porc, String tipo_prueba) {
        pruebaActual.setDescripcion(desc);
        pruebaActual.setId_Prueba(id_prueba);
        pruebaActual.setNombre(nomb);
        pruebaActual.setPorcentaje(porc);
        pruebaActual.setTipo_de_prueba(tipo_prueba);
    }

    public String mostrarPrueba() {
        return pruebaActual.toString();
    }

    public void confirmarPrueba() {
        asignatura.addPrueba(pruebaActual);
    }

    public String consultaPruebas() {
        Iterator<Prueba> it = asignatura.getPruebas();
        String s = "";
        while (it.hasNext()) {
            Prueba aux = it.next();
            s += aux.toString() + "\n";
        }
        return s;
    }

    public void añadirAlumno() {
        alumnoActual = new Alumno();
    }

    public void introducirDatosAlumnos(String nom, String apellidos, String dni, int grupoEPD) {
        alumnoActual.setNombre(nom);
        alumnoActual.setApellidos(apellidos);
        alumnoActual.setDni(dni);
        alumnoActual.setGrupo_de_EPD(grupoEPD);
    }

    public String mostrarAlumno() {
        return alumnoActual.toString();
    }

    public void confirmarAlumno() {
        asignatura.addAlumno(alumnoActual);
    }

    public void añadirNotaAlumno() {

        notaActual = new Nota();
    }

    public void introducirDatosNota(int id_prueba, String dni, double nota) {
        pruebaActual = asignatura.getPrueba(id_prueba);
        notaActual.setPrueba(pruebaActual);
        alumnoActual = asignatura.getAlumno(dni);
        notaActual.setCalificacion(nota);
    }

    public String mostrarNota() {
        return notaActual.toString();
    }

    public void confirmarNotaAlumno() {

        alumnoActual.addNota(notaActual);
    }

    public void añadirNotaClase() {}

    public void seleccionarPrueba(int id_prueba) {

        pruebaActual = asignatura.getPrueba(id_prueba);
    }

    public void introducirDatosNota(double nota) {

        Iterator<Alumno> it = asignatura.getAlumnos();
        
        while(it.hasNext()){
            mostrarAlumno();
            añadirNotaAlumno();
            notaActual.setPrueba(pruebaActual);
            notaActual.setCalificacion(nota);
            mostrarNota();
            confirmarNota();
        }
    }

    public void confirmarNota() {
        alumnoActual.addNota(notaActual);
    }

    public void crearGrupoTrabajo() {
        grupoActual = new Grupo();
    }

    public void introducirDatosGrupo(int id_grupo, int numero) {
        grupoActual.setId_Grupo(id_grupo);
        grupoActual.setNumero(numero);
    }

    public void introducirDNIAlumno(String dni) {
        alumnoActual = asignatura.getAlumno(dni);
        grupoActual.addAlumno(alumnoActual);
    }

    public String mostrarGrupo() {
        return grupoActual.toString();
    }

    public void confirmarGrupo() {
        asignatura.addGrupo(grupoActual);
    }

    public void añadirNotaGrupo() {
    }

    public void seleccionarGrupo(int id_grupo) {
        grupoActual = asignatura.getGrupo(id_grupo);
    }

    public void introducirNotaGrupo(int id_prueba, double nota) {
        pruebaActual = asignatura.getPrueba(id_prueba);
        Iterator<Alumno> it = grupoActual.getAlumnos();
        
        while(it.hasNext()){
            alumnoActual = it.next();
            System.out.println(alumnoActual.mostrarAlumno());
            notaActual = new Nota(pruebaActual, nota);
            System.out.println(notaActual.mostrarNota());
            alumnoActual.addNota(notaActual);  
        }

    }

    public void confirmarNotaGrupo() {
    }

    public String consultaAlumno() {
        
        Iterator<Alumno> it = asignatura.getAlumnos();
        
        String s = "";
        
        while(it.hasNext()){
            Alumno a = it.next();
            seleccionarAlumno(a.getDni());
            mostrarNota();
            s += a.toString() + "\n";
        }
        return s;
    }

    public void seleccionarAlumno(String dni) {
        
        alumnoActual = asignatura.getAlumno(dni);
    }

    public String consultaGrupo() {
        
        Iterator<Prueba> it = asignatura.getPruebas();
        
        String s = "";
        
        while(it.hasNext()){
            Prueba p = it.next();
            mostrarPrueba();
            
            Iterator<Alumno> it2 = asignatura.getAlumnos();
            while(it2.hasNext()){
                Alumno a = it2.next();
                mostrarAlumno();
                mostrarNota();
                s += a.toString() + "\n";
            }
        }
        return s;
    }
}
