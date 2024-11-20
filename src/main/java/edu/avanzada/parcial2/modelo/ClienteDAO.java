package edu.avanzada.parcial2.modelo;

import java.sql.*;

/**
 * La clase ClienteDAO es responsable de manejar las operaciones de acceso a
 * datos relacionadas con los clientes en la base de datos
 *
 * Esta clase proporciona métodos para realizar operaciones CRUD (Crear, Leer,
 * Actualizar, Eliminar) sobre los clientes, así como consultas específicas para
 * obtener información sobre ellos. Utiliza una conexión a la base de datos
 * proporcionada en su constructor para ejecutar las consultas SQL.
 *
 * @author Juan, Ana, Samuel
 */
public class ClienteDAO {

    private Connection connection;

    /**
     * Constructor de la clase ClienteDAO.
     *
     * @param connection La conexión a la base de datos que se utilizará para
     * realizar las operaciones de acceso a datos.
     */
    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Verifica si un cliente existe en la base de datos y si su contraseña es
     * válida.
     *
     * @param nombre El nombre del cliente a verificar.
     * @param contrasena La contraseña ingresada por el cliente como un arreglo
     * de caracteres.
     * @return {@code true} si el cliente existe y la contraseña es correcta, de
     * lo contrario {@code false}.
     * @throws SQLException Si ocurre un error durante la consulta a la base de
     * datos.
     */
    public boolean confirmarClienteVO(String nombre, char[] contrasena) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE nombre = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String contrasenaIngresada = new String(contrasena);
                    String contrasenaHashAlmacenada = rs.getString("contrasena");
                    if (contrasenaHashAlmacenada.equals(contrasenaIngresada)) {
                        ClienteVO cliente = new ClienteVO(
                                rs.getString("nombre"),
                                contrasenaHashAlmacenada,
                                rs.getInt("saldo"));
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

}
