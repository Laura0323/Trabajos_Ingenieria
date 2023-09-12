package colasconlistas;

import Clases.*;

public class ColasConListas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear una cola
        Cola cola1=new Cola();
        cola1.Enqueue(46);
        cola1.Enqueue(12);
        cola1.Enqueue(87);
        cola1.Enqueue(125);
        cola1.Enqueue(30);
        cola1.Listar();
        cola1.Dequeue();
        cola1.Listar();
        cola1.Dequeue();
        cola1.Listar();
        cola1.Dequeue();
        cola1.Dequeue();
        cola1.Listar();
        cola1.estaVacia();
        cola1.Contar();
    }
    
}
