package MODEL;

public class Sesion {
    private Clientes cliente;

    public void iniciarSesion(Clientes cliente) {
        this.cliente = cliente;
    }

    public void cerrarSesion() {
        this.cliente = null;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public boolean sesionIniciada() {
        return cliente != null;
    }
}