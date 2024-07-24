package CONTROLER;

import MODEL.ConeccionDB;
import MODEL.Clientes;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcesarClientes {
    protected ConeccionDB dbConnection;
    public ArrayList<Clientes> listaDeClientes;

    public ProcesarClientes(ConeccionDB dbConnection, ArrayList<Clientes> listaDeClientes) {
        this.dbConnection = dbConnection;
        this.listaDeClientes = listaDeClientes;
    }
    public String[] getColumnNombresClientes() {
        return new String[]{"nombres", "pasaporte", "ciudad", "marca", "modelo", "numeroCelular", "numeroTarjetaCredito",  "codigo", "pagoMensual","tipoDePlan_1", "tipoDePlan_2"};
    }

    public Object[] getValuesClientes(Clientes cliente) {
        return new Object[]{cliente.getNombres(), cliente.getPasaporte(), cliente.getCiudad(), cliente.getMarca(), cliente.getModelo(), cliente.getNumeroCelular(), cliente.getNumeroTarjetaCredito(), cliente.getCodigo(), cliente.getPagoMensual(),cliente.getTipoDePlan_1(), cliente.getTipoDePlan_2()};
    }

    public ArrayList<Clientes> generarReadClientes(ResultSet resultSet) throws SQLException {
        ArrayList<Clientes> listaClientes = new ArrayList<>();
        while (resultSet.next()) {
            Clientes cliente = new Clientes(
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
                    resultSet.getString("tipoDePlan_2")
            );
            listaClientes.add(cliente);
        }
        return listaClientes;
    }
}