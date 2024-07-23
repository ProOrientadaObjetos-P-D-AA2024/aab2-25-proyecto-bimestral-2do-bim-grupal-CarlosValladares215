
package MODEL;

import java.util.ArrayList;

public class Clientes {
    public String nombres, pasaporte, ciudad, marca, numeroCelular, 
            numeroTarjetaCredito, tipoDePlan_1, tipoDePlan_2;
    public int contraseña;
    public double pagoMensual;
    // variable que guarde dos planes Array, get impide que sean mas de dos

    public Clientes(String nombres, String pasaporte, String ciudad, String marca, String numeroCelular, String numeroTarjetaCredito, String tipoDePlan_1, String tipoDePlan_2, int contraseña, double pagoMensual) {
        this.nombres = nombres;
        this.pasaporte = pasaporte;
        this.ciudad = ciudad;
        this.marca = marca;
        this.numeroCelular = numeroCelular;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
        this.tipoDePlan_1 = tipoDePlan_1;
        this.tipoDePlan_2 = tipoDePlan_2;
        this.contraseña = contraseña;
        this.pagoMensual = pagoMensual;
    }

    public Clientes(String nombres, String pasaporte, String ciudad, String marca, String numeroCelular, String numeroTarjetaCredito, int contraseña, PlanMovil plan1) {
        ArrayList<PlanMovil> planesMoviles = new ArrayList<>();
        this.nombres = nombres;
        this.pasaporte = pasaporte;
        this.ciudad = ciudad;
        this.marca = marca;
        this.numeroCelular = numeroCelular;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
        this.contraseña = contraseña;
        planesMoviles.add(plan1);
        setTipoDePlan_1(plan1);
        
    }
    
    public Clientes(String nombres, String pasaporte, String ciudad, String marca, String numeroCelular, String numeroTarjetaCredito, int contraseña, PlanMovil plan1, PlanMovil plan2) {
        ArrayList<PlanMovil> planesMoviles = new ArrayList<>();
        this.nombres = nombres;
        this.pasaporte = pasaporte;
        this.ciudad = ciudad;
        this.marca = marca;
        this.numeroCelular = numeroCelular;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
        this.contraseña = contraseña;
        planesMoviles.add(plan1);
        planesMoviles.add(plan2);
        setTipoDePlan_1(plan1);
        setTipoDePlan_2(plan2);
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

    public void calcularPagoMensual(ArrayList<PlanMovil> planesMoviles) {
        int valor;
        for (int i = 0; i < planesMoviles.size(); i++) {
            // 
        }
    }

    public String getTipoDePlan_1() {
        return tipoDePlan_1;
    }

    private void setTipoDePlan_1(PlanMovil plan1) {
        tipoDePlan_1 = plan1.nombrePlan();
    }

    public String getTipoDePlan_2() {
        return tipoDePlan_2;
    }

    private void setTipoDePlan_2(PlanMovil plan2) {
        tipoDePlan_2 = plan2.nombrePlan();
    }

}
