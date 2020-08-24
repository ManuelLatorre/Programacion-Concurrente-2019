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
public class Avion implements Runnable{
    private String nombre;
    private Pista pista;
    
    public Avion(String n, Pista p){
        this.nombre=n;
        this.pista=p;
    }
    
    public void run(){
        try{
        this.pista.aterrizar();
        Thread.sleep(20000);
        this.pista.despegar();
        }catch(InterruptedException e){
            
        }
    }
}
