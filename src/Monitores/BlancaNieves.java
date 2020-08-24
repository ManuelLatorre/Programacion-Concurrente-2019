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
public class BlancaNieves implements Runnable {

    private String nombre = "Blanca Niveves";
    private Mesa mesa;
    private boolean seguirSirviendo = true;

    public BlancaNieves(Mesa m) {
        this.mesa = m;
    }

    public void run() {
        while (true) {
            System.out.println("BLANCA NIEVES ESTA EN CASA");
            while (mesa.seguirSirviendo()) {
                mesa.servir();
                System.out.println("Blanca nieves le sirvio a un enano");
            }
            pasear();
        }
    }
    
    public void pasear(){
        try{
            System.out.println("BLANCA NIEVES ESTA PASEANDO");
            Thread.sleep(20000);
        }catch(InterruptedException e){
        }
    }
}
