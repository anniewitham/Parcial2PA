package edu.avanzada.parcial2.modelo;

/**
 *
 * @author Personal
 */
public class ClienteVO {
    private String usuario;
    private String contraseña;
    private String saldo;

    public ClienteVO(String usuario, String contraseña, String saldo) {
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

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }
}