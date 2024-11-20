package edu.avanzada.parcial2.control;

import edu.avanzada.parcial2.modelo.*;
import edu.avanzada.parcial2.vista.*;
import java.awt.event.*;
import java.io.*;
import java.sql.SQLException;
import java.util.*;

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
                String rutaArchivo = buscarArchivo.buscarArchivo();

                if (buscarArchivo.isArchivoSeleccionado()) {
                    Properties propiedades = new Properties();
                    propiedades.load(new FileInputStream(rutaArchivo));

                    String urlBD = propiedades.getProperty("URLBD");
                    String usuario = propiedades.getProperty("usuario");
                    String contrasena = propiedades.getProperty("contrasena");

                    if (urlBD == null || usuario == null || contrasena == null) {
                        ventanaEmergente.ventanaError("Faltan propiedades en el archivo.");
                        continue;
                    }

                    conexion = new Conexion(urlBD, usuario, contrasena);
                    switch (ventana) {
                        case "cliente":
                            clienteDAO = new ClienteDAO(conexion.getConexion());
                            controlUsuario = new ControlUsuario();
                            validarUsuario.setVisible(true);
                            break;
                        case "servidor":
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Salir":
                System.exit(0);
                break;
            case "Ingresar":
                /**if((clienteDAO.confirmarClienteVO(validarUsuario.(), validarUsuario.get))) {

                }
                break;*/
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}