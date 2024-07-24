package CONTROLER;

import MODEL.Clientes;
import MODEL.ConeccionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CRUD_Clientes extends ProcesarClientes {

    public CRUD_Clientes(ConeccionDB dbConnection, ArrayList<Clientes> listaDeClientes) {
        super(dbConnection, listaDeClientes);
    }

    public void insertarCliente(Clientes cliente) {
        dbConnection.insertarRegistro("Clientes", getColumnNombresClientes(), getValuesClientes(cliente));
    }

    public ArrayList<Clientes> leerRegistroClientes() {
        System.out.println("");
        ArrayList<Clientes> listaClientes = new ArrayList<>();
        try {
            dbConnection.establecerConexion();
            try (Statement statement = dbConnection.obtenerConeccion().createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Clientes");
                listaClientes = generarReadClientes(resultSet);
            }
        } catch (SQLException sqlException) {
            System.out.println("Error al obtener clientes: " + sqlException.getMessage());
        }
        return listaClientes;
    }

    public void actualizarCliente(Clientes cliente) {
        System.out.println("");
        listaDeClientes.set(listaDeClientes.indexOf(cliente), cliente);
        (new ConeccionDB()).actualizarCliente(cliente);
    }

    public void eliminarCliente(String pasaporte) {
        System.out.println("");
        dbConnection.eliminarRegistro("Clientes", "pasaporte = '" + pasaporte + "'");
    }

    public void setListaDeClientes(Clientes cliente) {
        listaDeClientes.add(cliente);
    }

    public int obtenerCodigoPorPasaporte(String pasaporte) {
        return dbConnection.obtenerCodigoPorPasaporte(pasaporte);
    }

    public Clientes obtenerClientePorPasaporte(String pasaporte) {
        return dbConnection.obtenerClientePorPasaporte(pasaporte);
    }

}
