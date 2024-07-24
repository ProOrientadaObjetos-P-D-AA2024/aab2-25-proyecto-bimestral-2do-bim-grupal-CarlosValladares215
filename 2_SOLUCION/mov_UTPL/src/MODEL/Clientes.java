package MODEL;

import java.util.ArrayList;

public class Clientes {

    public String nombres, pasaporte, ciudad, marca, modelo, numeroCelular,
            numeroTarjetaCredito, tipoDePlan_1, tipoDePlan_2;
    public int codigo;
    public double pagoMensual;
    public ArrayList<PlanMovil> listaPlanes;

    public Clientes(String nombres, String pasaporte, String ciudad, String marca, String modelo, String numeroCelular, String numeroTarjetaCredito, int codigo, double pagoMensual, String tipoDePlan_1, String tipoDePlan_2) {
        this.nombres = nombres;
        this.pasaporte = pasaporte;
        this.ciudad = ciudad;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroCelular = numeroCelular;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
        this.codigo = codigo;
        this.pagoMensual = pagoMensual;
        this.tipoDePlan_1 = tipoDePlan_1;
        this.tipoDePlan_2 = tipoDePlan_2;
        listaPlanes = new ArrayList<>();
    }

    public Clientes(String nombres, String pasaporte, String ciudad, String marca, String modelo, String numeroCelular, String numeroTarjetaCredito, int codigo) {
        this.nombres = nombres;
        this.pasaporte = pasaporte;
        this.ciudad = ciudad;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroCelular = numeroCelular;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
        this.codigo = codigo;
        listaPlanes = new ArrayList<>();
    }

    public Clientes(String nombres, String pasaporte, String ciudad, String marca, String modelo, String numeroCelular, String numeroTarjetaCredito, int codigo, String tipoDePlan_1, String tipoDePlan_2) {
        this.nombres = nombres;
        this.pasaporte = pasaporte;
        this.ciudad = ciudad;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroCelular = numeroCelular;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
        this.codigo = codigo;
        this.tipoDePlan_1 = tipoDePlan_1;
        this.tipoDePlan_2 = tipoDePlan_2;
        listaPlanes = new ArrayList<>();

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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPagoMensual() {
        return pagoMensual;
    }

    public void calcularPagoMensual() {
        double valor = 0;
        for (int i = 0; i < listaPlanes.size(); i++) {
            valor = valor + listaPlanes.get(i).getTotal();
        }
        pagoMensual = valor;
    }

    public String getTipoDePlan_1() {
        return tipoDePlan_1;
    }

    public void setTipoDePlan_1(String tipoDePlan_1) {
        this.tipoDePlan_1 = tipoDePlan_1;
    }

    public String getTipoDePlan_2() {
        return tipoDePlan_2;
    }

    public void setTipoDePlan_2(String tipoDePlan_2) {
        this.tipoDePlan_2 = tipoDePlan_2;
    }

    public ArrayList<PlanMovil> getListaPlanes() {
        return listaPlanes;
    }

    public void setListaPlanes(PlanMovil plan) {
        if (!listaPlanes.isEmpty()) {
            if (listaPlanes.size() == 1) {
            listaPlanes.add(plan);
            setTipoDePlan_1(plan.nombrePlan());
            System.out.println("La compra ha sido realizada con exito");
        } else {
            if (listaPlanes.size() == 2) {
                listaPlanes.add(plan);
                setTipoDePlan_2(plan.nombrePlan());
                System.out.println("La compra ha sido realizada con exito");
            } else {
                System.out.println("Usted ha alcanzado el limite de planes activos en su cuenta");
            }
        }
        }
    }
    
    @Override
    public String toString() {
        String cadena = String.format("\nCliente\n* Nombre: %s\n* Pasaporte: %s\n* Ciudad: %s\n* Marca: %s\n* Modelo: %s\n* Número de celular: %s\n* Número de tarjeta de crédito: %s",nombres, pasaporte, ciudad,marca,modelo,numeroCelular,numeroTarjetaCredito);
        if (getListaPlanes().isEmpty()) {
            System.out.println("\t-Ninguno");
        } else {
            for (int i = 0; i < getListaPlanes().size(); i++) {
                System.out.println("\t- " + getListaPlanes().get(i).nombrePlan());
            }
        }
        cadena = String.format("%s\n* Pago Mensual: %s",cadena, pagoMensual);
        return cadena;
    }
}
