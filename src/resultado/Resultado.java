package resultado;

public class Resultado {
    private String equipo1;
    private int goles1;
    private int goles2;
    private String equipo2;

    public Resultado(String equipo1, int goles1, int goles2, String equipo2) {
        this.equipo1 = equipo1;
        this.goles1 = goles1;
        this.goles2 = goles2;
        this.equipo2 = equipo2;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public int getGoles1() {
        return goles1;
    }

    public void setGoles1(int goles1) {
        this.goles1 = goles1;
    }

    public int getGoles2() {
        return goles2;
    }

    public void setGoles2(int goles2) {
        this.goles2 = goles2;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }
}