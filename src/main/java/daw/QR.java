/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos
 *
 */
public class QR {

    // Constantes. Tamaño del QR
    public static final int ANCHO_QR = 400;
    public static final int ALTO_QR = 400;

    // Método que genera el archivo de imagen
    // a partir del texto almacenado en la variable "texto"
    public static void escribirQR(String texto, String fichero, String formatoImagen) {

        // Objeto QRCodeWriter
        // Renderiza un código QR como una matriz de dos
        // dimensiones (BitMatrix) de valores de escala de grises
        QRCodeWriter qrcw = new QRCodeWriter();
        
        BitMatrix matrizPuntos = null;
        try {
            // El método encode() del objeto QRCodeWriter codifica la matriz y
            // la devuelve como un objeto BitMatrix, según se especifica en los
            // argumentos que se le pasen
            matrizPuntos = qrcw.encode(texto, BarcodeFormat.QR_CODE, ANCHO_QR, ALTO_QR);
        } catch (WriterException ex) {
            // Este método lanza una excepción si no puede crear correctamente la matriz
            // con la imagen de puntos
            JOptionPane.showMessageDialog(null, "El contenido no puede ser correctamente generado.");
        }
        
        FileOutputStream ficheroSalida = null;
        try {
            // Objeto FileOutputStream sirve para escribir en ficheros
            // flujos de bytes de datos, como imágenes
            // Este constructor recibe una instancia de File, que es el objeto que
            // representa un archivo en el disco duro
            ficheroSalida = new FileOutputStream(new File(fichero));
        } catch (FileNotFoundException ex) {
            // Si la creación del FileOutputStream produce algún error porque 
            // el fichero no puede ser creado o no existe se lanza esta excepción
            JOptionPane.showMessageDialog(null, "Problemas con la creación del "
                    + "fichero en el sistema de ficheros.");
        }
        
        try {
            // Se escribe la matriz de puntos en el objeto ficheroSalida
            // Para ello se usa un método de clase de la clase MatrixToImageWriter
            // Este método recibe la matriz de puntos, el formato de la imagen y
            // el fichero donde escribir la matriz
            MatrixToImageWriter.writeToStream(matrizPuntos, formatoImagen, ficheroSalida);
        } catch (IOException ex) {
            // Si hay problemas pasando la matriz al fichero entonces
            // se lanza la excepción IOException
            JOptionPane.showMessageDialog(null, "No se puede crear el archivo "
                    + "que contiene el códio QR");
        }
        
    }

    /*
    * API Zxing
    * https://zxing.github.io/zxing/apidocs/
     */
}
