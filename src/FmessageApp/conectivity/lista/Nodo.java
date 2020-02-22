package FmessageApp.conectivity.lista;

class Nodo {
    private String mensaje;
    private int puerto;
    private String hora;

    protected Nodo(String mensaje, int puerto, String hora, String remitente){
        this.mensaje = mensaje;
        this.puerto = puerto;
        this.hora = hora;
        this.remitente = remitente;

        siguiente = null;


    }
    public Nodo setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
        return this;
    }

    private String remitente;
    private Nodo siguiente;

    private Nodo anterior;

    public String getMensaje() {
        return mensaje;
    }

    public int getPuerto() {
        return puerto;
    }

    public String getHora() {
        return hora;
    }

    public String getRemitente() {
        return remitente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
}
