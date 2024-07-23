
package MODEL;

public class PlanPostPagoMinutosMegasEconomico extends PlanMegasGigas implements PlanMovil{
    public double porcentajeDescuento;

    public PlanPostPagoMinutosMegasEconomico(double porcentajeDescuento, double megasExpresadosGigas, double costoPorGigas, int minutos, double costoMinutos) {
        super(megasExpresadosGigas, costoPorGigas, minutos, costoMinutos);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
    
    @Override
    public void calcularPlan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
