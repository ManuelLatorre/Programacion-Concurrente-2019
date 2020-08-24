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
public class Letras implements Runnable {
    private String nombre;
    
    public Letras(String unNombre){
        this.nombre=unNombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void run(){
        for (int i = 0; i < 10; i++) {
            RecursoLetras.imprimir();
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                
            }
        }
        
    }
}
