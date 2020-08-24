/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monitores;

/**
 *
 * @author Manuel
 */
public class SalaFumadores {

    private static boolean alguienFumando = false;
    private static int ingredienteNoEsta = 0;//Con 0 indico que no hay ingredientes en la mesa

    public synchronized void entraFumar(int id) {
        while (ingredienteNoEsta != id || alguienFumando) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        ingredienteNoEsta = 0;//use los ingredientes de la mesa por lo que la mesa esta vacia
        alguienFumando = true;

    }

    public synchronized void terminaFumar() {
        alguienFumando = false;
        notifyAll();
    }

    public synchronized void colocar(int ingrediente) {

        while (ingredienteNoEsta != 0 || alguienFumando) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        ingredienteNoEsta = ingrediente;
        notifyAll();

    }
}
