/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.avanzada.parcial2.control;

import Conexion.VerificarConexion;
import com.edu.avanzada.parcial2.modelo.ModeloCancion;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Personal
 */
public class Control {
    
    public static void main(String[] args) throws SQLException, IOException {
        /*ControlCanciones canC = new ControlCanciones();
        canC.iniciar();*/
        /*VerificarConexion co = new VerificarConexion();
        co.getConexcion();*/
        try {
            // Crear una instancia de ValidadorUsuario
            ValidadorUsuario validador = new ValidadorUsuario();
            
            // Validar el usuario
            boolean isUserValid = validador.Usuario("ana");
            
            if (isUserValid) {
                System.out.println("Usuario encontrado.");
            } else {
                System.out.println("Usuario no encontrado.");
            }
            
            // Cerrar la conexión
            validador.close();
        } catch (IOException e) {
            System.out.println("Error al iniciar el validador: " + e.getMessage());
        }
    }
}
