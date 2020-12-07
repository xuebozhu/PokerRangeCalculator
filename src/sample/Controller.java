package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import practica1.Carta;
import practica3.Equity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Controller {
	@FXML
    GridPane gridPaneMazo;
	
	Equity equity;
	Boolean fold1 = false;
	Boolean fold2 = false;
	Boolean fold3 = false;
	Boolean fold4 = false;
	Boolean fold5 = false;
	Boolean fold6 = false;
	@FXML
    ImageView P1Card1;
    @FXML
    ImageView P1Card2;
    @FXML
    ImageView P2Card1;
    @FXML
    ImageView P2Card2;
    @FXML
    ImageView P3Card1;
    @FXML
    ImageView P3Card2;
    @FXML
    ImageView P4Card1;
    @FXML
    ImageView P4Card2;
    @FXML
    ImageView P5Card1;
    @FXML
    ImageView P5Card2;
    @FXML
    ImageView P6Card1;
    @FXML
    ImageView P6Card2;
	@FXML
	ImageView As;
	@FXML
	ImageView Ah;
	@FXML
	ImageView Ac;
	@FXML
	ImageView Ad;
	@FXML
	ImageView Ks;
	@FXML
	ImageView Kh;
	@FXML
	ImageView Kc;
	@FXML
	ImageView Kd;
	@FXML
	ImageView Qs;
	@FXML
	ImageView Qc;
	@FXML
	ImageView Qh;
	@FXML
	ImageView Qd;
	@FXML
	ImageView Js;
	@FXML
	ImageView Jc;
	@FXML
	ImageView Jh;
	@FXML
	ImageView Jd;
	@FXML
	ImageView Tc;
	@FXML
	ImageView Ts;
	@FXML
	ImageView Td;
	@FXML
	ImageView Th;
	@FXML
	ImageView Ns;
	@FXML
	ImageView Nc;
	@FXML
	ImageView Nh;
	@FXML
	ImageView Nd;
	@FXML
	ImageView Os;
	@FXML
	ImageView Oc;
	@FXML
	ImageView Oh;
	@FXML
	ImageView Od;
	@FXML
	ImageView Ss;
	@FXML
	ImageView Sc;
	@FXML
	ImageView Sh;
	@FXML
	ImageView Sd;
	@FXML
	ImageView Xs;
	@FXML
	ImageView Xc;
	@FXML
	ImageView Xh;
	@FXML
	ImageView Xd;
	@FXML
	ImageView Cs;
	@FXML
	ImageView Cc;
	@FXML
	ImageView Ch;
	@FXML
	ImageView Cd;
	@FXML
	ImageView Fs;
	@FXML
	ImageView Fc;
	@FXML
	ImageView Fh;
	@FXML
	ImageView Fd;
	@FXML
	ImageView Es;
	@FXML
	ImageView Ec;
	@FXML
	ImageView Eh;
	@FXML
	ImageView Ed;
	@FXML
	ImageView Ds;
	@FXML
	ImageView Dc;
	@FXML
	ImageView Dh;
	@FXML
	ImageView Dd;

    @FXML
    ImageView BoardCard1;
    @FXML
    ImageView BoardCard2;
    @FXML
    ImageView BoardCard3;
    @FXML
    ImageView BoardCard4;
    @FXML
    ImageView BoardCard5;
    
    @FXML
    Label lblPlayer1;
    @FXML
    Label lblPlayer2;
    @FXML
    Label lblPlayer3;
    @FXML
    Label lblPlayer4;
    @FXML
    Label lblPlayer5;
    @FXML
    Label lblPlayer6;
    
    boolean[] cartaSeleccionada;
    boolean popUp = false;
    
    @FXML
    Button btnRandom;

    @FXML
	void playerFold(Event e){
    	Button boton = (Button) e.getSource();
    	switch (boton.getId()){
			case "fold1": P1Card1.setOpacity(0.7);P1Card2.setOpacity(0.7);fold1 = true;P1Card1.setDisable(true);P1Card2.setDisable(true);break;
			case "fold2": P2Card1.setOpacity(0.7);P2Card2.setOpacity(0.7);fold2 = true;P2Card1.setDisable(true);P2Card2.setDisable(true);break;
			case "fold3": P3Card1.setOpacity(0.7);P3Card2.setOpacity(0.7);fold3 = true;P3Card1.setDisable(true);P3Card2.setDisable(true);break;
			case "fold4": P4Card1.setOpacity(0.7);P4Card2.setOpacity(0.7);fold4 = true;P4Card1.setDisable(true);P4Card2.setDisable(true);break;
			case "fold5": P5Card1.setOpacity(0.7);P5Card2.setOpacity(0.7);fold5 = true;P5Card1.setDisable(true);P5Card2.setDisable(true);break;
			case "fold6": P6Card1.setOpacity(0.7);P6Card2.setOpacity(0.7);fold6 = true;P6Card1.setDisable(true);P6Card2.setDisable(true);break;

		}
	}

	@FXML
	void popUpWindow(){
		if(!popUp) {
			Stage newStage = new Stage();
			BorderPane pane = new BorderPane();
			Label label = new Label("Programado por Grupo 9");
			Label label2 = new Label("Javier Anton Alonso \n Joaquin Barrio Lottmann \n Javier Berdecio Trigueros \n Xuebo Zhu");
			pane.setCenter(label);
			pane.setBottom(label2);
			Scene stageScene = new Scene(pane, 350, 100);
			newStage.setScene(stageScene);
			newStage.setTitle("About");
			newStage.setResizable(false);
			newStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent event) {
					popUp = false;
				}
			});
			newStage.show();
			popUp = true;
		}
	}

    @FXML
    void resetBoard() {
		ArrayList<Carta> CartasBoard = new ArrayList<>();
		CartasBoard.add(new Carta(this.getCartaJugadorImagen(BoardCard1)));
		CartasBoard.add(new Carta(this.getCartaJugadorImagen(BoardCard2)));
		CartasBoard.add(new Carta(this.getCartaJugadorImagen(BoardCard3)));
		CartasBoard.add(new Carta(this.getCartaJugadorImagen(BoardCard4)));
		CartasBoard.add(new Carta(this.getCartaJugadorImagen(BoardCard5)));
    	File f = new File("imagenes\\00.png");
        BoardCard1.setImage(new Image(f.toURI().toString()));
        BoardCard2.setImage(new Image(f.toURI().toString()));
        BoardCard3.setImage(new Image(f.toURI().toString()));
        BoardCard4.setImage(new Image(f.toURI().toString()));
        BoardCard5.setImage(new Image(f.toURI().toString()));
        BoardCard4.setDisable(true);
		BoardCard4.setOpacity(0.25);
		BoardCard5.setDisable(true);
		BoardCard5.setOpacity(0.25);
		lblPlayer1.setText("Player1");
		lblPlayer2.setText("Player2");
		lblPlayer3.setText("Player3");
		lblPlayer4.setText("Player4");
		lblPlayer5.setText("Player5");
		lblPlayer6.setText("Player6");
		P1Card1.setDisable(false);

		P1Card2.setDisable(false);
		P2Card1.setDisable(false);
		P2Card2.setDisable(false);
		P3Card1.setDisable(false);
		P3Card2.setDisable(false);
		P4Card1.setDisable(false);
		P4Card2.setDisable(false);
		P5Card1.setDisable(false);
		P5Card2.setDisable(false);
		P6Card1.setDisable(false);
		P6Card2.setDisable(false);

		P1Card2.setOpacity(1.0);
		P1Card1.setOpacity(1.0);
		P2Card2.setOpacity(1.0);
		P2Card1.setOpacity(1.0);
		P3Card2.setOpacity(1.0);
		P3Card1.setOpacity(1.0);
		P4Card2.setOpacity(1.0);
		P4Card1.setOpacity(1.0);
		P5Card2.setOpacity(1.0);
		P5Card1.setOpacity(1.0);
		P6Card2.setOpacity(1.0);
		P6Card1.setOpacity(1.0);

		fold1 = false;
		fold2 = false;
		fold3 = false;
		fold4 = false;
		fold5 = false;
		fold6 = false;
		for ( Node n : gridPaneMazo.getChildren()) {
			try {
				ImageView imagen = (ImageView) n;
				Carta carta1 = new Carta(this.getCartaJugadorImagen(imagen));
				for(int i = 0 ; i < 5 ; i++){
					if (carta1.getValor() == CartasBoard.get(i).getValor() && carta1.getPalo() == CartasBoard.get(i).getPalo()) {
						imagen.setDisable(false);
						imagen.setOpacity(1);
					}
				}

			}catch (Exception e1){
				e1.printStackTrace();
			}
		}
    }

    @FXML
    void resetAll() {
    	File f = new File("imagenes\\00.png");
    	P1Card1.setImage(new Image(f.toURI().toString()));
    	P1Card2.setImage(new Image(f.toURI().toString()));
    	P2Card1.setImage(new Image(f.toURI().toString()));
    	P2Card2.setImage(new Image(f.toURI().toString()));
    	P3Card1.setImage(new Image(f.toURI().toString()));
    	P3Card2.setImage(new Image(f.toURI().toString()));
    	P4Card1.setImage(new Image(f.toURI().toString()));
    	P4Card2.setImage(new Image(f.toURI().toString()));
    	P5Card1.setImage(new Image(f.toURI().toString()));
    	P5Card2.setImage(new Image(f.toURI().toString()));
    	P6Card1.setImage(new Image(f.toURI().toString()));
    	P6Card2.setImage(new Image(f.toURI().toString()));

		for ( Node n : gridPaneMazo.getChildren()) {
			try {
				n.setDisable(false);
				n.setOpacity(1);
			}catch (Exception e1){};
		}
		resetBoard();
    }
	@FXML
    public void inicializar(){
    	resetAll();
		File s = new File("imagenes\\As.png");
		As.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\Ks.png");
		Ks.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\Qs.png");
		Qs.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\Js.png");
		Js.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\Ts.png");
		Ts.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\9s.png");
		Ns.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\8s.png");
		Os.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\7s.png");
		Ss.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\6s.png");
		Xs.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\5s.png");
		Cs.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\4s.png");
		Fs.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\3s.png");
		Es.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\2s.png");
		Ds.setImage(new Image(s.toURI().toString()));


		s = new File("imagenes\\Ac.png");
		Ac.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\Kc.png");
		Kc.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\Qc.png");
		Qc.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\Jc.png");
		Jc.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\Tc.png");
		Tc.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\9c.png");
		Nc.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\8c.png");
		Oc.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\7c.png");
		Sc.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\6c.png");
		Xc.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\5c.png");
		Cc.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\4c.png");
		Fc.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\3c.png");
		Ec.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\2c.png");
		Dc.setImage(new Image(s.toURI().toString()));


		s = new File("imagenes\\Ah.png");
		Ah.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\Kh.png");
		Kh.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\Qh.png");
		Qh.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\Jh.png");
		Jh.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\Th.png");
		Th.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\9h.png");
		Nh.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\8h.png");
		Oh.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\7h.png");
		Sh.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\6h.png");
		Xh.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\5h.png");
		Ch.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\4h.png");
		Fh.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\3h.png");
		Eh.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\2h.png");
		Dh.setImage(new Image(s.toURI().toString()));


		s = new File("imagenes\\Ad.png");
		Ad.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\Kd.png");
		Kd.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\Qd.png");
		Qd.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\Jd.png");
		Jd.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\Td.png");
		Td.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\9d.png");
		Nd.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\8d.png");
		Od.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\7d.png");
		Sd.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\6d.png");
		Xd.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\5d.png");
		Cd.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\4d.png");
		Fd.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\3d.png");
		Ed.setImage(new Image(s.toURI().toString()));
		s = new File("imagenes\\2d.png");
		Dd.setImage(new Image(s.toURI().toString()));

	}

    @FXML
    void seleccionarRandom() {
    	int randomNum = ThreadLocalRandom.current().nextInt(0, 51 + 1);
    	while(gridPaneMazo.getChildren().get(randomNum).isDisabled()) {
    		if(randomNum<52) {
    			randomNum++;
    		}else {
    			randomNum=0;
    		}
    	}
  		ImageView imagen = (ImageView) gridPaneMazo.getChildren().get(randomNum);
    	this.seleccionarImagen(imagen);
    }
    
    //Obtener carta a traves de ImageView de la Vista
    @FXML
    String getCartaJugadorImagen(ImageView imagen) {
    	String cadenaP1Card1=imagen.getImage().impl_getUrl();
		String[] splitted=cadenaP1Card1.split("/");
		String cadenaCarta=splitted[splitted.length-1];
		cadenaCarta=cadenaCarta.substring(0, cadenaCarta.length()-4);
		return cadenaCarta;
	}

	@FXML
	void todasRandom(Event e){
		int randomNum = ThreadLocalRandom.current().nextInt(0, 51 + 1);
		while(gridPaneMazo.getChildren().get(randomNum).isDisabled()) {
			if(randomNum<52) {
				randomNum++;
			}else {
				randomNum=0;
			}
		}
		ImageView imagen = (ImageView) gridPaneMazo.getChildren().get(randomNum);
		P1Card1.setImage(imagen.getImage());
		this.seleccionarCartaMazo2(imagen);
		//
		randomNum = ThreadLocalRandom.current().nextInt(0, 51 + 1);
		while(gridPaneMazo.getChildren().get(randomNum).isDisabled()) {
			if(randomNum<52) {
				randomNum++;
			}else {
				randomNum=0;
			}
		}
		imagen = (ImageView) gridPaneMazo.getChildren().get(randomNum);
		P1Card2.setImage(imagen.getImage());
		this.seleccionarCartaMazo2(imagen);

		randomNum = ThreadLocalRandom.current().nextInt(0, 51 + 1);
		while(gridPaneMazo.getChildren().get(randomNum).isDisabled()) {
			if(randomNum<52) {
				randomNum++;
			}else {
				randomNum=0;
			}
		}
		imagen = (ImageView) gridPaneMazo.getChildren().get(randomNum);
		P2Card1.setImage(imagen.getImage());
		this.seleccionarCartaMazo2(imagen);
		//
		randomNum = ThreadLocalRandom.current().nextInt(0, 51 + 1);
		while(gridPaneMazo.getChildren().get(randomNum).isDisabled()) {
			if(randomNum<52) {
				randomNum++;
			}else {
				randomNum=0;
			}
		}
		imagen = (ImageView) gridPaneMazo.getChildren().get(randomNum);
		P2Card2.setImage(imagen.getImage());
		this.seleccionarCartaMazo2(imagen);

		randomNum = ThreadLocalRandom.current().nextInt(0, 51 + 1);
		while(gridPaneMazo.getChildren().get(randomNum).isDisabled()) {
			if(randomNum<52) {
				randomNum++;
			}else {
				randomNum=0;
			}
		}
		imagen = (ImageView) gridPaneMazo.getChildren().get(randomNum);
		P3Card1.setImage(imagen.getImage());
		this.seleccionarCartaMazo2(imagen);
		//
		randomNum = ThreadLocalRandom.current().nextInt(0, 51 + 1);
		while(gridPaneMazo.getChildren().get(randomNum).isDisabled()) {
			if(randomNum<52) {
				randomNum++;
			}else {
				randomNum=0;
			}
		}
		imagen = (ImageView) gridPaneMazo.getChildren().get(randomNum);
		P3Card2.setImage(imagen.getImage());
		this.seleccionarCartaMazo2(imagen);

		randomNum = ThreadLocalRandom.current().nextInt(0, 51 + 1);
		while(gridPaneMazo.getChildren().get(randomNum).isDisabled()) {
			if(randomNum<52) {
				randomNum++;
			}else {
				randomNum=0;
			}
		}
		imagen = (ImageView) gridPaneMazo.getChildren().get(randomNum);
		P4Card1.setImage(imagen.getImage());
		this.seleccionarCartaMazo2(imagen);
		//
		randomNum = ThreadLocalRandom.current().nextInt(0, 51 + 1);
		while(gridPaneMazo.getChildren().get(randomNum).isDisabled()) {
			if(randomNum<52) {
				randomNum++;
			}else {
				randomNum=0;
			}
		}
		imagen = (ImageView) gridPaneMazo.getChildren().get(randomNum);
		P4Card2.setImage(imagen.getImage());
		this.seleccionarCartaMazo2(imagen);

		randomNum = ThreadLocalRandom.current().nextInt(0, 51 + 1);
		while(gridPaneMazo.getChildren().get(randomNum).isDisabled()) {
			if(randomNum<52) {
				randomNum++;
			}else {
				randomNum=0;
			}
		}
		imagen = (ImageView) gridPaneMazo.getChildren().get(randomNum);
		P5Card1.setImage(imagen.getImage());
		this.seleccionarCartaMazo2(imagen);
		//
		randomNum = ThreadLocalRandom.current().nextInt(0, 51 + 1);
		while(gridPaneMazo.getChildren().get(randomNum).isDisabled()) {
			if(randomNum<52) {
				randomNum++;
			}else {
				randomNum=0;
			}
		}
		imagen = (ImageView) gridPaneMazo.getChildren().get(randomNum);
		P5Card2.setImage(imagen.getImage());
		this.seleccionarCartaMazo2(imagen);

		randomNum = ThreadLocalRandom.current().nextInt(0, 51 + 1);
		while(gridPaneMazo.getChildren().get(randomNum).isDisabled()) {
			if(randomNum<52) {
				randomNum++;
			}else {
				randomNum=0;
			}
		}
		imagen = (ImageView) gridPaneMazo.getChildren().get(randomNum);
		P6Card1.setImage(imagen.getImage());
		this.seleccionarCartaMazo2(imagen);
		//
		randomNum = ThreadLocalRandom.current().nextInt(0, 51 + 1);
		while(gridPaneMazo.getChildren().get(randomNum).isDisabled()) {
			if(randomNum<52) {
				randomNum++;
			}else {
				randomNum=0;
			}
		}
		imagen = (ImageView) gridPaneMazo.getChildren().get(randomNum);
		P6Card2.setImage(imagen.getImage());
		this.seleccionarCartaMazo2(imagen);

	}

    @FXML
    void calcularEquity() throws IOException{
    	//getters cartas de la vista para cada jugador

    	Carta P1Carta1=new Carta(this.getCartaJugadorImagen(P1Card1));
    	Carta P1Carta2=new Carta(this.getCartaJugadorImagen(P1Card2));
    	Carta P2Carta1=new Carta(this.getCartaJugadorImagen(P2Card1));
    	Carta P2Carta2=new Carta(this.getCartaJugadorImagen(P2Card2));
    	Carta P3Carta1=new Carta(this.getCartaJugadorImagen(P3Card1));
    	Carta P3Carta2=new Carta(this.getCartaJugadorImagen(P3Card2));
    	Carta P4Carta1=new Carta(this.getCartaJugadorImagen(P4Card1));
    	Carta P4Carta2=new Carta(this.getCartaJugadorImagen(P4Card2));
    	Carta P5Carta1=new Carta(this.getCartaJugadorImagen(P5Card1));
    	Carta P5Carta2=new Carta(this.getCartaJugadorImagen(P5Card2));
    	Carta P6Carta1=new Carta(this.getCartaJugadorImagen(P6Card1));
    	Carta P6Carta2=new Carta(this.getCartaJugadorImagen(P6Card2));
    	
    	//Agregar todas las cartas de los jugadores a listaCartasEnManos tamano 6*2
    	List<Carta[]> listaCartasEnManos = new ArrayList<Carta[]>();
    	if(!fold1){
    		listaCartasEnManos.add(new Carta[] {P1Carta1, P1Carta2});
		}
    	if(!fold2){
    		listaCartasEnManos.add(new Carta[] {P2Carta1, P2Carta2});
		}
    	if(!fold3){
    		listaCartasEnManos.add(new Carta[] {P3Carta1, P3Carta2});
		}
    	if(!fold4){
    		listaCartasEnManos.add(new Carta[] {P4Carta1, P4Carta2});
		}
    	if(!fold5){
    		listaCartasEnManos.add(new Carta[] {P5Carta1, P5Carta2});
		}
    	if(!fold6){
    		listaCartasEnManos.add(new Carta[] {P6Carta1, P6Carta2});
		}
    	
    	boolean errorGeneral=false;
    	boolean errorJugadores=false;
    	for(Carta[] cList : listaCartasEnManos) {
    		for(Carta c : cList) {
    			if(c.getValor()==0) {
    				errorJugadores=true;
    			}
    		}
    	}
    	if(errorJugadores) {
    		errorGeneral=true;
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Todos los jugaddores activos deben tener cartas");
			alert.setHeaderText("Faltan cartas por asignar a los jugadores");

			alert.showAndWait();
    	}

    	
    	Carta BoardCarta1=new Carta(this.getCartaJugadorImagen(BoardCard1));
    	Carta BoardCarta2=new Carta(this.getCartaJugadorImagen(BoardCard2));
    	Carta BoardCarta3=new Carta(this.getCartaJugadorImagen(BoardCard3));
    	Carta BoardCarta4=new Carta(this.getCartaJugadorImagen(BoardCard4));
    	Carta BoardCarta5=new Carta(this.getCartaJugadorImagen(BoardCard5));
    	
    	//Agregar todas las cartas del board a listaCartasEnMesa tamano 0-5
    	List<Carta> listaCartasEnMesa = new ArrayList<Carta>();
    	if(BoardCarta1.getValor()!=0)
    		listaCartasEnMesa.add(BoardCarta1);
    	if(BoardCarta2.getValor()!=0)
    		listaCartasEnMesa.add(BoardCarta2);
    	if(BoardCarta3.getValor()!=0)
    		listaCartasEnMesa.add(BoardCarta3);
    	if(BoardCarta4.getValor()!=0)
    		listaCartasEnMesa.add(BoardCarta4);
    	if(BoardCarta5.getValor()!=0)
    		listaCartasEnMesa.add(BoardCarta5);
    	
    	boolean errorBoard=false;
    	if(listaCartasEnMesa.size()>0 && listaCartasEnMesa.size()<3)
    		errorBoard=true;
    	if(errorBoard) {
    		errorGeneral=true;
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Fase Flop");
			alert.setHeaderText("Selecciona al menos 3 cartas en el Board para Fase Flop");

			alert.showAndWait();
    	}
    	
    	//Clase equity
    	double[] porcentajes = null;
    	if(!errorGeneral) {
	    	this.equity = new Equity();
	    	porcentajes=equity.calcularEquity(listaCartasEnManos, listaCartasEnMesa);
	    	//this.equity.obtieneCombinacionesDe5Cartas(listaCartasEnManos, listaCartasEnMesa);
    	}
		lblPlayer1.setText("0%");
		lblPlayer2.setText("0%");
		lblPlayer3.setText("0%");
		lblPlayer4.setText("0%");
		lblPlayer5.setText("0%");
		lblPlayer6.setText("0%");
		List<Boolean> fold = new ArrayList<Boolean>();
		List<Integer> jugadores = new ArrayList<Integer>();
		jugadores.add(-1);
		jugadores.add(-1);
		jugadores.add(-1);
		jugadores.add(-1);
		jugadores.add(-1);
		jugadores.add(-1);
		fold.add(fold1);
		fold.add(fold2);
		fold.add(fold3);
		fold.add(fold4);
		fold.add(fold5);
		fold.add(fold6);
		int cont = 0;
		for(int i = 0; i< 6;++i){
			if(!fold.get(i)){
				jugadores.set(i,cont);
				cont++;
			}
		}
    	if(porcentajes!=null) {
	    	try{
	    		lblPlayer1.setText(String.format("%.3f", porcentajes[jugadores.get(0)] * 100) + "%");
			}catch(Exception e){}
			try {
				lblPlayer2.setText(String.format("%.3f", porcentajes[jugadores.get(1)] * 100) + "%");
			}catch(Exception e){}
	    	try{
				lblPlayer3.setText(String.format("%.3f", porcentajes[jugadores.get(2)] * 100) + "%");
			}catch(Exception e){}
	    	try{
				lblPlayer4.setText(String.format("%.3f", porcentajes[jugadores.get(3)] * 100) + "%");
			}catch(Exception e){}
	    	try {
				lblPlayer5.setText(String.format("%.3f", porcentajes[jugadores.get(4)] * 100) + "%");
			}catch(Exception e){}
	    	try{
				lblPlayer6.setText(String.format("%.3f", porcentajes[jugadores.get(5)] * 100) + "%");
			}catch(Exception e){}
    	}
    }
    @FXML
    void seleccionaCarta(Event e){
        ImageView imagen;
        File f;
        imagen = (ImageView) e.getSource();
        
        //0-11 Cartas Jugadores, 12-16 Cartas Board
        this.cartaSeleccionada = new boolean[17];
        
        switch(imagen.getId()){
            case "P1Card1": 
            	for(boolean b : cartaSeleccionada)
            		b=false;
            	cartaSeleccionada[0]=true;
            break;
            case "P1Card2": 
	            for(boolean b : cartaSeleccionada)
	        		b=false;
	        	cartaSeleccionada[1]=true;
            break;
            case "P2Card1": 
	            for(boolean b : cartaSeleccionada)
	        		b=false;
	        	cartaSeleccionada[2]=true;
            break;
            case "P2Card2": 
	            for(boolean b : cartaSeleccionada)
	        		b=false;
	        	cartaSeleccionada[3]=true;
            break;
            case "P3Card1": 
	            for(boolean b : cartaSeleccionada)
	        		b=false;
	        	cartaSeleccionada[4]=true;
            break;
            case "P3Card2": 
	            for(boolean b : cartaSeleccionada)
	        		b=false;
	        	cartaSeleccionada[5]=true;
            break;
            case "P4Card1":
	            for(boolean b : cartaSeleccionada)
	        		b=false;
	        	cartaSeleccionada[6]=true;
            break;
            case "P4Card2":
	            for(boolean b : cartaSeleccionada)
	        		b=false;
	        	cartaSeleccionada[7]=true;
            break;
            case "P5Card1":
	            for(boolean b : cartaSeleccionada)
	        		b=false;
	        	cartaSeleccionada[8]=true;
            break;
            case "P5Card2": 
	            for(boolean b : cartaSeleccionada)
	        		b=false;
	        	cartaSeleccionada[9]=true;
            break;
            case "P6Card1": 
	            for(boolean b : cartaSeleccionada)
	        		b=false;
	        	cartaSeleccionada[10]=true;
            break;
            case "P6Card2": 
	            for(boolean b : cartaSeleccionada)
	        		b=false;
	        	cartaSeleccionada[11]=true;
            break;
            //Board Cards
            case "BoardCard1":
	        	for(boolean b : cartaSeleccionada)
	        		b=false;
	        	cartaSeleccionada[12]=true;
	        break;
            case "BoardCard2":
            	for(boolean b : cartaSeleccionada)
            		b=false;
            	cartaSeleccionada[13]=true;
            break;
            case "BoardCard3":
            	for(boolean b : cartaSeleccionada)
            		b=false;
            	cartaSeleccionada[14]=true;
            break;
            case "BoardCard4":
            	for(boolean b : cartaSeleccionada)
            		b=false;
            	cartaSeleccionada[15]=true;
            break;
            case "BoardCard5":
            	for(boolean b : cartaSeleccionada)
            		b=false;
            	cartaSeleccionada[16]=true;
            break;
        }
        for(int i = 0; i<cartaSeleccionada.length;i++) {
        	if(cartaSeleccionada[i]) {
        		switch(i){
		            case 0: 
		            	P1Card1.setOpacity(0.7);
		            break;
		            case 1: 
		            	P1Card2.setOpacity(0.7);
		            break;
		            case 2: 
		            	P2Card1.setOpacity(0.7);
		            break;
		            case 3: 
		            	P2Card2.setOpacity(0.7);
		            break;
		            case 4: 
		            	P3Card1.setOpacity(0.7);
		            break;
		            case 5: 
		            	P3Card2.setOpacity(0.7);
		            break;
		            case 6: 
		            	P4Card1.setOpacity(0.7);
		            break;
		            case 7: 
		            	P4Card2.setOpacity(0.7);
		            break;
		            case 8: 
		            	P5Card1.setOpacity(0.7);
		            break;
		            case 9: 
		            	P5Card2.setOpacity(0.7);
		            break;
		            case 10: 
		            	P6Card1.setOpacity(0.7);
		            break;
		            case 11: 
		            	P6Card2.setOpacity(0.7);
		            break;
		            case 12: 
		            	BoardCard1.setOpacity(0.7);
		            break;
		            case 13: 
		            	BoardCard2.setOpacity(0.7);
		            break;
		            case 14: 
		            	BoardCard3.setOpacity(0.7);
		            break;
		            case 15: 
		            	BoardCard4.setOpacity(0.7);
		            break;
		            case 16: 
		            	BoardCard5.setOpacity(0.7);
		            break;
		        }
        	}else {
        		switch(i){
		            case 0: 
		            	if(!fold1){
		            		P1Card1.setOpacity(1);
						}
		            break;
		            case 1: 
		            	if(!fold1){
		            		P1Card2.setOpacity(1);
						}
		            break;
		            case 2: 
		            	if(!fold2){
		            		P2Card1.setOpacity(1);
						}
		            break;
		            case 3: 
		            	if(!fold2){
		            		P2Card2.setOpacity(1);
						}
		            break;
		            case 4: 
		            	if(!fold3){
		            		P3Card1.setOpacity(1);
						}
		            break;
		            case 5: 
		            	if(!fold3){
		            		P3Card2.setOpacity(1);
						}
		            break;
		            case 6: 
		            	if(!fold4){
		            		P4Card1.setOpacity(1);
						}
		            break;
		            case 7: 
		            	if(!fold4){
		            		P4Card2.setOpacity(1);
						}
		            break;
		            case 8: 
		            	if(!fold5){
		            		P5Card1.setOpacity(1);
						}
		            break;
		            case 9: 
		            	if(!fold5){
		            		P5Card2.setOpacity(1);
						}
		            break;
		            case 10: 
		            	if(!fold6){
		            		P6Card1.setOpacity(1);
						}
		            break;
		            case 11: 
		            	if(!fold6){
		            		P6Card2.setOpacity(1);
						}
		            break;
		            case 12: 
		            	BoardCard1.setOpacity(1);
		            break;
		            case 13: 
		            	BoardCard2.setOpacity(1);
		            break;
		            case 14: 
		            	BoardCard3.setOpacity(1);
		            break;
		            case 15: 
		            	if(!BoardCard4.isDisabled())
		            		BoardCard4.setOpacity(1);
		            break;
		            case 16:
		            	if(!BoardCard5.isDisabled())
		            		BoardCard5.setOpacity(1);
		            break;
		        }
        	}
        }
    }
    @FXML
    void seleccionarCartaMazo(Event e) {
    	ImageView imagen;
        imagen = (ImageView) e.getSource();
        this.seleccionarImagen(imagen);
    }

	@FXML
	void seleccionarCartaMazo2(ImageView e) {
		for ( Node node : gridPaneMazo.getChildren()) {
			try {
				ImageView imagen = (ImageView) node;
				Carta carta1 = new Carta(this.getCartaJugadorImagen(imagen));
				Carta carta2 = new Carta(this.getCartaJugadorImagen(e));
				if (carta1.getValor() == carta2.getValor() && carta1.getPalo() == carta2.getPalo()) {
					imagen.setDisable(true);
					imagen.setOpacity(0.25);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

    void seleccionarImagen(ImageView imagen) {    
        if(cartaSeleccionada!=null) {
        	for(int i = 0; i<cartaSeleccionada.length-5;i++) {
	        	if(cartaSeleccionada[i]) {
	        		switch(i){
			            case 0:
			                if(!this.getCartaJugadorImagen(imagen).equals(this.getCartaJugadorImagen(P1Card1))) {
			                	for ( Node n : gridPaneMazo.getChildren()) {
			        				try {
			        					ImageView imgAux = (ImageView) n;
			        					if(this.getCartaJugadorImagen(P1Card1).equals(this.getCartaJugadorImagen(imgAux))) {
			        						n.setDisable(false);
			        		            	n.setOpacity(1);
			        					}
			        				}catch (Exception e1){};
			        			}
			                }
			            	P1Card1.setImage(imagen.getImage());
			            break;
			            case 1: 
			            	if(!this.getCartaJugadorImagen(imagen).equals(this.getCartaJugadorImagen(P1Card2))) {
			                	for ( Node n : gridPaneMazo.getChildren()) {
			        				try {
			        					ImageView imgAux = (ImageView) n;
			        					if(this.getCartaJugadorImagen(P1Card2).equals(this.getCartaJugadorImagen(imgAux))) {
			        						n.setDisable(false);
			        		            	n.setOpacity(1);
			        					}
			        				}catch (Exception e1){};
			        			}
			                }
			            	P1Card2.setImage(imagen.getImage());
			            break;
			            case 2: 
			            	if(!this.getCartaJugadorImagen(imagen).equals(this.getCartaJugadorImagen(P2Card1))) {
			                	for ( Node n : gridPaneMazo.getChildren()) {
			        				try {
			        					ImageView imgAux = (ImageView) n;
			        					if(this.getCartaJugadorImagen(P2Card1).equals(this.getCartaJugadorImagen(imgAux))) {
			        						n.setDisable(false);
			        		            	n.setOpacity(1);
			        					}
			        				}catch (Exception e1){};
			        			}
			                }
			            	P2Card1.setImage(imagen.getImage());
			            break;
			            case 3: 
			            	if(!this.getCartaJugadorImagen(imagen).equals(this.getCartaJugadorImagen(P2Card2))) {
			                	for ( Node n : gridPaneMazo.getChildren()) {
			        				try {
			        					ImageView imgAux = (ImageView) n;
			        					if(this.getCartaJugadorImagen(P2Card2).equals(this.getCartaJugadorImagen(imgAux))) {
			        						n.setDisable(false);
			        		            	n.setOpacity(1);
			        					}
			        				}catch (Exception e1){};
			        			}
			                }
			            	P2Card2.setImage(imagen.getImage());
			            break;
			            case 4: 
			            	if(!this.getCartaJugadorImagen(imagen).equals(this.getCartaJugadorImagen(P3Card1))) {
			                	for ( Node n : gridPaneMazo.getChildren()) {
			        				try {
			        					ImageView imgAux = (ImageView) n;
			        					if(this.getCartaJugadorImagen(P3Card1).equals(this.getCartaJugadorImagen(imgAux))) {
			        						n.setDisable(false);
			        		            	n.setOpacity(1);
			        					}
			        				}catch (Exception e1){};
			        			}
			                }
			            	P3Card1.setImage(imagen.getImage());
			            break;
			            case 5: 
			            	if(!this.getCartaJugadorImagen(imagen).equals(this.getCartaJugadorImagen(P3Card2))) {
			                	for ( Node n : gridPaneMazo.getChildren()) {
			        				try {
			        					ImageView imgAux = (ImageView) n;
			        					if(this.getCartaJugadorImagen(P3Card2).equals(this.getCartaJugadorImagen(imgAux))) {
			        						n.setDisable(false);
			        		            	n.setOpacity(1);
			        					}
			        				}catch (Exception e1){};
			        			}
			                }
			            	P3Card2.setImage(imagen.getImage());
			            break;
			            case 6: 
			            	if(!this.getCartaJugadorImagen(imagen).equals(this.getCartaJugadorImagen(P4Card1))) {
			                	for ( Node n : gridPaneMazo.getChildren()) {
			        				try {
			        					ImageView imgAux = (ImageView) n;
			        					if(this.getCartaJugadorImagen(P4Card1).equals(this.getCartaJugadorImagen(imgAux))) {
			        						n.setDisable(false);
			        		            	n.setOpacity(1);
			        					}
			        				}catch (Exception e1){};
			        			}
			                }
			            	P4Card1.setImage(imagen.getImage());
			            break;
			            case 7: 
			            	if(!this.getCartaJugadorImagen(imagen).equals(this.getCartaJugadorImagen(P4Card2))) {
			                	for ( Node n : gridPaneMazo.getChildren()) {
			        				try {
			        					ImageView imgAux = (ImageView) n;
			        					if(this.getCartaJugadorImagen(P4Card2).equals(this.getCartaJugadorImagen(imgAux))) {
			        						n.setDisable(false);
			        		            	n.setOpacity(1);
			        					}
			        				}catch (Exception e1){};
			        			}
			                }
			            	P4Card2.setImage(imagen.getImage());
			            break;
			            case 8: 
			            	if(!this.getCartaJugadorImagen(imagen).equals(this.getCartaJugadorImagen(P5Card1))) {
			                	for ( Node n : gridPaneMazo.getChildren()) {
			        				try {
			        					ImageView imgAux = (ImageView) n;
			        					if(this.getCartaJugadorImagen(P5Card1).equals(this.getCartaJugadorImagen(imgAux))) {
			        						n.setDisable(false);
			        		            	n.setOpacity(1);
			        					}
			        				}catch (Exception e1){};
			        			}
			                }
			            	P5Card1.setImage(imagen.getImage());
			            break;
			            case 9: 
			            	if(!this.getCartaJugadorImagen(imagen).equals(this.getCartaJugadorImagen(P5Card2))) {
			                	for ( Node n : gridPaneMazo.getChildren()) {
			        				try {
			        					ImageView imgAux = (ImageView) n;
			        					if(this.getCartaJugadorImagen(P5Card2).equals(this.getCartaJugadorImagen(imgAux))) {
			        						n.setDisable(false);
			        		            	n.setOpacity(1);
			        					}
			        				}catch (Exception e1){};
			        			}
			                }
			            	P5Card2.setImage(imagen.getImage());
			            break;
			            case 10: 
			            	if(!this.getCartaJugadorImagen(imagen).equals(this.getCartaJugadorImagen(P6Card1))) {
			                	for ( Node n : gridPaneMazo.getChildren()) {
			        				try {
			        					ImageView imgAux = (ImageView) n;
			        					if(this.getCartaJugadorImagen(P6Card1).equals(this.getCartaJugadorImagen(imgAux))) {
			        						n.setDisable(false);
			        		            	n.setOpacity(1);
			        					}
			        				}catch (Exception e1){};
			        			}
			                }
			            	P6Card1.setImage(imagen.getImage());
			            break;
			            case 11: 
			            	if(!this.getCartaJugadorImagen(imagen).equals(this.getCartaJugadorImagen(P6Card2))) {
			                	for ( Node n : gridPaneMazo.getChildren()) {
			        				try {
			        					ImageView imgAux = (ImageView) n;
			        					if(this.getCartaJugadorImagen(P6Card2).equals(this.getCartaJugadorImagen(imgAux))) {
			        						n.setDisable(false);
			        		            	n.setOpacity(1);
			        					}
			        				}catch (Exception e1){};
			        			}
			                }
			            	P6Card2.setImage(imagen.getImage());
			            break;
			        }
	        	}
			}
        	for(int i=cartaSeleccionada.length-5; i<cartaSeleccionada.length; i++) {
        		if(cartaSeleccionada[i]) {
        			switch(i) {
	        			case 12: 
	    	            	if(!this.getCartaJugadorImagen(imagen).equals(this.getCartaJugadorImagen(BoardCard1))) {
	    	                	for ( Node n : gridPaneMazo.getChildren()) {
	    	        				try {
	    	        					ImageView imgAux = (ImageView) n;
	    	        					if(this.getCartaJugadorImagen(BoardCard1).equals(this.getCartaJugadorImagen(imgAux))) {
	    	        						n.setDisable(false);
	    	        		            	n.setOpacity(1);
	    	        					}
	    	        				}catch (Exception e1){};
	    	        			}
	    	                }
	    	            	BoardCard1.setImage(imagen.getImage());
	    	            break;
	        			case 13: 
	    	            	if(!this.getCartaJugadorImagen(imagen).equals(this.getCartaJugadorImagen(BoardCard2))) {
	    	                	for ( Node n : gridPaneMazo.getChildren()) {
	    	        				try {
	    	        					ImageView imgAux = (ImageView) n;
	    	        					if(this.getCartaJugadorImagen(BoardCard2).equals(this.getCartaJugadorImagen(imgAux))) {
	    	        						n.setDisable(false);
	    	        		            	n.setOpacity(1);
	    	        					}
	    	        				}catch (Exception e1){};
	    	        			}
	    	                }
	    	            	BoardCard2.setImage(imagen.getImage());
	    	            break;
	        			case 14: 
	    	            	if(!this.getCartaJugadorImagen(imagen).equals(this.getCartaJugadorImagen(BoardCard3))) {
	    	                	for ( Node n : gridPaneMazo.getChildren()) {
	    	        				try {
	    	        					ImageView imgAux = (ImageView) n;
	    	        					if(this.getCartaJugadorImagen(BoardCard3).equals(this.getCartaJugadorImagen(imgAux))) {
	    	        						n.setDisable(false);
	    	        		            	n.setOpacity(1);
	    	        					}
	    	        				}catch (Exception e1){};
	    	        			}
	    	                }
	    	            	BoardCard3.setImage(imagen.getImage());
	    	            break;
	        			case 15: 
	    	            	if(!this.getCartaJugadorImagen(imagen).equals(this.getCartaJugadorImagen(BoardCard4))) {
	    	                	for ( Node n : gridPaneMazo.getChildren()) {
	    	        				try {
	    	        					ImageView imgAux = (ImageView) n;
	    	        					if(this.getCartaJugadorImagen(BoardCard4).equals(this.getCartaJugadorImagen(imgAux))) {
	    	        						n.setDisable(false);
	    	        		            	n.setOpacity(1);
	    	        					}
	    	        				}catch (Exception e1){};
	    	        			}
	    	                }
	    	            	BoardCard4.setImage(imagen.getImage());
	    	            break;
	        			case 16: 
	    	            	if(!this.getCartaJugadorImagen(imagen).equals(this.getCartaJugadorImagen(BoardCard5))) {
	    	                	for ( Node n : gridPaneMazo.getChildren()) {
	    	        				try {
	    	        					ImageView imgAux = (ImageView) n;
	    	        					if(this.getCartaJugadorImagen(BoardCard5).equals(this.getCartaJugadorImagen(imgAux))) {
	    	        						n.setDisable(false);
	    	        		            	n.setOpacity(1);
	    	        					}
	    	        				}catch (Exception e1){};
	    	        			}
	    	                }
	    	            	BoardCard5.setImage(imagen.getImage());
	    	            break;
	            		}
        			}
        		
        	}
        	if(this.getCartaJugadorImagen(BoardCard1).equals("00") || this.getCartaJugadorImagen(BoardCard2).equals("00") || this.getCartaJugadorImagen(BoardCard3).equals("00")) {
        		BoardCard4.setDisable(true);
        		BoardCard4.setOpacity(0.25);
        		BoardCard5.setDisable(true);
        		BoardCard5.setOpacity(0.25);
        	}else{
        		BoardCard4.setDisable(false);
        		BoardCard4.setOpacity(1);
        	}
        	if(!this.getCartaJugadorImagen(BoardCard4).equals("00")) {
        		BoardCard5.setDisable(false);
        		BoardCard5.setOpacity(1);
        	}
        	
			imagen.setDisable(true);
			imagen.setOpacity(0.25);
        }
    }
}
