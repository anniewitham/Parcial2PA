package edu.avanzada.parcial2.control;

import java.io.DataInputStream;
import java.net.Socket;

public class ServidorThread extends Thread{
    private Socket cliente;
    private DataInputStream dis;
    private int idSesion;

    public ServidorThread(Socket cliente, int idSesion){
        this.cliente = cliente;
        this.idSesion = idSesion;
    }

    @Override
    public void run() {
        //Aqui se debe agregar la logica de manejo del servidor
    }
}