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
public class Silla {

    private String Ubicacion;
    private String Clase;
    private boolean Reserva;
    private boolean Disponibilidad;
    private Pasajero pasajero;
    private int Numero;
    private boolean Fumador;

    public Silla(String Ubicacion, String Clase, boolean Reserva, boolean Disponibilidad, int Numero) {
        this.Ubicacion = Ubicacion;
        this.Clase = Clase;
        this.Reserva = Reserva;
        this.Disponibilidad = true;
        this.pasajero = pasajero;
        this.Numero = Numero;
        this.Fumador = false;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public String getClase() {
        return Clase;
    }

    public void setClase(String Clase) {
        this.Clase = Clase;
    }

    public boolean getReserva() {
        return Reserva;
    }

    public void setReserva(boolean Reserva) {
        this.Reserva = Reserva;
    }

    public boolean isDisponibilidad() {
        return Disponibilidad;
    }

    public void setDisponibilidad(boolean Disponibilidad) {
        this.Disponibilidad = Disponibilidad;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public boolean isFumador() {
        return Fumador;
    }

    public void setFumador(boolean Fumador) {
        this.Fumador = Fumador;
    }

    public void asignarSillaPasajero() {
        Pasajero pasajero = new Pasajero();
        this.pasajero = pasajero;
        Disponibilidad = false;
    }
}
