/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import java.util.Comparator;

/**
 *
 * @author juani_000
 */
public class ComparadorAlumno implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Alumno a1 = (Alumno) o1;
        Alumno a2 = (Alumno) o2;
        int res = a1.getApellidos().compareTo(a2.getApellidos());
        if (res == 0) {
            res = a1.getNombre().compareTo(a2.getNombre());
        }
        if (res == 0) {
            res = a1.getDni().compareTo(a2.getDni());
        }
        return res;
    }
    
}
