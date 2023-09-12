package sasoripc.bancojframe;

import javax.swing.JOptionPane;

public class CuentaDeAhorros {

    private double saldo;
    private static final double interes = 0.06;

    public CuentaDeAhorros() {
        this.saldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el saldo inicial de su cuenta de ahorros"));
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void avanzarMes() {
        saldo = saldo * (1 + (interes * 1));

    }
}
