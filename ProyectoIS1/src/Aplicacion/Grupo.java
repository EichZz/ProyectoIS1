
package Aplicacion;

import java.util.*;

public class Grupo {
    
    private List<Alumno> listaAlumnosGrupo;
    private int id_Grupo;
    private int nAlumnos;

    public Grupo() {
        listaAlumnosGrupo = new ArrayList();
    }

    public int getId_Grupo() {
        return id_Grupo;
    }

    public void setId_Grupo(int id_Grupo) {
        this.id_Grupo = id_Grupo;
    }

    public void setNumero(int numero) {
        this.nAlumnos = numero;
    }

    public int getnAlumnos() {
        return nAlumnos;
    }

    public Iterator getAlumnos() {
        return listaAlumnosGrupo.iterator();
    }
    
    
    
    public void mostrarGrupo(){
        toString();
    }
    
    public boolean addAlumno(Alumno a){
        return listaAlumnosGrupo.add(a);
    }
    
    public String toString(){
        Iterator<Alumno> it = listaAlumnosGrupo.iterator();
        String s = "";
        while(it.hasNext()){
            Alumno a = it.next();
            s += "" + a;
        }
        return s;
    }
}
