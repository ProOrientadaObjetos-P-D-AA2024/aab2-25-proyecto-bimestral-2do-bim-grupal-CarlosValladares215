
package MODEL;

public class Personas {
    public String nombres, pasaporte, ciudad, marca, numeroCelular, numeroTarjetaCredito;
    public int contraseña;
    public double pagoMensual;
    // variable que guarde dos planes Array, get impide que sean mas de dos

    public Personas(String nombres, String pasaporte, String ciudad, String marca, String numeroCelular, String numeroTarjetaCredito, int contraseña) {
        this.nombres = nombres;
        this.pasaporte = pasaporte;
        this.ciudad = ciudad;
        this.marca = marca;
        this.numeroCelular = numeroCelular;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
        this.contraseña = contraseña;
    }

    public Personas(String nombres, String pasaporte, String ciudad, String marca, String numeroCelular, String numeroTarjetaCredito, int contraseña, double pagoMensual) {
        this.nombres = nombres;
        this.pasaporte = pasaporte;
        this.ciudad = ciudad;
        this.marca = marca;
        this.numeroCelular = numeroCelular;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
        this.contraseña = contraseña;
        this.pagoMensual = pagoMensual;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getNumeroTarjetaCredito() {
        return numeroTarjetaCredito;
    }

    public void setNumeroTarjetaCredito(String numeroTarjetaCredito) {
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    public double getPagoMensual() {
        return pagoMensual;
    }

    public void setPagoMensual(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }
    
    
}
