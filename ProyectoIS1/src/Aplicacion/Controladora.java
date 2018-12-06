
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
    
    public String mostrarPrueba(){
        return pruebaActual.toString();
    }

    public void confirmarPrueba() {
       asignatura.addPrueba(pruebaActual);
    }

    public void consultaPruebas() {
    asignatura.getPruebas();
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
        
        notaActual.mostrarNota();
        alumnoActual.addNota(notaActual);
    }

    public void añadirNotaClase() {
    }

    public void seleccionarPrueba(int id_prueba) {
        
        pruebaActual = asignatura.getPrueba(id_prueba);
    }

    public void introducirDatosNota(double nota) {
        
        Iterator<Alumno> it = (Iterator<Alumno>) asignatura.getAlumnos();
    }

    public void confirmarNota() {
    }

    public void crearGrupoTrabajo() {
    }

    public void introducirDatosGrupo(int id_grupo, int numero) {
    }

    public void introducirDNIAlumno(String dni) {
    }

    public void mostrarGrupo() {
    }

    public void confirmarGrupo() {
    }

    public void añadirNotaGrupo() {
    }

    public void seleccionarGrupo(int id_grupo) {
    }

    public void introducirNotaGrupo(int id_prueba, Nota nota) {
    }

    public void confirmarNotaGrupo() {
    }

    public void consultaAlumno() {
    }

    public void seleccionarAlumno(int dni) {
    }

    public void consultaGrupo() {
    }
}
