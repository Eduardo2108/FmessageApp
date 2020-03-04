package extraclase.gui;

import extraclase.conectivity.Conversacion;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class botonMensajes extends javafx.scene.control.Button {
    int puerto;
    int height;
    int weight;
    Conversacion chat;

    Scene escena;
    public botonMensajes(int puerto){

        this.puerto = puerto;
        this.escena = escena;
        this.setHeight(height);
        this.setWidth(weight);
        this.setText(this.chat.getRemitente()+" en: " + puerto);


    }

     public void handle(ActionEvent event) {
        System.out.println("Hi there! You clicked me!");
    }
}
