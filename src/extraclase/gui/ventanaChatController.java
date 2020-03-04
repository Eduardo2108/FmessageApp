package extraclase.gui;

import extraclase.conectivity.App;
import extraclase.conectivity.Client;
import extraclase.conectivity.Conversacion;
import extraclase.conectivity.server;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ventanaChatController {
    @FXML private TextField d;
    @FXML private ListView<String> lst;

    private App aplicacion = exe.getApp();


    public void sendMessagePressed(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        System.out.println("Mensaje a enviar: " + d.getText());
        aplicacion.sendMessage(d.getText(), Integer.parseInt(puertoLabel.getText()), "Eduardo");
        Conversacion[] lista = server.listaConversaciones;
        int i = 0;
        while (i < 5) {
            if (lista[i] == null) {
                lista[i] = new Conversacion(Integer.parseInt(d1.getText()));
                lista[i].sendMessage(d1.getText(),Integer.parseInt(d1.getText()),"eduard");

                break;
            } else {
                if(lista[i].getPuerto()==Integer.parseInt(d1.getText())){
                    lista[i].sendMessage(d1.getText(),Integer.parseInt(d1.getText()),"eduard");
                    break;
                }
                i++;
            }

        }
    }
    @FXML private TextField d1;
    @FXML private ListView lst;
    private int puerto;
    public void sendMessagePressed(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Client.sendMessage(entradaTexto.getText(), puerto, puerto, "Remitente");
        lst.getItems().add("Tu: " + entradaTexto.getText());
    }
    public void puertoOKpressed() {
        try{
            System.out.println(d1.getText());
            puerto = Integer.parseInt( d1.getText());
        }
        catch (Exception e){
            System.out.println(e.getCause());
        }
    }
}



