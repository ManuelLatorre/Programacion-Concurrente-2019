/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semaforos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Manuel
 */
public class Mesa {

    private int cantSillas;
    private int enanosSentados = 0;
    private int enanosPidiendo = 0;
    private Semaphore semSilla;
    private Semaphore semServir;

    public Mesa(int cantSillas) {
        semSilla = new Semaphore(4);
        semServir = new Semaphore(1);
        this.cantSillas = cantSillas;
    }

    public void servir() {
        try {
            semServir.acquire();
            if (enanosPidiendo > 0) {
                enanosPidiendo--;
            }
            semServir.release();
        } catch (InterruptedException e) {
        }

    }

    public void sentarse() {
        try {
            semSilla.acquire();
            enanosSentados++;
        } catch (InterruptedException e) {
        }
    }

    public void pedirComida() {
        try {
            semServir.acquire();
            enanosPidiendo++;
            semServir.release();
        } catch (InterruptedException e) {
        }

    }

    public void comer() { //come y se va
        try {
            this.enanosSentados--;
            semSilla.release();
        } catch (Exception e) {
        }

    }

    public boolean seguirSirviendo() { //Returns en zona critica? como asegurar exclucion con semaforos?
        return (enanosPidiendo > 0);
    }

    public synchronized int enanosPidiendo() {
        return enanosPidiendo;
    }

}
