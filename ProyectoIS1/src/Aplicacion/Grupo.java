/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grupo {
    
    List listaAlumnosGrupo = new ArrayList();
    int id_Grupo;
    int nAlumnos;

    public void setId_Grupo(int id_Grupo) {
        this.id_Grupo = id_Grupo;
    }

    public void setnAlumnos(int nAlumnos) {
        this.nAlumnos = nAlumnos;
    }
    
    public void mostrarGrupo(){
        toString();
    }
    
    public boolean addAlumno(Alumno a){
        return listaAlumnosGrupo.add(a);
    }
    
    public String toString(){
        Iterator it = listaAlumnosGrupo.iterator();
        String s = "";
        while(it.hasNext()){
            Grupo g = (Grupo) it.next();
            s += "" + g;
        }
        return s;
    }
}
