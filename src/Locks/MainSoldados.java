/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locks;

/**
 *
 * @author Manuel
 */
public class MainSoldados {
    public static void main(String[] args) {
        Comedor comedor= new Comedor();
        Soldado[]soldados= new Soldado[100];
        
        for (int i = 0; i < 25; i++) {
            soldados[i]= new Soldado("Soldado"+(i+1),comedor,true,true);
        }
        for (int i = 25; i < 50; i++) {
            soldados[i]= new Soldado("Soldado"+(i+1),comedor,true,false);
        }
        for (int i = 50; i < 75; i++) {
            soldados[i]= new Soldado("Soldado"+(i+1),comedor,false,true);
        }
        for (int i = 75; i < 100; i++) {
            soldados[i]= new Soldado("Soldado"+(i+1),comedor,false,false);
        }
        
        Thread[]soldadosThread= new Thread[100];
        
        for (int i = 0; i < 100; i++) {
            soldadosThread[i]= new Thread(soldados[i]);
        }
        for (int i = 0; i < 100; i++) {
            soldadosThread[i].start();
        }
    }
}
