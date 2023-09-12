/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cstallerobjetos2;

import javax.swing.JOptionPane;

/**
 *
 *
 *
 * @author Usuario
 */
public class Avión {

    private Silla[][] SillasEjecutivas = new Silla[2][4];
    private Silla[][] SillasEconomicas = new Silla[7][6];
    private int sw;

    public Avión(int sw) {
        this.sw = sw;
    }

    public int getSw() {
        return sw;
    }

    public void setSw(int sw) {
        this.sw = sw;
    }

    public Avión() {
        int numero = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                this.SillasEjecutivas[i][j] = new Silla("ventana", "Ejecutiva", false, true, numero);
                numero++;
                this.SillasEjecutivas[i][j].setClase("Ejecutiva");
                if (j == 0 || j == 3) {
                    this.SillasEjecutivas[i][j].setUbicacion("Ventana");
                } else {
                    this.SillasEjecutivas[i][j].setUbicacion("Pasillo");
                }
            }
        }

        numero = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                this.SillasEconomicas[i][j] = new Silla("ventana", "Ejecutiva", false, true, numero);
                numero++;
                this.SillasEconomicas[i][j].setClase("Ecónomica");
                if (j == 0 || j == 5) {
                    this.SillasEconomicas[i][j].setUbicacion("Ventana");
                }
                if (j == 1 || j == 4) {
                    this.SillasEconomicas[i][j].setUbicacion("Centro");
                }
                if (j == 2 || j == 3) {
                    this.SillasEconomicas[i][j].setUbicacion("Pasillo");
                }
            }
        }
    }

    public Silla buscarSillaLibreEjecutiva() {
        String Ubicacion = JOptionPane.showInputDialog(null, "Ingrese la ubicacion que desea(Ventana/Pasillo)");
        Silla silla = null;
        Silla encontrada = null;
        boolean encontro = false;
        sw = 1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != 0 && j != 1 || i != 1 && j != 1) {
                    silla = SillasEjecutivas[i][j];
                    if (silla.isDisponibilidad() && silla.getUbicacion().equalsIgnoreCase(Ubicacion) && !encontro) {
                        encontro = true;
                        encontrada = silla;
                    }
                }
            }
        }
        return encontrada;
    }

    public Silla buscarSillaLibreEconomica() {
        String Ubicacion = JOptionPane.showInputDialog(null, "Ingrese la ubicacion que desea(Ventana/Pasillo/Centro)");
        Silla silla = null;
        Silla encontrada = null;
        boolean encontro = false;
        sw = 1;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (i != 0 && j != 1 || i != 1 && j != 1 || i != 2 && j != 1) {
                    silla = SillasEconomicas[i][j];
                    if (silla.isDisponibilidad() && silla.getUbicacion().equalsIgnoreCase(Ubicacion) && !encontro) {
                        encontro = true;
                        encontrada = silla;
                    }
                }
            }
        }
        return encontrada;
    }

    public Silla buscarSillaLibre() {
        String Clase = JOptionPane.showInputDialog(null, "Ingrese la clase que desea(Ejecutiva/Economica)");
        Silla silla = null;
        if (Clase.equalsIgnoreCase("ejecutiva")) {
            silla = buscarSillaLibreEjecutiva();
        }
        if (Clase.equalsIgnoreCase("economica")) {
            silla = buscarSillaLibreEconomica();
        }
        return silla;
    }

    public void eliminarReserva() {
        int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la cedula de la persona para eliminar la reserva"));
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (SillasEjecutivas[i][j].getPasajero() != null) {
                    if (SillasEjecutivas[i][j].getPasajero().getCedula() == cedula) {
                        SillasEjecutivas[i][j].setPasajero(null);
                        SillasEjecutivas[i][j].setReserva(false);
                        SillasEjecutivas[i][j].setDisponibilidad(true);
                        JOptionPane.showMessageDialog(null, "La reserva ha sido eliminada");
                    }
                }
            }
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (SillasEconomicas[i][j].getPasajero() != null) {
                    if (SillasEconomicas[i][j].getPasajero().getCedula() == cedula) {
                        SillasEconomicas[i][j].setPasajero(null);
                        SillasEconomicas[i][j].setReserva(false);
                        SillasEconomicas[i][j].setDisponibilidad(true);
                        JOptionPane.showMessageDialog(null, "La reserva ha sido eliminada");
                    }
                }
            }
        }
    }

    public Pasajero buscarPasajeroEjecutivo() {
        boolean encontrada = false;
        Pasajero pasajero = null;
        int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cédula del pasajero a buscar"));
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.SillasEjecutivas[i][j].getPasajero() != null) {
                    if (this.SillasEjecutivas[i][j].getPasajero().getCedula() == cedula) {
                        pasajero = this.SillasEjecutivas[i][j].getPasajero();
                        encontrada = true;
                        JOptionPane.showMessageDialog(null, "El pasajero ha sido encontrado");
                    }
                }
            }
        }
        if (encontrada == true) {
            return pasajero;
        } else {
            return null;
        }
    }

    public Pasajero buscarPasajeroEconomico() {
        boolean encontrada = false;
        Pasajero pasajero = null;
        int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cédula del pasajero a buscar"));
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (this.SillasEconomicas[i][j].getPasajero() != null) {
                    if (this.SillasEconomicas[i][j].getPasajero().getCedula() == cedula) {
                        pasajero = this.SillasEconomicas[i][j].getPasajero();
                        encontrada = true;
                        JOptionPane.showMessageDialog(null, "El pasajero ha sido encontrado");
                    }
                }
            }
        }
        if (encontrada == true) {
            return pasajero;
        } else {
            return null;
        }
    }

    public Pasajero buscarPasajero() {
        Pasajero pasajero = buscarPasajeroEjecutivo();
        if (null == pasajero) {
            pasajero = buscarPasajeroEconomico();
        }
        return pasajero;
    }

    public int cantidadSillasEjecutivas() {
        int contador = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (SillasEjecutivas[i][j].isDisponibilidad() != true) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public int cantidadSillasEconomicas() {
        int contador = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (SillasEconomicas[i][j].isDisponibilidad() != true) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public double porcentajeDeOcupacion() {
        double porcentaje;
        double total = (SillasEconomicas.length * SillasEconomicas[0].length) + (SillasEjecutivas.length * SillasEjecutivas[0].length);
        double ocupadas = cantidadSillasEjecutivas() + cantidadSillasEconomicas();
        porcentaje = ocupadas / total * 100;
        return porcentaje;
    }

    public Silla asignarSillaFumador() {
        this.SillasEjecutivas[0][1].setFumador(true);
        this.SillasEjecutivas[1][1].setFumador(true);
        this.SillasEconomicas[0][1].setFumador(true);
        this.SillasEconomicas[1][1].setFumador(true);
        this.SillasEconomicas[2][1].setFumador(true);
        Silla silla = null;
        Silla encontrada = null;
        boolean encontro = false;
        String ubicacion = JOptionPane.showInputDialog(null, "ingrese la clase que desea(Ejecutiva/Economica)");
        if (ubicacion.equalsIgnoreCase("ejecutiva")) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i == 0 && j == 1 || i == 1 && j == 1) {
                        silla = SillasEjecutivas[i][j];
                        if (silla.isFumador() && silla.isDisponibilidad() && !encontro) {
                            encontrada = silla;
                            JOptionPane.showMessageDialog(null, "La silla para fumador ha sido reservada");
                            encontro = true;
                        }
                    }
                }
            }
        }
        if (ubicacion.equalsIgnoreCase("economica")) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 6; j++) {
                    if (i == 0 && j == 1 || i == 1 && j == 1 || i == 2 && j == 1) {
                        silla = SillasEconomicas[i][j];
                        if (silla.isFumador() && silla.isDisponibilidad() && !encontro) {
                            encontrada = silla;
                            JOptionPane.showMessageDialog(null, "La silla para fumador ha sido reservada");
                            encontro = true;
                        }
                    }
                }
            }
        }

        if (encontrada == null) {
            JOptionPane.showMessageDialog(null, "No hay silla disponible para fumador");
        }
        return encontrada;
    }

    public int cantidadEconomicasFumadores() {
        int contador = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0 && j == 1 || i == 1 && j == 1 || i == 2 && j == 1) {
                    if (SillasEconomicas[i][j].isFumador() == false) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

    public Silla sillaEjecutivaLibreFumador(String Ubicacion) {
        int contador = 0;
        Silla encontrada = null;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {

                if (i == 0 && j == 1 || i == 1 && j == 1) {
                    if (Ubicacion.equalsIgnoreCase(SillasEjecutivas[i][j].getUbicacion()) && SillasEjecutivas[i][j].isDisponibilidad()) {
                        contador++;

                    }
                }
            }
        }
        if (contador != 0) {
            JOptionPane.showMessageDialog(null, "Hay silla disponible");
        } else {
            JOptionPane.showMessageDialog(null, "No hay silla disponible");
        }
        return encontrada;
    }

    public int cantidadSillasEjecutivasFumadores() {
        int contador = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (SillasEjecutivas[i][j].isFumador() != false && SillasEjecutivas[i][j].isDisponibilidad() != true) {
                    contador++;

                }
            }
        }
        return contador;
    }

    public int cantidadSillasEconomicasFumadores() {
        int contador = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (SillasEconomicas[i][j].isFumador() != false && SillasEconomicas[i][j].isDisponibilidad() != true) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public int sillasFumadoresEnTodoElAvion() {
        int total = cantidadSillasEjecutivasFumadores() + cantidadSillasEconomicasFumadores();
        return total;
    }

    public String darClaseConMasSillasEnVentanaOcupadas() {
        if (sw == 1) {
            int contadorEjecutivas = 0;
            int contadorEconomicas = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == 0 || j == 3) {
                        if (SillasEjecutivas[i][j].isDisponibilidad() != true) {
                            SillasEjecutivas[i][j].getUbicacion();
                            contadorEjecutivas++;
                        }
                    }
                }
            }

            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 6; j++) {
                    if (j == 0 || j == 5) {
                        if (SillasEconomicas[i][j].isDisponibilidad() != true) {
                            SillasEconomicas[i][j].getUbicacion();
                            contadorEconomicas++;
                        }
                    }
                }
            }
            if (contadorEjecutivas == contadorEconomicas) {
                JOptionPane.showMessageDialog(null, "Ambas clases tienen la misma cantidad de sillas");
                return null;
            }
            if (contadorEjecutivas > contadorEconomicas) {
                JOptionPane.showMessageDialog(null, "La clase con mas sillas en ventana es: Ejecutiva");
            } else {
                JOptionPane.showMessageDialog(null, "La clase con mas sillas en ventana es: Economica");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todavia no se han asignado sillas");
        }
        return null;
    }

    public Silla darSillaEconomicaLibreEnVentana() {
        Silla silla = null;
        Silla encontrada = null;
        boolean encontro = false;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (j == 0 || j == 5) {
                    if (SillasEconomicas[i][j].isDisponibilidad() && !encontro) {
                        encontro = true;
                        encontrada = silla;
                        JOptionPane.showMessageDialog(null, "La silla libre en ventana se encuentra en la posicion " + i + " " + j);
                        return encontrada;
                    }
                }
            }
        }
        return null;
    }

    public void asignarPasajero() {
        buscarSillaLibre().asignarSillaPasajero();
    }
}
