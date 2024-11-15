/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.avanzada.parcial2.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Personal
 */
public class ModeloCancion {
    Properties propiedades = new Properties();
    
    public ArrayList<String> ListaCanciones() throws SQLException{
        ArrayList<String> canciones = new ArrayList<>();
        String consulta = "SELECT nombre FROM canciones1";
        
        String URL = propiedades.getProperty("URLBD");
        String usuario = propiedades.getProperty("usuario");
        String contraseña = propiedades.getProperty("constraseña");
        
        try(Connection conn = DriverManager.getConnection(URL, usuario, contraseña); 
            Statement stmt = conn.createStatement(); 
            ResultSet rs = stmt.executeQuery(consulta)){
            
            while(rs.next()){
                canciones.add(rs.getString("nombre"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return canciones;
    }
}
