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
public class Cliente implements Runnable {

    private String nombre;
    private Barberia barberia;

    public Cliente(String n, Barberia b) {
        this.nombre = n;
        this.barberia = b;
    }

    public void run() {
        
        this.barberia.entraCliente();
       
        
    }

}
