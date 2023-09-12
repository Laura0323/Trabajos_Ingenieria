package sasoripc.bancojframe;

import javax.swing.JOptionPane;

public class CDT {

    private double Interes;
    private double saldo;
    private int mesesDeDuracion;

    public CDT() {
        this.Interes = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese cuanto sera el interes para este CDT"));
        this.saldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el saldo inicial de su CDT"));
        this.mesesDeDuracion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los meses a los cuales desea abrir su CDT"));;
    }

    public double getInteres() {
        return Interes;
    }

    public void setInteres(double Interes) {
        this.Interes = Interes;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getMesesDeDuracion() {
        return mesesDeDuracion;
    }

    public void setMesesDeDuracion(int mesesDeDuracion) {
        this.mesesDeDuracion = mesesDeDuracion;
    }

    public void avanzarMes() {
        saldo = saldo * (1 + (Interes * 1));

    }
}
