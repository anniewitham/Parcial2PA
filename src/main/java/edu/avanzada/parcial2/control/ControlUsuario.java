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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
