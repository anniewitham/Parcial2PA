package edu.avanzada.parcial2.control;

import java.io.*;
import java.net.*;

public class ControlUsuario implements Runnable {
    
    private Socket socketCliente; // Socket para la comunicación con el cliente
    
    public ControlUsuario(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    @Override
    public void run() {
        try {
            
            InputStream input = socketCliente.getInputStream();
            OutputStream output = socketCliente.getOutputStream();
            
            // Enviar la lista de canciones al cliente 
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            PrintWriter writer = new PrintWriter(output, true);
            
            String usuario = reader.readLine(); 
            String contrasena = reader.readLine(); 

            //cerrar la conexión con el cliente
            socketCliente.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
