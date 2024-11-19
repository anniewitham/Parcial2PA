/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Personal
 */
public class VerificarConexion {
    private Socket servidor;
    public void getConexcion(/*String URL, String USER, String PASSWORD*/) {
        /*try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            if (conn != null) {
                System.out.println("¡Conexión exitosa a la base de datos!");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }*/
        
        try {
            servidor = new Socket("localhost", 3308);
            System.out.println("Servidor en espera de conversacion ......");
            //se conecta el cliente
            System.out.println("Conversacion iniciada......");
        } catch (IOException e) {
            System.out.println("Error: No se pudo crear el Servidor" + e);
        }

    }
    
}
