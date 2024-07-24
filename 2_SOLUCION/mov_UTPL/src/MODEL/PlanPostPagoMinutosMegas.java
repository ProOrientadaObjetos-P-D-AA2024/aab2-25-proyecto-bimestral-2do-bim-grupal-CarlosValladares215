package MODEL;

public class PlanPostPagoMinutosMegas extends PlanMinutos{

    public double megas, megasExpresadosGigas, costoPorGigas;

    public PlanPostPagoMinutosMegas(String pasaporte, int minutos, double costoMinutos, double megas, double megasExpresadosGigas, double costoPorGigas, double todos) {
        super(pasaporte, minutos, costoMinutos, todos);
        this.megas = megas;
        this.megasExpresadosGigas = megasExpresadosGigas;
        this.costoPorGigas = costoPorGigas;
    }

    public PlanPostPagoMinutosMegas(String pasaporte, int minutos, double megas) {
        super(pasaporte, minutos);
        this.megas = megas;
    }


    public double getMegas() {
        return megas;
    }

    public double getMegasExpresadosGigas() {
        return megasExpresadosGigas;
    }

    public void calcularMegasExpresadosGigas() {
        megasExpresadosGigas = megas / 1024;
    }

    public double getCostoPorGigas() {
        return costoPorGigas;
    }

    public void calcularCostoPorGigas() {
        costoPorGigas = megasExpresadosGigas * 1.5;
    }

    @Override
    public void calcularPlan() {
        calcularCostoMinutos();
        calcularMegasExpresadosGigas();
        calcularCostoMinutos();

        total = costoMinutos + costoPorGigas;
    }

    @Override
    public String nombrePlan() {
        String nombrePlan = "Plan Post Pago Minutos Megas";
        return nombrePlan;
    }
}
