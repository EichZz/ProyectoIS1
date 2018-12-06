
package Aplicacion;

import java.util.Scanner;

public class Pantalla {

    private Controladora controladora;

    private void AñadirPruebasEvaluables() {
        controladora.añadirPrueba();

        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca el ID de la prueba: ");
        int id = s.nextInt();
        System.out.println("Introduzca el nombre de la prueba: ");
        String nom = s.nextLine();
        System.out.println("Introduzca la descripción de la prueba: ");
        String desc = s.nextLine();
        System.out.println("Introduzca el porcentaje de la prueba: ");
        double porc = s.nextLong();
        System.out.println("Introduzca el tipo de prueba: ");
        String tipo = s.nextLine();

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

    private void ConsultaPruebasEvaluables() {
        //System.out.println(controladora.consultaPruebas());
    }

    private void AñadirDatosAlumnos() {
    }

    private void IntroducirNotaAlumno() {
    }

    private void IntroducirNotaClase() {
    }

    private void CrearGruposTrabajo() {
    }

    private void IntroducirNotaGrupo() {
    }

    private void ConsultaAlumno() {
    }

    private void ConsultaGrupo() {
    }

    public void MenuPrincipal() {
        Scanner s = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.print("Menú Principal:\n"
                    + "\t1. Añadir Pruebas Evaluables.\n"
                    + "\t2. Consulta Pruebas Evaluables.\n"
                    + "\t3. Gestionar Datos.\n"
                    + "\t0. Salir.\n");
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

    private void MenuDatos() {
        Scanner s = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.print("Menú Gestión de Datos:\n"
                    + "\t1. Añadir Datos Alumnos.\n"
                    + "\t2. Consulta Alumno.\n"
                    + "\t3. Crear Grupos Trabajo.\n"
                    + "\t4. Consulta Grupo.\n"
                    + "\t5. Introducir Notas.\n"
                    + "\t0. Volver.\n");
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

    private void MenuNotas() {
        Scanner s = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.print("Menú Introducir Notas:\n"
                    + "\t1. Introducir Nota Alumno.\n"
                    + "\t2. Introducir Nota Clase.\n"
                    + "\t3. Introducir Nota Grupo.\n"
                    + "\t0. Volver.\n");
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
