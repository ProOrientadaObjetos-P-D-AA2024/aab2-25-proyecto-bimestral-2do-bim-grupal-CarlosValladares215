package MODEL;

public class PlanPostPagoMinutos extends PlanMinutos{

    public int minutoInternacional;
    public double costoMinutoInternacional;

    public PlanPostPagoMinutos(String pasaporte, int minutos, double costoMinutos, int minutoInternacional, double costoMinutoInternacional, double todos) {
        super(pasaporte, minutos, costoMinutos, todos);
        this.minutoInternacional = minutoInternacional;
        this.costoMinutoInternacional = costoMinutoInternacional;
    }

    public PlanPostPagoMinutos(String pasaporte, int minutos, int minutoInternacional) {
        super(pasaporte, minutos);
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
