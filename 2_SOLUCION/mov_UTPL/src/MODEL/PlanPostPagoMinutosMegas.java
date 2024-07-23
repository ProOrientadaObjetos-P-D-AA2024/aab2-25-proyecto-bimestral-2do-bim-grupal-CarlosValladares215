
package MODEL;

public class PlanPostPagoMinutosMegas extends PlanMegasGigas implements  PlanMovil{

    public PlanPostPagoMinutosMegas(double megasExpresadosGigas, double costoPorGigas, int minutos, double costoMinutos) {
        super(megasExpresadosGigas, costoPorGigas, minutos, costoMinutos);
    }

    @Override
    public void calcularPlan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
