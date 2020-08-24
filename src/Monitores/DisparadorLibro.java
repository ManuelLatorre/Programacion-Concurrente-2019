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
public class DisparadorLibro {
    public static void main(String[] args) {
        Libro libro=new Libro("Libro", 500);
        
        Escritor[]escritores= new Escritor[2];
        Lector[]lectores= new Lector[5];
        for (int i = 0; i < 2; i++) {
            escritores[i]=new Escritor("Escritor"+i,libro);
        }
        for (int i = 0; i < 5; i++) {
            lectores[i]=new Lector("Lector"+i,libro);
        }
        
        Thread[]escritoresThread=new Thread[2];
        Thread[]lectoresThread=new Thread[5];
        for (int i = 0; i < 2; i++) {
            escritoresThread[i]=new Thread(escritores[i]);
        }
        for (int i = 0; i < 5; i++) {
            lectoresThread[i]= new Thread(lectores[i]);
        }
        
        for (int i = 0; i < 2; i++) {
            escritoresThread[i].start();
        }
        for (int i = 0; i < 5; i++) {
            lectoresThread[i].start();
        }
    }
}
