package edu.avanzada.parcial2.modelo;

/**
 * Clase que representa un cliente como un objeto de valor (VO, por sus siglas
 * en inglés). Contiene los datos básicos de un cliente: nombre de usuario,
 * contraseña y saldo.
 *
 * @author Juan, Ana, Samuel
 */
public class ClienteVO {

    private String usuario;
    private String contraseña;
    private int saldo;

    /**
     * Constructor para inicializar una instancia de ClienteVO con sus
     * atributos.
     *
     * @param usuario El nombre de usuario del cliente.
     * @param contraseña La contraseña del cliente.
     * @param saldo El saldo inicial asociado al cliente.
     */
    public ClienteVO(String usuario, String contraseña, int saldo) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.saldo = saldo;
    }

    /**
     * Obtiene el nombre de usuario del cliente.
     *
     * @return El nombre de usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario del cliente.
     *
     * @param usuario El nuevo nombre de usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la contraseña del cliente.
     *
     * @return La contraseña del cliente.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del cliente.
     *
     * @param contraseña La nueva contraseña del cliente.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Obtiene el saldo asociado al cliente.
     *
     * @return El saldo del cliente.
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo asociado al cliente.
     *
     * @param saldo El nuevo saldo del cliente.
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
