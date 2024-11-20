package edu.avanzada.parcial2.control;

import edu.avanzada.parcial2.modelo.Servidor;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ControlServidor {

    private Servidor servidor; // Usamos la clase Servidor como modelo

    // Constructor de ControlServidor que recibe el puerto
    public ControlServidor(int puerto) {
        servidor = new Servidor(puerto); // Crear una instancia de Servidor con el puerto
    }

    /**
     * Inicia el servidor en el puerto especificado.
     * 
     * @throws IOException si ocurre un error al iniciar el servidor o aceptar conexiones.
     */
    public void iniciar() throws IOException {
        try (ServerSocket servidorSocket = new ServerSocket(servidor.getPuerto(), 50, InetAddress.getByName("0.0.0.0"))) {
            notificarEstado("Servidor iniciado en el puerto " + servidor.getPuerto());

            while (true) {
                notificarEstado("Esperando conexiones...");
                Socket socketCliente = servidorSocket.accept();
                notificarEstado("Cliente conectado desde: " + socketCliente.getInetAddress());

                // Crear un nuevo hilo para manejar este cliente
                Thread clienteThread = new Thread(new ControlUsuario(socketCliente)); 
                clienteThread.start(); // Iniciar el hilo
            }
        } catch (IOException e) {
            notificarError("Error al iniciar el servidor: " + e.getMessage());
            throw e;
        }
    }

    private void notificarEstado(String mensaje) {
        // Aquí podrías conectar a una vista o logger en el futuro
    }

    private void notificarError(String mensaje) {
        // Aquí podrías conectar a una vista o logger en el futuro
    }
}




