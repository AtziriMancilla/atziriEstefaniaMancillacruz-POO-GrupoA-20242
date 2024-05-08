import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //1. ArithmeticException: ocurre cuando se realiza una operación aritmética ilegal.
        //Ejemplo:
        try {
            int division=5/0;
        }catch (ArithmeticException error){
            System.out.println("1. Operacion no valida");
        }
        //2. NullPointerException: ocurre cuando intentas acceder a un objeto que no ha sido inicializado.
        //Ejemplo:
        try {
            String cadena = null;
            int longitud = cadena.length();
        }catch (NullPointerException error){
            System.out.println("2. Cadena vacía");
        }
        //3. NumberFormatException: ocurre cuando se intenta convertir una cadena en un tipo numérico, pero la cadena no tiene el formato adecuado.
        //Ejemplo:
        try {
            String texto = "Estoy cansado, jefe";
            int numero = Integer.parseInt(texto);
        }catch (NumberFormatException error){
            System.out.println("3. No se puede convertir una cadena a un valor entero");
        }
        //4. ArrayIndexOutOfBoundsException: ocurre cuando intentas acceder a un índice fuera del rango de un array.
        //Ejemplo:
        try {
            int[] array = new int[6];
            int valor = array[6];
        }catch (ArrayIndexOutOfBoundsException error){
            System.out.println("4. No se puede acceder a esta posicion en el arreglo");
        }
        //5. FileNotFoundException: Ocurre cuando intentas abrir un archivo que no existe.
        //Ejemplo:
        try {
            FileReader archivo = new FileReader("archivo_que_no_existe.txt");
        }catch (FileNotFoundException error){
            System.out.println("5. El archivo no existe");
        }
        //6. ClassCastException: Ocurre cuando intentas realizar una conversión de tipo incompatible.
        //Ejemplo:
        try {
            Object objeto = "Hola";
            Integer entero = (Integer) objeto;
        }catch (ClassCastException error){
            System.out.println("6. No se puede realizar esta conversión");
        }
        //7. InputMismatchException: ocurre cuando se intenta leer un tipo de dato de entrada que no coincide con el tipo esperado.
        //Por ejemplo cuando se espera un nÚmero entero y se ingresa una cadena.
        //Ejemplo:
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Ingresa un número entero:");
            int numeroEntero = sc.nextInt(); // Intenta leer un entero
        } catch (InputMismatchException error) {
            System.out.println("7. No has ingresado un número entero válido.");
            sc.nextLine();
        }
        //8. IOException: Se levanta cuando ocurre un error relacionado con la entrada o salida de datos, como problemas al leer/escribir archivos.
        //Ejemplo:
        try {
            FileReader archivo = new FileReader("archivo_que_no_existe.txt");
        }catch (IOException error){
            System.out.println("8. Este archivo no existe");
        }
        //9. ArrayStoreException: Ocurre cuando se intenta almacenar un objeto de tipo incorrecto en un array.
        //Ejemplo:
        try {
            Object[] arreglo = new String[3];
            arreglo[0] = 123;
        }catch (ArrayStoreException error){
            System.out.println("9. No se puede guardar este tipo de dato");
        }
        //10. NoSuchElementException: Se levanta cuando no se puede acceder a más elementos en una colección, como cuando se llama al método next() en un Iterator que ha llegado al final.
        //Ejemplo:
        try {
            ArrayList<String> lista = new ArrayList<>();
            Iterator<String> iterador = lista.iterator();
            String elemento = iterador.next();
        }catch (NoSuchElementException error){
            System.out.println("10. Error");
        }
    }
}