/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Aplicacion.Alumno;
import Aplicacion.Controladora;
import Aplicacion.Grupo;
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
        Controladora c = new Controladora("test");
        c.añadirPrueba();
        c.introducirDatosPrueba(0, "EPD1", "PrimeraEPD", 30, "EPD");
        c.confirmarPrueba();

        String aux = c.consultaPruebas();
        String s = "\nPruebas de la asignatura:\n";
        Iterator<Prueba> it = c.getAsignatura().getPruebas();
        while (it.hasNext()) {
            Prueba p = it.next();
            s += p.toString() + "\n";
        }
        assertTrue(s.equals(aux));
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

        c.confirmarAlumno();
        assertTrue(c.getAlumnoActual().equals(c.getAsignatura().getAlumno("111111111")));
    }

    /**
     * Test of IntroducirNotaAlumno method, of class Pantalla.
     */
    @Test
    public void testIntroducirNotaAlumno() {
        System.out.println("IntroducirNotaAlumno");
        Controladora c = new Controladora();

        c.añadirPrueba();
        c.introducirDatosPrueba(4, "EPD1", "PrimeraEPD", 30, "EPD");
        c.confirmarPrueba();

        c.añadirAlumno();
        c.introducirDatosAlumnos("Pepe", "Gracia", "111111111", 1);
        c.confirmarAlumno();

        c.añadirNotaAlumno();
        c.introducirDatosNota(4, "111111111", 7.5);
        c.confirmarNotaAlumno();
        assertTrue(c.getAsignatura().getAlumno("111111111").getNota(c.getAsignatura().getPrueba(4)).getCalificacion() == 7.5);
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
        Controladora c = new Controladora();

        c.setGrupoActual(new Grupo());

        int id = 4;
        int n = 3;

        c.getGrupoActual().setId_Grupo(id);
        c.getGrupoActual().setNumero(n);

        //Introduzco alumnos
        c.setAlumnoActual(new Alumno());
        String dni1 = "11111";
        c.getAlumnoActual().setDni(dni1);
        c.getGrupoActual().addAlumno(c.getAlumnoActual());
        assertTrue(c.getAlumnoActual().equals(c.getGrupoActual().getAlumno(dni1)));

        c.setAlumnoActual(new Alumno());
        String dni2 = "22222";
        c.getAlumnoActual().setDni(dni2);
        c.getGrupoActual().addAlumno(c.getAlumnoActual());
        assertTrue(c.getAlumnoActual().equals(c.getGrupoActual().getAlumno(dni2)));

        c.setAlumnoActual(new Alumno());
        String dni3 = "33333";
        c.getAlumnoActual().setDni(dni3);
        c.getGrupoActual().addAlumno(c.getAlumnoActual());
        assertTrue(c.getAlumnoActual().equals(c.getGrupoActual().getAlumno(dni3)));

        c.confirmarGrupo();
        assertTrue(c.getGrupoActual().equals(c.getAsignatura().getGrupo(id)));
    }

    /**
     * Test of IntroducirNotaGrupo method, of class Pantalla.
     */
    @Test
    public void testIntroducirNotaGrupo() {
        Controladora c = new Controladora("test");

        c.setGrupoActual(new Grupo());

        int id = 4;
        int n = 3;

        c.getGrupoActual().setId_Grupo(id);
        c.getGrupoActual().setNumero(n);

        c.setAlumnoActual(new Alumno());
        String dni1 = "11111";
        c.getAlumnoActual().setDni(dni1);
        c.getGrupoActual().addAlumno(c.getAlumnoActual());
        c.getAsignatura().addAlumno(c.getAlumnoActual());

        c.setAlumnoActual(new Alumno());
        String dni2 = "22222";
        c.getAlumnoActual().setDni(dni2);
        c.getGrupoActual().addAlumno(c.getAlumnoActual());
        c.getAsignatura().addAlumno(c.getAlumnoActual());

        c.setAlumnoActual(new Alumno());
        String dni3 = "33333";
        c.getAlumnoActual().setDni(dni3);
        c.getGrupoActual().addAlumno(c.getAlumnoActual());
        c.getAsignatura().addAlumno(c.getAlumnoActual());

        c.confirmarGrupo();

        c.añadirPrueba();
        c.introducirDatosPrueba(4, "EPD1", "PrimeraEPD", 30, "EPD");
        c.confirmarPrueba();

        c.añadirNotaGrupo();
        c.seleccionarGrupo(id);
        c.introducirNotaGrupo(4, 5.6);

        assertTrue(c.getAsignatura().getAlumno("11111").getNota(c.getAsignatura().getPrueba(4)).getCalificacion() == 5.6);
        assertTrue(c.getAsignatura().getAlumno("22222").getNota(c.getAsignatura().getPrueba(4)).getCalificacion() == 5.6);
        assertTrue(c.getAsignatura().getAlumno("33333").getNota(c.getAsignatura().getPrueba(4)).getCalificacion() == 5.6);
    }

    /**
     * Test of ConsultaAlumno method, of class Pantalla.
     */
    @Test
    public void testConsultaAlumno() {
        System.out.println("Consulta Alumno");
        Controladora c = new Controladora();

        c.añadirPrueba();
        c.introducirDatosPrueba(4, "EPD1", "PrimeraEPD", 30, "EPD");
        c.confirmarPrueba();

        c.añadirAlumno();
        c.introducirDatosAlumnos("Pepe", "Gracia", "111111111", 1);
        c.confirmarAlumno();

        c.añadirNotaAlumno();
        c.introducirDatosNota(4, "111111111", 7.5);
        c.confirmarNotaAlumno();

        String aux = c.seleccionarAlumno("111111111");

        String s = c.getAlumnoActual().mostrarAlumno() + "\nPruebas y calificaciones:\n\n";

        Iterator<Nota> it = c.getAlumnoActual().getNotas();
        double total = 0;
        while (it.hasNext()) {
            c.setNotaActual(it.next());
            s += c.getNotaActual().mostrarNota() + "\n\n";
            total += c.getNotaActual().getCalificacion() * (c.getNotaActual().getPrueba().getPorcentaje() / 100);
        }
        s += "Nota completa: " + total + "\n";

        assertTrue(s.equals(aux));
    }

    /**
     * Test of ConsultaGrupo method, of class Pantalla.
     */
    @Test
    public void testConsultaGrupo() {
        System.out.println("ConsultaGrupo");
        Controladora c = new Controladora();
        String saux = c.consultaGrupo();
        Iterator<Prueba> it = c.getAsignatura().getPruebas();

        String s = "\t\t\t\t\t";

        while (it.hasNext()) {
            Prueba p = it.next();
            s += p.getNombre() + "\t";
        }

        s += "Nota Final";

        Iterator<Alumno> it2 = c.getAsignatura().getAlumnos();
        while (it2.hasNext()) {
            String aux = "";
            Alumno a = it2.next();
            aux += a.getApellidos() + " " + a.getNombre();
            for (int i = 40 - aux.length(); i > 0; i--) {
                aux += " ";
            }
            s += "\n" + aux;
            Iterator<Nota> it3 = a.getNotas();
            double total = 0;
            while (it3.hasNext()) {
                Nota n = it3.next();
                s += n.getCalificacion() + "\t\t";
                total += n.getCalificacion() * (n.getPrueba().getPorcentaje() / 100);
            }
            s += total;
        }
        assertTrue(s.equals(saux));

    }
}
