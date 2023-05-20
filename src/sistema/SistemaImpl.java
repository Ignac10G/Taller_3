package sistema;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class SistemaImpl {

    public SistemaImpl() {
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


            while(sc.hasNext()) {

                aux = sc.nextLine();
                String[] partes = aux.split(",");

                String id = partes[0];
                String codigo = partes[1];
                String precio = partes[2];
                String Stock = partes[3];
                String tipo = partes[4];
                String instrumento = partes[5];
                String tipoCuerda = partes[6];
                String numeroCuerdas = partes[7];
                String material = partes[8];
                String tipoSonido = partes[9];
                String altura = partes[10];



                System.out.println(codigo);

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
                    System.out.println("Ingrese el tipo de instrumento (Cuerda, Percusion, Viento): ");
                    lecturaDeArchivos("instrumentos.csv");
                    System.out.println("Archivo cargado con exito!");
                    menuSistema();
                case 2:
                    System.out.println("Ingrese el código del instrumento a vender: ");
                    //venderInstrumento()
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

    public void venderInstrumento() {

    }
}


