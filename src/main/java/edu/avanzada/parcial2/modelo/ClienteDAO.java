package edu.avanzada.parcial2.modelo;

import java.sql.*;

/**
 * La clase ClienteDAO es responsable de manejar las operaciones de acceso a
 * datos
 * relacionadas con los clientes en la base de datos
 * 
 * Esta clase proporciona métodos para realizar operaciones CRUD (Crear, Leer,
 * Actualizar, Eliminar) sobre los clientes, así como consultas específicas para
 * obtener información sobre ellos. Utiliza una conexión a la base de datos
 * proporcionada
 * en su constructor para ejecutar las consultas SQL.
 *
 * @author Juan, Ana, Samuel
 */
public class ClienteDAO {
    private Connection connection;

    /**
     * Constructor de la clase RazaDAO.
     *
     * @param connection La conexión a la base de datos que se utilizará para
     *                   realizar las operaciones de acceso a datos.
     */
    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Busca una raza en la base de datos según su nombre.
     *
     * @param nombre El nombre de la raza a buscar.
     * @return Un objeto RazaVO que representa la raza encontrada, o null si no se
     *         encuentra.
     * @throws SQLException Si ocurre un error al realizar la operación en la base
     *                      de datos.
     */
    public ClienteVO confirmarClienteVO(String nombre, String contrasena) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE nombre = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    if (rs.getString("contrasena").equals(contrasena)) {
                        return new ClienteVO(
                                rs.getString("nombre"),
                                rs.getString("contrasena"),
                                rs.getString("saldo"));
                    } else {
                        return null;
                    }
                }
            }
        }
        return null;
    }
}
