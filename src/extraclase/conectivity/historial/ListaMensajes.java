package extraclase.conectivity.historial;

public class ListaMensajes {

    private Mensaje head;
    private int largo;


    public void agregarMensaje(String texto, String hora,int key) {
        Mensaje mensajeNuevo = new Mensaje(texto, hora, key);

        if (largo == 0) {
            this.head = mensajeNuevo;
            this.largo++;
         } else {
            Mensaje tmp = this.head;
            while (tmp.getSiguiente() != null) {
                tmp = tmp.getSiguiente();
            }
            tmp.setSiguiente(mensajeNuevo);
            this.largo++;
         }
    }

    public ListaMensajes() {

        this.largo = 0;
        this.head = null;
    }

    public Mensaje index(int subIndice) {
        Mensaje tmp = this.head;
        int ref = 0;
        while (ref != subIndice) {
            if (tmp == null) {
                System.out.println("Index out of range");
                break;
            }
            tmp = tmp.getSiguiente();
            ref++;
        }
        return tmp;

    }

    public boolean existe(Mensaje mensaje) {
        Mensaje tmp = this.head;
        boolean var = false;
        while (tmp.getSiguiente() != null) {
            if (tmp == mensaje) {
                var = true;
                break;
            }
            tmp = tmp.getSiguiente();
        }
        return var;
    }

}
