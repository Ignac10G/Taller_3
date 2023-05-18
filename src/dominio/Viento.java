package dominio;

public class Viento extends Instrumento{
    private String instrumento;
    private String material;

    public Viento(String codigoInstrumento, int stock, int precio, String detallesInstrumento, String instrumento, String material) {
        super(codigoInstrumento, stock, precio, detallesInstrumento);
        this.instrumento = instrumento;
        this.material = material;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public String getMaterial() {
        return material;
    }
}
