import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import biblioteca.Biblioteca;
import biblioteca.Menu;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Menu menu=new Menu();
        //menu.ejecutarMenu();
        Biblioteca bib=new Biblioteca();
        bib.registrarCliente();
        bib.registrarGerente();
    }
}