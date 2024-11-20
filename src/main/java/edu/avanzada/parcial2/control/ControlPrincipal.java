package edu.avanzada.parcial2.control;

import edu.avanzada.parcial2.modelo.*;
import edu.avanzada.parcial2.vista.*;
import java.awt.event.*;
import java.io.*;

import java.sql.SQLException;
import java.util.*;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ana Quintero, Juan Avila, Samuel Barrera
 */
public class ControlPrincipal implements ActionListener {

    protected Canciones canciones;
    protected ValidarUsuario validarUsuario;
    protected Reproductor reproductor;
    protected VentanaEmergente ventanaEmergente;
    protected VentanaBuscarArchivo buscarArchivo;
    protected Conexion conexion;
    protected ClienteDAO clienteDAO;
    protected CancionDAO cancionDAO;
    protected ControlUsuario controlUsuario;
    private String ventana;

    public ControlPrincipal(int tipo) throws IOException {
        switch (tipo) {
            case 1:
                validarUsuario = new ValidarUsuario(this);
                validarUsuario.botonIngresar.addActionListener(this);
                validarUsuario.botonSalir.addActionListener(this);
                validarUsuario.botonSalir.setActionCommand("Salir");

                canciones = new Canciones(this);
                canciones.botonSalir.addActionListener(this);
                canciones.botonDescargar.addActionListener(this);
                canciones.botonSalir.setActionCommand("Salir");

                reproductor = new Reproductor(this);
                reproductor.BotonDevolver.addActionListener(this);
                reproductor.botonAdelantar.addActionListener(this);
                reproductor.botonPausa.addActionListener(this);
                reproductor.botonPlay.addActionListener(this);
                reproductor.botonVolverTienda.addActionListener(this);
                reproductor.botonSalir.addActionListener(this);
                reproductor.botonSalir.setActionCommand("Salir");

                ventana = "cliente";
                break;
            case 2:
                ventana = "servidor";
               
                break;
        }

        ventanaEmergente = new VentanaEmergente();
        buscarArchivo = new VentanaBuscarArchivo();

        generarConexion();
    }

    /**
     * Carga las propiedades de la base de datos desde un archivo seleccionado por
     * el usuario.
     * Establece la conexión a la base de datos y crea instancias de los objetos
     * necesarios.
     */
    private void generarConexion() {
    boolean archivoSeleccionado = false;

    while (!archivoSeleccionado) {
        try {
            // Buscar archivo de propiedades
            String rutaArchivo = buscarArchivo.buscarArchivo();

            if (buscarArchivo.isArchivoSeleccionado()) {
                // Cargar propiedades desde el archivo
                Properties propiedades = new Properties();
                propiedades.load(new FileInputStream(rutaArchivo));

                // Obtener las propiedades de la base de datos
                String urlBD = propiedades.getProperty("URLBD");
                String usuario = propiedades.getProperty("usuario");
                String contrasena = propiedades.getProperty("contrasena");

                if (urlBD == null || usuario == null || contrasena == null) {
                    ventanaEmergente.ventanaError("Faltan propiedades en el archivo.");
                    continue;
                }

                // Crear conexión a la base de datos
                conexion = new Conexion(urlBD, usuario, contrasena);

                // Obtener el puerto desde el archivo de propiedades
                String puertoStr = propiedades.getProperty("puerto", "50"); // Si no hay puerto, usa 50 por defecto
                int puerto = Integer.parseInt(puertoStr);

                switch (ventana) {
                    case "cliente":
                        // Configuración para el cliente
                        clienteDAO = new ClienteDAO(conexion.getConexion());
                        cancionDAO = new CancionDAO(conexion.getConexion());
                        validarUsuario.setVisible(true);

                        // Mostrar canciones en la vista
                        DefaultTableModel model = (DefaultTableModel) canciones.jTable1.getModel();
                        model.setRowCount(0);

                        List<CancionVO> lista = cancionDAO.consultarCanciones();
                        agregarCanciones(lista);
                        break;
                    case "servidor":
                        // Crear el ControlServidor con el puerto
                        ControlServidor controlServidor = new ControlServidor(puerto); // Pasamos el puerto
                        controlServidor.iniciar(); // Llamamos al método iniciar() para iniciar el servidor
                        break;
                    default:
                        break;
                }
                archivoSeleccionado = true;
            } else {
                ventanaEmergente.ventanaAtencion("Debes seleccionar un archivo de propiedades.");
            }
        } catch (IOException e) {
            ventanaEmergente.ventanaError("Error al cargar propiedades: " + e.getMessage());
            archivoSeleccionado = true;
        } catch (SQLException e) {
            ventanaEmergente.ventanaError("Error al acceder a la base de datos: " + e.getMessage());
            archivoSeleccionado = true;
        } catch (Exception e) {
            ventanaEmergente.ventanaError("Error inesperado: " + e.getMessage());
        }
    }
}

    private void agregarCanciones(List<CancionVO> lista) {
        DefaultTableModel model = (DefaultTableModel) canciones.jTable1.getModel();
        model.setRowCount(0);

        for (CancionVO cancion : lista) {
            Object[] rowData = {
                cancion.getNombre(),
                cancion.getArtista()
            };
            model.addRow(rowData);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Salir":
                System.exit(0);
                break;
            case "Ingresar":
                try {
                    if((clienteDAO.confirmarClienteVO(validarUsuario.TextUsuario.getText(), validarUsuario.TextContraseña.getPassword()))) {
                        validarUsuario.dispose();
                        canciones.setVisible(true);
                    } else {
                        ventanaEmergente.ventanaAtencion("Usuario o contraseña invalida!");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
            case "Descargar Cancion":
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
}