package edu.avanzada.parcial2.control;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
/**
 * Clase para gestionar la reproducción de música.
 * Proporciona funcionalidades para cargar, reproducir, pausar, adelantar y retroceder audio.
 @author  Juan Avila, Ana Quintero, Samuel Barrera
 */
public class ControlMusica {

    private ControlPrincipal control;
    private Clip clip;

    public ControlMusica() {
    }

   

    /**
     * Carga un archivo de audio y lo prepara para su reproducción.
     * 
     * @param archivo Archivo de audio a cargar.
     * @throws IOException                  Si ocurre un error al leer el archivo.
     * @throws UnsupportedAudioFileException Si el formato de audio no es compatible.
     * @throws LineUnavailableException     Si no se puede acceder al sistema de audio.
     */
     public void cargarCancion(File archivo) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivo);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

    /**
     * Reproduce el audio desde el inicio.
     */
     public void play() {
        if (clip != null) {
            clip.setFramePosition(0); // Reproducir desde el inicio
            clip.start();
        }
    }

    /**
     * Pausa la reproducción actual.
     */
    public void pausar() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }


    /**
     * Avanza la reproducción 5 segundos.
     */
    public void adelantar() {
    if (clip != null) {
        int nuevaPosicion = clip.getFramePosition() + (int) (clip.getFormat().getFrameRate() * 5);
        if (nuevaPosicion < clip.getFrameLength()) {
            clip.setFramePosition(nuevaPosicion);
        } else {
            clip.setFramePosition(clip.getFrameLength() - 1);
        }
    }
}

    /**
     * Retrocede la reproducción 5 segundos.
     */
    public void devolver() {
        if (clip != null) {
            int nuevaPosicion = clip.getFramePosition() - (int) (clip.getFormat().getFrameRate() * 5);
            clip.setFramePosition(Math.max(nuevaPosicion, 0));
        }
    }

}
