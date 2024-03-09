import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] lista = {1, 2, 3, 4, 5, 6, 7};
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el elemento a buscar:");
        int element = readIntFromUser(scanner);

        System.out.println("Ingrese el algoritmo a utilizar (1: Binario, 2: Secuencial):");
        int algorithm = readIntFromUser(scanner);

        int result = search(lista, element, algorithm);

        String var10001 = result != -1 ? "Elemento encontrado en la posición " + result : "Elemento no encontrado.";
        System.out.println("Resultado de la búsqueda: " + var10001);

        // Cierra el Scanner después de su uso
        scanner.close();
    }

    public static int search(int[] data, int element, int algorithm) {
        if (algorithm == 1) {
            return binarySearch(data, element, 0, data.length - 1);
        } else if (algorithm == 2) {
            return linearSearch(data, element);
        } else {
            System.out.println("Algoritmo no reconocido. Por favor, elija 1 o 2.");
            return -1;
        }
    }

    public static int binarySearch(int[] data, int element, int start, int end) {
        if (start > end) {
            return -1;
        } else {
            int mid = (start + end) / 2;
            if (data[mid] == element) {
                return mid;
            } else {
                return data[mid] > element ? binarySearch(data, element, start, mid - 1) : binarySearch(data, element, mid + 1, end);
            }
        }
    }

    public static int linearSearch(int[] data, int element) {
        for(int i = 0; i < data.length; ++i) {
            if (data[i] == element) {
                return i;
            }
        }

        return -1;
    }

    private static int readIntFromUser(Scanner scanner) {
        while(!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
            scanner.next();
        }

        return scanner.nextInt();
    }
}