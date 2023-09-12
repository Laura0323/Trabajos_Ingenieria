package sasoripc.colas;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opc = 0;

        Cola cola1 = new Cola();
        do {
            System.out.println("Taller");
            System.out.println("1. Registrar vehiculos");
            System.out.println("2. Mostrar cola");
            System.out.println("3. Desencolar vehiculos");
            System.out.println("4. Buscar un vehiculo en la cola");
            System.out.println("5. Salir");
            System.out.println("Ingrese su opción:");
            opc = teclado.nextInt();
            
            switch (opc) {
                case 1:
                    System.out.println("Ingrese la placa del vehiculo:");
                    System.out.println("Recuerde que la placa debe ser de 3 digitos");
                    int x = teclado.nextInt();
                    String y = Integer.toString(x);
                    do {
                        y = Integer.toString(x);
                        if (y.length() < 3 || y.length() > 3) {
                            System.out.println("Ingresaste un valor incorrecto, por favor ingresa una placa con valor de 3 digitos");
                            x = teclado.nextInt();
                        }
                    } while (y.length() < 3 || y.length() > 3);
                    cola1.Enqueue(y);
                    break;
                case 2:
                    cola1.Listar();
                    break;
                case 3:
                    cola1.Dequeue();
                    break;
                case 4:
                    System.out.println("Ingrese la placa del vehiculo:");
                    System.out.println("Recuerde que la placa debe ser de 3 digitos");
                    int w = teclado.nextInt();
                    String z = Integer.toString(w);
                    do {
                        y = Integer.toString(w);
                        if (y.length() < 3) {
                            System.out.println("Ingresaste un valor incorrecto, por favor ingresa una placa con valor de 3 digitos");
                            w = teclado.nextInt();
                        }
                    } while (z.length() < 3);
                    cola1.Buscar(z);
                    break;
            }
        } while (opc < 5);
    }
}
