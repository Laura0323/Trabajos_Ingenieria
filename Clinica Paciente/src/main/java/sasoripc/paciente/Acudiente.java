package sasoripc.paciente;

import javax.swing.JOptionPane;

public class Acudiente {

    private String Nombre;
    private String Cedula;

    public Acudiente() {
        this.Nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del acudiente del paciente: ");
        this.Cedula = JOptionPane.showInputDialog(null, "Ingrese la cedula del acudiente del paciente: ");
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

}
