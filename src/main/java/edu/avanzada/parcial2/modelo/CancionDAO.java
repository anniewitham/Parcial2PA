package edu.avanzada.parcial2.modelo;

import java.io.File;
import java.sql.*;
import java.util.*;

/**
 * La clase CancionDAO es responsable de manejar las operaciones de acceso a
 * datos relacionadas con las canciones en la base de datos
 *
 * Esta clase proporciona métodos para realizar operaciones CRUD (Crear, Leer,
 * Actualizar, Eliminar) sobre las canciones, así como consultas específicas
 * para obtener información sobre ellos. Utiliza una conexión a la base de datos
 * proporcionada en su constructor para ejecutar las consultas SQL.
 *
 * @author Juan, Ana, Samuel
 */
public class CancionDAO {

    private Connection connection;

    /**
     * Constructor de la clase RazaDAO.
     *
     * @param connection La conexión a la base de datos que se utilizará para
     * realizar las operaciones de acceso a datos.
     */
    public CancionDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Consulta todas las canciones almacenadas en la base de datos.
     *
     * @return Una lista de objetos {@code CancionVO} que representan las
     * canciones recuperadas.
     * @throws SQLException Si ocurre un error al ejecutar la consulta en la
     * base de datos.
     */
    public List<CancionVO> consultarCanciones() throws SQLException {
        List<CancionVO> canciones = new ArrayList<>();
        String sql = "SELECT * FROM canciones";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                File archivoCancion = new File(rs.getString("cancion"));

                CancionVO cancion = new CancionVO(
                        rs.getString("nombre"),
                        rs.getString("artista"),
                        archivoCancion
                );
                canciones.add(cancion);
            }
        }

        return canciones;
    }
}
