package edu.avanzada.parcial2.modelo;

import java.io.File;

/**
 * Clase que representa una canción como un objeto de valor Contiene los
 * atributos básicos de una canción y los métodos para acceder y modificar su
 * información.
 *
 * @author Juan, Ana, Samuel
 */
public class CancionVO {

    private String nombre;
    private String artista;
    private File cancion;

    /**
     * Constructor para inicializar una instancia de CancionVO con sus
     * atributos.
     *
     * @param Nombre Nombre de la canción.
     * @param Artista Artista de la canción.
     * @param cancion Archivo asociado a la canción.
     */
    public CancionVO(String Nombre, String Artista, File cancion) {
        this.nombre = Nombre;
        this.artista = Artista;
        this.cancion = cancion;
    }

    /**
     * Obtiene el nombre de la canción.
     *
     * @return El nombre de la canción.
     * 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la canción.
     *
     * @param nombre El nuevo nombre de la canción.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del artista de la canción.
     *
     * @return El nombre del artista.
     */
    public String getArtista() {
        return artista;
    }

    /**
     * Establece el nombre del artista de la canción.
     *
     * @param artista El nuevo nombre del artista.
     */
    public void setArtista(String artista) {
        this.artista = artista;
    }

    /**
     * Obtiene el archivo asociado a la canción.
     *
     * @return Un objeto  que representa el archivo de la canción.
     */
    public File getCancion() {
        return cancion;
    }

    /**
     * Establece el archivo asociado a la canción.
     *
     * @param cancion Un objeto que representa el nuevo archivo de
     * la canción.
     */
    public void setCancion(File cancion) {
        this.cancion = cancion;
    }
}
