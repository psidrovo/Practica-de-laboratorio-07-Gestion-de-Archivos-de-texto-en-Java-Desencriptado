/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

/**
 *
 * @author Paul Idrovo
 */
public class ControladorDesencriptado {
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
