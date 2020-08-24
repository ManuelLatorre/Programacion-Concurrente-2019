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
public class MainSala {
    public static void main(String[] args) {
        Hebra[]personas=new Hebra[50];
        Sala sala=new Sala(15);
        Hebra hebraTemp= new Hebra("hebraTemp",sala);
        
        for (int i = 0; i < 47; i++) { //creo 47 personas que no son jubilados
            personas[i]=new Hebra(""+i,sala);
        }
        for (int i = 47; i < 50; i++) { //creo 3 jubilados
            personas[i]=new Hebra(""+i,true,sala);
        }
        
        Thread [] personasThread=new Thread[50];
        for (int i = 0; i < 50; i++) {
            personasThread[i]=new Thread(personas[i]);
        }
        
        for (int i = 0; i < 50; i++) {
            personasThread[i].start();
        }
        Thread hebraTempThread= new Thread(hebraTemp);
        hebraTempThread.start();
    }
}
