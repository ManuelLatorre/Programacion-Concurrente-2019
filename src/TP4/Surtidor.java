/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4;

/**
 *
 * @author Manuel
 */
import java.util.concurrent.Semaphore;
public class Surtidor {
    private int cantKmSurte;
    private Semaphore mutex;
    public Surtidor(int unaCantKmSurte){
        mutex=new Semaphore(1);
        this.cantKmSurte=unaCantKmSurte;
    }
    

    public void surtir(Auto auto) throws InterruptedException{
        System.out.println("Entra a cargar patente auto: "+ auto.getPatente());
        
      
        this.mutex.acquire();
        
        auto.setKmReservaCombustible(500);
        System.out.println("Patente auto:"+auto.getPatente()+" km cargados: "+auto.getKmReservaCombustible());
        Thread.sleep(3000);
        this.mutex.release();
        
      
    }
}
