package edu.avanzada.parcial2.modelo;

import java.io.File;

/**
 *
 * @author Personal
 */
public class CancionVO {
    private String nombre;
    private String artista;
    private byte[] cancion;

    public CancionVO(String Nombre, String Artista, byte[] cancion) {
        this.nombre = Nombre;
        this.artista = Artista;
        this.cancion = cancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
    
    public byte[] getCancion(){
        return cancion;
    }

    public void setCancion(byte[] cancion) {
        this.cancion = cancion;
    }
}
