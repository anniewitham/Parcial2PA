
package edu.avanzada.parcial2.control;

import edu.avanzada.parcial2.vista.Canciones;
import edu.avanzada.parcial2.vista.ValidarUsuario;
import edu.avanzada.parcial2.vista.VentanaEmergente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 *
 * @author Ana Quintero, Juan Avila, Samuel Barrera
 */
public class Control implements ActionListener{

    protected Canciones canciones;
    protected ValidarUsuario validarUsuario;
    protected VentanaEmergente ventanaEmergente; 
    
    
    
    public Control() throws IOException {
        ventanaEmergente = new VentanaEmergente();
        
        canciones = new Canciones(this);
        canciones.botonSalir.addActionListener(this);
        canciones.botonDescargar.addActionListener(this);
        canciones.botonSalir.setActionCommand("Salir");
        
        validarUsuario = new ValidarUsuario(this);
        validarUsuario.botonIngresar.addActionListener(this);
        validarUsuario.botonSalir.addActionListener(this);
        validarUsuario.botonSalir.setActionCommand("Salir");
        
    }

    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
