/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Personal
 */
public class VerificarConexion {
    
    public void getConexcion(String URL, String USER, String PASSWORD) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            if (conn != null) {
                System.out.println("¡Conexión exitosa a la base de datos!");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }
    }
}
