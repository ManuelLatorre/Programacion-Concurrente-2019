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
public class TesteoRecurso {
    public static void main(String[] args) {
        Cliente juan=new Cliente();
        Cliente ines= new Cliente();
        Thread juanThread=new Thread(juan);
        Thread inesThread=new Thread(ines);
        juanThread.setName("juan");
        inesThread.setName("ines");
        juanThread.start();
        inesThread.start();
      
    }
}
