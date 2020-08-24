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
public class Pista {

    private Semaphore mutex;
    private Semaphore semPista;
    private Semaphore semDespegue;
    private int esperaAterrizar = 0;

    public Pista() {
        this.mutex = new Semaphore(1, true);
        this.semPista = new Semaphore(1, true);
        this.semDespegue= new Semaphore(0,true);
    }

    public void aterrizar() {
        try {
            if (!semPista.tryAcquire()) {
                System.out.println("LA PISTA ESTA OCUPADA UN AVION ESPERA ATERRIZAR");
                mutex.acquire();
                esperaAterrizar++;
                mutex.release();
                semPista.acquire();
            }
            System.out.println("Un avion aterriza");
            Thread.sleep(2000);
            mutex.acquire();
            esperaAterrizar--;
            mutex.release();
            semPista.release();
        } catch (InterruptedException e) {

        }
    }
    
    public void despegar(){
        try{
        mutex.acquire();
        while(esperaAterrizar>0){
            System.out.println("HAY AVIONES ESPERANDO ATERRIZAR ESTE ESPERA"+this.esperaAterrizar);
        }
        mutex.release();
        
        

        if(!semPista.tryAcquire()){
         System.out.println("Un avion esta utilizando la pista para despegar, el actual espera");
            semPista.acquire();
        }
            System.out.println("el avion despega");
            Thread.sleep(5000);
            semPista.release();
        }catch(InterruptedException e){
            
        }
    }
}
