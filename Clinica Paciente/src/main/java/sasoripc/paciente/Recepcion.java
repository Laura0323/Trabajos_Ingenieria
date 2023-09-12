package sasoripc.paciente;

import javax.swing.JOptionPane;

public class Recepcion {

    Paciente Paciente;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido a la clinica Tdea");
        JOptionPane.showMessageDialog(null, "Por favor ingrese los datos de los 3 pacientes");

        for (int i = 0; i < 3; i++) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos del paciente #" + (i + 1));
            Paciente persona = new Paciente();
            if (persona.getEdad() < 18) {
                persona.adulto();
            }
            persona.pesoIdeal();
            persona.datos();
        }

        JOptionPane.showMessageDialog(null, "Gracias por confiar en nuestra clinica!");
    }
}
