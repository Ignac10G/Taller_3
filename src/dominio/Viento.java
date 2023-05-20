package dominio;

public class Viento extends Instrumento{
    private String instrumento;
    private String material;

    public Viento(String codigoInstrumento, int stock, int precio, String instrumento, String material) {
        super(codigoInstrumento, stock, precio);
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
