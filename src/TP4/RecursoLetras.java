/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4;

/**
 *
 * @author Manuel
 */
public class RecursoLetras {

    static char turno = 'A';

    static synchronized void imprimir() {
        if (turno == 'A' && Thread.currentThread().getName().equals("A")) {
            for (int i = 0; i < 1; i++) {
                System.out.print(Thread.currentThread().getName());
            }
            turno = 'B';
        }
        if (turno == 'B' && Thread.currentThread().getName().equals("B")) {
            for (int i = 0; i < 2; i++) {
                System.out.print(Thread.currentThread().getName());
            }
            turno = 'C';
        }
        if (turno == 'C' && Thread.currentThread().getName().equals("C")) {
            for (int i = 0; i < 3; i++) {
                System.out.print(Thread.currentThread().getName());
            }
            turno = 'A';
        }
    }
}
