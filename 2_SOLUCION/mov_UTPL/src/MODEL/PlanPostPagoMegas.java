package MODEL;

public class PlanPostPagoMegas extends PlanMovil {

    public double tarifaBase, megas, megasExpresadosGigas, costoPorGigas;

    public PlanPostPagoMegas(String pasaporte, double tarifaBase, double megas, double megasExpresadosGigas, double costoPorGigas, double total) {
        super(pasaporte);
        this.tarifaBase = tarifaBase;
        this.megas = megas;
        this.megasExpresadosGigas = megasExpresadosGigas;
        this.costoPorGigas = costoPorGigas;
        this.total = total;
    }

    public PlanPostPagoMegas(String pasaporte, double megas) {
        super(pasaporte);
        this.megas = megas;
        tarifaBase = 0;
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

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void definirTarifaBase() {
        if (megasExpresadosGigas <= 2) {
            tarifaBase = 5;
            System.out.println("Al comprar un paquete inferior a 2 Gigas, "
                    + "usted recibe 1 Giga extra por 5$ en el mes");
        } else if (megasExpresadosGigas <= 5) {
            tarifaBase = 10;
            System.out.println("Al comprar un paquete entre 2 y 5 Gigas, "
                    + "usted recibe 10 Gigas extra por 10$ en el mes");
        } else if (megasExpresadosGigas <= 45) {
            tarifaBase = 25;
            System.out.println("Al comprar un paquete entre 5 a 12 Gigas, "
                    + "usted recibe 60 Gigas extra por 25$ en el mes");
        } else {
            tarifaBase = 40;
            System.out.println("Al comprar un paquete superior a 60 Gigas, "
                    + "usted recibe datos ilimitados por 40$ en el mes");
        }
    }

    @Override
    public void calcularPlan() {
        calcularMegasExpresadosGigas();
        calcularCostoPorGigas();
        definirTarifaBase();

        total = costoPorGigas + tarifaBase;
    }

    @Override
    public String nombrePlan() {
        String nombrePlan = "Plan Post Pago Megas";

        return nombrePlan;
    }

}
