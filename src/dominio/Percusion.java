package dominio;
/**
 * Esta clase almacena todos los intrumento de percusión.
 * @author: Ignacio Gavia
 * @author: Vicente Castro
 */

public class Percusion extends Instrumento{

    private String tipoPercusion;
    private String materialContruccion;
    private String altura;

    /**
     * The constructor.
     * @param codigoInstrumento
     * @param stock
     * @param precio
     * @param instrumento
     * @param tipoPercusion
     * @param materialContruccion
     * @param altura
     */

    public Percusion(String tipoInstrumento,String codigoInstrumento, int stock, int precio, String instrumento,String tipoPercusion, String materialContruccion, String altura) {
        super(tipoInstrumento,instrumento, codigoInstrumento, stock, precio);
        this.tipoPercusion = tipoPercusion;
        this.materialContruccion = materialContruccion;
        this.altura = altura;
    }
    public String getTipoPercusion() {
        return tipoPercusion;
    }

    public String getMaterialContruccion() {
        return materialContruccion;
    }

    public String getAltura() {
        return altura;
    }
}
