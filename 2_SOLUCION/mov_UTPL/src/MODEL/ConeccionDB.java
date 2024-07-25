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

    public Connection establecerConexion() {
        try {
            if (concDB == null || concDB.isClosed()) {
                String url = "jdbc:sqlite:bd/dataBase_movUTPL.db";
                concDB = DriverManager.getConnection(url);
            }
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexión: " + e.getMessage());
        }
        return concDB;
    }

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

    public void actualizarCliente(Clientes cliente) {
    try {
        establecerConexion();
        try (Statement statement = concDB.createStatement()) {
            String strUpdateEst = String.format(
                "UPDATE Clientes SET nombres = '%s', ciudad = '%s', marca = '%s', modelo = '%s', numeroCelular = '%s', numeroTarjetaCredito = '%s', codigo = %d, pagoMensual = %.2f, tipoDePlan_1 = '%s', tipoDePlan_2 = '%s' WHERE pasaporte = '%s'",
                cliente.nombres,
                cliente.ciudad,
                cliente.marca,
                cliente.modelo,
                cliente.numeroCelular,
                cliente.numeroTarjetaCredito,
                cliente.codigo,
                cliente.pagoMensual,
                cliente.tipoDePlan_1,
                cliente.tipoDePlan_2,
                cliente.pasaporte
            );
            statement.executeUpdate(strUpdateEst);
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
