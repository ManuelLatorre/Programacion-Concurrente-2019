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
public class MainBarbero {
    public static void main(String[] args) {
        Barberia barberia= new Barberia();
        Barbero barbero= new Barbero(barberia);
        Thread barberoThread= new Thread(barbero);
        
        Cliente[]cliente= new Cliente[10];
        
        for (int i = 0; i < 10; i++) {
            cliente[i]=new Cliente(("Cliente"+i),barberia);
        }
        
        Thread[]clienteThread= new Thread[10];
        
        for (int i = 0; i < 10; i++) {
            clienteThread[i]=new Thread(cliente[i]);
        }
        for (int i = 0; i < 10; i++) {
            clienteThread[i].setName("Cliente"+i);
        }
        
        barberoThread.start();
        for (int i = 0; i < 10; i++) {
            clienteThread[i].start();
        }
        
    }
}
