/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Aplicacion.Alumno;
import Aplicacion.Controladora;
import Aplicacion.Nota;
import Aplicacion.Prueba;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hecto
 */
public class PantallaTest {

    public PantallaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of AñadirPruebasEvaluables method, of class Pantalla.
     */
    @Test
    public void testAñadirPruebasEvaluables() {
        System.out.println("AnadirPruebasEvaluables");
        Controladora c = new Controladora();
        c.añadirPrueba();
        c.introducirDatosPrueba(0, "EPD1", "PrimeraEPD", 30, "EPD");

        assertTrue((c.getPruebaActual().getId_Prueba() == 0)
                && c.getPruebaActual().getNombre().equals("EPD1")
                && c.getPruebaActual().getDescripcion().equals("PrimeraEPD")
                && c.getPruebaActual().getPorcentaje() == 30
                && c.getPruebaActual().getTipo_de_prueba().equals("EPD"));

        c.confirmarPrueba();
        assertTrue(c.getPruebaActual().equals(c.getAsignatura().getPrueba(0)));
    }

    /**
     * Test of ConsultaPruebasEvaluables method, of class Pantalla.
     */
    @Test
    public void testConsultaPruebasEvaluables() {
        Controladora c = new Controladora();
        c.añadirPrueba();
        c.introducirDatosPrueba(0, "EPD1", "PrimeraEPD", 30, "EPD");
        c.confirmarPrueba();

        String s = c.consultaPruebas();
        assertTrue(s.equals(c.getAsignatura().getPrueba(0).toString() + "\n"));

    }

    /**
     * Test of AñadirDatosAlumnos method, of class Pantalla.
     */
    @Test
    public void testAñadirDatosAlumnos() {
        System.out.println("AnadirDatosAlumnos");
        Controladora c = new Controladora();
        c.añadirAlumno();
        c.introducirDatosAlumnos("Pepe", "Gracia", "111111111", 1);
        assertTrue((c.getAlumnoActual().getNombre().equals("Pepe"))
                && c.getAlumnoActual().getApellidos().equals("Gracia")
                && c.getAlumnoActual().getDni().equals("111111111")
                && c.getAlumnoActual().getGrupo_de_EPD() == 1);
        
        c.añadirAlumno();
        assertTrue(c.getAlumnoActual().equals(c.getAsignatura().getAlumno("111111111")));
    }

    /**
     * Test of IntroducirNotaAlumno method, of class Pantalla.
     */
    @Test
    public void testIntroducirNotaAlumno() {
        System.out.println("IntroducirNotaAlumno");
        Pantalla instance = new Pantalla();
        instance.IntroducirNotaAlumno();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of IntroducirNotaClase method, of class Pantalla.
     */
    @Test
    public void testIntroducirNotaClase() {
        System.out.println("IntroducirNotaClase");
        Controladora c = new Controladora();
        c.añadirPrueba();
        c.introducirDatosPrueba(0, "EPD1", "PrimeraEPD", 30, "EPD");

        c.añadirNotaClase();
        c.seleccionarPrueba(0);

        Iterator<Alumno> it = c.getAsignatura().getAlumnos();
        double calificacion;
        while (it.hasNext()) {
            c.setAlumnoActual(it.next());
            System.out.println(c.getAlumnoActual().toString());
            System.out.println("Introduzca la nota del alumno: ");
            calificacion = 4;
            //IntroducirDatosNota
            c.setNotaActual(new Nota());
            c.getNotaActual().setCalificacion(calificacion);
            c.getNotaActual().setPrueba(c.getPruebaActual());
            c.getAlumnoActual().addNota(c.getNotaActual());

            Alumno aux = c.getAsignatura().getAlumno(c.getAlumnoActual().getDni());
            assertTrue(aux.getNota(c.getAsignatura().getPrueba(0)).getCalificacion() == 4);
        }
    }

    /**
     * Test of CrearGruposTrabajo method, of class Pantalla.
     */
    @Test
    public void testCrearGruposTrabajo() {
        System.out.println("CrearGruposTrabajo");
        Pantalla instance = new Pantalla();
        instance.CrearGruposTrabajo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of IntroducirNotaGrupo method, of class Pantalla.
     */
    @Test
    public void testIntroducirNotaGrupo() {
        System.out.println("IntroducirNotaGrupo");
        Pantalla instance = new Pantalla();
        instance.IntroducirNotaGrupo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ConsultaAlumno method, of class Pantalla.
     */
    @Test
    public void testConsultaAlumno() {

        System.out.println("ConsultaAlumno");
        Controladora c = new Controladora();

        c.consultaAlumno();
        String s = c.seleccionarAlumno("123");
    }

    /**
     * Test of ConsultaGrupo method, of class Pantalla.
     */
    @Test
    public void testConsultaGrupo() {
        System.out.println("ConsultaGrupo");
        Pantalla instance = new Pantalla();
        instance.ConsultaGrupo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
