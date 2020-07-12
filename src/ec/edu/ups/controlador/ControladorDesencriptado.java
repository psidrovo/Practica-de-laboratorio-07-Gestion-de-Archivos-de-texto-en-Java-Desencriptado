package ec.edu.ups.controlador;

import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

/**
 * CONTROLADOR DESENCRIPTADO.
 *
 * Este controlador se encarga de desencriptar el texto que nos pasa la vista
 * Desencriptacion al metoodo Desencriptar
 *
 * @author Paul Idrovo, Dennis Dutan
 */
public class ControladorDesencriptado {

    /**
     * METODO DESENCRIPTAR. Este metodo se encarga de desencriptar el texto del
     * documento encriptado. Para esto usamos StringTokenizer, quien nos ayuda a
     * separar los caracteres encriptados, se le tiene que pasar el texto y el
     * caracter que deseamos poner como separador, en este caso es "%$" ya que
     * en el encriptado se lo concatenaba despues de cada numero generado.
     *
     * Luego recoremos el resultado de StringTokenizer mediante un while, vamos
     * leyendo cada codigo y hacemos operaciones inversas al encriptado y asi
     * obtener el codigo ASCII de cada letra e irlos concatenando en un texto en
     * el que el Usuario pueda leer.
     *
     * @param texto String - Texto Encriptado
     * @return textoDesencriptado String - Texto desencriptado
     */
    public String desencriptar(String texto) {
        String textoDesencriptado = "";
        StringTokenizer desencriptado = new StringTokenizer(texto, "%$");
        while (desencriptado.hasMoreTokens()) {
            String caracter = desencriptado.nextToken();
            int codigo = Integer.valueOf(caracter);
            codigo -= 10;
            codigo = codigo / 5;
            char letra = (char) codigo;
            textoDesencriptado = textoDesencriptado + letra;
        }
        return textoDesencriptado;
    }
}
