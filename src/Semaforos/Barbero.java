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
public class Barbero implements Runnable {

    private String nombre = "Barbero";
    private Barberia barberia;

    public Barbero(Barberia b) {
        this.barberia = b;
    }

    public void run() {
        while (true) {
            this.barberia.atenderClientes();
        }
    }
}
