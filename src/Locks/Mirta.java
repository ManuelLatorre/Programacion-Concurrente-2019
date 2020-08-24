/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locks;


/**
 *
 * @author Manuel
 */
public class Mirta implements Runnable{
    private MesaMirta mesa;
    
    public Mirta(MesaMirta m){
        this.mesa=m;
    }
    
    public void run(){
        try{
            this.mesa.sentarseMirta();
            this.mesa.servirse();
            this.mesa.comer();
            this.mesa.lanzarPregunta();
            this.mesa.enojarse();
        }catch(InterruptedException e){
        }
    }
}
