package sasoripc.colas;

public class Cola {

    private Nodo inicio;
    private Nodo termino;

    public Cola() {
        inicio = null;
        termino = null;
    }

    public void Enqueue(String dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.setSig(null);
        if (inicio == null & termino == null) {
            inicio = nuevo;
            termino = nuevo;
        }
        termino.setSig(nuevo);
        termino = termino.getSig();
        System.out.println("Se agrego un nuevo vehiculo a la cola");
        System.out.println("");
    }

    public String Dequeue() {
        String dato = null;
        if (!estaVacia()) {
            dato = inicio.getInfo();
            inicio = inicio.getSig();
            System.out.println("Se ha desencolado un vehiculo");
            System.out.println("");
        }
        return dato;
    }

    public boolean estaVacia() {
        boolean cola = false;
        if (inicio == null & termino == null) {
            cola = true;
            System.out.println("La cola está vacía");
        } else {
            cola = false;
            System.out.println("La cola no esta vacía");
        }
        return cola;
    }

    public int Contar() {
        int contador = 0;
        Nodo t = this.inicio;
        while (t != null) {
            contador++;
            t = t.getSig();
        }
        System.out.println("Número de elementos en la cola: " + contador);
        return contador;
    }

    public void Listar() {
        Nodo t = inicio;
        while (t != null) {
            System.out.print("|" + t.getInfo() + "|");
            t = t.getSig();
        }
        System.out.println("");
    }

    public void Buscar(String Dato) {
        Nodo t = inicio;
        int x = 1;
        boolean y = false;
        if (!estaVacia()) {
            while (t != null) {
                if (t.getInfo().equalsIgnoreCase(Dato)) {
                    System.out.println("Se encontro el vehiculo buscado dentro de la cola");
                    System.out.println("Se encuentra en la posicion #" + x);
                    System.out.println("");
                    y = true;
                }
                x = x + 1;
                t = t.getSig();
            }
            if (y == false) {
                System.out.println("El vehiculo buscado no existe dentro de la cola");
                System.out.println("");
            }
        }
        System.out.println("");
    }
}
