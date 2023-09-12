/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cstallerobjetos2;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Pasajero {

    private String Nombre;
    private int Cedula;

    public Pasajero() {
        this.Nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre");
        this.Cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su cédula"));
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }
}
