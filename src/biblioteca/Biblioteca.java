package biblioteca;

import Usuarios.*;
import Usuarios.utils.Rol;
import biblioteca.utils.DatosComun;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import libros.Libro;
import libros.LibroAccion;
import libros.LibroComedia;
import libros.LibroTerror;
import libros.constants.Genero;
import libros.constants.SubgeneroAccion;
import libros.constants.SubgeneroComedia;
import libros.constants.SubgeneroTerror;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
// borrar y modificar
public class Biblioteca {
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<>();
    public static final HashMap<Genero, ArrayList<Libro>> libros = new HashMap<>();

    public Biblioteca() {
        inicializarHashmap();
        testerUsuarios();
        jsonUsuarios();
    }
    public static void inicializarHashmap(){
        usuarios.put(Rol.TRABAJADOR, new ArrayList<Usuario>());
        usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());

        libros.put(Genero.ACCION, new ArrayList<Libro>());
        libros.put(Genero.TERROR, new ArrayList<Libro>());
        libros.put(Genero.COMEDIA, new ArrayList<Libro>());
    }

    public Usuario verificarInicioSesion(String usuario, String contrasena) {
        for (Map.Entry<Rol,ArrayList<Usuario>> entry: usuarios.entrySet()){
            ArrayList<Usuario> listaUsuarios=entry.getValue();
            for (Usuario usuarioActual: listaUsuarios){
                if(usuarioActual.getNombreUsuario().equals(usuario)&&usuarioActual.getContrasena().equals(contrasena)){
                    return usuarioActual;
                }
            }
        }
        return null;
    }
    public void registrarCliente(){
        Cliente.registrarCliente();
    }
    public void registrarTrabajador() {
        Trabajador.registrarTrabajador();
    }

    public void registrarGerente() {
        Gerente.registrarGerente();
    }

    public void mostrarClientes() {
        Cliente.mostrarClientes();
    }

    public void mostrarTrabajadores() {
        Trabajador.mostrarTrabajadores();
    }

    public void mostrarGerentes() {
        Gerente.mostrarGerentes();
    }
    public void borrarCliente(){
        Cliente.borrarCliente();
    }
    public void borrarTrabajador(){
        Trabajador.borrarTrabajador();
    }
    public void borrarGerente(){
        Gerente.borrarGerente();
    }

    public static void testerUsuarios(){
        Trabajador trabajador1=new Trabajador("Sianya","Garcia","Medina","4342674748585","Amoconta","contachido","05-06","Almacen",56789.0);
        Trabajador trabajador2=new Trabajador("Alejandro","Montejano","Dias","434269809605","Elpro","dr profesor","05-06","Mostrador",56789.0);
        Cliente cliente=new Cliente("Andrea","Duran","Martinez","434267405939","Canelita","paysito");
        Cliente cliente1=new Cliente("Edgar","Lopez","Vazquez","434268968308603","Gari","1234");
        Gerente gerente1=new Gerente("Jafet","Santoyo","Benitez","43486049505","Jafi","sdgs","05-06",150);
        Gerente gerente2=new Gerente("Mariana","Paz","Alfaro","4342674756868","Amoconta","contachido","05-06",250);
        Trabajador trabajador = new Trabajador("Andrea", "Duran", "Martinez","44378039433", "genshin", "1234", "09:00-12:00", "Libreria centro", 30000);
        usuarios.get(Rol.TRABAJADOR).add(trabajador);
        usuarios.get(Rol.TRABAJADOR).add(trabajador1);
        usuarios.get(Rol.TRABAJADOR).add(trabajador2);
        usuarios.get(Rol.CLIENTE).add(cliente);
        usuarios.get(Rol.CLIENTE).add(cliente1);
        usuarios.get(Rol.GERENTE).add(gerente1);
        usuarios.get(Rol.GERENTE).add(gerente2);
    }
    public static void testerLibros(){
        LibroComedia libroComedia=new LibroComedia("Libro chistoso","Autor que hace chistes","Editorial chistosa",436.68,22, SubgeneroComedia.PARODIA);
        LibroComedia libroComedia2=new LibroComedia("Libro romantico de risa ","Autor romantico","Editorial amorosa",386,30, SubgeneroComedia.ROMANTICA);
        LibroAccion libroAccion=new LibroAccion("Libro de aventuras","Autor aventurero","Aventura editorial",450.5,75, SubgeneroAccion.AVENTURA);
        LibroAccion libroAccion2=new LibroAccion("La ley y el orden ","Autor policiaco","Ley editorial",220,65, SubgeneroAccion.POLICIACA);
        LibroTerror terror1 =new LibroTerror("Nombre libro terror ","Autor de terror","Editorial terrorifica",546,20, SubgeneroTerror.CRIMEN);
        LibroTerror terror2 =new LibroTerror("Nombre libro terror 2 ","Autor de terror psicológico","Editorial malvada",345.6,15, SubgeneroTerror.PSICOLOGICO);
        libros.get(Genero.COMEDIA).add(libroComedia);
        libros.get(Genero.COMEDIA).add(libroComedia2);
        libros.get(Genero.ACCION).add(libroAccion);
        libros.get(Genero.ACCION).add(libroAccion2);
        libros.get(Genero.TERROR).add(terror1);
        libros.get(Genero.TERROR).add(terror2);
    }
    public static void jsonUsuarios(){
        Gson json= new GsonBuilder().setPrettyPrinting().create();
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("dataUsuarios.json"));
            json.toJson(usuarios,writer);
            writer.close();//forma en la que le decimos que después de recibir los datos lo cierre y escriba todo en el archivo
        }catch (IOException e){
            System.out.println(e);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static void jsonLibros(){
        Gson json= new GsonBuilder().setPrettyPrinting().create();
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("dataLibros.json"));
            json.toJson(libros,writer);
            writer.close();//forma en la que le decimos que después de recibir los datos lo cierre y escriba todo en el archivo
        }catch (IOException e){
            System.out.println(e);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}