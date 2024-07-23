
package MODEL;

public class PlanPostPagoMinutos extends PlanMinutos implements PlanMovil{
    public int minutoInternacional;
    public double costoMinutoInternacional;    

    public PlanPostPagoMinutos(int minutoInternacional, double costoMinutoInternacional, int minutos, double costoMinutos) {
        super(minutos, costoMinutos);
        this.minutoInternacional = minutoInternacional;
        this.costoMinutoInternacional = costoMinutoInternacional;
    }
    
    public int getMinutoInternacional() {
        return minutoInternacional;
    }

    public void setMinutoInternacional(int minutoInternacional) {
        this.minutoInternacional = minutoInternacional;
    }

    public double getCostoMinutoInternacional() {
        return costoMinutoInternacional;
    }

    public void setCostoMinutoInternacional(double costoMinutoInternacional) {
        this.costoMinutoInternacional = costoMinutoInternacional;
    }

    @Override
    public void calcularPlan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
