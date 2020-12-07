package practica3;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import practica1.Carta;


public class Mazo {
	
    private List<Carta> listaCartas;
    
    public Mazo(String fileName) throws IOException{
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        this.listaCartas=new ArrayList<Carta>();
        String line="";
        int j=0;
        while((line=bufferedReader.readLine()) != null){
            String[] partes = line.split(";");
            for (int i = 0; i < partes.length; i++) {
                Carta carta=new Carta(partes[i]);
                listaCartas.add(carta);
                j=j+1;
            }
        }
        bufferedReader.close();
    }
    
    public String toString(){
        String cadena="";
        for(int i=0; i<listaCartas.size(); i++){
            cadena=cadena+listaCartas.get(i);
            if((i+1)%((listaCartas.size()/4))==0){
                cadena=cadena+"\n";
            }else{
                cadena=cadena+"-";
            }
        }
        return cadena;
    }
    
    boolean barajar(){
        Collections.shuffle(listaCartas);
        return true;
    }
    
    List<Carta> getListMazo(){
        return this.listaCartas;
    }
    

}
