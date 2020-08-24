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
public class Enano implements Runnable{
    private String nombre;
    private Mesa mesa;
    
    public Enano(String n, Mesa m){
        this.nombre=n;
        this.mesa=m;
    }
    
    public void run(){
        //while(true){
            mesa.sentarse();
            System.out.println("El "+this.nombre+" se a sentado");
            mesa.pedirComida();
            System.out.println("El "+this.nombre+" le pide comida a Blancanieves"+mesa.enanosPidiendo());
            try{
                Thread.sleep(10000);
            }catch(InterruptedException e){
                
            }
            mesa.comer();
            trabajar();
        //}
    }
    
    public void trabajar(){
        try{
            System.out.println(this.nombre+" se fue a trabajar");
            Thread.sleep(10000);
        }catch(InterruptedException e){
        }
    }
    
}
