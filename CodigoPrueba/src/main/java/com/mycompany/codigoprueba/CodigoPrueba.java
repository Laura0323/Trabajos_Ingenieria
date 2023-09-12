/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.codigoprueba;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author user
 */
public class CodigoPrueba {

    public static void Ssort(LinkedList<Integer> list) {
        int n = list.size(); 
        for (int i = 0; i < n - 1; i++) { 
            int min_idx = i; 

            for (int j = i + 1; j < n; j++) {  
                if (list.get(j) < list.get(min_idx)) { 
                    min_idx = j; 
                }
            }

            int temp = list.get(min_idx); 
            list.set(min_idx, list.get(i));
            list.set(i, temp);
        }
    }

    public static void Llenar(LinkedList<Integer> A, int size) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            A.add(rand.nextInt(1000)); // llenando aleatoriamente
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> A;
        LinkedList<Double> T = new LinkedList<>();
        int ini = 100;  // mínimo número de puntos de prueba
        int np = 50;    // cuantas pruebas
        int s = 100;    // salto (incremento de entrada)

        for (int k = 0; k < np; k++) {
            int N = k * s + ini;    // tamaño de entrada
            A = new LinkedList<>(); // dando tamaño
            Llenar(A, N);           // método de llenado aleatorio con tamaño N
            long t1 = System.nanoTime();
            Ssort(A);                // ordenar lista aleatoria A
            long t2 = System.nanoTime();
            double tiempo = (t2 - t1) / 1000000.0; // tiempo en milisegundos
            T.add(tiempo);          // lista de tiempos
            System.out.println("Tamaño de la lista: " + N + ", Tiempo de ejecución: " + tiempo + " ms");
        }
    }
}

