package dominio;

public class Percusion extends Instrumento{

    private String tipoPercusion;
    private String materialContruccion;
    private float altura;

    public Percusion(String codigoInstrumento, int stock, int precio, String instrumento, String tipoPercusion, String materialContruccion, float altura) {
        super(instrumento, codigoInstrumento, stock, precio);
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

    public float getAltura() {
        return altura;
    }
}
