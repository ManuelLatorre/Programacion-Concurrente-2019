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
public class MainLista {
    public static void main(String[] args) {
        Insertor[]insertores= new Insertor[3];
        Buscador[]buscadores= new Buscador[3];
        Borrador[]borradores= new Borrador[1];
        Thread[]insertoresThread= new Thread[3];
        Thread[]buscadoresThread= new Thread[3];
        Thread[]borradoresThread= new Thread[1];
        Lista lista= new Lista();
        
        for (int i = 0; i < 3; i++) {
            insertores[i]= new Insertor(lista,i);
        }
        
        for (int i = 0; i < 3; i++) {
            buscadores[i]= new Buscador(lista,i);
        }
        
        for (int i = 0; i < 1; i++) {
            borradores[i]= new Borrador(lista,i);
        }
        
        for (int i = 0; i < 3; i++) {
            insertoresThread[i]=new Thread(insertores[i]);
        }
        
        for (int i = 0; i < 3; i++) {
            buscadoresThread[i]= new Thread(buscadores[i]);
        }
        
        for (int i = 0; i < 1; i++) {
            borradoresThread[i]= new Thread(borradores[i]);
        }
        
        for (int i = 0; i < 3; i++) {
            buscadoresThread[i].start();
        }
        
        for (int i = 0; i < 3; i++) {
            insertoresThread[i].start();
        }
        
        
        
        for (int i = 0; i < 1; i++) {
            borradoresThread[i].start();
        }
        
    }
}
