package Vista;

import Aplicacion.Alumno;
import Aplicacion.Controladora;
import java.util.Iterator;
import edi.io.*;

public class Pantalla {

    private Controladora controladora;

    public Pantalla() {
        controladora = new Controladora();
    }

    public void AñadirPruebasEvaluables() { //CU01
        controladora.añadirPrueba();


        System.out.println("Introduzca el ID de la prueba: ");
        int id =(int) IO.readNumber();
        System.out.println("Introduzca el nombre de la prueba: ");
        String nom = IO.readLine();
        System.out.println("Introduzca la descripción de la prueba: ");
        String desc = IO.readLine();
        System.out.println("Introduzca el porcentaje de la prueba: ");
        double porc = IO.readNumber();
        System.out.println("Introduzca el tipo de prueba: ");
        String tipo = IO.readLine();

        controladora.introducirDatosPrueba(id, nom, desc, porc, tipo);

        System.out.println(controladora.mostrarPrueba()
                + "\n¿Desea confirmar la prueba?"
                + "\n\t1. Sí"
                + "\n\t0. No");
        int opc =(int) IO.readNumber();
        if (opc == 1) {
            controladora.confirmarPrueba();
            System.out.println("La prueba se añadió con éxito");
        } else {
            System.out.println("Operación cancelada"); //Flujo Alternativo 1
        }
    }

    public void ConsultaPruebasEvaluables() {//CU02
        System.out.println(controladora.consultaPruebas()); //Flujo alternativo dentro del método
    }

    public void AñadirDatosAlumnos() {//CU03
        controladora.añadirAlumno();

        System.out.println("Introduzca el nombre del alumno: ");
        String nom = IO.readLine();
        System.out.println("Introduzca los apellidos del alumno: ");
        String apell = IO.readLine();
        System.out.println("Introduzca el DNI del alumno: ");
        String dni = IO.readLine();
        System.out.println("Introduzca el grupo de EPD: ");
        int epd =(int) IO.readNumber();

        controladora.introducirDatosAlumnos(nom, apell, dni, epd);

        System.out.println(controladora.mostrarAlumno()
                + "\n¿Desea confirmar el alumno?"
                + "\n\t1. Sí"
                + "\n\t0. No");
        int opc =(int) IO.readNumber();
        if (opc == 1) {
            controladora.confirmarAlumno();
            System.out.println("El alumno se añadió con éxito");
        } else {
            System.out.println("Operación cancelada"); //Flujo Alternativo 1
        }
    }

    public void IntroducirNotaAlumno() {//CU04
        controladora.añadirNotaAlumno();

        
        System.out.println("Introduzca el ID de la prueba: ");
        int id =(int) IO.readNumber();
        System.out.println("Introduzca el DNI del alumno: ");
        String dni = IO.readLine();
        System.out.println("Introduzca la calificacion: ");
        double calif = IO.readNumber();

        controladora.introducirDatosNota(id, dni, calif);

        while (controladora.getAlumnoActual() == null) { //Flujo Alternativo 2
            System.out.println("DNI Incorrecto. Introduzca un DNI válido: ");
            dni = IO.readLine();
            controladora.introducirDatosNota(id, dni, calif);
        }

        System.out.println(controladora.mostrarNota()
                + "\n¿Desea confirmar la nota del alumno?"
                + "\n\t1. Sí"
                + "\n\t0. No");
        int opc =(int) IO.readNumber();
        if (opc == 1) {
            controladora.confirmarNotaAlumno();
            System.out.println("La nota se añadió al alumno con éxito");
        } else {
            System.out.println("Operación cancelada"); //Flujo Alternativo 1
        }
    }

    public void IntroducirNotaClase() {//CU05
        controladora.añadirNotaClase();

        
        System.out.println("Introduzca el ID de la prueba: ");
        int id =(int) IO.readNumber();
        controladora.seleccionarPrueba(id);

        Iterator<Alumno> it = controladora.getAsignatura().getAlumnos();
        double calificacion;
        while (it.hasNext()) {
            controladora.setAlumnoActual(it.next());
            System.out.println(controladora.getAlumnoActual().toString());
            System.out.println("Introduzca la nota del alumno: ");
            calificacion = IO.readNumber();
            controladora.introducirDatosNota(calificacion);
        }
    }

