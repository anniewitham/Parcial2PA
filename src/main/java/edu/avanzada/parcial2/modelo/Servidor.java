
package edu.avanzada.parcial2.modelo;

/**
 * Esta clase representa el modelo de un servidor, con su puerto.
 * Es usada para mantener la configuración del servidor.
 * @author Ana Quientero, Juan Avila, Samuel Barrera 
 */

public class Servidor {
    private int puerto;

    // Constructor para inicializar el puerto
    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    // Getter y setter para el puerto
    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
}

