package edu.avanzada.parcial2.control;

import java.io.*;
import java.net.Socket;

import edu.avanzada.parcial2.modelo.CancionVO;

public class ServidorThread extends Thread {
    private Socket cliente;
    private DataInputStream dis;
    private int idSesion;
    private ControlPrincipal control;

    public ServidorThread(Socket cliente, int idSesion, ControlPrincipal control) {
        this.cliente = cliente;
        this.idSesion = idSesion;
        this.control = control;
    }

    public void run() {
        try {
            dis = new DataInputStream(cliente.getInputStream());
            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());

            while (true) {
                String nombreCancion = dis.readUTF();
                double saldoCliente = dis.readDouble();

                if (verificarPagosPendientes(saldoCliente)) {
                    dos.writeUTF("PAGOS_PENDIENTES");
                    dos.writeUTF("Debes pagar " + saldoCliente + " antes de la fecha limite.");
                    cliente.close();
                    break; // Salir del ciclo mientras el cliente tenga pagos pendientes
                } else {
                    // Enviar la canción al cliente
                    enviarCancion(nombreCancion, dos);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean verificarPagosPendientes(double saldoCliente) {
        return saldoCliente < 0; // Si el saldo es negativo, el cliente tiene pagos pendientes
    }

    public void enviarCancion(String nombreCancion, DataOutputStream dos) throws IOException {
        byte[] cancionBytes = cancionEncontrada(nombreCancion); // Obtener los bytes de la canción
        System.out.println(cancionBytes);

        if (cancionBytes != null) {
            dos.writeUTF("OK"); // Indicar que la canción existe y está lista para enviarse

            // Enviar los bytes de la canción en bloques
            int bufferSize = 4096;
            int totalBytes = cancionBytes.length;
            System.out.println(totalBytes);
            int bytesEnviados = 0;
            dos.writeLong(cancionBytes.length);
            while (bytesEnviados < totalBytes) {
                int bytesRestantes = totalBytes - bytesEnviados;
                int bytesAEnviar = Math.min(bufferSize, bytesRestantes);
                dos.write(cancionBytes, bytesEnviados, bytesAEnviar);
                bytesEnviados += bytesAEnviar;
            }

            System.out.println("Canción enviada: " + nombreCancion);
        } else {
            dos.writeUTF("ERROR: La canción no existe.");
        }
    }

    public byte[] cancionEncontrada(String nombre) {
        // Buscar la canción en la lista de canciones
        for (CancionVO cancion : control.lista) {
            if (cancion.getNombre().equals(nombre)) {
                System.out.println(cancion.getCancion());
                return cancion.getCancion(); // Retorna los bytes de la canción
            }
        }
        return null; // Si no se encuentra, retorna null
    }
}
