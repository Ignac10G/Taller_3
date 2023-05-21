package coleccion;

import dominio.Instrumento;

import java.util.Objects;

/**
 * Esta clase almacena los datos de los intrumentos.
 * @author: Ignacio Gavia
 * @author: Vicente Castro
 */

public class ListaInstrumento {
    private int cantidadMaxima;
    private int cantidadInstrumento;
    private final Instrumento[] listaInstrumento;

    /**
     * Este método define la cantidad maxima de intrumentos.
     * @param cantidadMaxima limite de la lista.
     */
    public ListaInstrumento(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.cantidadInstrumento = 0;
        this.listaInstrumento = new Instrumento[cantidadMaxima];
    }

    /**
     * Este método agrega un intrumento limitado por la cantidad maxima.
     * @param instrumento Instrumento a almacenar.
     *
     */
    public void agregarInstrumento(Instrumento instrumento){
        if (this.buscarPorCodigo(instrumento.getCodigoInstrumento()) != -1){
            throw new IllegalArgumentException("El instrumento ya existe.");
        }
        if (this.cantidadInstrumento == this.cantidadMaxima){
            System.out.println("No se pueden almacenar mas datos");
        }
        for (int i = 0; i < cantidadMaxima; i++) {
            if (this.listaInstrumento[i]== null){
                this.listaInstrumento[i] = instrumento;
                this.cantidadInstrumento++;
                return;
            }
        }
        throw new IllegalArgumentException("No se encontro espacio disponible.");
    }
    /**
     * Este método elimina un intrumento dentro de la lista que le pasemos por parámetro.
     * @param codigo Codigo de instrumento a comprobar.
     * @return boolean que confirma en la lista el codigo del intrumento a eliminar.
     */
    public boolean eliminarInstrumento(String codigo){
        int pos = this.buscarPorCodigo(codigo);
        if(pos < 0){
            return false;
        }
        this.listaInstrumento[pos] = null;
        this.cantidadInstrumento--;
        return true;
    }
    /**
     * Este método busca el instrumento por codigo que le pasemos por parámetro.
     * @param codigo Codigo de intrumento a buscar.
     * @return Verifica la existencia del instrumento mediante el codigo.
     */
    public int buscarPorCodigo(String codigo){
        for (int i = 0; i <cantidadMaxima; i++) {
            if (this.listaInstrumento[i] != null && Objects.equals(this.listaInstrumento[i].getCodigoInstrumento(), codigo)){
                return i;
            }
        }
        return -1;
    }
    /**
     * Este método obtiene el instrumento mediante una posición.
     * @param pos posicion a buscar del intrumento.
     * @return Instrumento buscado.
     */
    public Instrumento obtenerInstrumento(int pos){
        if(pos < 0 || pos >= this.cantidadMaxima){
            throw new IllegalArgumentException("Posicion no valida");
        }
        return this.listaInstrumento[pos];
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public int getCantidadInstrumento() {
        return cantidadInstrumento;
    }

    public Instrumento[] getListaInstrumento() {
        return listaInstrumento;
    }
    public Instrumento getInstrumento(int posicion){
        return listaInstrumento[posicion];
    }
}
