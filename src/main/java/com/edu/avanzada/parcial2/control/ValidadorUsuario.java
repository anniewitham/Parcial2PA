/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.avanzada.parcial2.control;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Personal
 */
public class ValidadorUsuario {
    
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private String host = "localhost"; // Cambia esto según tu configuración
    private int port = 3306; // Cambia esto según tu configuración

    public ValidadorUsuario() throws IOException {
        socket = new Socket(host, port);
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
    }

    public boolean Usuario(String username) {
        try {
            
            // Enviar la consulta SQL al servidor
            output.writeUTF("SELECT * FROM usuarios WHERE nombre = '" + username + "'");

            // Leer la respuesta del servidor
            String response = input.readUTF();

            // Procesar la respuesta
            return response.equals("USER_FOUND");
        } catch (IOException e) {
            System.out.println("Error al comunicarse con el servidor: " + e.getMessage());
            return false;
        }
    }

    public void close() throws IOException {
        input.close();
        output.close();
        socket.close();
    }

    public static void main(String[] args) {
        try {
            ValidadorUsuario validador = new ValidadorUsuario();
            boolean isUserValid = validador.Usuario("usuarioEjemplo");
            if (isUserValid) {
                System.out.println("Usuario encontrado.");
            } else {
                System.out.println("Usuario no encontrado.");
            }
            validador.close();
        } catch (IOException e) {
            System.out.println("Error al iniciar el validador: " + e.getMessage());
        }
    }
}
