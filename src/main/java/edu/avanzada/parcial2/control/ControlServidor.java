package edu.avanzada.parcial2.control;

import java.io.IOException;
import java.net.*;

public class ControlServidor {

    private ServerSocket servidor;
    private int puerto;
    private int idSesion;

    public ControlServidor(int puerto) {
        this.puerto = puerto;
        this.idSesion = 0;
    }

    /**
     * Inicia el servidor en el puerto especificado.
     * Escucha conexiones entrantes y lanza un hilo para cada cliente.
     */
    public void iniciar() {
        try {
            servidor = new ServerSocket(puerto);
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("Servidor iniciado en IP: " + ip.getHostAddress() + ", Puerto: " + puerto);

            while (true) {
                Socket usuario = servidor.accept();
                System.out.println("Nueva conexión entrante desde: " + usuario.getInetAddress().getHostAddress());

                new ServidorThread(usuario, idSesion).start();
                idSesion++;
            }
        } catch (IOException e) {
        } catch (Exception e) {
        }
    }
}
