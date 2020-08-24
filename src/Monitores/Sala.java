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
public class Sala {

    private int temperatura;
    private int cantidadPersonas = 0;
    private int tUmbral = 30;
    private int colaJubi = 0;


    public Sala(int temp) {
        this.temperatura = temp;
    }
    
    public int getTemperatura(){
        return this.temperatura;
    }
    
    public int getCantidadPersonas(){
        return this.cantidadPersonas;
    }
    
    public synchronized void entraSala() {
        while ((temperatura <= tUmbral && cantidadPersonas >= 50) || (temperatura > tUmbral && cantidadPersonas >= 35) || colaJubi > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        cantidadPersonas++;
    }

    public synchronized void entraSalaJubilado() {
        colaJubi++;
        while ((temperatura <= tUmbral && cantidadPersonas >= 50) || (temperatura > tUmbral && cantidadPersonas >= 35)) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        colaJubi--;
        cantidadPersonas++;
    }

    public synchronized void salirSala() {
        cantidadPersonas--;
        notifyAll();
    }

    public synchronized void notificarTemperaturaSala(int t) {
        temperatura = t;
    }

}
