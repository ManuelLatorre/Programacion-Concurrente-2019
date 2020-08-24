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
public class MainAuto {
    public static void main(String[] args) {
        Auto []autos= new Auto[5];
        Thread []hilos= new Thread[5];
        Surtidor surtidor= new Surtidor(500);
        for (int i = 0; i < 5; i++) {
            autos[i]=new Auto("120"+i,"Modelo","Marca",10000,300,surtidor);
            hilos[i]= new Thread(autos[i]);
            hilos[i].setName("h"+i);
        }
        
        for (int i = 0; i < 5; i++) {
            hilos[i].start();
        }
        
        for (int i = 0; i < 5; i++) {
            try{
                hilos[i].join();
            }catch(InterruptedException e){
            }
        }
        
    }
}
