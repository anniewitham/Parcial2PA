package edu.avanzada.parcial2.control;

import java.io.*;
import java.net.*;
import java.sql.SQLException;

import javax.swing.JFileChooser;

import edu.avanzada.parcial2.modelo.ClienteVO;

public class ControlUsuario {

    private Socket socket; // Socket para la comunicación con el cliente
    private int puerto;
    private InetAddress ip;
    private ClienteVO clienteVO;
    private ControlPrincipal control;
    // private File fileDestino;
    // private DataInputStream inCliente;
    // private DataOutputStream outCliente;

    public ControlUsuario(int puerto, Inet4Address ip, ClienteVO cliente, ControlPrincipal control) {
        this.puerto = puerto;
        this.ip = ip;
        this.clienteVO = cliente;
        this.control = control;
        Conectar();
    }

    public void Conectar() {
        try {
            socket = new Socket(ip, puerto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void descargarCancion(String nombreCancion) throws SQLException {
        try {
            String rutaDirectorio = control.buscarArchivo.buscarDirectorio();

            if (rutaDirectorio == null) {
                control.ventanaEmergente.ventanaError("No se selecciono ningun directorio");
                return;
            }

            File directorioDestino = new File(rutaDirectorio);

            File archivoDestino = new File(directorioDestino, nombreCancion+".mp3");
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            dos.writeUTF(nombreCancion);
            dos.writeDouble(control.clienteDAO.buscarSaldo(clienteVO));

            String respuesta = dis.readUTF();

            if ("OK".equals(respuesta)) {
                FileOutputStream fos = new FileOutputStream(archivoDestino);
                int x = (int) dis.readLong();
                byte[] buffer = new byte[4096];
                int bytesLeidos;
                int bytesRecibidos = 0;
                try {
                    while (bytesRecibidos < x) {
                        bytesLeidos = dis.read(buffer);
                        fos.write(buffer, 0, bytesLeidos);
                        bytesRecibidos += bytesLeidos;
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                fos.close();

                control.ventanaEmergente.ventanaAtencion("Canción descargada con éxito en: " + archivoDestino.getAbsolutePath());
                control.setSalir(true);
                clienteVO.setSaldo(clienteVO.getSaldo()-15000);
            } else if ("PAGOS_PENDIENTES".equals(respuesta)) {
                String mensaje = dis.readUTF();
                control.canciones.dispose();
                control.ventanaEmergente.ventanaAtencion("Descarga rechazada: " + mensaje);
                socket.close();
            } else {
                control.ventanaEmergente.ventanaError("Error: " + respuesta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ClienteVO getClienteVO() {
        return clienteVO;
    }

}
