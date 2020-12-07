package practica1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mano implements Comparable<Mano> {

    private List<Carta> listaMano;
    private int mejorJugada;
    private boolean escaleraA2345;

    public Mano(List<Carta> listaCartas) {
        this.listaMano = new ArrayList<>(listaCartas);
        ordenarMano();
        escaleraA2345 = false;
    }

    public Mano(Carta[] cartasEnMano, List<Carta> cartasEnMesa) {
        this.listaMano = new ArrayList<>(cartasEnMesa);
        this.listaMano.add(cartasEnMano[0]);
        this.listaMano.add(cartasEnMano[1]);
        ordenarMano();
        escaleraA2345 = false;
	}

	public void calculaMejorMano() {
		boolean encontrado = false;
        char[] estadoJugadas = new char[9];
        
        altaParDuplexTrioPokerFullHouse(estadoJugadas);
        colorEscaleraYEscaleraDeColor(estadoJugadas);

        for (int i = estadoJugadas.length - 1; 0 <= i && !encontrado; --i) {
            if (estadoJugadas[i] == 'c') {
                mejorJugada = i;
                encontrado = true;
            }
        }
        
        reordenarMano();
    }

    /* Guarda el estado de cada jugada en una lista
     * 
	 * En estadoJugadas: 0->CartaAlta 1->pareja 2->duplex 3->trio 4->escalera
	 * 5->color 6->full 7->poker 8-> escaleraColor
	 *
     */
    private void colorEscaleraYEscaleraDeColor(char[] estadoJugadas) {
        int palos[] = new int[4]; // array de los cuatro palos y almacenar el numero de cartas de cada palo
        boolean color = false;
 
        // Color
        for (Carta c : listaMano) {
            switch (c.getPalo()) {
                case ('s'):
                    palos[0]++;
                    break;
                case ('h'):
                    palos[1]++;
                    break;
                case ('d'):
                    palos[2]++;
                    break;
                case ('c'):
                    palos[3]++;

            }
        }
        
        // Si alguno de los palos tiene 5 cartas, es que hay color
        if (palos[0] >= 5 || palos[1] >= 5 || palos[2] >= 5 || palos[3] >= 5) {
            color = true; 
        }

        // Escalera
        int seguidas = 1;
        int valorCartaActual, valorCartaSiguiente;
        
        valorCartaActual = listaMano.get(0).getValor();
        for (int contador = 0; contador <= 3; contador++) {
        	valorCartaSiguiente = listaMano.get(contador + 1).getValor();
        	if ((valorCartaActual == valorCartaSiguiente - 1) ||(seguidas == 4 && valorCartaActual == 5 && valorCartaSiguiente == 14)) {
                seguidas++;
            }
        	valorCartaActual = valorCartaSiguiente;
        }

        // Se determina el estado para color
        if (color) {
            estadoJugadas[5] = 'c';// jugada completa para color
        }
        
        // Se determina el estado para una escalera
        if (seguidas == 5) {
        	if (color) {
        		estadoJugadas[8] = 'c';
        	}
        	else {
        		estadoJugadas[4] = 'c';
        		if (valorCartaActual == 14) {
        			escaleraA2345 = true;
        		}
        	}
        }

    }

    private void altaParDuplexTrioPokerFullHouse(char[] estadoJugadas) {
        HashMap<Integer, List<Carta>> hm = new HashMap<>(13);
        Carta cartaAlta = new Carta('0', 'x');

        for (Carta c : listaMano) {
            int valor = c.getValor();

            if (hm.containsKey(valor)) {
                hm.get(valor).add(c);
            } else {
                ArrayList<Carta> l = new ArrayList<>();
                l.add(c);
                hm.put(valor, l);
            }
            if (cartaAlta.getValor() < valor) {
                cartaAlta = c;
            }
        }

        int parejas = 0;
        for (Map.Entry<Integer, List<Carta>> entry : hm.entrySet()) {
            List<Carta> value = entry.getValue();
            switch (value.size()) {
                case 4:
                    estadoJugadas[7] = 'c'; // Poker
                    break;
                case 3:
                    estadoJugadas[3] = 'c'; // Trio
                    break;
                case 2:
                    estadoJugadas[1] = 'c'; // Par
                    parejas++;
            }
        }

        // Comprobamos si hay par, duplex o full house
        switch (parejas) {
            case 2:
                estadoJugadas[2] = 'c';
            case 1:
                estadoJugadas[1] = 'c';
                if (estadoJugadas[3] == 'c') {
                    estadoJugadas[6] = 'c';
                }
        }
        estadoJugadas[0] = 'c';
    }

    public void reordenarMano() {
        int numIter = 1, borrados = 0, limiteWhile = 0;
        
        switch (mejorJugada) {
            case 1:
                borrados = 2;// numero de elementos que ha de borrar y poner al final
                limiteWhile = 3;
                break;
            case 2:
                // aqui se definen los parametros
                borrados = 2;// numero de elementos que ha de borrar y poner al final
                limiteWhile = 3;
                numIter = 2;
                break;
            case 3:
                borrados = 3;
                limiteWhile = 2;
                break;
            case 4:
            	if (escaleraA2345) {
                	listaMano.get(4).setValor(1);
                }
            	return;
            case 6:
                borrados = 3;
                limiteWhile = 2;
                break;
            case 7:
                borrados = 4;
                limiteWhile = 1;
                break;
            default:
                return;
        }
        // esto busca una pareja y la colaca al final de la mano , para un duplex hace 2
        // iteraciones para mover atras las 2 parejas , poniendo la mas alta al final
        for (int j = 0; j < numIter; j++) {
            boolean encontrado = false, condicion;
            int i = 0;
            while (!encontrado && i < limiteWhile) {
                condicion = true;
                // es la forma de definir cuantas cartas seguidas debe comparar
                for (int a = 1; a < borrados; a++) {
                    if (listaMano.get(i).getValor() != listaMano.get(i + a).getValor()) {
                        condicion = false;
                    }
                }
                if (condicion) {
                    encontrado = true;
                    //  la borra de la lista , la lista se recoloca y
                    // anhade las cartas al final de la misma
                    for (int p = 0; p < borrados; p++) {
                        Carta aux = listaMano.get(i);
                        listaMano.remove(i);
                        listaMano.add(aux);
                    }

                } else {
                    i++;
                }
            }
        }

    }

    private void ordenarMano() {
        Collections.sort(listaMano);
    }

    private String cartasAString(List<Carta> l) {
        StringBuilder sb = new StringBuilder();
        for (Carta c : l) {
            sb.append(c.toString());
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Mano mano2) {
        if (this.mejorJugada > mano2.mejorJugada) {
            return 1;
        } else if (this.mejorJugada < mano2.mejorJugada) {
            return -1;
        } else {
            for (int i = 4; i >= 0; i--) {
                int res = this.listaMano.get(i).compareTo(mano2.listaMano.get(i));
                if (res != 0) {
                    return res;
                }
            }
            return 0;
        }
    }
    
    @Override
    public String toString() {
        return cartasAString(listaMano);
    }

}
