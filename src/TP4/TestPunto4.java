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
public class TestPunto4 {
    public static void main(String[] args) {
        Valor valorInicial= new Valor(3);
        runHilo1punto4 p1 = new runHilo1punto4(valorInicial);
        runHilo2punto4 p2= new runHilo2punto4(valorInicial);
        Thread h1= new Thread (p1);
        Thread h2= new Thread (p2);
        h1.setName("h1");
        h2.setName("h2");
        
        h1.start();
        h2.start();
        
        
        try{
            h1.join();
            h2.join();
        }catch(InterruptedException e){
        }
        
        System.out.println("En main "+valorInicial.getValor());
    }
        
    
}
