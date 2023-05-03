package partido;

import resultado.Resultado;

public class Partido {
    private String equipo1;
    private String equipo2;
    private int goles1;
    private int goles2;
    
    public Partido(Resultado resultado1, Resultado resultado2, boolean usarResultado1) {
        if (usarResultado1) {
            this.equipo1 = resultado1.getEquipo1();
            this.equipo2 = resultado1.getEquipo2();
            this.goles1 = resultado1.getGoles1();
            this.goles2 = resultado1.getGoles2();
        } else {
            this.equipo1 = resultado2.getEquipo1();
            this.equipo2 = resultado2.getEquipo2();
            this.goles1 = resultado2.getGoles1();
            this.goles2 = resultado2.getGoles2();
        }
    }
    
    public String getEquipo1() {
        return equipo1;
    }
    
    public String getEquipo2() {
        return equipo2;
    }
    
    public int getGoles1() {
        return goles1;
    }
    
    public int getGoles2() {
        return goles2;
    }
}