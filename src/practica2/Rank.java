package practica2;

public class Rank {
    private String mano;
    private double valor;

    public Rank(String mano, double valor){
        this.mano = mano;
        this.valor = valor;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(mano);
        sb.append("     ");
        sb.append(valor);
        return  sb.toString();
    }
    public String toString2(){
        return mano;
    }
}
