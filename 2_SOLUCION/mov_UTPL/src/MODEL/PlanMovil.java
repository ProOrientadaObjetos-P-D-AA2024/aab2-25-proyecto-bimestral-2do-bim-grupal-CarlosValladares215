
package MODEL;

public abstract class PlanMovil {
    protected String pasaporte;
    protected double total;

    public PlanMovil(String pasaporte) {
        this.pasaporte = pasaporte;
    }
    
    public abstract void calcularPlan();
    public abstract String nombrePlan();

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    /*
    package MODEL;

public abstract interface PlanMovil {
    public abstract void calcularPlan();
    public abstract String nombrePlan(); 
}
    */
}
