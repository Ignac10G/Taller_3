package dominio;

public class Instrumento {
    private String codigoInstrumento;
    private int stock;
    private int precio;
    private String detallesInstrumento;

    public Instrumento(String codigoInstrumento, int stock, int precio, String detallesInstrumento) {
        this.codigoInstrumento = codigoInstrumento;
        this.stock = stock;
        this.precio = precio;
        this.detallesInstrumento = detallesInstrumento;
    }

    public String getCodigoInstrumento() {
        return codigoInstrumento;
    }

    public int getStock() {
        return stock;
    }

    public int getPrecio() {
        return precio;
    }

    public String getDetallesInstrumento() {
        return detallesInstrumento;
    }
}
