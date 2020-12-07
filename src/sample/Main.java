package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller controller = new Controller();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Poker.fxml"));
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Equity");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        controller.inicializar();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
