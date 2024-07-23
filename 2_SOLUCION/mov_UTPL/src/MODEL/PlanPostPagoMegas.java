
package MODEL;

public class PlanPostPagoMegas extends PlanMegasGigas implements PlanMovil{
    private double tarifaBase;

    public PlanPostPagoMegas(double tarifaBase, double megasExpresadosGigas, double costoPorGigas, int minutos, double costoMinutos) {
        super(megasExpresadosGigas, costoPorGigas, minutos, costoMinutos);
        this.tarifaBase = tarifaBase;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }
    
    @Override
    public void calcularPlan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
