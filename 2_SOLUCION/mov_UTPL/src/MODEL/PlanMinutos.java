
package MODEL;

public class PlanMinutos {
    public int minutos;
    public double costoMinutos;
    public double total;

    public PlanMinutos(int minutos) {
        this.minutos = minutos;
    }
    
    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public double getCostoMinutos() {
        return costoMinutos;
    }

    public void calcularCostoMinutos() {
        /*
        Precio del minuto de llamada celular en Ecuador
        Precio final: $ 0,0448 incluido impuestos
        */
        costoMinutos = minutos * 0.0448;
    }

}
