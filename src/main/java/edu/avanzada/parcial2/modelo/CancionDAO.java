package edu.avanzada.parcial2.modelo;

import java.sql.*;
import java.util.*;

/**
 * La clase CancionDAO es responsable de manejar las operaciones de acceso a
 * datos relacionadas con las canciones en la base de datos
 * 
 * Esta clase proporciona métodos para realizar operaciones CRUD (Crear, Leer,
 * Actualizar, Eliminar) sobre las canciones, así como consultas específicas para
 * obtener información sobre ellos. Utiliza una conexión a la base de datos
 * proporcionada
 * en su constructor para ejecutar las consultas SQL.
 *
 * @author Juan, Ana, Samuel
 */
public class CancionDAO {
    private Connection connection;

    /**
     * Constructor de la clase RazaDAO.
     *
     * @param connection La conexión a la base de datos que se utilizará para
     *                   realizar las operaciones de acceso a datos.
     */
    public CancionDAO(Connection connection) {
        this.connection = connection;
    }


    public List<CancionVO> consultarCanciones() throws SQLException {
        List<CancionVO> canciones = new ArrayList<>();
        String sql = "SELECT * FROM canciones";
    
        try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                CancionVO cancion = new CancionVO(
                        rs.getString("nombre"),
                        rs.getString("artista"),
                        rs.getBytes("cancion")
                );
                canciones.add(cancion);
            }
        }
    
        return canciones;
    }

    /**public CancionVO buscarCancion(String nombre) throws SQLException {
        String sql = "SELECT * FROM canciones WHERE nombre = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new CancionVO(
                        rs.getString("nombre"),
                        rs.getString("pais_origen"),
                        rs.getString("grupo_fci"),
                        rs.getString("seccion_fci"),
                        rs.getString("apariencia_general"),
                        rs.getString("pelo"),
                        rs.getString("color"),
                        rs.getString("espalda"),
                        rs.getString("lomo"),
                        rs.getString("cola"),
                        rs.getString("pecho")
                    );
                }
            }
        }
        return null;
    }*/
}