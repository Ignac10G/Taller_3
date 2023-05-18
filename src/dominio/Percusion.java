package dominio;

public class Percusion extends Instrumento{
    private String instrumento;
    private String tipoPercusion;
    private String materialContruccion;
    private float altura;

    public Percusion(String codigoInstrumento, int stock, int precio, String detallesInstrumento, String instrumento, String tipoPercusion, String materialContruccion, float altura) {
        super(codigoInstrumento, stock, precio, detallesInstrumento);
        this.instrumento = instrumento;
        this.tipoPercusion = tipoPercusion;
        this.materialContruccion = materialContruccion;
        this.altura = altura;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public String getTipoPercusion() {
        return tipoPercusion;
    }

    public String getMaterialContruccion() {
        return materialContruccion;
    }

    public float getAltura() {
        return altura;
    }
}
