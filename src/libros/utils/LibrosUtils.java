package libros.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LibrosUtils {
    public static ArrayList<String> obtenerLibrosDatosComun() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<>();
        System.out.println("Ingresa el nombre del Libro: ");
        String nombre = sc.nextLine();
        System.out.println("Ingresa el autor del Libro: ");
        String autor = sc.nextLine();
        System.out.println("Ingresa la editorial del Libro: ");
        String editorial = sc.nextLine();
        System.out.println("Ingresa el dia de publicacion del Libro: ");
        int dia = sc.nextInt();
        System.out.println("Ingresa el mes de publicacion del Libro: ");
        int mes = sc.nextInt();
        System.out.println("Ingresa el año de publicacion del Libro: ");
        int anio = sc.nextInt();
        LocalDate fechaPublicacion = LocalDate.of(anio, mes, dia);
        return new ArrayList<>();//arreglarlo

    }
}
