/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3;

/**
 *
 * @author Manuel
 */
public class MainThread extends Thread{
    public static void main(String[] args) {
        ClienteP6 cliente1=new ClienteP6("Cliente1",new int[]{2,2,1,5,2,3});
        ClienteP6 cliente2=new ClienteP6("Cliente2",new int[]{1,3,5,1,1});
        
        long initialTime= System.currentTimeMillis();
        CajeraThread cajera1= new CajeraThread("Cajera1",cliente1,initialTime);
        CajeraThread cajera2= new CajeraThread("Cajera2",cliente2,initialTime);
        
        Thread cajera1Thread=new Thread(cajera1);
        Thread cajera2Thread=new Thread(cajera2);
        //Tiempo inicial de referencia
        cajera1Thread.start();
        cajera2Thread.start();
    }
}
