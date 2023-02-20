import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CalculoHask {
    /**
     * Calcula el resumen de un mensaje
     * @param mensaje Mensaje del cual se quiere calcular el resumen
     * @return Resumen del mensaje en hexadecimal
     */
    public static String getDigest(String mensaje){
        // Convierto el mensaje introducido por el usuario en un array de bytes
        byte[] mensajeBytes;
        byte[] resumen = null;
        String resumenHexadecimal=null;
        try {
            mensajeBytes = mensaje.getBytes("UTF-8");
            // Creo una instancia de MessageDigest con el algoritmo SHA-256
            MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");

            // Reiniciamos el objeto por si contiene datos
            algoritmo.reset();

            // Añado el mensaje del cual quiero calcular su hash
            algoritmo.update(mensajeBytes);

            // Generamos el resumen
            resumen = algoritmo.digest();
            resumenHexadecimal = String.format("%064x", new BigInteger(1, resumen));
        }catch (UnsupportedEncodingException e) {
            System.err.println("Error al convertir el mensaje a bytes");
        }catch (NoSuchAlgorithmException e) {
            System.err.println("Error al crear el MessageDigest");
        }
        return resumenHexadecimal;
    }
    /**
     * Compara dos resúmenes
     * @param primero Resumen en hexadecimal
     * @param segundo Resumen en hexadecimal
     * @return true si son iguales, false en caso contrario
     */
    public static boolean compararResumenes(String primero,String segundo){
        return primero.equals(segundo);
    }
}
