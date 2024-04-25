/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author carlos
 */
public class VentanaResultado extends JFrame {

    private JLabel resultado;

    // Este constructor recibe el fichero que contiene 
    // el QR, lo establece en el JLabel y se muestra
    public VentanaResultado(String fichero) {
        // Título del frame
        this.setTitle(fichero);
        // No se redimensiona
        this.setResizable(false);
        // Objeto dimension para guardar información del tamaño de la pantalla
        Dimension tamanioPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        // Posición inicial de la ventana. Centrada respecto a la pantalla
        this.setBounds(tamanioPantalla.width/2 - QR.ANCHO_QR/2, 
                    tamanioPantalla.height/2 - QR.ALTO_QR/2, 
                QR.ANCHO_QR, QR.ALTO_QR);
        // Inicialización del atributo
        resultado = new JLabel();
        // Se crea un objeto imagen a partir del fichero del QR
        ImageIcon icono = new ImageIcon(fichero);
        // Se establece la imagen del QR en el JLabel
        resultado.setIcon(icono);
        this.add(resultado);
        // Ajusta el tamaño de la ventana al contenido
        this.pack();
        // Hace visible la ventana
        this.setVisible(true);
    }
}
