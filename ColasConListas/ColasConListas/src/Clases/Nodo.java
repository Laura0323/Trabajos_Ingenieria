package Clases;

public class Nodo {
    private int info;
    private Nodo sig;

    public Nodo() {
        this.info=0;
        this.sig=null;
    }
    
    public Nodo(int dato) {
        this.info=dato;
        this.sig=null;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
    
    
}
