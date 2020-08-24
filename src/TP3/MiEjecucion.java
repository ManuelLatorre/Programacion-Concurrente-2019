/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3;

/**
 *
 * @author Manuel
 */
public class MiEjecucion implements Runnable{
    public void run(){
        ir();
    }
    
    public void ir(){
        hacerMas();
    }
    public void hacerMas(){
        System.out.println("En la pila");
    }
}
class ThreadTesting{
    public static void main(String[] args) {
        Thread miHilo= new Thread();
        miHilo.start();
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
        }
        System.out.println("En el main");
    }
}