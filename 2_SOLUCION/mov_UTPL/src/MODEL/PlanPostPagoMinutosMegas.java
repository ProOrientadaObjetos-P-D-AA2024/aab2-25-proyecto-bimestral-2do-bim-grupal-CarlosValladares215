package MODEL;

public class PlanPostPagoMinutosMegas extends PlanMinutos implements PlanMovil {

    public double megas, megasExpresadosGigas, costoPorGigas;

    public PlanPostPagoMinutosMegas(double megas, int minutos) {
        super(minutos);
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
        costoPorGigas = megasExpresadosGigas * 5;
    }

    @Override
    public void calcularPlan() {
        total = costoMinutos + costoPorGigas;
    }

}
