package MODEL;

import CONTROLER.DataBaseUtils.DatabaseUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConeccionDB {

    public Connection concDB;
    public ArrayList<Clientes> listaClientes;
    public ArrayList<PlanMovil> listaPlanes;
    public String mensaje;

    public void establecerConexion() {

        try {
            String url = "jdbc:sqlite:bd/dataBase_movUTPL.db";
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
   
   public int obtenerCodigoPorPasaporte(String pasaporte) {
        int codigo = -1;
        try {
            establecerConexion();
            try (Statement statement = concDB.createStatement()) {
                String query = String.format("SELECT codigo FROM Clientes WHERE pasaporte = '%s'", pasaporte);
                ResultSet resultSet = statement.executeQuery(query);
                if (resultSet.next()) {
                    codigo = resultSet.getInt("codigo");
                }
            }
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
        }
        return codigo;
    }
    
   public Clientes obtenerClientePorPasaporte(String pasaporte) {
    Clientes cliente = null;
    try {
        establecerConexion();
        try (Statement statement = concDB.createStatement()) {
            String query = String.format("SELECT * FROM Clientes WHERE pasaporte = '%s'", pasaporte);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                cliente = new Clientes(
                    resultSet.getString("nombres"),
                    resultSet.getString("pasaporte"),
                    resultSet.getString("ciudad"),
                    resultSet.getString("marca"),
                    resultSet.getString("modelo"),
                    resultSet.getString("numeroCelular"),
                    resultSet.getString("numeroTarjetaCredito"),
                    resultSet.getInt("codigo"),
                    resultSet.getDouble("pagoMensual"),
                    resultSet.getString("tipoDePlan_1"),
                    resultSet.getString("tipoDePlan_2"));
            }
        }
    } catch (SQLException sqlException) {
        this.mensaje = sqlException.getMessage();
    }
    return cliente;
}

    public void actualizarRegistro(String tableName, String strUpdate) {
        try {
            establecerConexion();
            try (Statement statement = concDB.createStatement()) {
                statement.executeUpdate(strUpdate);
            }
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
        }
    }

    public void eliminarRegistro(String tableName, String strDelete) {
        try {
            establecerConexion();
            try (Statement statement = concDB.createStatement()) {
                statement.executeUpdate(strDelete);
            }
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
        }
    }
}