    public void CrearGruposTrabajo() {//CU06
        controladora.crearGrupoTrabajo();

        
        System.out.println("Introduzca el ID del grupo: ");
        int id =(int) IO.readNumber();
        System.out.println("Introduzca el numero de alumnos del grupo: ");
        int n =(int) IO.readNumber();

        controladora.introducirDatosGrupo(id, n);

        for (int i = 0; i < n; i++) {
            System.out.println("Introduzca el DNI del siguiente alumno: ");
            String dni = IO.readLine();
            controladora.introducirDNIAlumno(dni);
        }

        System.out.println(controladora.mostrarGrupo()
                + "\n¿Desea confirmar el grupo?"
                + "\n\t1. Sí"
                + "\n\t0. No");
        int opc =(int) IO.readNumber();
        if (opc == 1) {
            controladora.confirmarGrupo();
            System.out.println("El grupo se añadió con éxito");
        } else {
            System.out.println("Operación cancelada"); //Flujo Alternativo 1
        }
    }

    public void IntroducirNotaGrupo() {//CU07
        controladora.añadirNotaGrupo();

        System.out.println("Introduzca el ID del grupo: ");
        int idg =(int) IO.readNumber();

        controladora.seleccionarGrupo(idg);
        while (controladora.getGrupoActual() == null) { //Flujo Alternativo 1
            System.out.println("Grupo inexistente. Introduzca un ID de grupo válido: ");
            idg =(int) IO.readNumber();
            controladora.seleccionarGrupo(idg);
        }

        System.out.println("Introduzca el ID de la prueba: ");
        int idp =(int) IO.readNumber();
        System.out.println("Introduzca la nota del alumno: ");
        double calificacion = IO.readNumber();
        controladora.introducirNotaGrupo(idp, calificacion);
    }

    public void ConsultaAlumno() {//CU08
        System.out.println("Introduzca el DNI del alumno: ");
        String dni = IO.readLine();
        System.out.println(controladora.seleccionarAlumno(dni)); // Flujo Alternativo dentro del método.
    }

    public void ConsultaGrupo() {//CU09
        System.out.println(controladora.consultaGrupo());
    }

    public void MenuPrincipal() {
        int opcion = -1;
        do {
            System.out.print("\nMenú Principal:\n"
                    + "\t1. Añadir Pruebas Evaluables.\n"
                    + "\t2. Consulta Pruebas Evaluables.\n"
                    + "\t3. Gestionar Datos.\n"
                    + "\t0. Salir.\n"
                    + "Introduzca una opción: ");
            opcion =(int) IO.readNumber();
            while (opcion > 3 || opcion < 0) {
                System.out.println("Introduzca una opcion valida:\n");
                opcion =(int) IO.readNumber();
            }
            switch (opcion) {
                case 1:
                    AñadirPruebasEvaluables();
                    break;
                case 2:
                    ConsultaPruebasEvaluables();
                    break;
                case 3:
                    MenuDatos();
                    break;
                default:
                    System.out.print("Adios!!!\n");
                    break;
            }
        } while (opcion != 0);
    }

    public void MenuDatos() {
        int opcion = -1;
        do {
            System.out.print("\nMenú Gestión de Datos:\n"
                    + "\t1. Añadir Datos Alumnos.\n"
                    + "\t2. Consulta Alumno.\n"
                    + "\t3. Crear Grupos Trabajo.\n"
                    + "\t4. Consulta Grupo.\n"
                    + "\t5. Introducir Notas.\n"
                    + "\t0. Volver.\n"
                    + "Introduzca una opción: ");
            opcion =(int) IO.readNumber();
            while (opcion > 5 || opcion < 0) {
                System.out.print("Introduzca una opcion valida:\n");
                opcion =(int) IO.readNumber();
            }
            switch (opcion) {
                case 1:
                    AñadirDatosAlumnos();
                    break;
                case 2:
                    ConsultaAlumno();
                    break;
                case 3:
                    CrearGruposTrabajo();
                    break;
                case 4:
                    ConsultaGrupo();
                    break;
                case 5:
                    MenuNotas();
                    break;

            }
        } while (opcion != 0);
    }

    public void MenuNotas() {
        int opcion = -1;
        do {
            System.out.print("\nMenú Introducir Notas:\n"
                    + "\t1. Introducir Nota Alumno.\n"
                    + "\t2. Introducir Nota Clase.\n"
                    + "\t3. Introducir Nota Grupo.\n"
                    + "\t0. Volver.\n"
                    + "Introduzca una opción: ");
            opcion =(int) IO.readNumber();
            while (opcion > 3 || opcion < 0) {
                System.out.print("Introduzca una opcion valida:\n");
                opcion =(int) IO.readNumber();
            }
            switch (opcion) {
                case 1:
                    IntroducirNotaAlumno();
                    break;
                case 2:
                    IntroducirNotaClase();
                    break;
                case 3:
                    IntroducirNotaGrupo();
                    break;
            }
        } while (opcion != 0);
    }
}
