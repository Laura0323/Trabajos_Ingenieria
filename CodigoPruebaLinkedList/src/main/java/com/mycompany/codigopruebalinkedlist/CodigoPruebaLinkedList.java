/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.codigopruebalinkedlist;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public class CodigoPruebaLinkedList {

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

    public static void Llenar(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) (Math.random() * 100);
        }
    }

    public static void main(String[] args) {
        LinkedList<Double> T = new LinkedList<>();
        int ini = 100;
        int np = 20;
        int s = 500;

        for (int k = 0; k < np; k++) {
            int N = k * s + ini;
            int[] A = new int[N];
            Llenar(A);
            LinkedList<Integer> L = new LinkedList<>();
            for (int i = 0; i < A.length; i++) {
                L.add(A[i]);
            }
            long t3 = System.nanoTime();
            Ssort(L);
            long t4 = System.nanoTime();
            T.add((t4 - t3) / 1000000.0);
        }
        for (double tiempo : T) {
            System.out.println("Tiempo: " + tiempo + " ms");
        }
    }
}
