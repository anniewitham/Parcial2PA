package edu.avanzada.parcial2.control;

import edu.avanzada.parcial2.modelo.*;
import edu.avanzada.parcial2.vista.*;

import org.junit.jupiter.api.*;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ControlPrincipalTest {

    private ControlPrincipal controlCliente;
    private ClienteVO clienteVO;
    private List<CancionVO> canciones;

    @BeforeAll
    public static void configurarEntornoGlobal() {
        System.out.println("Configurando entorno global para las pruebas...");
    }

    @AfterAll
    public static void limpiarEntornoGlobal() {
        System.out.println("Limpieza global después de las pruebas...");
    }

    @BeforeEach
    public void configurarAntesDeCadaPrueba() throws Exception {
        System.out.println("Configurando entorno antes de la prueba...");

        // Crear datos ficticios en memoria simulando archivos
        canciones = new ArrayList<>();
        canciones.add(new CancionVO("Canción 1", "Artista 1", crearArchivoTemporal("archivo1.mp3")));
        canciones.add(new CancionVO("Canción 2", "Artista 2", crearArchivoTemporal("archivo2.mp3")));
        canciones.add(new CancionVO("Canción 3", "Artista 3", crearArchivoTemporal("archivo3.mp3")));

        // Crear cliente ficticio en memoria
        clienteVO = new ClienteVO("usuario1", 100);

        // Inicializar DAOs con datos en memoria
        ClienteDAO clienteDAO = new ClienteDAO(null); 
        CancionDAO cancionDAO = new CancionDAO(null); // Pasamos `null` porque no usaremos conexión

        // Inicializar el control principal en modo cliente
        controlCliente = new ControlPrincipal(1);

        // Simular un archivo o URL para que pase directamente
        assertDoesNotThrow(() -> {
            controlCliente.buscarArchivo = new VentanaBuscarArchivo() {
                @Override
                public String buscarArchivo() {
                    return "archivo_simulado.properties"; // Simulación exitosa
                }

                @Override
                public boolean isArchivoSeleccionado() {
                    return true;
                }
            };
        });

        controlCliente.clienteDAO = clienteDAO;
        controlCliente.cancionDAO = cancionDAO;
    }

    @AfterEach
    public void limpiarDespuesDeCadaPrueba() {
        System.out.println("Limpiando entorno después de la prueba...");
        controlCliente = null;
        canciones = null;
    }

    @Test
    public void testIngresarUsuarioCorrecto() {
        System.out.println("Prueba: Ingresar con usuario correcto");

        // Simular ingreso del usuario correcto
        controlCliente.validarUsuario.TextUsuario.setText("usuario1");
        controlCliente.validarUsuario.TextContraseña.setText("contrasena"); // Simular contraseña correcta

        ActionEvent eventoIngresar = new ActionEvent(controlCliente.validarUsuario.botonIngresar, 0, "Ingresar");

        // Verificar que no lanza excepciones
        assertDoesNotThrow(() -> controlCliente.actionPerformed(eventoIngresar));

        // Validar estado esperado
        assertTrue(controlCliente.canciones.isVisible());
        assertEquals("usuario1", controlCliente.canciones.TextNombreCliente1.getText());
        assertEquals("100", controlCliente.canciones.TextCuenta.getText());
    }

    /**
     * Método auxiliar para crear archivos temporales.
     */
    private File crearArchivoTemporal(String nombre) throws IOException {
        File archivo = File.createTempFile(nombre, ".mp3");
        archivo.deleteOnExit(); // Eliminar el archivo al finalizar la JVM
        return archivo;
    }
}


