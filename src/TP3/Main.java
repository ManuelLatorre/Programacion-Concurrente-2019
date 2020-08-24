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
public class Main {
    public static void main(String[] args) {
        ClienteP6 cliente1=new ClienteP6("Cliente1",new int[]{2,2,1,5,2,3});
        ClienteP6 cliente2=new ClienteP6("Cliente2",new int[]{1,3,5,1,1});
        Cajera cajera1= new Cajera("Cajera1");
        //Tiempo inicial de referencia
        long initialTime= System.currentTimeMillis();
        cajera1.procesarCompra(cliente1, initialTime);
        cajera1.procesarCompra(cliente2, initialTime);
        
    }
}
