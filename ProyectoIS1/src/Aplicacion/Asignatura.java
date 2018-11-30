/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import java.util.ArrayList;
import java.util.List;


public class Asignatura {
    
    private String nombre;
    private List<Alumno> ListaAlumnos;
    private List<Grupo> ListaGrupos;
    private List<Prueba> ListaPruebas;
    
    public Asignatura(String nombre){
        
        this.nombre = nombre;
        ListaAlumnos = new ArrayList<>();
        ListaGrupos = new ArrayList<>();
        ListaPruebas = new ArrayList<>();
    }
    
    public void addPrueba(Prueba p){
        
    }
    
    
}
