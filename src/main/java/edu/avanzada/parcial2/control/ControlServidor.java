package edu.avanzada.parcial2.control;

import java.io.IOException;
import java.net.*;

public class ControlServidor {

    private ServerSocket servidor;
    private Socket usuario;
    private int puerto; // Usamos la clase Servidor como modelo

    // Constructor de ControlServidor que recibe el puerto
    public ControlServidor(int puerto) {
        this.puerto = puerto; // Crear una instancia de Servidor con el puerto
    }

    /**
     * Inicia el servidor en el puerto especificado.
     * 
     * @throws IOException si ocurre un error al iniciar el servidor o aceptar
     *                     conexiones.
     */
    public void iniciar() {
        try {
            servidor = new ServerSocket(puerto);
            while (true) {
                usuario = servidor.accept();

                // Crear un nuevo hilo para manejar este cliente
                //Thread usuarioThread = new Thread(new ControlUsuario();
                //usuarioThread.start();
            }
        } catch (Exception e) {
        }
    }
}