
package MODEL;

public class PlanMegasGigas extends PlanMinutos{
    public double megasExpresadosGigas, costoPorGigas;

    public PlanMegasGigas(double megasExpresadosGigas, double costoPorGigas, int minutos, double costoMinutos) {
        super(minutos, costoMinutos);
        this.megasExpresadosGigas = megasExpresadosGigas;
        this.costoPorGigas = costoPorGigas;
    }
    
}
