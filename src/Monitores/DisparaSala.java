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
public class DisparaSala {
    public static void main(String[] args) {
        SalaFumadores sala= new SalaFumadores();
        Fumador []fumadores= new Fumador[4];
        
        
        for (int i = 1; i < 4; i++) {
            fumadores[i]= new Fumador(i,sala);
        }
        Agente ag= new Agente(sala);
        
        
        Thread []fumadoresThread= new Thread[4];
        for (int i = 1; i < 4; i++) {
            fumadoresThread[i]= new Thread(fumadores[i]);
        }
        Thread agente= new Thread(ag);
        
        agente.start();
        for (int i = 1; i < 4; i++) {
            fumadoresThread[i].start();
        }
        
        
    }
}
