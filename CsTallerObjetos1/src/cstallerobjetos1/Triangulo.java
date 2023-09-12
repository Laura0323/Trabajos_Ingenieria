/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cstallerobjetos1;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Triangulo {

    private Puntos punto1;
    private Puntos punto2;
    private Puntos punto3;
    private Color ColorDeRelleno;
    private Color ColorDeLinea;
    private String textura;

    public Triangulo() {

        int X1 = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la coordenada X para el punto 1"));
        int Y1 = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la coordenada Y para el punto 1"));
        this.punto1 = new Puntos(X1, Y1);

        int X2 = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la coordenada X para el punto 2"));
        int Y2 = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la coordenada Y para el punto 2"));
        this.punto2 = new Puntos(X2, Y2);

        int X3 = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la coordenada X para el punto 3"));
        int Y3 = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la coordenada Y para el punto 3"));
        this.punto3 = new Puntos(X3, Y3);

        this.ColorDeRelleno = new Color(255, 255, 255);
        this.ColorDeLinea = new Color(0, 0, 0);
        this.textura = textura;

    }

    public Puntos getPunto1() {
        return punto1;
    }

    public void setPunto1(Puntos punto1) {
        this.punto1 = punto1;
    }

    public Puntos getPunto2() {
        return punto2;
    }

    public void setPunto2(Puntos punto2) {
        this.punto2 = punto2;
    }

    public Puntos getPunto3() {
        return punto3;
    }

    public void setPunto3(Puntos punto3) {
        this.punto3 = punto3;
    }

    public Color getColorDeRelleno() {
        return ColorDeRelleno;
    }

    public void setColorDeRelleno(Color ColorDeRelleno) {
        this.ColorDeRelleno = ColorDeRelleno;
    }

    public Color getColorDeLinea() {
        return ColorDeLinea;
    }

    public void setColorDeLinea(Color ColorDeLinea) {
        this.ColorDeLinea = ColorDeLinea;
    }

    public String getTextura() {
        return textura;
    }

    public void setTextura(String textura) {
        this.textura = textura;
    }

    public void cambiarPuntos() {
        int X1 = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la nueva coordenada X para el punto 1"));
        int Y1 = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la nueva coordenada Y para el punto 1"));
        punto1.setX(X1);
        punto1.setY(Y1);

        int X2 = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la nueva coordenada X para el punto 2"));
        int Y2 = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la nueva coordenada Y para el punto 2"));
        punto2.setX(X2);
        punto2.setY(Y2);

        int X3 = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la nueva coordenada X para el punto 3"));
        int Y3 = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la nueva coordenada Y para el punto 3"));
        punto3.setX(X3);
        punto3.setY(Y3);
    }

    public void cambiarColorDeRelleno() {
        int intensidadRojoRelleno;
        do {
            intensidadRojoRelleno = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la intensidad de relleno de rojo"));
            if (intensidadRojoRelleno < 0 || intensidadRojoRelleno > 255) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor entre 0 y 255");
            } else {
                ColorDeRelleno.setIntensidadDeRojo(intensidadRojoRelleno);
            }
        } while (intensidadRojoRelleno < 0 || intensidadRojoRelleno > 255);

        int intensidadVerdeRelleno;
        do {
            intensidadVerdeRelleno = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la intensidad de relleno de verde"));
            if (intensidadVerdeRelleno < 0 || intensidadVerdeRelleno > 255) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor entre 0 y 255");
            } else {
                ColorDeRelleno.setIntensidadDeVerde(intensidadVerdeRelleno);
            }
        } while (intensidadVerdeRelleno < 0 || intensidadVerdeRelleno > 255);

        int intensidadAzulRelleno;
        do {
            intensidadAzulRelleno = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la intensidad de relleno de azul"));
            if (intensidadAzulRelleno < 0 || intensidadAzulRelleno > 255) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor entre 0 y 255");
            } else {
                ColorDeRelleno.setIntensidadDeAzul(intensidadAzulRelleno);
            }
        } while (intensidadAzulRelleno < 0 || intensidadAzulRelleno > 255);
    }

    public void cambiarColorDeLinea() {
        int intensidadRojoLinea;
        do {
            intensidadRojoLinea = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la intensidad de trazo de rojo"));
            if (intensidadRojoLinea < 0 || intensidadRojoLinea > 255) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor entre 0 y 255");
            } else {
                ColorDeLinea.setIntensidadDeRojo(intensidadRojoLinea);
            }
        } while (intensidadRojoLinea < 0 || intensidadRojoLinea > 255);

        int intensidadVerdeLinea;
        do {
            intensidadVerdeLinea = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la intensidad de trazo de verde"));
            if (intensidadVerdeLinea < 0 || intensidadVerdeLinea > 255) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor entre 0 y 255");
            } else {
                ColorDeLinea.setIntensidadDeVerde(intensidadVerdeLinea);
            }
        } while (intensidadVerdeLinea < 0 || intensidadVerdeLinea > 255);

        int intensidadAzulLinea;
        do {
            intensidadAzulLinea = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la intensidad de trazo de azul"));
            if (intensidadAzulLinea < 0 || intensidadAzulLinea > 255) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor entre 0 y 255");
            } else {
                ColorDeLinea.setIntensidadDeAzul(intensidadAzulLinea);
            }
        } while (intensidadAzulLinea < 0 || intensidadAzulLinea > 255);
    }

    public double distanciaEntrePuntos(Puntos PuntoA, Puntos PuntoB) {
        double distancia = Math.sqrt(Math.pow((PuntoA.getX() - PuntoB.getX()), 2) + Math.pow(PuntoA.getY() - PuntoB.getY(), 2));
        return distancia;
    }

    public double perimetro() {
        double perimetro;
        double distancia1 = distanciaEntrePuntos(punto1, punto2);
        double distancia2 = distanciaEntrePuntos(punto2, punto3);
        double distancia3 = distanciaEntrePuntos(punto1, punto3);
        perimetro = distancia1 + distancia2 + distancia3;
        return perimetro;

    }

    public double semiPerimetro() {
        double s;
        s = (distanciaEntrePuntos(punto1, punto2) + distanciaEntrePuntos(punto2, punto3) + distanciaEntrePuntos(punto1, punto3)) / 2;
        return s;
    }

    public double areaTriangulo() {
        double area;
        double s = semiPerimetro();
        double distancia1 = distanciaEntrePuntos(punto1, punto2);
        double distancia2 = distanciaEntrePuntos(punto2, punto3);
        double distancia3 = distanciaEntrePuntos(punto1, punto3);
        area = Math.sqrt(s * (s - distancia1) * (s - distancia2) * (s - distancia3));
        return area;
    }

    public double alturaTriangulo() {
        double altura;
        double base = distanciaEntrePuntos(punto1, punto2);
        double area = areaTriangulo();
        altura = (2 * area) / base;
        return altura;
    }

    public void textura() {
        String Textura;
        Textura = JOptionPane.showInputDialog(null, "Ingrese la textura que tendrá su triángulo(liso o rugoso)");
        if (Textura.equalsIgnoreCase("liso")) {
            JOptionPane.showMessageDialog(null, "Liso");
        } else {
            if (Textura.equalsIgnoreCase("rugoso")) {
                JOptionPane.showMessageDialog(null, "Rugoso");
            }
        }
    }
}
