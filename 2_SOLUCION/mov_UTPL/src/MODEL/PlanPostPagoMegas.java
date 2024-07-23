
package MODEL;

public class PlanPostPagoMegas implements PlanMovil{
    public double tarifaBase, megas, megasExpresadosGigas, costoPorGigas, total;

    public PlanPostPagoMegas(double megas) {
        this.megas = megas;
        tarifaBase = 10;
    }
    
    
    public double getMegas() {
        return megas;
    }
    
    public double getMegasExpresadosGigas() {
        return megasExpresadosGigas;
    }

    public void calcularMegasExpresadosGigas() {
        megasExpresadosGigas = megas/1024;
    }

    public double getCostoPorGigas() {
        return costoPorGigas;
    }

    public void calcularCostoPorGigas() {
        costoPorGigas = megasExpresadosGigas*5;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void definirTarifaBase() {
        if (100 <= megasExpresadosGigas) {
            tarifaBase = 20;
        }else{
            if (150 <= megasExpresadosGigas) {
                tarifaBase = 30;
            }else{
                tarifaBase = 40;
            }
        }
    }
    
    @Override
    public void calcularPlan() {
        total = costoPorGigas + tarifaBase;
    }
    
    
}
