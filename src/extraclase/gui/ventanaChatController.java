package extraclase.gui;

import extraclase.conectivity.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class ventanaChatController {
    @FXML private TextField entradaTexto;
    @FXML private TextField d1;
    @FXML private ListView lst;
    @FXML private Label puertoLabel;

    private int puerto;
    public void sendMessagePressed(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Client.sendMessage(entradaTexto.getText(), puerto, puerto, "Remitente");
        lst.getItems().add("Tu a el puerto " +": " + puerto + entradaTexto.getText());
    }

    public void addMensaje(String msj, int puerto){
        lst.getItems().add("Puerto " + puerto + ": " + msj);

    }
    public void puertoOKpressed() {
        try{
            System.out.println(d1.getText());
            puerto = Integer.parseInt( d1.getText());
            puertoLabel.setText(d1.getText());
        }
        catch (Exception e){
            System.out.println(e.getCause());
        }
    }
}



