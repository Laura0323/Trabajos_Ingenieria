
package ejemplobusquedasecuencial3;

//Ejemplo banco
import java.util.*;

public class EjemploBusquedaSecuencial3 {
    static Scanner teclado=new Scanner(System.in);
    
    static void LlenarClientes(String clientes[],double saldos[],int tam){
        for(int i=0;i<tam;i++){
            System.out.println("Ingrese el nombre del cliente:");
            clientes[i]=teclado.next();
            System.out.println("Ingrese el saldo del cliente:");
            saldos[i]=teclado.nextDouble();
        }
    }
    
    static void BuscarCliente(String clientes[],double saldos[],int tam){
        System.out.println("Usuarios");
        for(int i=0;i<tam;i++){
            System.out.println(clientes[i] + ": " + i);
        }
        System.out.println("Ingrese el número del cliente:");
        int busqueda=teclado.nextInt();
        if(busqueda>tam-1){
            System.out.println("El cliente no se encuentra registrado");
        }else{
            System.out.println("Nombre Cliente: " + clientes[busqueda] + "\nSaldo: " + saldos[busqueda]);
        } 
    }
    
    static void BuscarClienteNombre(String clientes[],double saldos[],int tam){
        //??
    }
    
    static void MayorSaldo(String clientes[],double saldos[],int tam){
       double may=saldos[0]; 
       int pos=0;
       for(int i=1;i<tam;i++){
           if(saldos[i]>may){
               may=saldos[i];
               pos=i;
           }
       }
        System.out.println("El cliente " + clientes[pos] + " tiene el mayor saldo " + saldos[pos]);
    }
    
    static void MenorSaldo(String clientes[],double saldos[],int tam){
       double men=saldos[0]; 
       int pos=0;
       for(int i=1;i<tam;i++){
           if(saldos[i]>men){
               men=saldos[i];
               pos=i;
           }
       }
        System.out.println("El cliente " + clientes[pos] + " tiene el mayor saldo " + saldos[pos]);
    }
    
      static void PromedioSaldo(String clientes[],double saldos[],int tam){
       double suma=0; 
       for(int i=0;i<tam;i++){
         suma+=saldos[i];
       }
        System.out.println("Promedio de saldos es " + suma/tam);
    }
    
    public static void main(String[] args) {
        
        System.out.println("Ingrese la cantidad de clientes:");
        int tam=teclado.nextInt();
        String nombres[]=new String[tam];
        double saldos[]=new double[tam];
        LlenarClientes(nombres,saldos,tam);
        BuscarCliente(nombres,saldos,tam);
    }
    
}
