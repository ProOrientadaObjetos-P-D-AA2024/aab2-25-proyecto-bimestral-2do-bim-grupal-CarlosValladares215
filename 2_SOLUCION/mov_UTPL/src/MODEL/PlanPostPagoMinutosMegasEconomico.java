package MODEL;

public class PlanPostPagoMinutosMegasEconomico extends PlanMinutos implements PlanMovil {

    public double porcentajeDescuento;

    public double megas, megasExpresadosGigas, costoPorGigas;

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
        costoPorGigas = megasExpresadosGigas * 5;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void calcularPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public void calcularPlan() {
        double costos = costoMinutos + costoPorGigas;
        double calculoPorcentaje = costos * porcentajeDescuento;
        total = porcentajeDescuento - calculoPorcentaje;
    }
}
