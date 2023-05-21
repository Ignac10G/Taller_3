package dominio;

public class Viento extends Instrumento{
    private String material;

    public Viento(String tipoInstrumento,String codigoInstrumento, int stock, int precio, String instrumento, String material) {
        super(tipoInstrumento,instrumento, codigoInstrumento, stock, precio);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
}
