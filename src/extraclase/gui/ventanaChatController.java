package extraclase.gui;

import extraclase.conectivity.App;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ventanaChatController {
    @FXML private TextField d;
    @FXML private ListView lst;
    private App aplicacion = exe.getApp();


    public void sendMessagePressed(javafx.scene.input.MouseEvent mouseEvent) {

        System.out.println("Mensaje a enviar: " + d.getText());
        this.agregarMensaje(true,d.getText(),"Eduardo");

    }















    public void agregarMensaje(boolean enviado, String mensaje, String Name){
        String prefix = "You: ";
        if(!enviado){
            prefix = Name;
        }
        //Obtener la hora
        Date hora = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        String strHora = dateFormat.format(hora);

        lst.getItems().add(prefix + " "+mensaje + "                  hora: " + strHora          );
    }
}



