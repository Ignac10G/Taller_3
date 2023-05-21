package dominio;

public class Instrumento {
    private String instrumento;
    private String codigoInstrumento;
    private int stock;
    private int precio;

    public Instrumento(String instrumento,String codigoInstrumento, int stock, int precio) {
        this.instrumento = instrumento;
        this.codigoInstrumento = codigoInstrumento;
        this.stock = stock;
        this.precio = precio;
    }
    public String getInstrumento() {
        return instrumento;
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

    public void setStock(int stock) {
        this.stock = stock;
    }
}
