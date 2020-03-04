package extraclase.gui;
import extraclase.conectivity.App;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Optional;


public class exe extends Application {
    @FXML private Label nameLabel;

    private static App app;


    public static App getApp() {
        return app;
    }

    String name;
    int puerto;
    @Override
    public void start(Stage primeraEscena) throws Exception{
        app.start();
        Parent root = FXMLLoader.load(getClass().getResource("ventanaPrincipal.fxml"));
        primeraEscena.setTitle("Hello World");
        primeraEscena.setScene(new Scene(root));



        //Ajustes y actualizacion de la pantalla
        primeraEscena.setResizable(false);
        primeraEscena.show();
     }


    public static void main(String[] args) {
        launch(args);
    }
}
