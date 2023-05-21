package sistema;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SistemaImpl cs = new SistemaImpl();
        cs.lecturaDeArchivos("instrumentos.csv");

        cs.menuSistema();

    }

}
