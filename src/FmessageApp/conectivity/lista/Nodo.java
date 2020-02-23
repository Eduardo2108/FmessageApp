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
    public Nodo setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
        return this;
    }


    private Nodo siguiente;

    private Nodo anterior;

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
