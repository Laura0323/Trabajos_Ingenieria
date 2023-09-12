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
public class Paciente {

    private String Nombre;
    private int Edad;
    private int Cedula;
    private int Genero;
    private double Peso;
    private double Altura;

    public Paciente() {

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

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public int getGenero() {
        return Genero;
    }

    public void setGenero(int Genero) {
        this.Genero = Genero;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    public double getAltura() {
        return Altura;
    }

    public void setAltura(double Altura) {
        this.Altura = Altura;
    }

    public void informacion() {
        Nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre: ");
        Edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su edad: "));
        Cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su cedula: "));
        Genero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su genero(1. Hombre/ 2. Mujer): "));
        Peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese su peso (en kg): "));
        Altura = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese su altura: "));
    }

    public void Edad() {

        if (Edad < 18) {
            JOptionPane.showMessageDialog(null, "El paciente debe de tener un acompañante");
        }
    }

    public int validarGenero() {
        if (Genero == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public void mostrar() {
        JOptionPane.showMessageDialog(null, "El paciente se llama: " + Nombre + "su edad es: " + Edad + "su cedula es: " + Cedula + "su genero es: " + Genero + "Su peso es: " + Peso + "su altura es: " + Altura);
    }

    public void IMC() {
        double peso_ideal = Peso / Altura * Altura;

        if (peso_ideal >= 20 && peso_ideal < 25) {
            JOptionPane.showMessageDialog(null, "Usted esta en el peso ideal");

        } else {
            if (peso_ideal > 25) {
                JOptionPane.showMessageDialog(null, "Usted tiene sobre peso");

            } else {
                if (peso_ideal < 20) {
                    JOptionPane.showMessageDialog(null, "Usted esta por debajo del peso ideal");
                }
            }
        }
    }
}
