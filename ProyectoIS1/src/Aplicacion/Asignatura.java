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
        //Inicializar la asignatura para poder hacer uso de la aplicación
        Prueba epd1 = new Prueba(1, "EPD Eval 1", "Primer parcial", 20.0, "Evaluacion continua");
        Prueba epd2 = new Prueba(2, "EPD Eval 2", "Segundo parcial", 30.0, "Evaluacion continua");
        Prueba conv = new Prueba(3, "Convocatoria", "Examen de enero", 50.0, "Evaluacion final");
        ListaPruebas.add(epd1);
        ListaPruebas.add(epd2);
        ListaPruebas.add(conv);
        Alumno a1 = new Alumno("Ana", "Perez Gomez", "34895017F", 1);
        Nota n11 = new Nota(epd1, 10);
        Nota n12 = new Nota(epd2, 10);
        Nota n1c = new Nota(conv, 10);
        a1.addNota(n11);
        a1.addNota(n12);
        a1.addNota(n1c);
        Alumno a2 = new Alumno("Paco", "Gonzalez Burgos", "60139345Y", 1);
        Nota n21 = new Nota(epd1, 7.5);
        Nota n22 = new Nota(epd2, 5);
        Nota n2c = new Nota(conv, 3);
        a2.addNota(n21);
        a2.addNota(n22);
        a2.addNota(n2c);
        Alumno a3 = new Alumno("Maria", "Fernandez Carmona", "73904457S", 2);
        Nota n31 = new Nota(epd1, 9);
        Nota n32 = new Nota(epd2, 8.5);
        Nota n3c = new Nota(conv, 6.75);
        a3.addNota(n31);
        a3.addNota(n32);
        a3.addNota(n3c);
        ListaAlumnos.add(a1);
        ListaAlumnos.add(a2);
        ListaAlumnos.add(a3);
        ListaAlumnos.sort(new ComparadorAlumno());
        Grupo g = new Grupo();
        g.setId_Grupo(1);
        g.setNumero(3);
        g.addAlumno(a1);
        g.addAlumno(a2);
        g.addAlumno(a2);
        ListaGrupos.add(g);
    }

    public Asignatura() {
        this.nombre = "Adignatura para tests";
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

    public List<Alumno> getListaAlumnos() {
        return ListaAlumnos;
    }
    
    
}
