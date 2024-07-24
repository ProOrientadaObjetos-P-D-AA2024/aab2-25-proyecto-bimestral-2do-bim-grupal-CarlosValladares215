
package MODEL;

public class PlanMinutos extends PlanMovil{
    public int minutos;
    public double costoMinutos;

    public PlanMinutos( String pasaporte, int minutos, double costoMinutos, double todos) {
        super(pasaporte);
        this.minutos = minutos;
        this.costoMinutos = costoMinutos;
    }

    public PlanMinutos(String pasaporte, int minutos) {
        super(pasaporte);
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

    @Override
    public void calcularPlan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String nombrePlan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
