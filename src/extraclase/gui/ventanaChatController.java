package extraclase.gui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.event.MouseEvent;

public class ventanaChatController {
    @FXML private TextField d;


    public void sendMessagePressed(javafx.scene.input.MouseEvent mouseEvent) {
        System.out.println("Mensaje a enviar: " + d.getText());
    }
}



