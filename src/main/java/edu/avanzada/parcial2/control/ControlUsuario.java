package edu.avanzada.parcial2.control;

import java.io.*;
import java.net.*;
import javax.swing.JFileChooser;

import edu.avanzada.parcial2.modelo.ClienteVO;

public class ControlUsuario{

    private Socket socket; // Socket para la comunicación con el cliente
    private int puerto;
    private InetAddress ip;
    private ClienteVO cliente;
    //private File fileDestino;
    //private DataInputStream inCliente;
    //private DataOutputStream outCliente;

    public ControlUsuario(int puerto, Inet4Address ip, ClienteVO cliente) {
        this.puerto = puerto;
        this.ip = ip;
        this.cliente = cliente;
        Conectar();
    }

    public void Conectar(){
        try {
            socket = new Socket(ip, puerto);
            System.out.println("Se establecio la conexion con el servidor");
            /**JFileChooser file = new JFileChooser("user.dir");
            file.showOpenDialog(file);
            fileDestino = file.getSelectedFile();
            FileOutputStream fos = new FileOutputStream(fileDestino);
            // se crean los flujose de entrada (desde el servidor) y salida (al archivo)
            outCliente = new DataOutputStream(fos);
            inCliente = new DataInputStream(usuario.getInputStream());*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
