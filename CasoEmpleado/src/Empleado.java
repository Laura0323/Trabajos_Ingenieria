
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
public class Empleado {

    private String Nombre;
    private String Apellido;
    private String Genero;
    private double Salario;
    private Fecha FechaNacimiento;
    private Fecha FechaDeIngreso;

    //constructor
    public Empleado() {
        this.Nombre = JOptionPane.showInputDialog(null, "ingrese el nombre del empleado");
        this.Apellido = JOptionPane.showInputDialog(null, "ingrese el apellido del empleado");;
        this.Genero = JOptionPane.showInputDialog(null, "ingrese el genero del empleado");;
        this.Salario = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el salario del empleado"));
        int dia_nacimiento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dia de nacimiento"));
        int mes_nacimiento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de nacimiento"));
        int ano_nacimiento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de nacimiento"));
        this.FechaNacimiento = new Fecha(dia_nacimiento, mes_nacimiento, ano_nacimiento);
        int dia_ingreso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dia de ingreso"));
        int mes_ingreso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de ingreso"));
        int ano_ingreso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de ingreso"));
        this.FechaDeIngreso = new Fecha(dia_ingreso, mes_ingreso, ano_ingreso);
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

    public Fecha getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Fecha FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public Fecha getFechaDeIngreso() {
        return FechaDeIngreso;
    }

    public void setFechaDeIngreso(Fecha FechaDeIngreso) {
        this.FechaDeIngreso = FechaDeIngreso;
    }

    public int calcularEdad(Fecha fechaActual) {
        int edad = fechaActual.getAno() - FechaNacimiento.getAno();
        if (fechaActual.getMes() < FechaNacimiento.getMes()) {
            edad--;
        } else {
            if (fechaActual.getMes() == FechaNacimiento.getMes() && fechaActual.getDia() > FechaNacimiento.getDia()) {
                edad--;
            }
        }
        return edad;
    }

    public int antiguedad(Fecha fechaActual) {
        int antiguedad = fechaActual.getAno() - FechaDeIngreso.getAno();
        if (fechaActual.getMes() > FechaDeIngreso.getMes()) {
            antiguedad--;
        } else {
            if (fechaActual.getMes() == FechaDeIngreso.getMes() && fechaActual.getDia() > FechaDeIngreso.getDia()) {
                antiguedad--;
            }
        }
        return antiguedad;
    }

    public double prestaciones(Fecha fechaActual) {
        int antiguedad = antiguedad(fechaActual);
        double prestaciones = (antiguedad * Salario) / 12;
        return prestaciones;
    }

    public void mostrar() {
        JOptionPane.showMessageDialog(null, "El nombre del empleado es " + Nombre + "\n"
                + " El apellido del empleado es " + Apellido + "\n"
                + " Nacio el dia " + FechaNacimiento.getDia() + " del mes " + FechaNacimiento.getMes() + " del año " + FechaNacimiento.getAno());
    }

    public void cambiarEmpleado() {
        this.Nombre = JOptionPane.showInputDialog(null, "ingrese el nombre del empleado");
        this.Apellido = JOptionPane.showInputDialog(null, "ingrese el apellido del empleado");;
        this.Genero = JOptionPane.showInputDialog(null, "ingrese el genero del empleado");;
        this.Salario = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el salario del empleado"));
        int dia_nacimiento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dia de nacimiento"));
        int mes_nacimiento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de nacimiento"));
        int ano_nacimiento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de nacimiento"));
        this.FechaNacimiento = new Fecha(dia_nacimiento, mes_nacimiento, ano_nacimiento);
        int dia_ingreso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dia de ingreso"));
        int mes_ingreso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de ingreso"));
        int ano_ingreso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de ingreso"));
        this.FechaDeIngreso = new Fecha(dia_ingreso, mes_ingreso, ano_ingreso);
    }
}
