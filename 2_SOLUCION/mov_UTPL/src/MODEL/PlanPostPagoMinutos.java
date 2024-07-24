package MODEL;

public class PlanPostPagoMinutos extends PlanMinutos implements PlanMovil {

    public int minutoInternacional;
    public double costoMinutoInternacional;

    public PlanPostPagoMinutos(int minutos, double costoMinutos, int minutoInternacional, double costoMinutoInternacional, double total) {
        super(minutos, costoMinutos, total);
        this.minutoInternacional = minutoInternacional;
        this.costoMinutoInternacional = costoMinutoInternacional;
    }

    

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
        calcularCostoMinutos();
        calcularCostoMinutoInternacional();

        total = costoMinutos + costoMinutoInternacional;
    }

    @Override
    public String nombrePlan() {
        String nombrePlan = "Plan Post Pago Minutos";
        return nombrePlan;
    }
}
