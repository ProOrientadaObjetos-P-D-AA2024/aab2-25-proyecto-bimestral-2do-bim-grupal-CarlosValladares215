
package MODEL;

public class PlanMinutos {
    public int minutos;
    public double costoMinutos;

    public PlanMinutos(int minutos, double costoMinutos) {
        this.minutos = minutos;
        this.costoMinutos = costoMinutos;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public double getCostoMinutos() {
        return costoMinutos;
    }

    public void setCostoMinutos(double costoMinutos) {
        this.costoMinutos = costoMinutos;
    }

}
