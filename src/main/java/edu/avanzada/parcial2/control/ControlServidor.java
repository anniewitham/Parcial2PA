package edu.avanzada.parcial2.control;

import java.io.IOException;
import java.net.*;

/**
 * Clase que controla el servidor, encargada de gestionar conexiones entrantes,
 * asignar identificadores de sesión y manejar hilos para cada cliente.
 * 
 * Esta clase utiliza un servidor basado en `ServerSocket` para aceptar
 * conexiones desde los clientes y delegar el manejo de cada cliente a un hilo
 * individual.
 */
public class ControlServidor {

    private ServerSocket servidor; // Objeto para escuchar conexiones en un puerto específico
    private int puerto; // Puerto en el que se ejecuta el servidor
    private int idSesion; // Identificador único para cada sesión
    private ControlPrincipal control; // Referencia al controlador principal para comunicación
    protected Thread sThread; // Hilo encargado de manejar cada cliente

    /**
     * Constructor de la clase `ControlServidor`.
     * 
     * @param puerto  el puerto en el que se debe iniciar el servidor.
     * @param control una referencia al controlador principal para manejar la lógica
     *                del servidor.
     */
    public ControlServidor(int puerto, ControlPrincipal control) {
        this.puerto = puerto;
        this.idSesion = 0; // Inicialización del identificador de sesión
        this.control = control;
    }

    /**
     * Inicia el servidor en el puerto especificado.
     * 
     * Este método configura el servidor para escuchar conexiones entrantes. Por
     * cada conexión aceptada, se lanza un hilo para manejar al cliente.
     * Además, registra la IP y el puerto del servidor en la ventana del servidor.
     */
    public void iniciar() {
        try {
            servidor = new ServerSocket(puerto); // Crear el servidor en el puerto especificado
            InetAddress ip = InetAddress.getLocalHost(); // Obtener la IP del host local
            control.ventanaServidor.AreaServidor.append(
                    "Servidor iniciado en IP: " + ip.getHostAddress() + ", Puerto: " + puerto + "\n");

            while (true) {
                Socket usuario = servidor.accept(); // Aceptar conexiones entrantes
                control.ventanaServidor.AreaServidor.append(
                        "Nueva conexión entrante desde: " + usuario.getInetAddress().getHostAddress() + "\n");

                // Crear un nuevo hilo para manejar al cliente
                sThread = new ServidorThread(usuario, idSesion, control);
                sThread.start(); // Iniciar el hilo
                idSesion++; // Incrementar el identificador de sesión
            }
        } catch (IOException e) {
            // Manejar errores relacionados con la entrada/salida
            control.ventanaServidor.AreaServidor.append("Error en el servidor: " + e.getMessage() + "\n");
        } catch (Exception e) {
            // Manejar otros errores no previstos
            control.ventanaServidor.AreaServidor.append("Error inesperado: " + e.getMessage() + "\n");
        }
    }
}
