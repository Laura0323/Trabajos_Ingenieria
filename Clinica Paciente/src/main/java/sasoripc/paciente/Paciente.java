package sasoripc.paciente;

import javax.swing.JOptionPane;

public class Paciente {

    private String Nombre;
    private int Edad;
    private String Cedula;
    private String Genero;
    private double altura;
    private double peso;
    private Acudiente Acudiente;

    public Paciente() {
        this.Nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del paciente: ");
        this.Edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad del paciente: "));
        this.Cedula = JOptionPane.showInputDialog(null, "Ingrese la cedula o TI del paciente: ");
        
        int x = 0;
        do {
            x = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese 1. Si es femenino o 2. si es masculino"));
            switch (x) {
                case 1: {
                    this.Genero = "Femenino";
                    break;
                }
                case 2: {
                    this.Genero = "Masculino";
                    break;
                }
                default: {
                    if ((x > 2) || (x < 1)) {
                        JOptionPane.showMessageDialog(null, "Ingreso un valor diferente de 1 y 2, por favor ingrese nuevamente un valor correcto");
                    }
                }
            }
        } while ((x > 2) || (x < 1));
        this.altura = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la altura del paciente: "));
        this.peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el peso (en Kg) del paciente: "));
        this.Acudiente = Acudiente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Acudiente getAcudiente() {
        return Acudiente;
    }

    public void setAcudiente(Acudiente Acudiente) {
        this.Acudiente = Acudiente;
    }

    public void adulto() {
        this.Acudiente = new Acudiente();
    }

    public void pesoIdeal() {
        double Pi;
        Pi = this.peso / (this.altura * this.altura);
        if (Pi >= 20 && Pi <= 25) {
            JOptionPane.showMessageDialog(null, "Este paciente esta en el peso ideal " + Pi);
        } else {
            if (Pi > 25) {
                JOptionPane.showMessageDialog(null, "Este paciente tiene sobre peso " + Pi);
            } else {
                JOptionPane.showMessageDialog(null, "Este paciente esta por debajo del peso ideal " + Pi);
            }
        }
    }

    public void datos() {
        String nombre = this.Nombre;
        JOptionPane.showMessageDialog(null, "Nombre del paciente: " + nombre);
        String cedula = this.Cedula;
        JOptionPane.showMessageDialog(null, "Documento de identidad del paciente: " + cedula);
        int edad = this.Edad;
        JOptionPane.showMessageDialog(null, "Edad del paciente: " + edad);
        
        if (edad < 18) {
            String aNombre = this.Acudiente.getNombre();
            JOptionPane.showMessageDialog(null, "Nombre del acudiente: " + aNombre);
            String aCedula = this.Acudiente.getCedula();
            JOptionPane.showMessageDialog(null, "Cedula del acudiente: " + aCedula);
        }
        
        String genero = this.Genero;
        JOptionPane.showMessageDialog(null, "Genero del paciente: " + genero);
        double altura = this.altura;
        JOptionPane.showMessageDialog(null, "Altura del paciente: " + altura);
        double peso = this.peso;
        JOptionPane.showMessageDialog(null, "Peso del paciente: " + peso);

    }

}
