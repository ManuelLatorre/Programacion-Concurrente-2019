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
public class Mesa {

    private int cantSillas;
    private int enanosSentados = 0;
    private int enanosPidiendo=0;

    public Mesa(int cantSillas) {
        this.cantSillas=cantSillas;
    }

    public synchronized void servir() {
       if(enanosPidiendo>0){
           enanosPidiendo--;
       }
    }

    public synchronized void sentarse() {
        try{
            while(enanosSentados==cantSillas){
                wait();
            }
            enanosSentados++;
        }catch(InterruptedException e){
        }
    }
    
    public synchronized void pedirComida(){
        enanosPidiendo++;
    }

    public synchronized void comer() { //come y se va
            this.enanosSentados--;
            notify();    
    }

    public synchronized boolean seguirSirviendo() {
        return (enanosPidiendo>0);
    }
    
    public synchronized int enanosPidiendo(){
        return enanosPidiendo;
    }
    
}
