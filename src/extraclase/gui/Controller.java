package extraclase.gui;

import extraclase.conectivity.Conversacion;
import extraclase.conectivity.server;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import javax.swing.*;
import javax.xml.namespace.QName;
import java.util.Optional;

public class Controller {

    public void agregarConversacion(){

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
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("Error en el dato");

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error en el dato ingresado, verificar la informacion y reintentar");
            alert.setContentText("Solamente ingrese numeros...");

            alert.showAndWait();
        }
        catch (Exception i){
            System.out.println("Error: " +  i.getMessage());
        }
    }
}
