package edu.avanzada.parcial2.control;

import java.io.*;
import java.net.*;

import javax.swing.JFileChooser;

public class ControlUsuario implements Runnable {

    private Socket usuario; // Socket para la comunicación con el cliente
    private int puerto;
    private InetAddress ip;
    private File fileDestino;
    private DataInputStream inCliente;
    private DataOutputStream outCliente;

    public ControlUsuario(int puerto, Inet4Address ip) {
        this.puerto = puerto;
        this.ip = ip;
    }

    public void Conectar(){
        try {
            usuario = new Socket(ip, puerto);
            JFileChooser file = new JFileChooser("user.dir");
            file.showOpenDialog(file);
            fileDestino = file.getSelectedFile();
            FileOutputStream fos = new FileOutputStream(fileDestino);
            // se crean los flujose de entrada (desde el servidor) y salida (al archivo)
            outCliente = new DataOutputStream(fos);
            inCliente = new DataInputStream(usuario.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        
    }
}
