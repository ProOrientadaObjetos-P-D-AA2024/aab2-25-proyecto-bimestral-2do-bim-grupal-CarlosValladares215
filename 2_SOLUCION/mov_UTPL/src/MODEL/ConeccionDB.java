package MODEL;

import CONTROLER.DataBaseUtils.DatabaseUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import CONTROLER.DatabaseUtils;

public class ConeccionDB {

    public Connection concDB;
    public ArrayList<Clientes> listaClientes;
    public ArrayList<PlanMovil> listaPlanes;
    public String mensaje;

    public void establecerConexion() {

        try {
            String url = "jdbc:sqlite:bd/dbTest_1.db";
            // La base da datos se usa para conectarse, mientras que la tabla permite realizar acciones CRUD
            concDB = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // devuelve un valor booleano
    public Connection obtenerConeccion() {
        return concDB;
    }

    public void setConcDB(String url) {
        try {
            this.concDB = DriverManager.getConnection(url);
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
        }
    }

    // CREATED
    public void insertarRegistro(String tableName, String[] columnNames, Object[] values) {
        try {
            establecerConexion();
            try (Statement statement = concDB.createStatement()) {
                String strInsert = DatabaseUtils.generarInsert(tableName, columnNames, values);
                statement.executeUpdate(strInsert);
            }
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
        }
    }
    
    // READ #1 Leer Planes
   public ResultSet leerDatos(String tableName) {
        ResultSet resultSet = null;
        try {
            establecerConexion();
            Statement statement = concDB.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM " + tableName);
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
        }
        return resultSet;
    }
    
    // READ #2 Leer Clientes
    public ArrayList<Clientes> leerLista() {
        lista = new ArrayList<>();
        try {
            establecerConexion();
            try (Statement statement = concDB.createStatement()) {
                ResultSet resultSet = statement.executeQuery("Select * from Estudiante");
                while (resultSet.next()) {
                    lstEstudiantes.add(new Estudiante(resultSet.getString("nombreEst"),
                            resultSet.getDouble("nota1"),
                            resultSet.getDouble("nota2"),
                            resultSet.getDouble("promedio"),
                            resultSet.getString("estado"),
                            resultSet.getString("id")));
                }
            }
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
        return lstEstudiantes;
    }

    
        // UPDATE
    public void updateEstudiante(Estudiante estudiante) {
        try {
            establecerConexion();
            try (Statement statement = concDB.createStatement()) {
                String strUpdateEst = String.format("UPDATE Estudiante SET "
                        + "nombreEst = '%s', "
                        + "estado = '%s', "
                        + "nota1 = %d, "
                        + "nota2 = %d, "
                        + "promedio = %d "
                        + "WHERE id = '%s'",
                        estudiante.nombreEst, estudiante.estado, (int) estudiante.nota1, (int) estudiante.nota2, (int) estudiante.promedio, estudiante.id);
                statement.executeUpdate(strUpdateEst);
                System.out.println("Estudiante actualizado en la base de datos: " + estudiante.getNombreEst());
            }
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
            System.out.println("Error al actualizar estudiante: " + this.msj);
        }
    }

    // DELETED
    public void deletedEstudiante(String id) {
        try {
            establecerConexion();
            try (Statement statement = concDB.createStatement()) {
                String strInsertEst = String.format("delete from Estudiante where id='%s'", id);
                statement.executeUpdate(strInsertEst);
            }
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }
}
