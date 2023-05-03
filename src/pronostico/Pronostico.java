package pronostico;

public class Pronostico {
    String equipo1;
    String equipo2;
    String resultado;

    public Pronostico(String equipo1, String resultado, String equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.resultado = resultado;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public String getResultado() {
        return resultado;
    }
}