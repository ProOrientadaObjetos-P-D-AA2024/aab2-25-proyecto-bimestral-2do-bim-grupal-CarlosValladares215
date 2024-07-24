package MODEL;

public class PlanPostPagoMinutosMegasEconomico extends PlanMinutos {

    public double porcentajeDescuento, megas, megasExpresadosGigas, costoPorGigas;

    public PlanPostPagoMinutosMegasEconomico(String pasaporte, int minutos, double costoMinutos, double porcentajeDescuento, double megas, double megasExpresadosGigas, double costoPorGigas, double todos) {
        super(pasaporte, minutos, costoMinutos, todos);
        this.porcentajeDescuento = porcentajeDescuento;
        this.megas = megas;
        this.megasExpresadosGigas = megasExpresadosGigas;
        this.costoPorGigas = costoPorGigas;
    }

    public PlanPostPagoMinutosMegasEconomico(String pasaporte, int minutos, double megas) {
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

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public void calcularPlan() {
        calcularCostoMinutos();
        calcularMegasExpresadosGigas();
        calcularCostoPorGigas();

        double costos = costoMinutos + costoPorGigas;
        double calculoPorcentaje = costos * porcentajeDescuento;
        total = porcentajeDescuento - calculoPorcentaje;
    }

    @Override
    public String nombrePlan() {
        String nombrePlan = "Plan Post Pago Minutos Megas Economico";
        return nombrePlan;
    }
}
