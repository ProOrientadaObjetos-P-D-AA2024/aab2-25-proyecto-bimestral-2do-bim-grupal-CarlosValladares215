package CONTROLER;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import MODEL.*;

public class DataBaseUtils {

    public class DatabaseUtils {

        public static String generarInsert(String tableName, String[] columnNames, Object[] values) {
            StringBuilder columns = new StringBuilder();
            StringBuilder vals = new StringBuilder();

            for (int i = 0; i < columnNames.length; i++) {
                columns.append(columnNames[i]);
                if (values[i] instanceof String) {
                    vals.append(String.format("'%s'", values[i]));
                } else {
                    vals.append(values[i]);
                }
                if (i < columnNames.length - 1) {
                    columns.append(", ");
                    vals.append(", ");
                }
            }

            return String.format("INSERT INTO %s(%s) values(%s)", tableName, columns.toString(), vals.toString());
        }

        public ArrayList<PlanMovil> procesarPlanes(String tableName, ResultSet resultSet) throws SQLException {
        ArrayList<PlanMovil> listaPlanes = new ArrayList<>();

        while (resultSet.next()) {
            PlanMovil plan;
            switch (tableName) {
                case "PlanPostPagoMinutosMegasEconomico":
                    plan = new PlanPostPagoMinutosMegasEconomico(
                            resultSet.getString("pasaporte"),
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
                            resultSet.getString("pasaporte"),
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
                            resultSet.getString("pasaporte"),
                            resultSet.getInt("minutos"),
                            resultSet.getDouble("costoMinutos"),
                            resultSet.getInt("minutoInternacional"),
                            resultSet.getDouble("costoMinutoInternacional"),
                            resultSet.getDouble("total")
                    );
                    break;
                case "PlanPostPagoMegas":
                    plan = new PlanPostPagoMegas(
                            resultSet.getString("pasaporte"),
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

        public static String generarUpdate(String tableName, PlanMovil plan, String pasaporte) {
            String strUpdate = null;
            switch (tableName) {
                case "PlanPostPagoMinutosMegasEconomico":
                    PlanPostPagoMinutosMegasEconomico plan1 = (PlanPostPagoMinutosMegasEconomico) plan;
                    strUpdate = String.format("UPDATE %s SET minutos=%d, costoMinutos=%.2f, porcentajeDescuento=%.2f, megas=%.2f, megasExpresadosGigas=%.2f, costoPorGigas=%.2f, total=%.2f WHERE pasaporte='%s'",
                            tableName, plan1.getMinutos(), plan1.getCostoMinutos(), plan1.getPorcentajeDescuento(), plan1.getMegas(), plan1.getMegasExpresadosGigas(), plan1.getCostoPorGigas(), plan1.getTotal(), pasaporte);
                    break;
                case "PlanPostPagoMinutosMegas":
                    PlanPostPagoMinutosMegas plan2 = (PlanPostPagoMinutosMegas) plan;
                    strUpdate = String.format("UPDATE %s SET minutos=%d, costoMinutos=%.2f, megas=%.2f, megasExpresadosGigas=%.2f, costoPorGigas=%.2f, total=%.2f WHERE pasaporte='%s'",
                            tableName, plan2.getMinutos(), plan2.getCostoMinutos(), plan2.getMegas(), plan2.getMegasExpresadosGigas(), plan2.getCostoPorGigas(), plan2.getTotal(), pasaporte);
                    break;
                case "PlanPostPagoMinutos":
                    PlanPostPagoMinutos plan3 = (PlanPostPagoMinutos) plan;
                    strUpdate = String.format("UPDATE %s SET minutos=%d, costoMinutos=%.2f, minutoInternacional=%d, costoMinutoInternacional=%.2f, total=%.2f WHERE pasaporte='%s'",
                            tableName, plan3.getMinutos(), plan3.getCostoMinutos(), plan3.getMinutoInternacional(), plan3.getCostoMinutoInternacional(), plan3.getTotal(), pasaporte);
                    break;
                case "PlanPostPagoMegas":
                    PlanPostPagoMegas plan4 = (PlanPostPagoMegas) plan;
                    strUpdate = String.format("UPDATE %s SET tarifaBase=%.2f, megas=%.2f, megasExpresadosGigas=%.2f, costoPorGigas=%.2f, total=%.2f WHERE pasaporte='%s'",
                            tableName, plan4.getTarifaBase(), plan4.getMegas(), plan4.getMegasExpresadosGigas(), plan4.getCostoPorGigas(), plan4.getTotal(), pasaporte);
                    break;
            }
            return strUpdate;
        }
        
        public static String generarUpdateCliente(String tableName, Clientes cliente, String pasaporte) {
            String strUpdate;
            strUpdate = String.format("UPDATE %s SET nombres='%s', ciudad='%s', marca='%s', modelo='%s', numeroCelula='%s', numeroTarjetaCredito='%s', codigo=%d, pagoMensual=%.2f, tipoDePlan_1='%s', tipoDePlan_2='%s' WHERE pasaporte='%s'",
                            tableName, cliente.getNombres(), cliente.getCiudad(), cliente.getMarca(), cliente.getModelo(), cliente.getNumeroCelular(), cliente.getNumeroTarjetaCredito(), cliente.getCodigo(), cliente.getPagoMensual(), cliente.getTipoDePlan_1(), cliente.getTipoDePlan_2(), pasaporte);
            return strUpdate;
        }
    }

}
