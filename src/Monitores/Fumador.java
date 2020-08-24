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
public class Fumador implements Runnable {

    private SalaFumadores sala;
    private int id;

    public Fumador(int id, SalaFumadores sala) {
        this.sala = sala;
        this.id = id;
    }

    public void run() {
        while (true) {
            try {
                sala.entraFumar(id);
                System.out.println("Fumador " + id + " esta fumando");
                Thread.sleep(1000);
                sala.terminaFumar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
