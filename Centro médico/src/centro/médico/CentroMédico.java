/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centro.médico;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class CentroMédico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Paciente paciente1 = new Paciente();
        Paciente paciente2 = new Paciente();
        Paciente paciente3 = new Paciente();

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, " Seleccione una opcion \n " + " 1.Registrar un paciente \n "
                    + " 2.Determinar edad \n " + " 3.validar genero \n " + " 4.Mostrar informacion \n "
                    + " 5.Calcular el indice de masa corporal \n " + " 6.salir"));

            switch (opcion) {
                case 1: {
                    paciente1.informacion();
                    paciente2.informacion();
                    paciente3.informacion();
                    break;
                }

                case 2: {
                    paciente1.getEdad();
                    paciente2.getEdad();
                    paciente3.getEdad();
                    break;
                }

                case 3: {
                    paciente1.validarGenero();
                    paciente2.validarGenero();
                    paciente3.validarGenero();
                }
                case 4: {
                    paciente1.mostrar();
                    paciente2.mostrar();
                    paciente3.mostrar();
                }
                case 5: {
                    paciente1.IMC();
                    paciente2.IMC();
                    paciente3.IMC();
                }
            }
        } while (opcion != 6);
    }
}
