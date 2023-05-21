package coleccion;

import dominio.Instrumento;

import java.util.Objects;

public class ListaInstrumento {
    private int cantidadMaxima;
    private int cantidadInstrumento;
    private final Instrumento[] listaInstrumento;

    public ListaInstrumento(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.cantidadInstrumento = 0;
        this.listaInstrumento = new Instrumento[cantidadMaxima];
    }
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
    public Instrumento buscarInstrumento(Instrumento instrumento){
        for (int i = 0; i < cantidadInstrumento; i++) {
            if (listaInstrumento[i] == instrumento){
                return listaInstrumento[i];
            }
        }
        return null;
    }
    public boolean eliminarInstrumento(String codigo){
        int pos = this.buscarPorCodigo(codigo);
        if(pos < 0){
            return false;
        }
        this.listaInstrumento[pos] = null;
        this.cantidadInstrumento--;
        return true;
    }

    public int buscarPorCodigo(String codigo){
        for (int i = 0; i <cantidadMaxima; i++) {
            if (this.listaInstrumento[i] != null && Objects.equals(this.listaInstrumento[i].getCodigoInstrumento(), codigo)){
                return i;
            }
        }
        return -1;
    }

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
