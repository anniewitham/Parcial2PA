package edu.avanzada.parcial2.control;

import java.io.IOException;

public class LauncherServidor {

    public static void main(String[] args) throws IOException {
        new ControlPrincipal(2);
        int puerto = 5080;
        ControlServidor servidor = new ControlServidor(puerto); 
        servidor.iniciar(); 

    }
}