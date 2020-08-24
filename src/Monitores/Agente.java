/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monitores;

import java.util.Random;

/**
 *
 * @author Manuel
 */
public class Agente implements Runnable{
    public SalaFumadores sala;
    private Random r;
    
    public Agente(SalaFumadores sala){
        this.sala=sala;
        this.r= new Random();
    }
    
    public void run(){
        while(true){
            sala.colocar(r.nextInt(3)+1);
        }
    }
}
