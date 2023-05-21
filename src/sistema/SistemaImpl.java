package sistema;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

import coleccion.ListaInstrumento;
import dominio.Cuerda;
import dominio.Instrumento;
import dominio.Percusion;
import dominio.Viento;

/**
 * Esta clase implementa los metodos del sistema.
 * @author: Ignacio Gavia
 * @author: Vicente Castro
 */
public class SistemaImpl implements Sistema{

    private ListaInstrumento listaDeInstrumentos;

    /**
     * The constructor.
     */
    public SistemaImpl() {
        this.listaDeInstrumentos = new ListaInstrumento(1000);
    }

    /**
     * Lectura de archivo.
     * @param nombreArchivo nombre del archivo a leer.
     */
    @Override
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
                    cuerda = new Cuerda(tipo,codigo, Integer.parseInt(stock),Integer.parseInt(precio), instrumento, tipoCuerda,Integer.parseInt(numeroCuerdas), material, tipoSonido);
                    listaDeInstrumentos.agregarInstrumento(cuerda);
                }
                if (Objects.equals(tipo, "Viento")){
                    viento= new Viento(tipo,codigo, Integer.parseInt(stock), Integer.parseInt(precio), instrumento, material);
                    listaDeInstrumentos.agregarInstrumento(viento);
                }
                if (Objects.equals(tipo, "Percusion")){
                    percusion = new Percusion(tipo, codigo, Integer.parseInt(stock), Integer.parseInt(precio), instrumento,tipoCuerda, material, altura);
                    listaDeInstrumentos.agregarInstrumento(percusion);
                }

            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Este método se encarga del control del menu principal del sofware.
     */
    @Override
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
                    consultarInventario();
                    break;
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
    /**
     * Este método se encarga de quitar el intrumento por el codigo que se entrega por párametro.
     * @param codigoVender Codigo solicitado de intrumento a vender.
     */
    @Override
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
    /**
     * Este método se encarga de generar la boleta por el intrumento que se entrega por párametro.
     * @param instrumento Intrumento solicitado mediante el codigo entregado.
     */
    @Override
    public void gBoleta(Instrumento instrumento) {
        Date todayDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String fechaActual = sdf.format(todayDate);
        double n = Math.random()*1000 + 100;

        System.out.println("-------DiscUCN Antofagasta------");
        System.out.println("-------Rut: 96620260-2------");
        System.out.println("======================================");
        System.out.println("Fecha: " + fechaActual );
        System.out.println("Numero de boleta: " + (int)n );
        System.out.println("Sucursal: Av. Angamos 610 ");
        System.out.println("Tienda: Antofagasta  ");

        System.out.println("======================================");
        System.out.println("// BOLETA ELECTRONICA//");
        System.out.println("Instrumento: " + instrumento.getInstrumento());
        System.out.println("Precio: " + instrumento.getPrecio());
        System.out.println("======================================");
    }
    /**
     * Este método se encarga de consultar el inventario mediante un menu.
     */
    @Override
    public void consultarInventario(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n" + "******************************************* \n" +
                                "-------------------Inventario----------------\n" +
                                "Seleccione su opción: \n" +
                                "[1]. Ver todos los intrumentos. \n" +
                                "[2]. Ver instrumentos tipo cuerda. \n" +
                                "[3]. Ver instrumentos tipo viento. \n" +
                                "[4]. Ver instrumentos tipo percusion.\n"+
                                "[5]. Buscar instrumento por codigo.\n"+
                                "[6]. Salir del inventario.\n"+
                                "******************************************* \n");
        System.out.println(">");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion){
            case 1:
                mostrarInstrumento("TODOS");
                break;
            case 2:
                mostrarInstrumento("Cuerda");
                break;
            case 3:
                mostrarInstrumento("Viento");
                break;
            case 4:
                mostrarInstrumento("Percusion");
                break;
            case 5:
                mostrarInstrumentoPorCodigo();
                break;
            case 6:
                menuSistema();
                break;
            default:
                System.out.println("Opción inválida. Intente nuevamente.");
        }
    }

    /**
     * Este método se encarga de mostrar mediante consola los instrumentos disponibles.
     * @param opcion tipo de intrumento a imprimir.
     */
    @Override
    public void mostrarInstrumento(String opcion){
        Instrumento instrumento;
        String codigo;
        int precio;
        String tipo;
        String nombreInstrumento;
        String tipoCuerda;
        int numeroCuerda;
        String material;
        String tipoSonido;
        String altura;
        String detallesInstrumentos;
        for (int i = 0; i < listaDeInstrumentos.getCantidadInstrumento(); i++) {
            instrumento = listaDeInstrumentos.getInstrumento(i);
            codigo = instrumento.getCodigoInstrumento();
            precio = instrumento.getPrecio();
            tipo = instrumento.getTipoInstrumento();
            nombreInstrumento = instrumento.getInstrumento();
            if (Objects.equals(tipo, "Cuerda")) {
                Cuerda instrumentoCuerda = (Cuerda) instrumento;
                tipoCuerda = instrumentoCuerda.getTipoCuerda();
                numeroCuerda = instrumentoCuerda.getNumeroCuerdas();
                material = instrumentoCuerda.getMaterialConstruccion();
                tipoSonido = instrumentoCuerda.getTipo();
                detallesInstrumentos = "Tipo de cuerda: " + tipoCuerda + "\nN° de cuerdas: " + numeroCuerda + "\nMaterial de construccion: " + material + "\nTipo de sonido: " + tipoSonido;
                if (opcion == "TODOS"|| opcion == "Cuerda") {
                    System.out.println(desplegarInstrumento(codigo, String.valueOf(precio), nombreInstrumento, detallesInstrumentos));
                }
            }
            if (Objects.equals(tipo, "Viento")) {
                Viento instrumentoViento = (Viento) instrumento;
                material = instrumentoViento.getMaterial();
                detallesInstrumentos = "Material de construccion: " + material;

                if (opcion == "TODOS"|| opcion == "Viento") {
                    System.out.println(desplegarInstrumento(codigo, String.valueOf(precio), nombreInstrumento, detallesInstrumentos));
                }
            }
            if (Objects.equals(tipo, "Percusion")) {
                Percusion intrumentoPercusion = (Percusion) instrumento;
                tipoCuerda = intrumentoPercusion.getTipoPercusion();
                material = intrumentoPercusion.getMaterialContruccion();
                altura = intrumentoPercusion.getAltura();
                detallesInstrumentos = "Tipo de percusion: " + tipoCuerda + "\nMateial de construccion: " + material + "\n Altura: " + altura;
                if (opcion == "TODOS"|| opcion == "Percusión") {
                    System.out.println(desplegarInstrumento(codigo, String.valueOf(precio), nombreInstrumento, detallesInstrumentos));
                }
            }
        }
    }

    /**
     * Este metodo imprime mediante consola la descripcion de cada instrumento.
     * @param codigo codigo del instrumento.
     * @param precio porecio del instrumento.
     * @param nombreInstrumento nombre del instrumento.
     * @param detallesInstrumento detalles del instrumento.
     *
     */
    @Override
    public String desplegarInstrumento(String codigo, String precio, String nombreInstrumento, String detallesInstrumento){
        return("**********************************************************************\n"+
                "  Codigo: "+codigo+"\n"+
                "  Precio: "+ precio+"\n"+
                "  Intrumento: "+nombreInstrumento+"\n"+
                "  Descripcion\n"+detallesInstrumento+"\n"+
                "***********************************************************************");
    }

    /**
     * Este metodo muestra mediante consola los detalles del instrumento buscado mediante su codigo.
     */
    @Override
    public void mostrarInstrumentoPorCodigo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el codigo de instrumento: ");
        String codigo = scanner.nextLine();
        int pos = listaDeInstrumentos.buscarPorCodigo(codigo);
        Instrumento instrumento = listaDeInstrumentos.obtenerInstrumento(pos);

        int precio = instrumento.getPrecio();
        String tipo = instrumento.getTipoInstrumento();
        String nombreInstrumento = instrumento.getInstrumento();
        String tipoCuerda;
        int numeroCuerda;
        String material;
        String tipoSonido;
        String detallesInstrumentos;
        String altura;

        if (Objects.equals(tipo, "Cuerda")){
            tipoCuerda = ((Cuerda) instrumento).getTipoCuerda();
            numeroCuerda = ((Cuerda) instrumento).getNumeroCuerdas();
            material = ((Cuerda) instrumento).getMaterialConstruccion();
            tipoSonido = ((Cuerda) instrumento).getTipo();
            detallesInstrumentos = "Tipo de cuerda: " + tipoCuerda + "\nN° de cuerdas: " + numeroCuerda + "\nMaterial de construccion: " + material + "\nTipo de sonido: " + tipoSonido;
            System.out.println(desplegarInstrumento(codigo, String.valueOf(precio), nombreInstrumento, detallesInstrumentos));
        }
        if (Objects.equals(tipo, "Viento")){
            material = ((Viento) instrumento).getMaterial();
            detallesInstrumentos = "Material de construccion: " + material;
            System.out.println(desplegarInstrumento(codigo, String.valueOf(precio), nombreInstrumento, detallesInstrumentos));

        }
        if (Objects.equals(tipo, "Percusion")){
            Percusion intrumentoPercusion = (Percusion) instrumento;
            tipoCuerda = intrumentoPercusion.getTipoPercusion();
            material = intrumentoPercusion.getMaterialContruccion();
            altura = intrumentoPercusion.getAltura();
            detallesInstrumentos = "Tipo de percusion: " + tipoCuerda + "\nMateial de construccion: " + material + "\n Altura: " + altura;
            System.out.println(desplegarInstrumento(codigo, String.valueOf(precio), nombreInstrumento, detallesInstrumentos));
        }
        menuSistema();

    }



}




