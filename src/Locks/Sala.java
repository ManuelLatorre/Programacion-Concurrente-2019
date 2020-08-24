/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locks;

import java.util.concurrent.locks.*;

/**
 *
 * @author Manuel
 */
public class Sala {

    private int temperatura;
    private int cantidadPersonas = 0;
    private int tUmbral = 30;
    private int colaJubi = 0;
    private Lock l;
    private Condition esperaPersonas;

    public Sala(int temp) {
        l = new ReentrantLock(true);
        esperaPersonas = l.newCondition();
        this.temperatura = temp;
    }

    public int getTemperatura() {
        return this.temperatura;
    }

    public int getCantidadPersonas() {
        return this.cantidadPersonas;
    }

    public void entraSala() {
        l.lock();
        try {
            while ((temperatura <= tUmbral && cantidadPersonas >= 50) || (temperatura > tUmbral && cantidadPersonas >= 35) || colaJubi > 0) {
                esperaPersonas.await();
            }
            cantidadPersonas++;
        } catch (InterruptedException e) {
        } finally {
            l.unlock();
        }
    }

    public void entraSalaJubilado() {
        l.lock();
        colaJubi++;
        try {
            while ((temperatura <= tUmbral && cantidadPersonas >= 50) || (temperatura > tUmbral && cantidadPersonas >= 35)) {
                esperaPersonas.await();
            }
            colaJubi--;
            cantidadPersonas++;
        } catch (InterruptedException e) {
        } finally {
            l.unlock();
        }
    }

    public void salirSala() {
        l.lock();
        try{
        cantidadPersonas--;
        esperaPersonas.signal();
        }catch(Exception e){         
        }finally{
            l.unlock();
        }
    }

    public void notificarTemperaturaSala(int t) {
        l.lock();
        try{
        temperatura = t;
        }catch(Exception e){
        }finally{
            l.unlock();
        }
    }

}
