package sistema;

import dominio.Instrumento;

/**
 * Interaface que implementa los metodos del sistema.
 * @author: Ignacio Gavia
 * @author: Vicente Castro
 */

public interface Sistema {
    void lecturaDeArchivos(String nombreArchivo);

    void menuSistema();

    void venderInstrumento(String codigoVender);

    void gBoleta(Instrumento instrumento);

    void consultarInventario();

    void mostrarInstrumento(String opcion);

    String desplegarInstrumento(String codigo, String precio, String nombreInstrumento, String detallesInstrumento);

    void mostrarInstrumentoPorCodigo();
}


