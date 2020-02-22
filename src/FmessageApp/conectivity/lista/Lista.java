package FmessageApp.conectivity.lista;

import java.sql.SQLOutput;

class Lista {

    private Nodo head;
    private int largo;

    public void agregarMensaje(String texto, int puerto, String hora, String remitente){
        Nodo mensajeNuevo = new Nodo(texto, puerto, hora,remitente);
        if(largo==0){
            this.head = mensajeNuevo;
            this.largo ++;
            System.out.println("Mensaje #" + largo + " agregado");
        }
        else{
            Nodo tmp = this.head;
            while(tmp.getSiguiente() != null){
                tmp = tmp.getSiguiente();
            }
            tmp.setSiguiente(mensajeNuevo);
            this.largo++;
            System.out.println("Mensaje #" + largo + " agregado");
        }
    }

    public void index(int subIndice){
        Nodo tmp = this.head;
        int ref = 0;
        while(ref != subIndice){
            tmp = tmp.getSiguiente();
            if(tmp == null){
                System.out.println("Index out of range");
                break;
            }
        }

    }

}
