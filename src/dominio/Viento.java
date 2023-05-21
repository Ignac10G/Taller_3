package dominio;
/**
 * Esta clase almacena todos los intrumento de viento.
 * @author: Ignacio Gavia
 * @author: Vicente Castro
 */
public class Viento extends Instrumento{
    private String material;
    /**
     *  The constructor.
     * @param codigoInstrumento
     * @param stock
     * @param precio
     * @param instrumento
     * @param material
     */
    public Viento(String tipoInstrumento,String codigoInstrumento, int stock, int precio, String instrumento, String material) {
        super(tipoInstrumento,instrumento, codigoInstrumento, stock, precio);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
}
