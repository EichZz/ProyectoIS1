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
    
    private List<Alumno> listaAlumnosGrupo;
    private int id_Grupo;
    private int nAlumnos;

    public Grupo() {
        listaAlumnosGrupo = new ArrayList();
    }

    
    public void setId_Grupo(int id_Grupo) {
        this.id_Grupo = id_Grupo;
    }

    public void setNumero(int numero) {
        this.nAlumnos = numero;
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
