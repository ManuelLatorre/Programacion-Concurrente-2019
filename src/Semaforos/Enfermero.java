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
public class Enfermero implements Runnable{
    private Centro centro;
    
    public Enfermero(Centro c){
        this.centro=c;
    }
    public void run(){
        while(true){
            this.centro.atenderPaciente();
        }
    }
}
