package edu.avanzada.parcial2.control;

import java.io.IOException;

/**
 * Clase principal para iniciar el cliente del sistema. Se encarga de
 * inicializar el controlador principal con el contexto de cliente.
 * 
 *  @author  Juan Avila, Ana Quintero, Samuel Barrera.
 */
public class LauncherCliente {

    /**
     * Método principal que lanza la aplicación cliente.
     *
     * @param args args Argumentos de línea de comandos (no utilizados).
     * @throws IOException IOException Si ocurre algún error durante la
     * inicialización.
     */
    public static void main(String[] args) throws IOException {
        new ControlPrincipal(1);
    }
}
