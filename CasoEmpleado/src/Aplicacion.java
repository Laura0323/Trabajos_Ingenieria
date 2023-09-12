
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Empleado empleado = new Empleado();

        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, " Seleccione una opcion \n " + " 1.Visualizar informacion del empleado \n "
                    + " 2.Modificar salario del empelado \n " + " 3.Calcular la edad del empleado \n " + " 4.Calcular la antiguedad del empleado \n "
                    + " 5.Calcular las prestaciones del empleado \n " + " 6.Cambiar el empleado \n " + " 7.Salir "));

            switch (opc) {
                case 1: {
                    empleado.mostrar();
                    break;
                }
                case 2: {
                    double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el nuevo salario"));
                    empleado.setSalario(salario);
                    JOptionPane.showMessageDialog(null, "El salario ha sido modificado");
                    break;
                }
                case 3: {
                    int dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dia de hoy"));
                    int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de hoy"));
                    int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de hoy"));
                    Fecha fechaActual = new Fecha(dia, mes, ano);
                    int edad = empleado.calcularEdad(fechaActual);
                    JOptionPane.showMessageDialog(null, "La edad es " + edad);
                    break;
                }
                case 4: {
                    int dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dia de hoy"));
                    int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de hoy"));
                    int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de hoy"));
                    Fecha fechaActual = new Fecha(dia, mes, ano);
                    int antiguedad = empleado.antiguedad(fechaActual);
                    JOptionPane.showMessageDialog(null, "La antiguedad es " + antiguedad);
                    break;
                }
                case 5: {
                    int dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dia de hoy"));
                    int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de hoy"));
                    int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de hoy"));
                    Fecha fechaActual = new Fecha(dia, mes, ano);
                    double prestaciones = empleado.prestaciones(fechaActual);
                    JOptionPane.showMessageDialog(null, "Las prestaciones son " + prestaciones);
                    break;
                }
                case 6: {
                    empleado.cambiarEmpleado();
                    JOptionPane.showMessageDialog(null, "El empleado ha sido modificado");
                    break;
                }
            }
        } while (opc != 7);
    }
}
    