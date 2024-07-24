package CONTROLER;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import MODEL.*;

public class CRUD_Planes extends ProcesarPlanes {

    public CRUD_Planes(ConeccionDB dbConnection, ArrayList<PlanMovil> listaDePlanes) {
        super(dbConnection, listaDePlanes);
    }

    public void insertarPlan(PlanMovil plan) {
        if (plan instanceof PlanPostPagoMinutosMegasEconomico) {
            dbConnection.insertarRegistro("PlanPostPagoMinutosMegasEconomico", getColumnNombresPlanPostPagoMinutosMegasEconomico(), getValuesPlanPostPagoMinutosMegasEconomico((PlanPostPagoMinutosMegasEconomico) plan));
        } else if (plan instanceof PlanPostPagoMinutosMegas) {
            dbConnection.insertarRegistro("PlanPostPagoMinutosMegas", getColumnNombresPlanPostPagoMinutosMegas(), getValuesPlanPostPagoMinutosMegas((PlanPostPagoMinutosMegas) plan));
        } else if (plan instanceof PlanPostPagoMinutos) {
            dbConnection.insertarRegistro("PlanPostPagoMinutos", getColumnNombresPlanPostPagoMinutos(), getValuesPlanPostPagoMinutos((PlanPostPagoMinutos) plan));
        } else if (plan instanceof PlanPostPagoMegas) {
            dbConnection.insertarRegistro("PlanPostPagoMegas", getColumnNombresPlanPostPagoMegas(), getValuesPlanPostPagoMegas((PlanPostPagoMegas) plan));
        }
    }
    
    public ArrayList<PlanMovil> leerRegistroPlan(String tableName) {
        ArrayList<PlanMovil> listaPlanes = new ArrayList<>();
        try {
            dbConnection.establecerConexion();
            try (Statement statement = dbConnection.obtenerConeccion().createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
                listaPlanes = procesarPlanes(tableName, resultSet);
            }
        } catch (SQLException sqlException) {
            System.out.println("Error al obtener planes: " + sqlException.getMessage());
        }
        return listaPlanes;
}}
