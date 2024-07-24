package VIEW;

import MODEL.PlanMovil;
import MODEL.PlanPostPagoMinutosMegasEconomico;
import CONTROLER.*;
import MODEL.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejecutor {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        ConeccionDB dbConnection = new ConeccionDB();
        ArrayList<Clientes> listaCliente = new ArrayList<>();
        ArrayList<PlanMovil> listaPlanes = new ArrayList<>();
        CRUD_Planes dataPlanes = new CRUD_Planes(dbConnection, listaPlanes);
        CRUD_Clientes dataClientes = new CRUD_Clientes(dbConnection, listaCliente);
        Sesion sesion = new Sesion();

        String nombre, pasaporte = null, ciudad, marca, modelo, numeroCelular,
                numeroTarjetaCredito, TipoDePlan_1, TipoDePlan_2, respuestCompra;
        int codigo, minutos, minutoInternacional;
        double pagoMensual, megas;

        String cadenaOpcion = "Iniciar Sesión";
        String cadenaOpcion2 = "Registrarse";
        do {
            System.out.println("Bienvenido al Sistema de Gestión de clientes y facturación");
            System.out.println("1. " + cadenaOpcion);
            System.out.println("2. " + cadenaOpcion2);
            System.out.println("3. Base de Datos");
            System.out.println("4. Generar Factura");
            System.out.println("5. Salir");
            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    if (cadenaOpcion.equals("Iniciar Sesión")) {
                        System.out.println("Ingresa su pasaporte");
                        pasaporte = entrada.nextLine();
                        System.out.println("Ingrese su contraseña");
                        codigo = entrada.nextInt();
                        entrada.nextLine();

                        int codigoBD = dataClientes.obtenerCodigoPorPasaporte(pasaporte);
                        if (codigoBD == -1) {
                            System.out.println("Pasaporte no encontrado.");
                        } else if (codigoBD == codigo) {
                            cadenaOpcion = "Comprar un Plan";
                            cadenaOpcion2 = "Eliminar Plan";
                            Clientes cliente = dataClientes.obtenerClientePorPasaporte(pasaporte);
                            sesion.iniciarSesion(cliente);
                            System.out.println("Inicio de sesión exitoso.");
                        } else {
                            System.out.println("Contraseña incorrecta.");
                        }
                    } else {
                        System.out.println("Elija uno de los siguientes planes en venta");
                        System.out.println("\t1. Plan Post Pago Minutos Megas Economico");
                        System.out.println("\t2. Plan Post Pago Minutos Megas");
                        System.out.println("\t3. Plan Post Pago Minutos");
                        System.out.println("\t4. Plan Post Pago Megas");
                        int planOP = entrada.nextInt();
                        entrada.nextLine();

                        switch (planOP) {
                            case 1:
                                System.out.println("El siguiente plan le ofrece un paquete"
                                        + "de megas y llamadas personalizadas en una forma"
                                        + "economica ¿Desea comprar la tarifa?(s/n)");
                                respuestCompra = entrada.nextLine();
                                if (respuestCompra.equalsIgnoreCase("s")) {
                                    System.out.println("Ingrese el numero de megas que se desea adquirir");
                                    megas = entrada.nextDouble();
                                    System.out.println("Ingrese la cantidad de minutos que se desea adquirir");
                                    minutos = entrada.nextInt();

                                    PlanPostPagoMinutosMegasEconomico planComprado = new PlanPostPagoMinutosMegasEconomico(sesion.getCliente().getPasaporte(), minutos, megas);
                                    planComprado.calcularPlan();
                                    sesion.getCliente().setListaPlanes(planComprado);
                                    sesion.getCliente().calcularPagoMensual();
                                    
                                    dataClientes.actualizarCliente(sesion.getCliente());
                                } else {
                                    System.out.println("La compra ha sido cancelada");
                                }
                                break;
                            case 2:
                                System.out.println("El siguiente plan le ofrece un paquete"
                                        + "de megas y llamadas personalizadas. "
                                        + "¿Desea comprar la tarifa?(s/n)");
                                respuestCompra = entrada.nextLine();
                                if (respuestCompra.equalsIgnoreCase("s")) {
                                    System.out.println("Ingrese el numero de megas que se desea adquirir");
                                    megas = entrada.nextDouble();
                                    System.out.println("Ingrese la cantidad de minutos que se desea adquirir");
                                    minutos = entrada.nextInt();

                                    PlanPostPagoMinutosMegas planComprado = new PlanPostPagoMinutosMegas(sesion.getCliente().getPasaporte(), minutos, megas);
                                    planComprado.calcularPlan();
                                    sesion.getCliente().setListaPlanes(planComprado);
                                    sesion.getCliente().calcularPagoMensual();
                                    dataClientes.actualizarCliente(sesion.getCliente());
                                } else {
                                    System.out.println("La compra ha sido cancelada");
                                }
                                break;
                            case 3:
                                System.out.println("El siguiente plan le ofrece un paquete"
                                        + "de llamadas internacionales y nacionales. "
                                        + "¿Desea comprar la tarifa?(s/n)");
                                respuestCompra = entrada.nextLine();
                                if (respuestCompra.equalsIgnoreCase("s")) {
                                    System.out.println("Ingrese el numero de minutos internacionales que se desea adquirir");
                                    minutoInternacional = entrada.nextInt();
                                    System.out.println("Ingrese la cantidad de minutos nacionales que se desea adquirir");
                                    minutos = entrada.nextInt();

                                    PlanPostPagoMinutos planComprado = new PlanPostPagoMinutos(sesion.getCliente().getPasaporte(), minutos, minutoInternacional);
                                    planComprado.calcularPlan();
                                    sesion.getCliente().setListaPlanes(planComprado);
                                    sesion.getCliente().calcularPagoMensual();
                                    dataClientes.actualizarCliente(sesion.getCliente());
                                } else {
                                    System.out.println("La compra ha sido cancelada");
                                }
                                break;
                            case 4:
                                System.out.println("El siguiente plan le ofrece un paquete"
                                        + "de megas, con diferentes opciones. "
                                        + "¿Desea comprar la tarifa?(s/n)");
                                respuestCompra = entrada.nextLine();
                                if (respuestCompra.equalsIgnoreCase("s")) {
                                    System.out.println("Ingrese el numero de megas que se desea adquirir");
                                    megas = entrada.nextDouble();

                                    PlanPostPagoMegas planComprado = new PlanPostPagoMegas(sesion.getCliente().getPasaporte(), megas);
                                    planComprado.calcularPlan();
                                    sesion.getCliente().setListaPlanes(planComprado);
                                    sesion.getCliente().calcularPagoMensual();
                                    dataClientes.actualizarCliente(sesion.getCliente());
                                } else {
                                    System.out.println("La compra ha sido cancelada");
                                }
                                break;
                            default:
                                throw new AssertionError();
                        }
                    }

                    break;
                case 2:
                    if (cadenaOpcion2.equals("Registrarse")) {
                        System.out.println("Ingrese los datos del cliente:");
                        System.out.print("Nombres: ");
                        nombre = entrada.nextLine();
                        System.out.print("Pasaporte: ");
                        pasaporte = entrada.nextLine();
                        System.out.print("Ciudad: ");
                        ciudad = entrada.nextLine();
                        System.out.print("Marca: ");
                        marca = entrada.nextLine();
                        System.out.print("Modelo: ");
                        modelo = entrada.nextLine();
                        System.out.print("Número de Celular: ");
                        numeroCelular = entrada.nextLine();
                        System.out.print("Número de Tarjeta de Crédito: ");
                        numeroTarjetaCredito = entrada.nextLine();
                        System.out.print("Contraseña: ");
                        codigo = entrada.nextInt();
                        entrada.nextLine();

                        Clientes nuevoCliente = new Clientes(nombre, pasaporte, ciudad, marca, modelo, numeroCelular, numeroTarjetaCredito, codigo, 0, "", "");
                        dataClientes.insertarCliente(nuevoCliente);
                        System.out.println("Cliente registrado exitosamente.");
                    } else {
                        System.out.println("Elija el plan a eliminar:");
                        Clientes cliente = dataClientes.obtenerClientePorPasaporte(pasaporte);
                        System.out.println("1. " + cliente.getTipoDePlan_1());
                        System.out.println("2. " + cliente.getTipoDePlan_2());
                        opcion = entrada.nextInt();
                        entrada.nextLine();

                        switch (opcion) {
                            case 1: {
                                String tipoDePlan = cliente.getTipoDePlan_1();
                                cliente.setTipoDePlan_1("");
                                dataPlanes.eliminarPlan(tipoDePlan, cliente.getPasaporte());
                                System.out.println("Plan " + tipoDePlan + " eliminado exitosamente.");
                                break;
                            }
                            case 2: {
                                String tipoDePlan = cliente.getTipoDePlan_2();
                                cliente.setTipoDePlan_2("");
                                dataPlanes.eliminarPlan(tipoDePlan, cliente.getPasaporte());
                                System.out.println("Plan " + tipoDePlan + " eliminado exitosamente.");
                                break;
                            }
                            default:
                                System.out.println("Opción inválida.");
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("1. Crear Cliente");
                    System.out.println("2. Leer Clientes");
                    System.out.println("3. Actualizar Cliente");
                    System.out.println("4. Eliminar Cliente");
                    int crudOpcion = entrada.nextInt();
                    entrada.nextLine(); // Consumir la nueva línea

                    switch (crudOpcion) {
                        case 1:
                            System.out.println("Ingrese los datos del cliente:");
                            System.out.print("Nombres: ");
                            nombre = entrada.nextLine();
                            System.out.print("Pasaporte: ");
                            pasaporte = entrada.nextLine();
                            System.out.print("Ciudad: ");
                            ciudad = entrada.nextLine();
                            System.out.print("Marca: ");
                            marca = entrada.nextLine();
                            System.out.print("Modelo: ");
                            modelo = entrada.nextLine();
                            System.out.print("Número de Celular: ");
                            numeroCelular = entrada.nextLine();
                            System.out.print("Número de Tarjeta de Crédito: ");
                            numeroTarjetaCredito = entrada.nextLine();
                            System.out.print("Contraseña: ");
                            codigo = entrada.nextInt();
                            entrada.nextLine(); // Consumir la nueva línea

                            Clientes nuevoCliente = new Clientes(nombre, pasaporte, ciudad, marca, modelo, numeroCelular, numeroTarjetaCredito, codigo, 0, "", "");
                            dataClientes.insertarCliente(nuevoCliente);
                            System.out.println("Cliente registrado exitosamente.");
                            break;
                        case 2:
                            System.out.println("Lista de Clientes:");
                            listaCliente = dataClientes.leerRegistroClientes();
                            for (Clientes c : listaCliente) {
                                System.out.println(c);
                            }
                            break;
                        case 3:
                            System.out.print("Ingrese el pasaporte del cliente a actualizar: ");
                            pasaporte = entrada.nextLine();
                            Clientes clienteActualizado = dataClientes.obtenerClientePorPasaporte(pasaporte);
                            if (clienteActualizado == null) {
                                System.out.println("Cliente no encontrado.");
                            } else {
                                System.out.println("Ingrese los nuevos datos del cliente:");
                                System.out.print("Nombres: ");
                                clienteActualizado.setNombres(entrada.nextLine());
                                System.out.print("Ciudad: ");
                                clienteActualizado.setCiudad(entrada.nextLine());
                                System.out.print("Marca: ");
                                clienteActualizado.setMarca(entrada.nextLine());
                                System.out.print("Modelo: ");
                                clienteActualizado.setModelo(entrada.nextLine());
                                System.out.print("Número de Celular: ");
                                clienteActualizado.setNumeroCelular(entrada.nextLine());
                                System.out.print("Número de Tarjeta de Crédito: ");
                                clienteActualizado.setNumeroTarjetaCredito(entrada.nextLine());
                                System.out.print("Contraseña: ");
                                clienteActualizado.setCodigo(entrada.nextInt());

                                dataClientes.actualizarCliente(clienteActualizado);
                                System.out.println("Cliente actualizado exitosamente.");
                            }
                            break;
                        case 4:
                            System.out.print("Ingrese el pasaporte del cliente a eliminar: ");
                            pasaporte = entrada.nextLine();
                            dataClientes.eliminarCliente(pasaporte);
                            dataPlanes.eliminarPlan("PlanPostPagoMinutosMegasEconomico", pasaporte);
                            dataPlanes.eliminarPlan("PlanPostPagoMinutos", pasaporte);
                            dataPlanes.eliminarPlan("PlanPostPagoMegas", pasaporte);
                            dataPlanes.eliminarPlan("PlanPostPagoMinutosMegas", pasaporte);
                            System.out.println("Cliente eliminado exitosamente.");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                    break;
                case 4:
                    if (sesion.getCliente() != null) {
                        generarFactura(sesion.getCliente());
                    } else {
                        System.out.println("Debe iniciar sesión primero.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (true);
    }

    private static void generarFactura(Clientes cliente) {
        System.out.println("\nFactura:");
        System.out.println("Nombre: " + cliente.getNombres());
        System.out.println("Pasaporte: " + cliente.getPasaporte());
        System.out.println("Ciudad: " + cliente.getCiudad());
        System.out.println("Marca: " + cliente.getMarca());
        System.out.println("Número de celular: " + cliente.getNumeroCelular());
        System.out.println("Número de tarjeta de crédito: " + cliente.getNumeroTarjetaCredito());
        System.out.println("Planes comprados: ");
        if (cliente.getListaPlanes().isEmpty()) {
            System.out.println("\t-Ninguno");
        } else {
            for (int i = 0; i < cliente.getListaPlanes().size(); i++) {
                System.out.println("\t- " + cliente.getListaPlanes().get(i).nombrePlan());
            }
        }
        System.out.println("Pago Mensual: " + cliente.getPagoMensual());
    }
}
