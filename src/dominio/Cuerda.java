package dominio;

public class Cuerda extends Instrumento{
    private String instrumento;
    private String tipoCuerda;
    private int numeroCuerdas;
    private String materialConstruccion;
    private String tipo;

    public Cuerda(String codigoInstrumento, int stock, int precio, String instrumento, String tipoCuerda, int numeroCuerdas, String materialConstruccion, String tipo) {
        super(codigoInstrumento, stock, precio);
        this.instrumento = instrumento;
        this.tipoCuerda = tipoCuerda;
        this.numeroCuerdas = numeroCuerdas;
        this.materialConstruccion = materialConstruccion;
        this.tipo = tipo;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public String getTipoCuerda() {
        return tipoCuerda;
    }

    public int getNumeroCuerdas() {
        return numeroCuerdas;
    }

    public String getMaterialConstruccion() {
        return materialConstruccion;
    }

    public String getTipo() {
        return tipo;
    }
}
