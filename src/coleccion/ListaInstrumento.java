package coleccion;

import dominio.Instrumento;

public class ListaInstrumento {
    private int cantidadMaxima;
    private int cantidadInstrumento;
    private Instrumento[] listaInstrumento;

    public ListaInstrumento(int cantidadMaxima, int cantidadInstrumento, Instrumento[] listaInstrumento) {
        this.cantidadMaxima = cantidadMaxima;
        this.cantidadInstrumento = cantidadInstrumento;
        this.listaInstrumento = new Instrumento[cantidadMaxima];
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
}
