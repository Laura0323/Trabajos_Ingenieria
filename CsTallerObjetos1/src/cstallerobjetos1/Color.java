/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cstallerobjetos1;

/**
 *
 * @author Usuario
 */
public class Color {

    private int IntensidadDeRojo;
    private int IntensidadDeVerde;
    private int IntensidadDeAzul;

    public Color(int IntensidadDeRojo, int IntensidadDeVerde, int IntensidadDeAzul) {
        this.IntensidadDeRojo = IntensidadDeRojo;
        this.IntensidadDeVerde = IntensidadDeVerde;
        this.IntensidadDeAzul = IntensidadDeAzul;
    }

    public int getIntensidadDeRojo() {
        return IntensidadDeRojo;
    }

    public void setIntensidadDeRojo(int IntensidadDeRojo) {
        this.IntensidadDeRojo = IntensidadDeRojo;
    }

    public int getIntensidadDeVerde() {
        return IntensidadDeVerde;
    }

    public void setIntensidadDeVerde(int IntensidadDeVerde) {
        this.IntensidadDeVerde = IntensidadDeVerde;
    }

    public int getIntensidadDeAzul() {
        return IntensidadDeAzul;
    }

    public void setIntensidadDeAzul(int IntensidadDeAzul) {
        this.IntensidadDeAzul = IntensidadDeAzul;
    }
 
}
