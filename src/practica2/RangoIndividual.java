package practica2;

public class RangoIndividual {

	private int carta1;
	private int carta2;
	private int carta3; // inicializar a -1 en caso de no haber
	private int carta4; // inicializar a -1 en caso de no haber
	private boolean mas;
	private int suited;

	public RangoIndividual(String str) throws StringIndexOutOfBoundsException{
		String[] partesDeStr = str.split("-");
		// Rango simple
		if (partesDeStr.length == 1) {
			String s = partesDeStr[0];
			this.carta1 = charAValorCarta(s.charAt(0));
			this.carta2 = charAValorCarta(s.charAt(1));
			this.carta3 = -1;
			this.carta4 = -1;
			if (s.length() >= 3) {
				// XYs
				if (s.charAt(2) == 's') {
					suited = 1;
					mas = s.length() == 4; // XYs+
				}
				// XYo
				else if (s.charAt(2) == 'o') {
					suited = -1;
					mas = s.length() == 4; // XYs+
				}
				// XX+
				else if (s.charAt(2) == '+') {
					suited = 0;
					mas = true;
				}

				// XYo+
				// XYs+
				if (s.length() == 4 && s.charAt(3) == '+') {
					mas = true;
				}

			}
			// XX
			else {
				suited = 0;
				mas = false;
			}
		}
		// Rango simple - Rango simple
		else {
			String s1 = partesDeStr[0], s2 = partesDeStr[1];
			this.carta1 = charAValorCarta(s1.charAt(0));
			this.carta2 = charAValorCarta(s1.charAt(1));
			this.carta3 = charAValorCarta(s2.charAt(0));
			this.carta4 = charAValorCarta(s2.charAt(1));
			if (s1.length() == 3) {
				// XYo-XZo
				if (s1.charAt(2) == 'o') {
					this.suited = -1;
				}
				// XYs-XZs
				else {
					this.suited = 1;
				}
			}
			// XY-XZ
			else {
				this.suited = 0;
			}

		}
	}

	public void calculaRango(int[][] matrizDeColores) {
		if (!mas) {
			if (suited == 1) {
				if (carta4 == -1) {
					matrizDeColores[14 - carta1][14 - carta2] = 1;
				} else if (carta1 == carta3) {
					for (int i = carta4; i <= carta2; i++) {
						matrizDeColores[14 - carta1][14 - i] = 1;
					}
				} else {
					int j = carta4;
					for (int i = carta3; i <= carta1; i++) {
						matrizDeColores[14 - i][14 - j] = 1;
						j++;
					}
				}
			} else if (suited == -1) {
				if (carta4 == -1) {
					matrizDeColores[14 - carta2][14 - carta1] = 1;
				} else if (carta1 == carta3) {
					for (int i = carta4; i <= carta2; i++) {
						matrizDeColores[14 - i][14 - carta1] = 1;
					}
				} else {						
					int j = carta4;
					for (int i = carta3; i <= carta1; i++) {
						matrizDeColores[14 - j][14 - i] = 1;
						j++;
					}
				}
			} else {
				if (carta4 == -1) {
					matrizDeColores[14 - carta1][14 - carta2] = 1;
					matrizDeColores[14 - carta2][14 - carta1] = 1;
				} else {
					if (carta1 == carta2) {
						for (int i = carta4; i <= carta2; i++) {
							matrizDeColores[14 - i][14 - i] = 1;
						}
					} else {
						for (int i = carta4; i <= carta2; i++) {
							matrizDeColores[14 - carta1][14 - i] = 1;
							matrizDeColores[14 - i][14 - carta1] = 1;
						}
					}
				}
			}
		} else {
			if (carta1 == carta2) {
				for (int i = carta1; i <= 14; i++) {
					matrizDeColores[14 - i][14 - i] = 1;
				}
			} else if (suited == 1) {
				for (int i = carta2; i < carta1; i++) {
					matrizDeColores[14 - carta1][14 - i] = 1;
				}
				if (carta1 - carta2 == 1) {
					for (int i = carta2 + 1; i <= 14; i++) {
						matrizDeColores[14 - i][14 - i + 1] = 1;
					}
				}

			} else if (suited == -1) {
				// X(X-1)o+
				if (carta1 - carta2 == 1) {
					for (int i = carta2 + 1; i <= 14; i++) {
						matrizDeColores[14 - i + 1][14 - i] = 1;
					}
				} else {
					for (int i = carta2; i < carta1; i++) {
						matrizDeColores[14 - i][14 - carta1] = 1;
					}
				}
			} else {
				if (carta1 - carta2 == 1) {
					for (int i = carta2 + 1; i <= 14; i++) {
						matrizDeColores[14 - i + 1][14 - i] = 1;
						matrizDeColores[14 - i][14 - i + 1] = 1;
					}
				} else {
					for (int i = carta2; i <= carta1; i++) {
						matrizDeColores[14 - i][14 - carta1] = 1;
						matrizDeColores[14 - carta1][14 - i] = 1;
					}
				}
			}
		}
	}

	static private int charAValorCarta(final char c) {
		switch (c) {
		case 'T':
			return 10;
		case 'J':
			return 11;
		case 'Q':
			return 12;
		case 'K':
			return 13;
		case 'A':
			return 14;
		default:
			return Character.getNumericValue(c);
		}
	}

}
