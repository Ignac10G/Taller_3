package dominio;

public class Percusion extends Instrumento{

    private String tipoPercusion;
    private String materialContruccion;
    private String altura;


    public Percusion(String tipoInstrumento,String instrumento,String codigoInstrumento, int stock, int precio, String tipoPercusion, String materialContruccion, String altura) {
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
