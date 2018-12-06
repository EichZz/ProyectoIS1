package Aplicacion;

import java.util.*;

public class Asignatura {

    private String nombre;
    private List<Alumno> ListaAlumnos;
    private List<Grupo> ListaGrupos;
    private List<Prueba> ListaPruebas;

    public Asignatura(String nombre) {

        this.nombre = nombre;
        ListaAlumnos = new ArrayList<>();
        ListaGrupos = new ArrayList<>();
        ListaPruebas = new ArrayList<>();
    }

    public boolean addPrueba(Prueba p) {
        return ListaPruebas.add(p);
    }

    public boolean addAlumno(Alumno a) {
        return ListaAlumnos.add(a);
    }

    public boolean addGrupo(Grupo g) {
        return ListaGrupos.add(g);
    }

    public Prueba getPrueba(int id_prueba) {
        Iterator<Prueba> it = ListaPruebas.listIterator();
        boolean enc = false;
        Prueba p = null;
        while (it.hasNext() && !enc) {
            Prueba aux = it.next();
            if (id_prueba == aux.getId_Prueba()) {
                enc = true;
                p = aux;
            }
        }
        return p;
    }

    public Iterator getPruebas() {
        Iterator<Prueba> it = ListaPruebas.listIterator();
        return it;
    }
    
    public Iterator getAlumnos(){
        Iterator<Alumno> it = ListaAlumnos.listIterator();
        return it;
    }

    public Alumno getAlumno(String dni) {
        Iterator<Alumno> it = ListaAlumnos.listIterator();
        boolean enc = false;
        Alumno a = null;
        while (it.hasNext() && !enc) {
            Alumno aux = it.next();
            if (dni.equals(aux.getDni())) {
                enc = true;
                a = aux;
            }
        }
        return a;
    }

    public Grupo getGrupo(int id_grupo) {
        Iterator<Grupo> it = ListaGrupos.listIterator();
        boolean enc = false;
        Grupo g = null;
        while (it.hasNext() && !enc) {
            Grupo aux = it.next();
            if (id_grupo == aux.getId_Grupo()) {
                enc = true;
                g = aux;
            }
        }
        return g;
    }
}
