package edu.avanzada.parcial2.modelo;

/**
 *
 * @author Personal
 */
public class ClienteVO {
    private String usuario;
    private String contraseña;
    private int saldo;

    public ClienteVO(String usuario, String contraseña, int saldo) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.saldo = saldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}