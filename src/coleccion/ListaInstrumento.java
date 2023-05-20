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
    public void agregarInstrumento(Instrumento instrumento){
        if (cantidadInstrumento == cantidadMaxima){
            System.out.println("No se pueden almacenar mas datos");
        }
        listaInstrumento[cantidadInstrumento] = instrumento;
        cantidadInstrumento ++;
    }
    public Instrumento obtenerInstrumento(Instrumento instrumento){
        for (int i = 0; i < cantidadInstrumento; i++) {
            if (listaInstrumento[i] == instrumento){
                return listaInstrumento[i];
            }
        }
        return null;
    }
    public boolean eliminarInstrumento(Instrumento instrumento){
        for (int i = 0; i < cantidadInstrumento; i++) {
            if (listaInstrumento[i] == instrumento){
                cantidadInstrumento--;
                return true;
            }
        }
        return false;

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
