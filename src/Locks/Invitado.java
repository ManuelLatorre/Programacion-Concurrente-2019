/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locks;

import Semaforos.*;

/**
 *
 * @author Manuel
 */
public class Invitado implements Runnable{
    private MesaMirta mesa;
    private int nInvitado;
    
    public Invitado(MesaMirta m, int nI){
        this.mesa=m;
        this.nInvitado=nI;
    }
  
    public void run(){
        try{
        this.mesa.sentarseInvitado();
        this.mesa.servirse();
        this.mesa.comer();
        this.mesa.responder();
        this.mesa.levantarseInvitado();
        }catch(InterruptedException e){
        }
    }
}
