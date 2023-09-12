package sasoripc.bancojframe;

import javax.swing.JOptionPane;

public class CuentaCorriente {

    private double saldo;

    public CuentaCorriente() {
        this.saldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el saldo inicial de su cuenta corriente"));
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
