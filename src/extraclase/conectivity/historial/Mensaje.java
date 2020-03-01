package extraclase.conectivity.historial;

public class Mensaje {
    private String msj;
    private String hora;
    private int key; //if key = 2 => el mensaje fue recibido
                     // key = 1 => el mensaje fue enviado


    public Mensaje(String msj, String hora, int key){
        this.msj = msj;
        this.hora = hora;
        siguiente = null;
        this.key = key;


    }
    void setSiguiente(Mensaje siguiente) {
        this.siguiente = siguiente;
    }

    private Mensaje siguiente;

    public String getMsj() {
        return msj;
    }


    public Mensaje getSiguiente() {
        return siguiente;
    }
    public boolean recibido(){
        return this.key == 2;
    }
}
