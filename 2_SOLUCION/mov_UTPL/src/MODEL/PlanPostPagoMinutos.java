
package MODEL;

public class PlanPostPagoMinutos extends PlanMinutos implements PlanMovil{
    public int minutoInternacional;
    public double costoMinutoInternacional;    
    
    public PlanPostPagoMinutos(int minutos, int minutoInternacional) {
        super(minutos);
        this.minutoInternacional = minutoInternacional;
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

    public void calcularCostoMinutoInternacional() {
        costoMinutoInternacional = minutoInternacional * 0.50;
    }

    @Override
    public void calcularPlan() {
        total = costoMinutos + costoMinutoInternacional;
    }
    
}
