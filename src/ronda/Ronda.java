package ronda;

import java.util.ArrayList;
import java.util.List;

import partido.Partido;
import resultado.Resultado;

public class Ronda {
    private int numero;
    private List<Partido> partidos;
    
    public Ronda(int numero, List<Resultado> resultados) {
        this.numero = numero;
        this.partidos = new ArrayList<>();
        for (int i = 0; i<=1;i++) {
        	boolean primerPartido = i == 0;
        	Partido partido = primerPartido ?
            new Partido(resultados.get(i), resultados.get(i), true) :
            new Partido(resultados.get(i), resultados.get(i), false);
            this.partidos.add(partido);
        }
    }
    
    public int getNumero() {
        return numero;
    }
    
    public List<Partido> getPartidos() {
        return partidos;
    }
}