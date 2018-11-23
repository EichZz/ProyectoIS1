/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;
import java.util.*;
/**
 *
 * @author hecto
 */
public class Alumno {
    private String nombre;
    private String apellidos;
    private String dni;
    private int grupo_de_EPD;
    private List listaNotas;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setGrupo_de_EPD(int grupo_de_EPD) {
        this.grupo_de_EPD = grupo_de_EPD;
    }

    @Override
    public String toString() {
        return "Alumno: " + "nombre: " + nombre + ", apellidos: " + apellidos + ", dni: " + dni + ", grupo_de_EPD: " + grupo_de_EPD ;
    }
    
    public String mostrarAlumno(){
        return toString();
    }

    public boolean addNota(Nota n){
        boolean add = listaNotas.add(n);
        return add;
    }
    
}
