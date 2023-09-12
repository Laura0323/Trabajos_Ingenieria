package Clases;

public class Cola {
    private Nodo inicio;
    private Nodo termino;

    public Cola() {
        inicio=null;
        termino=null;
    }
    
    //Método para insertar datos en la cola
    public void Enqueue(int dato){
        Nodo nuevo=new Nodo(dato);
        nuevo.setSig(null);
        if(inicio==null & termino==null){
            inicio=nuevo;
            termino=nuevo;
        }
        termino.setSig(nuevo);
        termino=termino.getSig();
    }//Cierre del metodo
    
    //Método para sacar elementos de la cola
    public int Dequeue(){
        int dato=inicio.getInfo();
        inicio=inicio.getSig();
        return dato;
    }
    
    //Metodo para determinar si la cola está vacia
    public boolean estaVacia(){
        boolean cola=false;
        if(inicio==null & termino==null){
            cola=true;
            System.out.println("La cola está vacía");
        }else{
            cola=false;
            System.out.println("La cola no est+a vacía");
        }
        return cola;
    }
    
    //Método para contar los elementos de la cola
    public int Contar(){
        int contador=0;
        Nodo t=this.inicio;
        while(t!=null){
            contador++;
            t=t.getSig();
        }
        System.out.println("Número de elementos en la cola: " + contador);
        return contador;
    }
    
    //Método para Eliminar la cola
    public void Eliminar(){
        inicio=null;
        termino=null;
    }
    
    //Método para listar los elementos de la cola
    public void Listar(){
        Nodo t=inicio;
        while(t!=null){
            System.out.print("|" + t.getInfo() + "|");
            t=t.getSig();
        }
        System.out.println("");
    }
}
