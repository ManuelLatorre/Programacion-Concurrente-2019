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
public class Buscador implements Runnable{
    private int id;
    private Lista lista;
    
    public Buscador(Lista list, int i){
        this.id=i;
        this.lista=list;
        
    }
    
    public void run(){
        while(true){
            lista.buscar(id);
        }
        
    }
}
