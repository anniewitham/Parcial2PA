package edu.avanzada.parcial2.modelo;

/**
 *
 * @author Personal
 */
public class ClienteVO {
    private String usuario;
    private int saldo;

    public ClienteVO(String usuario, int saldo) {
        this.usuario = usuario;
        this.saldo = saldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}