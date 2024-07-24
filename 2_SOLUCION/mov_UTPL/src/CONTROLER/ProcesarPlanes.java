package CONTROLER;

import MODEL.ConeccionDB;
import MODEL.PlanMovil;
import MODEL.PlanPostPagoMegas;
import MODEL.PlanPostPagoMinutos;
import MODEL.PlanPostPagoMinutosMegas;
import MODEL.PlanPostPagoMinutosMegasEconomico;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProcesarPlanes {
    public ConeccionDB dbConnection;
    public ArrayList<PlanMovil> listaDePlanes;

    public ProcesarPlanes(ConeccionDB dbConnection, ArrayList<PlanMovil> listaDePlanes) {
        this.dbConnection = dbConnection;
        this.listaDePlanes = listaDePlanes;
    }
    
    
    // Insertar Datos (CREATE)
    public String[] getColumnNombresPlanPostPagoMinutosMegasEconomico() {
        return new String[]{"minutos", "costoMinutos", "porcentajeDescuento", "megas", "megasExpresadosGigas", "costoPorGigas", "total"};
    }

    public Object[] getValuesPlanPostPagoMinutosMegasEconomico(PlanPostPagoMinutosMegasEconomico plan) {
        return new Object[]{plan.getMinutos(), plan.getCostoMinutos(), plan.getPorcentajeDescuento(), plan.getMegas(), plan.getMegasExpresadosGigas(), plan.getCostoPorGigas(), plan.getTotal()};
    }

    public String[] getColumnNombresPlanPostPagoMinutosMegas() {
        return new String[]{"minutos", "costoMinutos", "megas", "megasExpresadosGigas", "costoPorGigas", "total"};
    }

    public Object[] getValuesPlanPostPagoMinutosMegas(PlanPostPagoMinutosMegas plan) {
        return new Object[]{plan.getMinutos(), plan.getMegas(), plan.getMegasExpresadosGigas(), plan.getCostoPorGigas()};
    }

    public String[] getColumnNombresPlanPostPagoMinutos() {
        return new String[]{"minutos", "costoMinutos", "minutoInternacional", "costoMinutoInternacional", "total"};
    }

    public Object[] getValuesPlanPostPagoMinutos(PlanPostPagoMinutos plan) {
        return new Object[]{plan.getMinutos(), plan.getCostoMinutos(), plan.getMinutoInternacional(), plan.getCostoMinutoInternacional(), plan.getTotal()};
    }

    public String[] getColumnNombresPlanPostPagoMegas() {
        return new String[]{"tarifaBase", "megas", "megasExpresadosGigas", "costoPorGigas", "total"};
    }

    public Object[] getValuesPlanPostPagoMegas(PlanPostPagoMegas plan) {
        return new Object[]{plan.getTarifaBase(), plan.getMegas(), plan.getMegasExpresadosGigas(), plan.getCostoPorGigas(), plan.getTotal()};
    }
    
    /*
    public PlanPostPagoMinutosMegasEconomico readPlanPostPagoMinutosMegasEconomico(ResultSet resultSet) throws SQLException {
        return new PlanPostPagoMinutosMegasEconomico(resultSet.getInt("minutos"), resultSet.getDouble("costoMinutos"),
            resultSet.getDouble("porcentajeDescuento"), resultSet.getDouble("megas"),
            resultSet.getDouble("megasExpresadosGigas"), resultSet.getDouble("costoPorGigas"), resultSet.getDouble("total"));
    }
    public PlanPostPagoMinutosMegas readColumnNombresPlanPostPagoMinutosMegas(ResultSet resultSet) throws SQLException {
        return new PlanPostPagoMinutosMegas(resultSet.getInt("minutos"), resultSet.getDouble("costoMinutos"),
            resultSet.getDouble("megas"), resultSet.getDouble("megasExpresadosGigas"),
            resultSet.getDouble("costoPorGigas"), resultSet.getDouble("total"));
    }
    
    public PlanPostPagoMinutos readColumnNombresPlanPostPagoMinutos(ResultSet resultSet) throws SQLException {
        return new PlanPostPagoMinutos(resultSet.getInt("minutos"), resultSet.getDouble("costoMinutos"),
            resultSet.getInt("minutoInternacional"), resultSet.getDouble("costoMinutoInternacional"),
            resultSet.getDouble("total"));
    }
        public PlanPostPagoMegas readColumnNombresPlanPostPagoMegas(ResultSet resultSet) throws SQLException {
        return new PlanPostPagoMegas(resultSet.getDouble("tarifaBase"), resultSet.getDouble("megas"),
            resultSet.getDouble("megasExpresadosGigas"), resultSet.getDouble("costoPorGigas"),
            resultSet.getDouble("total"));
    }*/
    public ArrayList<PlanMovil> procesarPlanes(String tableName, ResultSet resultSet) throws SQLException {
        ArrayList<PlanMovil> listaPlanes = new ArrayList<>();

        while (resultSet.next()) {
            PlanMovil plan;
            switch (tableName) {
                case "PlanPostPagoMinutosMegasEconomico":
                    plan = new PlanPostPagoMinutosMegasEconomico(
                            resultSet.getInt("minutos"),
                            resultSet.getDouble("costoMinutos"),
                            resultSet.getDouble("porcentajeDescuento"),
                            resultSet.getDouble("megas"),
                            resultSet.getDouble("megasExpresadosGigas"),
                            resultSet.getDouble("costoPorGigas"),
                            resultSet.getDouble("total")
                    );
                    break;
                case "PlanPostPagoMinutosMegas":
                    plan = new PlanPostPagoMinutosMegas(
                            resultSet.getInt("minutos"),
                            resultSet.getDouble("costoMinutos"),
                            resultSet.getDouble("megas"),
                            resultSet.getDouble("megasExpresadosGigas"),
                            resultSet.getDouble("costoPorGigas"),
                            resultSet.getDouble("total")
                    );
                    break;
                case "PlanPostPagoMinutos":
                    plan = new PlanPostPagoMinutos(
                            resultSet.getInt("minutos"),
                            resultSet.getDouble("costoMinutos"),
                            resultSet.getInt("minutoInternacional"),
                            resultSet.getDouble("costoMinutoInternacional"),
                            resultSet.getDouble("total")
                    );
                    break;
                case "PlanPostPagoMegas":
                    plan = new PlanPostPagoMegas(
                            resultSet.getDouble("tarifaBase"),
                            resultSet.getDouble("megas"),
                            resultSet.getDouble("megasExpresadosGigas"),
                            resultSet.getDouble("costoPorGigas"),
                            resultSet.getDouble("total")
                    );
                    break;
                default:
                    throw new IllegalArgumentException("Tabla no soportada: " + tableName);
            }
            listaPlanes.add(plan);
        }
        return listaPlanes;
    }
    
}
