package extraclase.gui;
import extraclase.conectivity.App;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Optional;


public class exe extends Application {
    private static App app;


    public static App getApp() {
        return app;
    }

    String name;
    int puerto;
    @Override
    public void start(Stage primeraEscena) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ventanaPrincipal.fxml"));
        primeraEscena.setTitle("Hello World");
        primeraEscena.setScene(new Scene(root));

        //obtencion del nombre del usuario
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Inicio de sesión");
        dialog.setHeaderText("Esto no es un nombre de usuario ni un pin, \neste nombre sera visible para sus contactos :)");
        dialog.setContentText("Digite su nombre de usuario (No puede tener simbolos ni números");
        Optional<String> result = dialog.showAndWait();
        this.name = result.get();


     //   botonMensajes boton = new botonMensajes(54);
        //Ajustes y actualizacion de la pantalla
        primeraEscena.setResizable(false);
        primeraEscena.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
