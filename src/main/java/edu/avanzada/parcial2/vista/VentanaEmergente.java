package edu.avanzada.parcial2.vista;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Ventana emergente. Clase encargada de mostrar mensajes de error.
 *
 * @author @author Ana Quintero, Juan Avila, Samuel Barrera.
 *
 */
public class VentanaEmergente {

    /**
     * Muestra una ventana de diálogo de advertencia con un mensaje específico.
     *
     * @param mensaje El mensaje que se mostrará en la ventana de diálogo.
     */
    public void ventanaAtencion(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Atención", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Ventana error. Muestra errores
     *
     * @param mensaje
     */
    public void ventanaError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

}