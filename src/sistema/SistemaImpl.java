package sistema;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import coleccion.ListaInstrumento;
import dominio.Cuerda;
import dominio.Instrumento;
import dominio.Percusion;
import dominio.Viento;

public class SistemaImpl {

    private ListaInstrumento listaDeInstrumentos;

    public SistemaImpl() {
        this.listaDeInstrumentos = new ListaInstrumento(1000);
    }

    /**
     * Lectura de archivo.
     * @param nombreArchivo nombre del archivo a leer.
     */
    public void lecturaDeArchivos(String nombreArchivo) {

        File archivoDatos = new File(nombreArchivo);
        try {
            Scanner sc = new Scanner(archivoDatos);
            String aux;
            Percusion percusion;
            Viento viento;
            Cuerda cuerda;


            while(sc.hasNext()) {

                aux = sc.nextLine();
                String[] partes = aux.split(",");

                String id = partes[0];
                String codigo = partes[1];
                String precio = partes[2];
                String stock = partes[3];
                String tipo = partes[4];
                String instrumento = partes[5];
                String tipoCuerda = partes[6];
                String numeroCuerdas = partes[7];
                String material = partes[8];
                String tipoSonido = partes[9];
                String altura = partes[10];

                if (Objects.equals(tipo, "Cuerda")){
                    cuerda = new Cuerda(codigo, Integer.parseInt(stock),Integer.parseInt(precio), instrumento, tipoCuerda,Integer.parseInt(numeroCuerdas), material, tipoSonido);
                    listaDeInstrumentos.agregarInstrumento(cuerda);
                }
                if (Objects.equals(tipo, "Viento")){
                    viento= new Viento(codigo, Integer.parseInt(stock), Integer.parseInt(precio), instrumento, material);
                    listaDeInstrumentos.agregarInstrumento(viento);
                }
                if (Objects.equals(tipo, "Percusion")){
                    percusion = new Percusion(codigo, Integer.parseInt(stock), Integer.parseInt(precio), instrumento, tipoSonido, material, Integer.parseInt(altura));
                    listaDeInstrumentos.agregarInstrumento(percusion);
                }

            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void menuSistema(){

        Scanner scanner = new Scanner(System.in);

        boolean salir = false;
        while (!salir) {
            System.out.println("// Menú //");
            System.out.println("1.Agregar Instrumento");
            System.out.println("2.Vender Instrumento");
            System.out.println("3.Consultar Inventario");
            System.out.println("4.Cierre");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Archivo cargado con exito!");
                    menuSistema();
                case 2:
                    System.out.println("Ingrese el código del instrumento a vender: ");
                    String codigoVender = scanner.nextLine();
                    venderInstrumento(codigoVender);
                    break;
                case 3:
                    System.out.println("Ingrese el tipo de instrumento (Todos, Cuerda, Percusion, Viento): ");
                    //consultarInventario()
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
            System.out.println();
        }
            System.out.println("Cerrando el sofware");
    }

    public void venderInstrumento(String codigoVender) {

        int posInstrumento = listaDeInstrumentos.buscarPorCodigo(codigoVender);
        Instrumento instrumento = listaDeInstrumentos.obtenerInstrumento(posInstrumento);

        if (instrumento.getStock() > 0) {
            instrumento.setStock(instrumento.getStock() - 1);
            System.out.println("El instrumento " + instrumento.getInstrumento() + ", se ha vendido.");
            System.out.println("Al precio de: " + instrumento.getPrecio());

            gBoleta(instrumento);
        } else {
            System.out.println("El instrumento " + codigoVender + " ya no se encuentra disponible.");
        }
    }
    private void gBoleta(Instrumento instrumento) {
        System.out.println("DiscUCN Antofagasta");
        System.out.println("Fecha: 24/12/2099" );
        System.out.println("// BOLETA //");
        System.out.println("Instrumento: " + instrumento.getInstrumento());
        System.out.println("Precio: " + instrumento.getPrecio());
    }

    private void consultarInventario(){
        System.out.printf("\n" + "******************************************* \n" +
                                "-------------------Inventario----------------\n" +
                                "Seleccione su opción: \n" +
                                "[1]. Ver empleados. \n" +
                                "[2]. Ver departamentos. \n" +
                                "[3]. ingresar nuevo empleado. \n" +
                                "[4]. Ingresar nuevo departamento.\n"+
                                "[5]. Estadísticas.\n"+
                                "[6]. Salir del programa.\n"+
                                "******************************************* \n");
        System.out.println(">");
    }

}




