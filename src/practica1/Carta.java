package practica1;

public class Carta implements Comparable<Carta>{
	
	private int valor;
	private char palo;
    private String source;

	public Carta(char c1, char c2){
		switch (c1) {
			case 'T': this.valor = 10; break;
			case 'J': this.valor = 11; break;
			case 'Q': this.valor = 12; break;
			case 'K': this.valor = 13; break;
			case 'A': this.valor = 14; break;
			default : this.valor = Character.getNumericValue(c1);
		}
		this.palo = c2;
		this.source="imagenes\\"+c1+c2+".png";
	}
	
	public Carta(int valor, char palo) {
		this.valor = valor;
		this.palo = palo;
	}
	
	public Carta(String c) {
		this(c.charAt(0), c.charAt(1));
	}

	public String getSource() {
		return this.source;
	}
	
	public int getValor(){
		return this.valor;
	}
	public String getValorToString() {
		StringBuilder cadenaValor = new StringBuilder();
		switch (this.valor) {
                case 1: cadenaValor.append('A'); break;
		case 10: cadenaValor.append('T'); break;
		case 11: cadenaValor.append('J'); break;
		case 12: cadenaValor.append('Q'); break;
		case 13: cadenaValor.append('K'); break;
		case 14: cadenaValor.append('A'); break;
		default : cadenaValor.append(this.valor);
		}
		return cadenaValor.toString();
	}
        
        public void setValor(int valor){
		this.valor=valor;
	}

	public char getPalo(){
		return this.palo;
	}
	
	@Override
	public boolean equals(Object o) {
		Carta b = (Carta) o;
		return this.palo == b.palo && this.valor == b.valor;
	}
	
	@Override
	public int compareTo(Carta b) {
                if (this.valor == 1 && b.valor != 1){
                    return 1;
                }
                else if (b.valor == 1 && this.valor != 1){
                    return -1;
                }
                else{
                    return Integer.compare(this.valor, b.valor);
                }
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		switch (this.valor) {
            case 1: sb.append('A'); break;
			case 10: sb.append('T'); break;
			case 11: sb.append('J'); break;
			case 12: sb.append('Q'); break;
			case 13: sb.append('K'); break;
			case 14: sb.append('A'); break;
			default : sb.append(this.valor);
		}
		sb.append(this.palo);
		return sb.toString();
	}
      
}
