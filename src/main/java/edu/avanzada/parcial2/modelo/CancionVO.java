/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.parcial2.modelo;

/**
 *
 * @author Personal
 */
public class CancionVO {
    private String Nombre;
    private String Artista;

    public CancionVO(String Nombre, String Artista) {
        this.Nombre = Nombre;
        this.Artista = Artista;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getArtista() {
        return Artista;
    }

    public void setArtista(String Artista) {
        this.Artista = Artista;
    }
    
    
}
