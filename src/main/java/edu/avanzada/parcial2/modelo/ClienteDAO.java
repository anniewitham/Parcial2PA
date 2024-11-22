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
     * Constructor de la clase ClienteDAO.
     *
     * @param connection La conexión a la base de datos que se utilizará para
     *                   realizar las operaciones de acceso a datos.
     */
    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

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

    public ClienteVO buscarCliente(String nombre) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE nombre = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ClienteVO(
                            rs.getString("nombre"),
                            rs.getInt("saldo"));
                }
            }
        }
        return null;
    }

    public void actualizarSaldo(ClienteVO cliente) throws SQLException {
        String sql = "UPDATE usuarios SET saldo = ? WHERE nombre = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getSaldo());
            stmt.setString(2, cliente.getUsuario());
            stmt.executeUpdate();
        }
    }

    public int buscarSaldo(ClienteVO cliente) throws SQLException {
        String sql = "SELECT saldo FROM usuarios WHERE nombre = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getUsuario());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Devolver el saldo si existe
                    return rs.getInt("saldo");
                }
            }
        }
        return 0;
    }
}