package Aplicacion;

import java.util.*;
import edi.io.*;

public class Controladora {

    private Grupo grupoActual;
    private Alumno alumnoActual;
    private Asignatura asignatura;
    private Nota notaActual;
    private Prueba pruebaActual;

    public Controladora() {
        asignatura = new Asignatura("Asignatura");
    }

    public Controladora(String test) {
        asignatura = new Asignatura();
    }

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
//CU02-Consultar Prueba

    public String consultaPruebas() {
        Iterator<Prueba> it = asignatura.getPruebas();

        String s = "\nPruebas de la asignatura:\n";
        while (it.hasNext()) {
            Prueba aux = it.next();
            s += aux.toString() + "\n";
        }
        if (s.equals("\nPruebas de la asignatura:\n")) { //Flujo Alternativo 1
            return "No existen pruebas\n";
        } else {
            return s;
        }
    }
//CU03-Añadir Alumno

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
        asignatura.getListaAlumnos().sort(new ComparadorAlumno());
    }
//CU04-Añadir Nota Alumno

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
//CU05-Añadir Nota Clase

    public void añadirNotaClase() {
    }

    public void seleccionarPrueba(int id_prueba) {
        pruebaActual = asignatura.getPrueba(id_prueba);
    }

    public void introducirDatosNota(double nota) {
        notaActual = new Nota();
        notaActual.setCalificacion(nota);
        notaActual.setPrueba(pruebaActual);
        alumnoActual.addNota(notaActual);
    }
//CU06-Crear Grupo

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
//CU07-Añadir Nota Grupo

    public void añadirNotaGrupo() {
    }

    public void seleccionarGrupo(int id_grupo) {
        grupoActual = asignatura.getGrupo(id_grupo);
    }

    public void introducirNotaGrupo(int id_prueba, double nota) {
        pruebaActual = asignatura.getPrueba(id_prueba);
        Iterator<Alumno> it = grupoActual.getAlumnos();

        while (it.hasNext()) {
            alumnoActual = it.next();
            notaActual = new Nota(pruebaActual, nota);
            alumnoActual.addNota(notaActual);
        }
    }
//CU08-Consulta Alumno

    public void consultaAlumno() {
    }

    public String seleccionarAlumno(String dni) {
        alumnoActual = asignatura.getAlumno(dni);
        
        while (alumnoActual == null) { //Flujo Alternativo 1
            System.out.println("DNI Incorrecto. Introduzca un DNI válido: ");

            dni = IO.readLine();
            alumnoActual = asignatura.getAlumno(dni);
        }
            
        String s = alumnoActual.mostrarAlumno() + "\nPruebas y calificaciones:\n\n";

        Iterator<Nota> it = alumnoActual.getNotas();
        double total = 0;
        while (it.hasNext()) {
            notaActual = it.next();
            s += notaActual.mostrarNota() + "\n\n";
            total += notaActual.getCalificacion() * (notaActual.getPrueba().getPorcentaje() / 100);
        }
        return s += "Nota completa: " + total + "\n";
    }
//CU09-Consulta Grupo

    public String consultaGrupo() {

        Iterator<Prueba> it = asignatura.getPruebas();

        String s = "\t\t\t\t\t";

        while (it.hasNext()) {
            Prueba p = it.next();
            s += p.getNombre() + "\t";
        }

        s += "Nota Final";
        String auxfa = new String(s);
        Iterator<Alumno> it2 = asignatura.getAlumnos();
        while (it2.hasNext()) {
            String aux = "";
            Alumno a = it2.next();
            aux += a.getApellidos() + " " + a.getNombre();
            for (int i = 40 - aux.length(); i > 0; i--) {
                aux += " ";
            }
            s += "\n" + aux;
            Iterator<Nota> it3 = a.getNotas();
            double total = 0;
            while (it3.hasNext()) {
                Nota n = it3.next();
                s += n.getCalificacion() + "\t\t";
                total += n.getCalificacion() * (n.getPrueba().getPorcentaje() / 100);
            }
            s += total;
        }
        if (s.equals(auxfa)) { //Flujo Alternativo 1
            return "No existen alumnos\n";
        } else {
            return s;
        }
    }
//fin

    public Grupo getGrupoActual() {
        return grupoActual;
    }

    public void setGrupoActual(Grupo grupoActual) {
        this.grupoActual = grupoActual;
    }

    public Alumno getAlumnoActual() {
        return alumnoActual;
    }

    public void setAlumnoActual(Alumno alumnoActual) {
        this.alumnoActual = alumnoActual;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Nota getNotaActual() {
        return notaActual;
    }

    public void setNotaActual(Nota notaActual) {
        this.notaActual = notaActual;
    }

    public Prueba getPruebaActual() {
        return pruebaActual;
    }

    public void setPruebaActual(Prueba pruebaActual) {
        this.pruebaActual = pruebaActual;
    }
}
