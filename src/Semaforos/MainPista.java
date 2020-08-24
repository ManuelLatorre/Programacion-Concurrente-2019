/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semaforos;

/**
 *
 * @author Manuel
 */
public class MainPista {

    public static void main(String[] args) {

        Pista pista = new Pista();
        Avion[] aviones = new Avion[18];
        Thread[] avionesThread = new Thread[18];

        for (int i = 0; i < 18; i++) {
            aviones[i] = new Avion("Avion" + i, pista);
        }
        for (int i = 0; i < 18; i++) {
            avionesThread[i] = new Thread(aviones[i]);
        }

        for (int i = 0; i < 18; i++) {
            avionesThread[i].start();
        }

    }
}
