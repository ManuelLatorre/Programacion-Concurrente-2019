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
public class Borrador implements Runnable{
    private int id;
    private Lista lista;
    
    public Borrador(Lista list, int i){
        this.id=i;
        this.lista=list;    
    }
    
    public void run(){
        lista.borrar(id);
    }
}
