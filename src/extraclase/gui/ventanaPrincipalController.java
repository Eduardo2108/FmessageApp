package extraclase.gui;

import extraclase.conectivity.Conversacion;
import extraclase.conectivity.server;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.util.Optional;

public class ventanaPrincipalController {

    public void nuevaConversacionPresionado( MouseEvent event) {

        //Obtencion del dato del puerto para Enviar...
        try {

            TextInputDialog dialog = new TextInputDialog();

            dialog.setTitle("Nueva conversacion");
            dialog.setHeaderText("Digite el puerto del destinatario");

            dialog.setContentText("Puerto");

            //Conversion a Int, para usarla en la creacion de la conversacion.
            Optional<String> result = dialog.showAndWait();
            int puertoDestino = Integer.parseInt(result.get());

            Conversacion[] lista = server.listaConversaciones;
            //bucle para agregar la conversacion a la lista
            int i = 0;
            while (i < 5) {
                if (lista[i] == null) {
                    lista[i] = new Conversacion(puertoDestino);

                    break;
                } else {
                    i++;
                }

                Parent vistaChat = FXMLLoader.load(getClass().getResource("ventanaChat.fxml"));
                Scene chat = new Scene(vistaChat);

                 //obtener la ventana anterior
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                //Ejecutar la nueva ventana
                window.setScene(chat);
                window.show();
                System.out.println("Se hace cambio de ventana");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error en el dato");

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error en el dato ingresado, verificar la informacion y reintentar");
            alert.setContentText("Solamente ingrese numeros...");

            alert.showAndWait();
        } catch (Exception i) {
            System.out.println("Error: " + i.getMessage());
        }
    }



}
