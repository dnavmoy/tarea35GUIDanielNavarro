/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw;

import javax.swing.JFrame;

/**
 *
 * @author jfervic933
 */
public class VentanaPrincipal extends JFrame{
    
    // Tamaño de la ventana. Constantes
    public static final int ANCHO_FRAME = 600;
    public static final int ALTO_FRAME = 200;
   
    // Atributos
    private Panel panel;
    
    // Constructor de la clase 
    public VentanaPrincipal(){
        crearVentana();
        // Incializa el atributo de tipo Panel
        panel = new Panel();
        // Añade el panel a la ventana
        this.add(panel);
        // Cuando todos los elementos están creados se hace visible la ventana
        this.setVisible(true);
    }
    
    
    // Método privado para inicializar el JFrame
    private void crearVentana(){
        // Posición y tamaño del JFrame
        this.setBounds(600, 150, ANCHO_FRAME, ALTO_FRAME);
        // Título de la ventana
        this.setTitle("Generador de códigos QR");
        // Ventana no redimensionable
        this.setResizable(false);
        // Comportamiento al cerrar la ventana
        // Terminar el programa
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
