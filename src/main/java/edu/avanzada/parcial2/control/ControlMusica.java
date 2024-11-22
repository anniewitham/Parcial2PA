package edu.avanzada.parcial2.control;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



public class ControlMusica{
    private Clip clip;
    private AudioInputStream audioInputStream;
    private File archivoActual;
    private boolean enPausa = false;
    private ControlPrincipal control;
    

    public void cargarCancion(String rutaArchivo) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        archivoActual = new File(rutaArchivo);
        audioInputStream = AudioSystem.getAudioInputStream(archivoActual);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
    }
    
     public void reproducirCancion(File archivo) {
        try {
            cargarCancion(archivo.getAbsolutePath());
            play();
            control.reproductor.actualizarNombreCancion(getCancionActual());
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
           control.ventanaEmergente.ventanaError("Error al reproducir la canción: " + e.getMessage());
        }
    }

    public ControlMusica(ControlPrincipal control) {
        this.control = control;
    }
    public void play() {
        if (enPausa) {
            clip.start();
            enPausa = false;
        } else {
            clip.setFramePosition(0); // Reinicia la canción si estaba detenida
            clip.start();
        }
    }

    public void pausar() {
        if (clip.isRunning()) {
            clip.stop();
            enPausa = true;
        }
    }


    public void adelantar(int milisegundos) {
        int posicion = clip.getFramePosition() + milisegundos * (int) clip.getFormat().getFrameRate() / 1000;
        clip.setFramePosition(Math.min(posicion, clip.getFrameLength()));
    }

    public void devolver(int milisegundos) {
        int posicion = clip.getFramePosition() - milisegundos * (int) clip.getFormat().getFrameRate() / 1000;
        clip.setFramePosition(Math.max(posicion, 0));
    }

    public String getCancionActual() {
        return archivoActual.getName();
    }
}