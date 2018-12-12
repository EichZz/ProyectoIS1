package Aplicacion;

import java.util.*;

public class Alumno implements Comparable {

    private String nombre;
    private String apellidos;
    private String dni;
    private int grupo_de_EPD;
    private List<Nota> listaNotas;

    public Alumno() {
    }

    public Alumno(String nombre, String apellidos, String dni, int grupo_de_EPD) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.grupo_de_EPD = grupo_de_EPD;
        listaNotas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getGrupo_de_EPD() {
        return grupo_de_EPD;
    }

    public void setGrupo_de_EPD(int grupo_de_EPD) {
        this.grupo_de_EPD = grupo_de_EPD;
    }

    public String mostrarAlumno() {
        return toString();
    }

    public Iterator getNotas() {
        return listaNotas.iterator();
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellidos
                + "\nDNI: " + dni
                + "\nGrupo de EPD: " + grupo_de_EPD + ".\n";
    }

    public boolean addNota(Nota n) {
        boolean add = listaNotas.add(n);
        return add;
    }

    public Nota getNota(Prueba p) {
        Iterator<Nota> it = listaNotas.listIterator();
        boolean enc = false;
        Nota n = null;
        while (it.hasNext() && !enc) {
            Nota aux = it.next();
            if (p == aux.getPrueba()) {
                enc = true;
                n = aux;
            }
        }
        return n;
    }

    @Override
    public int compareTo(Object t) {
        Alumno a = (Alumno) t;
        int res = this.apellidos.compareTo(a.apellidos);
        if (res == 0) {
            res = this.nombre.compareTo(a.nombre);
        }
        if (res == 0) {
            res = this.dni.compareTo(a.dni);
        }
        return res;
    }
    
}
