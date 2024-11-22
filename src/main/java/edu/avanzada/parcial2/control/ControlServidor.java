package edu.avanzada.parcial2.control;

import java.io.IOException;
import java.net.*;

public class ControlServidor {

    private ServerSocket servidor;
    private int puerto;
    private int idSesion;
    private ControlPrincipal control;
    protected Thread sThread;

    public ControlServidor(int puerto, ControlPrincipal control) {
        this.puerto = puerto;
        this.idSesion = 0;
        this.control = control;
    }

    /**
     * Inicia el servidor en el puerto especificado.
     * Escucha conexiones entrantes y lanza un hilo para cada cliente.
     */
    public void iniciar() {
        try {
            servidor = new ServerSocket(puerto);
            InetAddress ip = InetAddress.getLocalHost();
            control.ventanaServidor.AreaServidor.append("Servidor iniciado en IP: " + ip.getHostAddress() + ", Puerto: " + puerto + "\n");

            while (true) {
                Socket usuario = servidor.accept();
                control.ventanaServidor.AreaServidor.append("Nueva conexión entrante desde: " + usuario.getInetAddress().getHostAddress() + "\n");

                sThread = new ServidorThread(usuario, idSesion, control);
                sThread.start();
                idSesion++;
            }
        } catch (IOException e) {
        } catch (Exception e) {
        }
    }
}
