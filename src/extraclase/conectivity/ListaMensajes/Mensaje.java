package extraclase.conectivity.ListaMensajes;

public class Mensaje {
    private String mensaje;
    private int puerto;
    private String hora;


    protected Mensaje(String mensaje,String hora){
        this.mensaje = mensaje;

        this.hora = hora;
        siguiente = null;


    }
    void setSiguiente(Mensaje siguiente) {
        this.siguiente = siguiente;
    }

    private Mensaje siguiente;

    public String getMensaje() {
        return mensaje;
    }


    public Mensaje getSiguiente() {
        return siguiente;
    }
}
