
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author docente
 */
public class TestWindows {

    public static void main(String nada[]) throws FileNotFoundException, IOException {
        NumeralA numA = new NumeralA();
        NumeralB numB = new NumeralB();
        NumeralD numD = new NumeralD();
        NumeralE numE = new NumeralE();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(">> Menu de opciones: <<");
            System.out.println("1. Obtener dominios asociados a una dirección IP");
            System.out.println("2. Obtener el proceso con mayor uso de CPU");
            System.out.println("4. Cambiar la fecha y hora del sistema");
            System.out.println("5. Verificar si un DIR existe y de vista arbol");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
             String comand[] = {"powershell.exe", "/c", "Get-Process"};

            int opcion;

            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida. Por favor, ingrese un número.");
                scanner.nextLine();
                continue;
            }

            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese la dirección IP: ");
                    String ip = scanner.nextLine();
                    System.out.println(numA.IPfinder(ip));
                }
                case 2 -> {
                    System.out.println(numB.maxCPUProcess());
                }
                case 4 ->{
                    System.out.println("Ingrese una fecha y hora en formato DD-MM-AAAA/HH-MM-SS");
                    String date = scanner.nextLine();
                    numD.changeDate(date);   
                }
                case 5 ->{
                    System.out.println("Ingrese un directorio");
                    String dir = scanner.nextLine();
                    numE.treeDirectory(dir);
                }
                case 6 ->{
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                }
                default ->
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            System.out.println("====>>==========<<>>==========<<====");
            System.out.println("");
        }

    }
}
