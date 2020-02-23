package FmessageApp.conectivity.lista;

class Nodo {
    private String mensaje;
    private int puerto;
    private String hora;


    protected Nodo(String mensaje, int puerto, String hora){
        this.mensaje = mensaje;
        this.puerto = puerto;
        this.hora = hora;
        siguiente = null;


    }
    void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    private Nodo siguiente;

    public String getMensaje() {
        return mensaje;
    }

    public int getPuerto() {
        return puerto;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
}
