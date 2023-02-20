import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Registro {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String nombre, contraseña;
        System.out.println("Indique su nombre de usuario: ");
        nombre = sc.nextLine();
        System.out.println("Indique su contraseña: ");
        contraseña = sc.nextLine();
        guardarDatos(nombre, contraseña);
    }
    /**
     * Guarda los datos en un fichero de texto
     * @param nombre Nombre de usuario
     * @param contraseña Contraseña
     */
    private static void guardarDatos(String nombre, String contraseña) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("credenciales.cre"))) {
            bw.write(nombre+";"+CalculoHask.getDigest(contraseña));
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar los datos");
        }
    }
}