package sasoripc.colas;

public class Nodo {

    private String info;
    private Nodo sig;

    public Nodo() {
        this.info = null;
        this.sig = null;
    }

    public Nodo(String dato) {
        this.info = dato;
        this.sig = null;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
}
