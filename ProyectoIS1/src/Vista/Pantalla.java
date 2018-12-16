package Vista;

import Aplicacion.Alumno;
import Aplicacion.Controladora;
import java.util.Iterator;
import java.util.Scanner;

public class Pantalla {

    private Controladora controladora;

    public Pantalla() {
        controladora = new Controladora();
    }

    public void AñadirPruebasEvaluables() { //CU01
        controladora.añadirPrueba();

        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca el ID de la prueba: ");
        int id = s.nextInt();
        System.out.println("Introduzca el nombre de la prueba: ");
        String nom = s.next();
        System.out.println("Introduzca la descripción de la prueba: ");
        String desc = s.next();
        System.out.println("Introduzca el porcentaje de la prueba: ");
        double porc = s.nextDouble();
        System.out.println("Introduzca el tipo de prueba: ");
        String tipo = s.next();

        controladora.introducirDatosPrueba(id, nom, desc, porc, tipo);

        System.out.println(controladora.mostrarPrueba()
                + "\n¿Desea confirmar la prueba?"
                + "\n\t1. Sí"
                + "\n\t0. No");
        int opc = s.nextInt();
        if (opc == 1) {
            controladora.confirmarPrueba();
            System.out.println("La prueba se añadió con éxito");
        } else {
            System.out.println("Operación cancelada");
        }
    }

    public void ConsultaPruebasEvaluables() {//CU02
        System.out.println(controladora.consultaPruebas());
    }

    public void AñadirDatosAlumnos() {//CU03
        controladora.añadirAlumno();

        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca el nombre del alumno: ");
        String nom = s.nextLine();
        System.out.println("Introduzca los apellidos del alumno: ");
        String apell = s.nextLine();
        System.out.println("Introduzca el DNI del alumno: ");
        String dni = s.nextLine();
        System.out.println("Introduzca el grupo de EPD: ");
        int epd = s.nextInt();

        controladora.introducirDatosAlumnos(nom, apell, dni, epd);

        System.out.println(controladora.mostrarAlumno()
                + "\n¿Desea confirmar el alumno?"
                + "\n\t1. Sí"
                + "\n\t0. No");
        int opc = s.nextInt();
        if (opc == 1) {
            controladora.confirmarAlumno();
            System.out.println("El alumno se añadió con éxito");
        } else {
            System.out.println("Operación cancelada");
        }
    }

    public void IntroducirNotaAlumno() {//CU04
        controladora.añadirNotaAlumno();

        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca el ID de la prueba: ");
        int id = s.nextInt();
        System.out.println("Introduzca el DNI del alumno: ");
        String dni = s.next();
        System.out.println("Introduzca la calificacion: ");
        double calif = s.nextDouble();

        controladora.introducirDatosNota(id, dni, calif);

        System.out.println(controladora.mostrarNota()
                + "\n¿Desea confirmar la nota del alumno?"
                + "\n\t1. Sí"
                + "\n\t0. No");
        int opc = s.nextInt();
        if (opc == 1) {
            controladora.confirmarNotaAlumno();
            System.out.println("La nota se añadió al alumno con éxito");
        } else {
            System.out.println("Operación cancelada");
        }
    }

    public void IntroducirNotaClase() {//CU05
        controladora.añadirNotaClase();

        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca el ID de la prueba: ");
        int id = s.nextInt();
        controladora.seleccionarPrueba(id);

        Iterator<Alumno> it = controladora.getAsignatura().getAlumnos();
        double calificacion;
        while (it.hasNext()) {
            controladora.setAlumnoActual(it.next());
            System.out.println(controladora.getAlumnoActual().toString());
            System.out.println("Introduzca la nota del alumno: ");
            calificacion = s.nextDouble();
            controladora.introducirDatosNota(calificacion);
        }
    }

    public void CrearGruposTrabajo() {//CU06
        controladora.crearGrupoTrabajo();

        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca el ID del grupo: ");
        int id = s.nextInt();
        System.out.println("Introduzca el numero de alumnos del grupo: ");
        int n = s.nextInt();

        controladora.introducirDatosGrupo(id, n);

        for (int i = 0; i < n; i++) {
            System.out.println("Introduzca el DNI del siguiente alumno: ");
            String dni = s.next();
            controladora.introducirDNIAlumno(dni);
        }

        System.out.println(controladora.mostrarGrupo()
                + "\n¿Desea confirmar el grupo?"
                + "\n\t1. Sí"
                + "\n\t0. No");
        int opc = s.nextInt();
        if (opc == 1) {
            controladora.confirmarGrupo();
            System.out.println("El grupo se añadió con éxito");
        } else {
            System.out.println("Operación cancelada");
        }
    }

    public void IntroducirNotaGrupo() {//CU07
        controladora.añadirNotaGrupo();

        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca el ID del grupo: ");
        int idg = s.nextInt();
        controladora.seleccionarGrupo(idg);
        System.out.println("Introduzca el ID de la prueba: ");
        int idp = s.nextInt();
        System.out.println("Introduzca la nota del alumno: ");
        double calificacion = s.nextDouble();
        controladora.introducirNotaGrupo(idp, calificacion);
    }

    public void ConsultaAlumno() {//CU08
        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca el DNI del alumno: ");
        String dni = s.next();
        System.out.println(controladora.seleccionarAlumno(dni));
    }

    public void ConsultaGrupo() {//CU09
        System.out.println(controladora.consultaGrupo());
    }

    public void MenuPrincipal() {
        Scanner s = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.print("\nMenú Principal:\n"
                    + "\t1. Añadir Pruebas Evaluables.\n"
                    + "\t2. Consulta Pruebas Evaluables.\n"
                    + "\t3. Gestionar Datos.\n"
                    + "\t0. Salir.\n"
                    + "Introduzca una opción: ");
            opcion = s.nextInt();
            while (opcion > 3 || opcion < 0) {
                System.out.println("Introduzca una opcion valida:\n");
                opcion = s.nextInt();
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
        Scanner s = new Scanner(System.in);
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
            opcion = s.nextInt();
            while (opcion > 5 || opcion < 0) {
                System.out.print("Introduzca una opcion valida:\n");
                opcion = s.nextInt();
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
        Scanner s = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.print("\nMenú Introducir Notas:\n"
                    + "\t1. Introducir Nota Alumno.\n"
                    + "\t2. Introducir Nota Clase.\n"
                    + "\t3. Introducir Nota Grupo.\n"
                    + "\t0. Volver.\n"
                    + "Introduzca una opción: ");
            opcion = s.nextInt();
            while (opcion > 3 || opcion < 0) {
                System.out.print("Introduzca una opcion valida:\n");
                opcion = s.nextInt();
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
