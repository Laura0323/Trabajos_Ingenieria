package sasoripc.adivina;

import javax.swing.JOptionPane;

public class Adivina {

    static void LlenarVector(String palabra[], int x) {
        for (int i = 0; i < x; i++) {
            palabra[i] = JOptionPane.showInputDialog(null, "Ingrese la letra #" + (i + 1));
        }
    }

    static void Adivinar(String palabra[], int x) {
        String adivina[] = new String[x];
        String y;
        int a = 0;
        boolean z, w;
        for (int i = 0; i < x; i++) {
            adivina[i] = "?";
        }

        String usados[] = new String[10];
        for (int i = 0; i < 10; i++) {
            z = false;
            w = false;
            y = JOptionPane.showInputDialog(null, "Ingrese una letra o vocal");
            for (int j = 0; j < x; j++) {
                if (usados[j] != null && usados[j].equalsIgnoreCase(y)) {
                    JOptionPane.showMessageDialog(null, "Usted ya utilizo esta letra, perdiste un turno");
                    JOptionPane.showMessageDialog(null, "Le quedan " + (9 - i) + " intentos");
                    w = true;
                }
            }

            if (w == false) {
                for (int j = 0; j < x; j++) {
                    if (palabra[j].equalsIgnoreCase(y)) {
                        adivina[j] = y;
                        z = true;
                        a = a + 1;
                    }
                }
                usados[i] = y;
            }

            if (z == true) {
                JOptionPane.showMessageDialog(null, "Correcto, encontraste una nueva letra, 'Mira la consola'");
                for (int j = 0; j < x; j++) {
                    System.out.print(adivina[j] + ",");
                }

                System.out.println("");
                JOptionPane.showMessageDialog(null, "Le quedan " + (9 - i) + " intentos");
            } else {

                if (w == false) {
                    JOptionPane.showMessageDialog(null, "Lo sentimos, ingresaste una letra incorrecta");
                    JOptionPane.showMessageDialog(null, "Le quedan " + (9 - i) + " intentos");
                }
            }

            if (a == x) {
                usados[i] = y;
                i = 10;
                JOptionPane.showMessageDialog(null, "¡Felicitaciones!, Adivinaste la palabra");

            }
        }

        if (a != x) {
            JOptionPane.showMessageDialog(null, "¡Perdiste!, No adivinaste la palabra");
            JOptionPane.showMessageDialog(null, "La palabra era: 'Mirar en la consola'");
            for (int i = 0; i < x; i++) {
                System.out.print(palabra[i]);
            }
        }
    }

    public static void main(String[] args) {
        int x;
        x = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de letras que tendra su palabra"));
        String palabra[] = new String[x];
        LlenarVector(palabra, x);
        Adivinar(palabra, x);
        JOptionPane.showMessageDialog(null, "Fin");
    }
}
