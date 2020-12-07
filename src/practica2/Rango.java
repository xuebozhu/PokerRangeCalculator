package practica2;

import java.util.ArrayList;
import java.util.List;

public class Rango {

	private List<RangoIndividual> listaRangos;

	public Rango() {
		listaRangos = new ArrayList<RangoIndividual>();
	}

	public int[][] calculaRango(String linea) throws StringIndexOutOfBoundsException{
		String[] partesDeLinea = linea.split(",");
		for (int i = 0; i < partesDeLinea.length; i++) {
			listaRangos.add(new RangoIndividual(partesDeLinea[i]));
		}
		int[][] matrizDeColores = new int[13][13];
		for (RangoIndividual r : listaRangos) {
			r.calculaRango(matrizDeColores);
		}
		return matrizDeColores;
	}

	public String comprobarRango(int[][] matrizDeColores) {
		StringBuilder sb = new StringBuilder();
		sb.append(parejasComp(matrizDeColores));
		sb.append(secuencia(matrizDeColores));
		sb.append(identificaCartasIndividuales(matrizDeColores));
		if (sb.length() > 1) {
			sb.delete(sb.length() - 1, sb.length());
		}
		return sb.toString();
	}

	private String identificaCartasIndividuales(int[][] matrizDeColores) {
		StringBuilder sb = new StringBuilder();
		int n = matrizDeColores.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrizDeColores[i][j] == 1) {
					// En diagonal principal
					if (i == j && ((i >= 1 && j >= 1 && matrizDeColores[i - 1][j - 1] == 0) || (i == 0 && j == 0))
							&& ((i + 1 < n && j + 1 < n && matrizDeColores[i + 1][j + 1] == 0)
									|| (i == n - 1 && j == n - 1))) {
						traductorCordenadas(i, sb);
						traductorCordenadas(i, sb);
						sb.append(",");
					// Cartas suited
					} else if (j > i && ((j >= 1 && matrizDeColores[i][j - 1] == 0) || i == j - 1)
							&& ((j + 1 < n && matrizDeColores[i][j + 1] == 0) || j == n - 1)
							&& ((i >= 1 && j >= 1 && matrizDeColores[i - 1][j - 1] == 0) || i == 0)
							&& ((i + 1 < n && j + 1 < n && matrizDeColores[i + 1][j + 1] == 0) || j == n - 1)) {
						traductorCordenadas(i, sb);
						traductorCordenadas(j, sb);
						sb.append("s");
						sb.append(",");
					// Cartas off-suited
					} else if (j < i && ((i >= 1 && matrizDeColores[i - 1][j] == 0) || i == j + 1)
							&& ((i + 1 < n && matrizDeColores[i + 1][j] == 0) || i == n - 1)
							&& ((i >= 1 && j >= 1 && matrizDeColores[i - 1][j - 1] == 0) || j == 0)
							&& ((i + 1 < n && j + 1 < n && matrizDeColores[i + 1][j + 1] == 0) || i == n - 1)) {
						traductorCordenadas(j, sb);
						traductorCordenadas(i, sb);
						sb.append("o");
						sb.append(",");
					}
				}
			}
		}

		return sb.toString();
	}

	private String parejasComp(int[][] matrizDeColores) {
		boolean flagPareja = false;
		StringBuilder sb = new StringBuilder();
		int ini = 0;
		//Comprueba la diagonal principal, de tablero a texto Ej: 22+, 77-44.
		for (int i = 0; i < 13; i++) {
			if (matrizDeColores[i][i] == 1 && !flagPareja) {
				flagPareja = true;
				ini = i;
			} else if (flagPareja && matrizDeColores[i][i] == 0 && i - ini >= 2 && ini == 0) {
				traductorCordenadas(i - 1, sb);
				traductorCordenadas(i - 1, sb);
				sb.append("+");
				sb.append(",");
				flagPareja = false;
			} else if (flagPareja && i == matrizDeColores.length - 1 && matrizDeColores[i][i] == 1 && i - ini >= 2 && ini == 0) {
				traductorCordenadas(i, sb);
				traductorCordenadas(i, sb);
				sb.append("+");
				sb.append(",");
				flagPareja = false;
			} else if (flagPareja && matrizDeColores[i][i] == 0 && i - ini >= 2 && ini - 1 != i) {
				traductorCordenadas(ini, sb);
				traductorCordenadas(ini, sb);
				sb.append("-");
				traductorCordenadas(i - 1, sb);
				traductorCordenadas(i - 1, sb);
				sb.append(",");
				flagPareja = false;
			} else if (flagPareja && i == matrizDeColores.length - 1 && matrizDeColores[i][i] == 1 && i - ini >= 1
					&& ini - 1 != i) {
				traductorCordenadas(ini, sb);
				traductorCordenadas(ini, sb);
				sb.append("-");
				traductorCordenadas(i, sb);
				traductorCordenadas(i, sb);
				sb.append(",");
				flagPareja = false;
			} else if (matrizDeColores[i][i] == 0) {
				flagPareja = false;
			}
		}
		return sb.toString();
	}

	private String secuencia(int[][] matrizDeColores) {
		boolean flagIni = false;
		int ini = 0;
		StringBuilder sb = new StringBuilder();

		// Lectura suited fila
		for (int i = 0; i < matrizDeColores.length; i++) {
			for (int j = i + 1; j < matrizDeColores.length; j++) {
				if (matrizDeColores[i][j] == 1 && !flagIni) {
					flagIni = true;
					ini = j;
				} else if (flagIni && matrizDeColores[i][j] == 0 && j - ini >= 2 && ini - 1 == i) {
					traductorCordenadas(i, sb);
					traductorCordenadas(j - 1, sb);
					sb.append("s+");
					sb.append(",");
					flagIni = false;
				} else if (flagIni && matrizDeColores[i][j] == 1 && j == matrizDeColores.length - 1 && j - ini >= 1 && ini - 1 == i) {
					traductorCordenadas(i, sb);
					traductorCordenadas(j, sb);
					sb.append("s+");
					sb.append(",");
					flagIni = false;
				} else if (flagIni && matrizDeColores[i][j] == 0 && j - ini >= 2 && ini - 1 != i) {
					traductorCordenadas(i, sb);
					traductorCordenadas(ini, sb);
					sb.append("s");
					sb.append("-");
					traductorCordenadas(i, sb);
					traductorCordenadas(j - 1, sb);
					sb.append("s");
					sb.append(",");
					flagIni = false;
				} else if (flagIni && matrizDeColores[i][j] == 1 && j == matrizDeColores.length - 1 && j - ini >= 1 && ini - 1 != i) {
					traductorCordenadas(i, sb);
					traductorCordenadas(ini, sb);
					sb.append("s");
					sb.append("-");
					traductorCordenadas(i, sb);
					traductorCordenadas(j, sb);
					sb.append("s");
					sb.append(",");
					flagIni = false;
				} else if (matrizDeColores[i][j] == 0) {
					flagIni = false;
				}
			}
		}
		
		flagIni = false;
		ini = 0;
		// Lectura Offsuited columna
		for (int j = 0; j < matrizDeColores.length; j++) {
			for (int i = j + 1; i < matrizDeColores.length; i++) {
				if (matrizDeColores[i][j] == 1) {
					System.out.println("i: " + i + " j: " + j + " ini: " + ini);
				}

				if (matrizDeColores[i][j] == 1 && !flagIni) {
					flagIni = true;
					ini = i;
				} else if (flagIni && matrizDeColores[i][j] == 0 && i - ini >= 2 && ini - 1 == j) {
					traductorCordenadas(j, sb);
					traductorCordenadas(i - 1, sb);
					sb.append("o+");
					sb.append(",");
					flagIni = false;
				} else if (flagIni && matrizDeColores[i][j] == 1 && i == matrizDeColores.length - 1 && i - ini >= 1 && ini - 1 == j) {
					traductorCordenadas(j, sb);
					traductorCordenadas(i, sb);
					sb.append("o+");
					sb.append(",");
					flagIni = false;
				} else if (flagIni && matrizDeColores[i][j] == 0 && i - ini >= 2 && ini - 1 != j) {
					traductorCordenadas(j, sb);
					traductorCordenadas(ini, sb);
					sb.append("o");
					sb.append("-");
					traductorCordenadas(j, sb);
					traductorCordenadas(i - 1, sb);
					sb.append("o");
					sb.append(",");
					flagIni = false;
				} else if (flagIni && matrizDeColores[i][j] == 1 && i == matrizDeColores.length - 1 && i - ini >= 1 && ini - 1 != j) {
					traductorCordenadas(j, sb);
					traductorCordenadas(ini, sb);
					sb.append("o");
					sb.append("-");
					traductorCordenadas(j, sb);
					traductorCordenadas(i, sb);
					sb.append("o");
					sb.append(",");
					flagIni = false;
				} else if (matrizDeColores[i][j] == 0) {
					flagIni = false;
				}
			}
		}

		boolean flagIniSuited = false;
		boolean flagIniOffSuited = false;
		ini = 0;
		// Lectura diagonal ej.65s+ ej. AQs-86s
		for (int n = -matrizDeColores.length; n <= matrizDeColores.length; n++) {
			for (int i = 0; i < matrizDeColores.length; i++) { // j=i-n
				if ((i - n >= 0) && (i - n < matrizDeColores.length)) {
					// Suited
					if (i - n > i) {
						if (matrizDeColores[i][i - n] == 1 && !flagIniSuited) {
							flagIniSuited = true;
							ini = i;
						} else if (flagIniSuited && matrizDeColores[i][i - n] == 0 && i - ini >= 2
								&& i - n - (i - ini) == 1) {
							traductorCordenadas(i - 1, sb);
							traductorCordenadas(i - n - 1, sb);
							sb.append("s+");
							sb.append(",");
							flagIniSuited = false;
						} else if (flagIniSuited && i == matrizDeColores.length - 2 && i - 1 - ini >= 2
								&& i - n - (i - ini) == 1) {
							traductorCordenadas(i, sb);
							traductorCordenadas(i - n, sb);
							sb.append("s+");
							sb.append(",");
							flagIniSuited = false;
						} else if (flagIniSuited && matrizDeColores[i][i - n] == 0 && i - ini >= 2
								&& ini != i - n) {
							traductorCordenadas(ini, sb);
							traductorCordenadas(i - n - (i - ini), sb);
							sb.append("s");
							sb.append("-");
							traductorCordenadas(i - 1, sb);
							traductorCordenadas(i - n - 1, sb);
							sb.append("s");
							sb.append(",");
							System.out.print(sb.toString());
							flagIniSuited = false;
						} else if (flagIniSuited && i - n == matrizDeColores.length - 1
								&& matrizDeColores[i][i - n] == 1 && i - ini >= 1 && ini != i - n) {
							traductorCordenadas(ini, sb);
							traductorCordenadas(i - n - (i - ini), sb);
							System.out.println(i + " " + ini + " " + n);
							sb.append("s");
							sb.append("-");
							traductorCordenadas(i, sb);
							traductorCordenadas(i - n, sb);
							System.out.println(sb.toString());
							sb.append("s");
							sb.append(",");
							System.out.println(sb.toString());

							flagIniSuited = false;
						} else if (matrizDeColores[i][i - n] == 0) {
							flagIniSuited = false;
						}
					} // OffSuited
					else if (i > i - n) {
						if (matrizDeColores[i][i - n] == 1 && !flagIniOffSuited) {
							flagIniOffSuited = true;
							ini = i;
						} else if (flagIniOffSuited && matrizDeColores[i][i - n] == 0 && i - ini >= 2 && n - ini == 0 && n == 1) {
							traductorCordenadas(i - n - 1, sb);
							traductorCordenadas(i - 1, sb);
							sb.append("o+");
							sb.append(",");
							flagIniOffSuited = false;
						} else if (flagIniOffSuited && matrizDeColores[i][i - n] == 1 && i == matrizDeColores.length - 1 && i - ini >= 1 && n - ini == 0 && n == 1) {
							traductorCordenadas(i - n, sb);
							traductorCordenadas(i, sb);
							sb.append("o+");
							sb.append(",");
							flagIniOffSuited = false;
						} else if (flagIniOffSuited && matrizDeColores[i][i - n] == 0 && i - ini >= 2 && ini != i) {
							traductorCordenadas(i - n - (i - ini), sb);
							traductorCordenadas(ini, sb);
							sb.append("o");
							sb.append("-");
							traductorCordenadas(i - n - 1, sb);
							traductorCordenadas(i - 1, sb);
							sb.append("o");
							sb.append(",");
							flagIniOffSuited = false;
						} else if (flagIniOffSuited && matrizDeColores[i][i - n] == 1 && i == matrizDeColores.length - 1 && i - ini >= 1 && ini != i) {
							traductorCordenadas(i - n - (i - ini), sb);
							traductorCordenadas(ini, sb);
							sb.append("o");
							sb.append("-");
							traductorCordenadas(i - n, sb);
							traductorCordenadas(i, sb);
							sb.append("o");
							sb.append(",");
							flagIniOffSuited = false;
						} else if (matrizDeColores[i][i - n] == 0) {
							flagIniOffSuited = false;
						}
					}
				}
			}
		}

		return sb.toString();
	}

	private void traductorCordenadas(int valor, StringBuilder sb) {
		switch (valor) {
		case 0:
			sb.append('A');
			break;
		case 1:
			sb.append('K');
			break;
		case 2:
			sb.append('Q');
			break;
		case 3:
			sb.append('J');
			break;
		case 4:
			sb.append('T');
			break;
		case 5:
			sb.append('9');
			break;
		case 6:
			sb.append('8');
			break;
		case 7:
			sb.append('7');
			break;
		case 8:
			sb.append('6');
			break;
		case 9:
			sb.append('5');
			break;
		case 10:
			sb.append('4');
			break;
		case 11:
			sb.append('3');
			break;
		case 12:
			sb.append('2');
			break;
		}
	}

}
