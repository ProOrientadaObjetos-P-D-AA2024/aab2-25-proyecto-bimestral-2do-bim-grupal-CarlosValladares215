package MODEL;

public class PlanPostPagoMinutosMegasEconomico extends PlanMinutos implements PlanMovil {

    public double porcentajeDescuento, megas, megasExpresadosGigas, costoPorGigas;

    public PlanPostPagoMinutosMegasEconomico(int minutos, double costoMinutos, double porcentajeDescuento, double megas, double megasExpresadosGigas, double costoPorGigas, double total) {
        super(minutos, costoMinutos, total);
        this.porcentajeDescuento = porcentajeDescuento;
        this.megas = megas;
        this.megasExpresadosGigas = megasExpresadosGigas;
        this.costoPorGigas = costoPorGigas;
    }


    public PlanPostPagoMinutosMegasEconomico(double megas, int minutos) {
        super(minutos);
        this.megas = megas;
        porcentajeDescuento = 1.15;
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
