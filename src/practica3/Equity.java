package practica3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.paukov.combinatorics3.Generator;

import practica1.Carta;
import practica1.Mano;

public class Equity {

	private List<Carta> cartasEnMazo;

    public Equity() throws IOException {
        this.cartasEnMazo = new Mazo("allcards.txt").getListMazo();
    }
    
    public double[] calcularEquity(List<Carta[]> cartasEnManos, List<Carta> cartasEnMesa) {
    	int[] manosGanadas = new int[cartasEnManos.size()];
    	double[] porcentajes = new double[cartasEnManos.size()];
    	int numTotalJugadas = 0;
    	
    	limpiaMazo(cartasEnManos, cartasEnMesa);
    	
    	for (List<Carta> comb: Generator.combination(cartasEnMazo).simple(5 - cartasEnMesa.size())) {	
    		comb.addAll(cartasEnMesa);
    		manosGanadas[obtieneMejorManoEntreJugadores(cartasEnManos, comb)]++;
    		numTotalJugadas++;
    	}
    	
    	// ----------------------- Salida momentanea ------------------------------------------------------
    	int k = 1;
    	for (Carta[] l: cartasEnManos) {
    		System.out.println("Jugador " + k++ + ": " + l[0] + " " + l[1]);
    	}
    	
    	for (int i = 0; i < porcentajes.length; i++) {
    		porcentajes[i] = ((double) manosGanadas[i]) / numTotalJugadas;
    		System.out.println("Jugador " + (i + 1) + ": " + porcentajes[i] * 100 + "%" + " con " + manosGanadas[i]);
    	}
    	System.out.println("Total jugadas: " + numTotalJugadas);
    	// ------------------------------------------------------------------------------------------------
    	
    	return porcentajes;
    }
    
    private int obtieneMejorManoEntreJugadores(List<Carta[]> cartasEnManos, List<Carta> cartasEnMesa) {
		int indiceMejorMano = 0;
		Mano mejorMano = obtieneMejorMano(cartasEnManos.get(0), cartasEnMesa);	
		
		for (int i = 1; i < cartasEnManos.size(); i++) {
			Mano manoActual = obtieneMejorMano(cartasEnManos.get(i), cartasEnMesa);
			if (mejorMano.compareTo(manoActual) == -1) {
				mejorMano = manoActual;
				indiceMejorMano = i;
			}
		}
		
		return indiceMejorMano;
	}

    // Obtiene mejor mano para un jugador dadas las cartas en mesa y las que tiene en mano
	private Mano obtieneMejorMano(Carta[] cartasEnMano, List<Carta> cartasEnMesa) {
		List<Carta> cartas = new ArrayList<>(cartasEnMesa);
		Mano manoActual, mejorMano = null;
		boolean primeraMano = true;
		
		cartas.add(cartasEnMano[0]);
		cartas.add(cartasEnMano[1]);
		
		for (List<Carta> l: Generator.combination(cartas).simple(5)) {
			if (primeraMano) {
				mejorMano = new Mano(l);
				mejorMano.calculaMejorMano();
				primeraMano = false;
			}
			else {
				manoActual =  new Mano(l);
				manoActual.calculaMejorMano();
				if (mejorMano.compareTo(manoActual) == -1) {
					mejorMano = manoActual;
				}
			}
        }
		
		return mejorMano;
	}
	
    // Quita del mazo las cartas en mesa y las cartas en mano
    private void limpiaMazo(List<Carta[]> cartasEnManos, List<Carta> cartasEnMesa) {
    	for (Carta[] m: cartasEnManos) {
        	cartasEnMazo.remove(m[0]);
        	cartasEnMazo.remove(m[1]);
        }         
        for (Carta c: cartasEnMesa) {
        	cartasEnMazo.remove(c);
        }
    }
    public List<Carta> getMazo(){
    	return this.cartasEnMazo;
    }
    
}
