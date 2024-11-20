package edu.avanzada.parcial2.control;

import java.io.IOException;

/**
 * Clase principal para iniciar el servidor del sistema. Se encarga de
 * inicializar el controlador principal con el contexto de servidor.
 *
 * @author Juan Avila, Ana Quintero, Samuel Barrera.
 */
public class LauncherServidor {

    /**
     * Método principal que lanza la aplicación servidor.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     * @throws IOException Si ocurre algún error durante la inicialización.
     */
    public static void main(String[] args) throws IOException {
        new ControlPrincipal(2);
    }
}
