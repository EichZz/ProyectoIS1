
package Aplicacion;

import java.util.*;


public class Alumno {

    private String nombre;
    private String apellidos;
    private String dni;
    private int grupo_de_EPD;
    private List<Nota> listaNotas;

    public Alumno() {}

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
        return "Alumno: " + "Nombre: " + nombre + " " + apellidos
                + ".\nDNI: " + dni + 
                " Grupo de EPD: " + grupo_de_EPD + ".\n";
    }

    public boolean addNota(Nota n) {
        boolean add = listaNotas.add(n);
        return add;
    }
    
    public Nota getNota(Prueba p){
        Iterator<Nota> it = listaNotas.listIterator();
        boolean enc = false;
        Nota n = null;
        while(it.hasNext() && !enc){
            Nota aux = it.next();
            if(p == aux.getPrueba()){
                enc = true;
                n = aux;
            }
        }
        return n; 
    }
}
