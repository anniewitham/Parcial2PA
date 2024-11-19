/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.avanzada.parcial2.control;

import com.edu.avanzada.parcial2.modelo.ModeloCancion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Personal
 */
public class ControlCanciones {
    public ModeloCancion modelo = new ModeloCancion();
    
    public void iniciar() throws SQLException{
        ArrayList<String> canciones = modelo.ListaCanciones();
        for (int i = 0; i < canciones.size(); i++) {
            System.out.println(canciones.get(i));
            
        }
    }
}
