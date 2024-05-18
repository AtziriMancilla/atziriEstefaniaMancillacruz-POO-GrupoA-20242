package libros;

import biblioteca.Biblioteca;
import libros.constants.Genero;

import java.time.LocalDate;

//primera letra del autor
//genero
//precio
public abstract class Libro {
    public static int CANTIDAD_LIBROS=1;
    private int id;
    private String nombre;
    private String autor;
    private String editorial;
    //private LocalDate fechaDePublicacion;
    private Genero genero;
    private double precio;
    private int stock;
    public Libro(String nombre,String autor, String editorial,Genero genero,double precio,int stock) {
        id=CANTIDAD_LIBROS;
        CANTIDAD_LIBROS++;
        this.nombre=nombre;
        this.autor=autor;
        this.editorial=editorial;
        //this.fechaDePublicacion=fechaDePublicacion;
        this.genero=genero;
        this.precio=precio;
        this.stock=stock;
    }

    protected abstract void filtrarPorPrecio(double precio);
    protected abstract void filtrarPorAutor(String autor);
    public int getStock() {
        return stock;
    }
    public double getPrecio(){
        return precio;
    }
    public String getAutor(){
        return autor;
    }
    //tarea hacer registro del libro de terror y ponerle validaciones a los campos y hacerlo en librps de comedia y accion y que quede bien en el menu
    public String toString(){
        return String.format("Id: %d, Nombre: %s, Autor: %s, Editorial: %s, Fecha publicacion: , Genero: %s, Precio: %f, Stock: %d",id,nombre,autor,editorial,genero,precio,stock);
    }
    public static void mostrarTodosLosLibros(){
        System.out.println("<<LIBROS EN LA BIBLIOTECA>>");
        System.out.println("Libros terror: ");
        LibroTerror.mostrarLibrosTerror();
        System.out.println("Libros comedia: ");
        LibroComedia.mostrarLibrosComedia();
        System.out.println("Libros accion: ");
        LibroAccion.mostrarLibrosAccion();
    }
    public static void filtrarLibros(){

    }
}
