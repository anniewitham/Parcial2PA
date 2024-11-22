package edu.avanzada.parcial2.control;

import edu.avanzada.parcial2.modelo.*;
import edu.avanzada.parcial2.vista.*;

import java.awt.HeadlessException;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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
    private ControlServidor controlServidor;
    private ControlUsuario cliente;
    private int puerto;
    protected ClienteVO clienteVO;
    protected VentanaServidor ventanaServidor;
    protected List<CancionVO> lista;
    private boolean salir;

    private ControlMusica controlMusica;

    public ControlPrincipal(int tipo) throws IOException {
        switch (tipo) {
            case 1:
                validarUsuario = new ValidarUsuario();
                validarUsuario.botonIngresar.addActionListener(this);
                validarUsuario.botonSalir.addActionListener(this);
                validarUsuario.botonSalir.setActionCommand("Salir");

                canciones = new Canciones();
                canciones.botonSalir.addActionListener(this);
                canciones.botonDescargar.addActionListener(this);
                canciones.botonSalir.setActionCommand("Salir");

                reproductor = new Reproductor();
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
                ventanaServidor = new VentanaServidor();
                ventanaServidor.botonSalir.addActionListener(this);
                ventanaServidor.botonSalir.setActionCommand("Salir");

                ventana = "servidor";
                break;
        }

        ventanaEmergente = new VentanaEmergente();
        buscarArchivo = new VentanaBuscarArchivo();
        salir = false;

        generarConexion();
    }

    /**
     * Carga las propiedades de la base de datos desde un archivo seleccionado
     * por el usuario. Establece la conexión a la base de datos y crea
     * instancias de los objetos necesarios.
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
                    cancionDAO = new CancionDAO(conexion.getConexion());
                    lista = cancionDAO.consultarCanciones();

                    // Obtener el puerto desde el archivo de propiedades
                    puerto = Integer.parseInt(propiedades.getProperty("puerto"));

                    switch (ventana) {
                        case "cliente":
                            // Configuración para el cliente
                            clienteDAO = new ClienteDAO(conexion.getConexion());
                            validarUsuario.setVisible(true);

                            agregarCanciones(lista);
                            salir = true;
                            break;
                        case "servidor":
                            // Crear el ControlServidor con el puerto
                            ventanaServidor.setVisible(true);
                            controlServidor = new ControlServidor(puerto, this); // Pasamos el puerto
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
                if (salir) {
                    try {
                        clienteDAO.actualizarSaldo(clienteVO);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    System.exit(0);
                } else {
                    System.exit(0);
                }
                break;
            case "Ingresar":

                try {
                    if ((clienteDAO.confirmarClienteVO(validarUsuario.TextUsuario.getText(),
                            validarUsuario.TextContraseña.getPassword()))) {
                        clienteVO = clienteDAO.buscarCliente(validarUsuario.TextUsuario.getText());
                        System.out.println(clienteVO);
                        validarUsuario.dispose();
                        Inet4Address ip = null;
                        while (ip == null) {
                            ip = ventanaEmergente.ventanaIP();
                        }
                        cliente = new ControlUsuario(puerto, ip, clienteVO, this);
                        canciones.TextNombreCliente1.setText(clienteVO.getUsuario());
                        canciones.TextCuenta.setText(Integer.toString(clienteVO.getSaldo()));
                        canciones.setVisible(true);
                    } else {
                        ventanaEmergente.ventanaAtencion("Usuario o contraseña invalida!");
                    }
                } catch (SQLException e1) {
                } catch (HeadlessException e1) {
                } catch (UnknownHostException e1) {
                }
                break;
            case "Descargar Cancion":
                int seleccion = canciones.jTable1.getSelectedRow();
                String nombre = (String) canciones.jTable1.getValueAt(seleccion, 0);
                try {
                    cliente.descargarCancion(nombre);
                    // Inicia el reproductor con la canción descargada
                    
                    controlMusica = new ControlMusica(this);
                    controlMusica.cargarCancion(nombre);
                   canciones.setVisible(false);
                    reproductor.setVisible(true);

                    canciones.TextCuenta.setText(Integer.toString(clienteVO.getSaldo()));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(ControlPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ControlPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(ControlPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;


            case "Adelantar":
                controlMusica.adelantar(5000);
                break;

            case "Devolver":
                controlMusica.devolver(5000);
                break;

            case "Pausa":
                controlMusica.pausar();
                break;

            case "Play":
                controlMusica.play();
                break;
            case "Volver a la tienda":
                canciones.setVisible(true);
                canciones.setVisible(false);
                break;
        }
    }

    public void setSalir(boolean salir) {
        this.salir = salir;
    }
}
