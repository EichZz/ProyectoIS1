/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

/**
 *
 * @author hecto
 */
public class Controladora {

    private Grupo grupoActual;
    private Alumno alumnoActual;
    private Asignatura asignatura;
    private Nota notaActual;
    private Prueba pruebaActual;

    public Prueba añadirPrueba() {
        pruebaActual = new Prueba();
        return pruebaActual;
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

    public void mostrarPruebas() {
    }

    public void añadirAlumno() {
    }

    public void introducirDatosAlumnos(String nom, String apellidos, String dni, int grupoEPD) {
    }

    public void mostrarAlumno() {
    }

    public void confirmarAlumno() {
    }

    public void añadirNotaAlumno() {
    }

    public void introducirDatosNota(int id_prueba, String dni, Nota nota) {
    }

    public void mostrarNota() {
    }

    public void confirmarNotaAlumno() {
    }

    public void añadirNotaClase() {
    }

    public void seleccionarPrueba(int id_prueba) {
    }

    public void introducirDatosNota(Nota nota) {
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
