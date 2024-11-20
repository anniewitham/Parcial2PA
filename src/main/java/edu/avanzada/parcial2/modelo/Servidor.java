
package edu.avanzada.parcial2.modelo;

/**
 * Esta clase representa el modelo de un servidor, con su puerto.
 * Es usada para mantener la configuración del servidor.
 */
public class Servidor {
    private int puerto;

    // Constructor
    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    // Getters y setters
    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
}

