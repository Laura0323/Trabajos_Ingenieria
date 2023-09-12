
package ejemploarraylist;

import java.util.ArrayList; //Importar la clase vector del paquete java.util
import java.util.Scanner;
public class EjemploArrayList {

    static Scanner teclado=new Scanner(System.in);
    
    //Imprimir el vector
    //Metodo para Imprimir el vector
    static void ImprimirArray(ArrayList<String> clientes){
        //Verificar si la coleccion está vacia
        if(clientes.isEmpty()){
            System.out.println("El Array está vacío");
        }else{
            System.out.println("Contenido del Array:");
            for(String elemento:clientes){ //Esto es un ciclo FOR EACH
                System.out.print(elemento + "/");
            }
            System.out.println("\n");
        }
    }
    
    //Metodo para llenar el arraylist
    static void LlenarArray(ArrayList<String> clientes){
        String opc="";
        do{
            System.out.println("Ingrese el nombre del cliente:");
            clientes.add(teclado.next());
            System.out.println("Presione ENTER para continuar o (*) para terminar");
            opc=teclado.next();
        }while(!opc.equals("*"));
    }
    
    //Metodo para buscar el cliente
    static void BuscarCliente(ArrayList<String> clientes){
        System.out.println("Ingrese el cliente a buscar:");
        String dato=teclado.next();
        if(clientes.contains(dato)){
            System.out.println("El cliente está en la posición "
            + clientes.indexOf(dato));
        }else{
            System.out.println("El cliente a buscar no se encuentra");
        }
    }
    
    //Metodo para eliminar un cliente dado
    static void EliminarCliente(ArrayList<String> clientes){
        System.out.println("Ingrese el cliente a eliminar:");
        String cliE=teclado.next();
        if(clientes.contains(cliE)){
            clientes.remove(cliE); //Eliminar el dato
            System.out.println("Se ha eliminado el cliente");
            ImprimirArray(clientes);
        }else{
            System.out.println("No se puede eliminar el color porque no existe");
        }
    }
    
    
    public static void main(String[] args) {
        ArrayList<String> clientes=new ArrayList<String>();
        boolean salir=false;
        while(!salir){
            System.out.println("Menu");
            System.out.println("1. Registrar Clientes");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Buscar Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("5. Salir");
            System.out.println("Ingrese su opción:");
            int menu=teclado.nextInt();
            switch(menu){
                case 1:
                    LlenarArray(clientes);
                    break;
                case 2:
                    ImprimirArray(clientes);
                    break;
                case 3:
                    BuscarCliente(clientes);
                    break;
                case 4:
                    EliminarCliente(clientes);
                    break;
                case 5:
                    salir=true;
                    break;
            }
        }
    }
    
}
