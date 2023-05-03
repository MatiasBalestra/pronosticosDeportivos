package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import partido.Partido;
import pronostico.Pronostico;
import resultado.Resultado;
import ronda.Ronda;

public class Main {

    public static void main(String[] args) {
    	
    	String archivoResultados = "C:\\Users\\matyb\\Desktop\\Java-Workspace\\ArgProgramaUno\\src\\resultados.csv";
    	String archivoPronosticos = "C:\\Users\\matyb\\Desktop\\Java-Workspace\\ArgProgramaUno\\src\\pronostico.csv";

        // Verificar que se hayan pasado los nombres de los archivos por argumento
        if (args.length == 2) {
            archivoResultados = args[0];
            archivoPronosticos = args[1];
        } else {
            System.out.println("Debe ingresar los nombres de los archivos de entrada");
        }

        // Leer archivo de resultados

        List<Resultado> resultados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoResultados))) {
        	br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
            //    System.out.println(linea);
                String equipo1 = datos[0];
                int goles1 = Integer.parseInt(datos[1]);
                int goles2 = Integer.parseInt(datos[2]);
                String equipo2 = datos[3];
                resultados.add(new Resultado(equipo1, goles1, goles2, equipo2));
                System.out.println(equipo1);
                System.out.println(goles1);
                System.out.println(equipo2);
                System.out.println(goles2);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo de resultados: " + e.getMessage());
            return;
        }

        // Leer archivo de pronósticos

        List<Pronostico> pronosticos = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivoPronosticos))) {
        	br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
          //  	System.out.println(linea);
                String[] datos = linea.split(";");
                String equipo1 = datos[0];
                String resultado = "";
                String equipo2 = datos[4];
                if (datos[1].equals("X")) {
                  	System.out.println("Gano equipo 1");
                	System.out.println(equipo1);
                    resultado = "Gana 1";
                    pronosticos.add(new Pronostico(equipo1, resultado, equipo2));
                } else if (datos[2].equals("X")) {
                	System.out.println("Empataron");
                    resultado = "Empata";
                    pronosticos.add(new Pronostico(equipo1, resultado, equipo2));
                } else if (datos[3].equals("X")) {
                	System.out.println("Gano equipo 2");
                	System.out.println(equipo2);
                    resultado = "Gana 2";
                    pronosticos.add(new Pronostico(equipo1, resultado, equipo2));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo de pronósticos: " + e.getMessage());
            return;
        }

        // Calcular puntaje
        int puntaje = 0;
        Ronda ronda = new Ronda(2, resultados); // Suponemos que hay 2 partidos por ronda
        List<Partido> partidos = ronda.getPartidos();

        for (Pronostico pronostico : pronosticos) {
            for (Partido partido : partidos) {
                System.out.println("Pronóstico: " + pronostico.getEquipo1() + " vs " + pronostico.getEquipo2()+ pronostico.getResultado());
                System.out.println("Partido: " + partido.getEquipo1() + " vs " + partido.getEquipo2());
                if (pronostico.getEquipo1().equals(partido.getEquipo1()) && pronostico.getEquipo2().equals(partido.getEquipo2())) {
                    if (pronostico.getResultado().equals("Gana 1") && partido.getGoles1() > partido.getGoles2()) {
                        puntaje++;
                        System.out.println("entre papu al 1");
                    } else if (pronostico.getResultado().equals("Gana 2") && partido.getGoles2() > partido.getGoles1()) {
                        puntaje++;
                        System.out.println("entre papu al 2");
                    } else if (pronostico.getResultado().equals("Empata") && partido.getGoles1() == partido.getGoles2()) {
                        puntaje++;
                        System.out.println("entre papu al 3");
                    }
                } else {
                	System.out.println(pronostico.getResultado());
                	System.out.println(partido.getGoles1());
                	System.out.println(partido.getGoles2());
                    System.out.println("Los equipos del pronóstico no coinciden con los equipos del partido");
                }
            }
        }

        // Imprimir resultado
        System.out.println("Puntaje: " + puntaje);
    }

}