package ejemploclasevector;

import java.util.Vector; //Importar la clase vector del paquete java.util
import java.util.Scanner;

public class EjemploClaseVector {

    static Scanner teclado=new Scanner(System.in);
    //Metodo para probar diferentes métodos de la clase vector
    static void ProbarVector(){
        //Instanciar o crear nuestro vector
        Vector<String> colores=new Vector<String>();
        
        String opc="";
        System.out.println("¿Desea ingresar un color? - Si/No");
        opc=teclado.next();
        while(opc.equals("si") || opc.equals("Si") || opc.equals("SI")){
            System.out.println("Ingrese el color:");
            colores.addElement(teclado.next());//Agregamos elementos a la colección
            //colores.add(teclado.next());
            System.out.println("¿Desea ingresar un color? - Si/No");
            opc=teclado.next();
        }
        
        //Mostrar los colores almacenados en la coleccion
        ImprimirVector(colores);
        
        //Mostrar el primer y ultimo elemento de la colección
        System.out.println("Primer Elemento: " + colores.firstElement());
        System.out.println("Ultimo Elemento: " + colores.lastElement());
        
        //Buscar un color dentro de la colección
        BuscarColor(colores);
        
        //Buscar un color dada su posicion
        BuscarColorPosicion(colores);
        
        //Eliminar un color de la colección
        EliminarColor(colores);
        
        //Eliminar un color dada su posicion
        EliminarColorPosicion(colores);
        
        //Eliminar todos los elementos de la coleccion
        EliminarElementos(colores);
        
    }//Cierre del metodo probar
    
    //Metodo para eliminar todos los elementos
    static void EliminarElementos(Vector<String> color){
        color.removeAllElements(); //Eliminar todos los elementos
        System.out.println("Se han eliminado los elementos");
        ImprimirVector(color);
        System.out.println("");
    }
    
    //Metodo para eliminar un color dada su posicion
    static void EliminarColorPosicion(Vector<String> color){
        System.out.println("Ingrese la posicion del color a eliminar:");
        int posE=teclado.nextInt();
        if(posE>=0 && posE<color.size()){
            color.removeElementAt(posE);
            System.out.println("Se ha eliminado el color");
            ImprimirVector(color);
        }else{
            System.out.println("La posición es inválida");
        }
        System.out.println("");
    }
    
    //Metodo para eliminar un color dado
    static void EliminarColor(Vector<String> color){
        System.out.println("Ingrese el color a eliminar:");
        String colorE=teclado.next();
        if(color.contains(colorE)){
            color.remove(colorE); //Eliminar el dato
            //color.removeElement(colorE);
            System.out.println("Se ha eliminado el color");
            ImprimirVector(color);
        }else{
            System.out.println("No se puede eliminar el color porque no existe");
        }
    }
    
    //Metodo para buscar un color dada su posicion
    static void BuscarColorPosicion(Vector<String> color){
        System.out.println("Ingrese la posicion a buscar:");
        int posBuscar=teclado.nextInt();
        if(posBuscar>=0 && posBuscar<color.size()){
            System.out.println("El color es: " + color.get(posBuscar));
            //System.out.println("El color es: " + color.elementAt(posBuscar));
        }else{
            System.out.println("Posicion Inválida");
        }
        System.out.println("");
    }
    
    //Metodo para Imprimir el vector
    static void ImprimirVector(Vector<String> color){
        //Verificar si la coleccion está vacia
        if(color.isEmpty()){
            System.out.println("El vector está vacío");
        }else{
            System.out.println("Contenido del Vector:");
            for(String elemento:color){ //Esto es un ciclo FOR EACH
                System.out.println(elemento + "/");
            }
            System.out.println("\n");
        }
    }
    
    //Metodo para buscar un color
    static void BuscarColor(Vector<String> color){
        System.out.println("Ingrese el color a buscar:");
        String dato=teclado.next();
        if(color.contains(dato)){
            System.out.println("El color está en la posición "
            + color.indexOf(dato));
        }else{
            System.out.println("El color a buscar no se encuentra");
        }
    }
    
    public static void main(String[] args) {
        //Probar todo la colección Vector
        ProbarVector();
    }
    
}
