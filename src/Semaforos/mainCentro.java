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
public class mainCentro {
    public static void main(String[] args) {
        Persona[]personas=new Persona[100];
        Centro centro= new Centro();
        Enfermero enfermero= new Enfermero(centro);
        Thread enfermeroThread= new Thread(enfermero);
        
        Thread []personasThread=new Thread[100];
        for (int i = 0; i < 100; i++) {
            personas[i]=new Persona("Persona"+i,centro);
        }
        for (int i = 0; i < 100; i++) {
            personasThread[i]= new Thread(personas[i]);
        }
        enfermeroThread.start();
        for (int i = 0; i < 100; i++) {
            personasThread[i].start();
        }
    }
}
