import Usuarios.Estudiante;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import biblioteca.Biblioteca;
import biblioteca.Menu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Biblioteca.inicializarHashmap();
        Biblioteca.testerUsuarios();
        Biblioteca.testerLibros();
        Biblioteca.jsonUsuarios();
        Biblioteca.jsonLibros();
    }
}