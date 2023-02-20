import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class InicioSesion {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String nombre, contraseña;
        System.out.println("Indique su nombre de usuario: ");
        nombre = sc.nextLine();
        System.out.println("Indique su contraseña: ");
        contraseña = sc.nextLine();
        validarDatos(nombre, contraseña);
    }

    /**
     * Valida los datos introducidos por el usuario en el fichero
     * @param nombre Nombre de usuario
     * @param contraseña Contraseña
     */
    private static void validarDatos(String nombre, String contraseña) {
        // Comprobara si el nombre y la contraseña son correctos
        try(BufferedReader br=new BufferedReader(new FileReader("credenciales.cre"))) {
            String linea;
            boolean encontrado = false;
            while ((linea = br.readLine()) != null&&!encontrado) {
                String[] datos = linea.split(";");
                if (datos[0].equals(nombre) && datos[1].equals(CalculoHask.getDigest(contraseña))) {
                    System.out.println("Bienvenido " + nombre);
                    encontrado=true;
                }
            }
            if(!encontrado){
                System.out.println("Nombre de usuario o contraseña incorrectos");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado");
        }catch (IOException e){
            System.err.println("Error al leer el fichero");
        }
    }
}
