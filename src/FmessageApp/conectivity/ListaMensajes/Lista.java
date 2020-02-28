package FmessageApp.conectivity.ListaMensajes;

public class Lista {

    private Nodo head;
    private int largo;
    private String remitente;



    public void agregarMensaje(String texto, int puerto, String hora){
        Nodo mensajeNuevo = new Nodo(texto, puerto, hora);
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
    public Lista(String remitente){

        this.largo = 0;
        this.head = null;
        this.remitente = remitente;
    }
    public Nodo index(int subIndice){
        Nodo tmp = this.head;
        int ref = 0;
        while(ref != subIndice){
            tmp = tmp.getSiguiente();
            if(tmp == null){
                System.out.println("Index out of range");
                break;
            }
            ref++;
        }
        return tmp;

    }

    public boolean existe(Nodo mensaje){
        Nodo tmp = this.head;
        boolean var = false;
        while(tmp.getSiguiente() != null){
            if(tmp == mensaje){
                var = true;
                break;
            }
            tmp = tmp.getSiguiente();
        }
        return var;
    }
}
