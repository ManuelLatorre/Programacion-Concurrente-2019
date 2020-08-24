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
public class testPunto2 {
    public static void main(String[] args) {
        Letras A= new Letras("A");
        Letras B= new Letras("B");
        Letras C= new Letras("C");
        Thread Athread= new Thread(A);
        Thread Bthread= new Thread(B);
        Thread Cthread= new Thread(C);
        Athread.setName("A");
        Bthread.setName("B");
        Cthread.setName("C");
        
        Athread.start();
        Bthread.start();
        Cthread.start();
        
    }
}
