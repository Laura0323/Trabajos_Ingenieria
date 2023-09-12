package sasoripc.bancojframe;

import javax.swing.JOptionPane;

public class Cliente {

    private String Nombre;
    private CuentaDeAhorros cuentaDeAhorros;
    private CuentaCorriente cuentaCorriente;
    private CDT cdt;

    public Cliente() {
        this.Nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente");
        this.cuentaDeAhorros = new CuentaDeAhorros();
        this.cuentaCorriente = new CuentaCorriente();
        this.cdt = new CDT();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public CuentaDeAhorros getCuentaDeAhorros() {
        return cuentaDeAhorros;
    }

    public void setCuentaDeAhorros(CuentaDeAhorros cuentaDeAhorros) {
        this.cuentaDeAhorros = cuentaDeAhorros;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public CDT getCdt() {
        return cdt;
    }

    public void setCdt(CDT cdt) {
        this.cdt = cdt;
    }
}
