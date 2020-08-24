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
public class MainBlancaNieves {
    public static void main(String[] args) throws InterruptedException {
        Enano[]enanos= new Enano[7];
        Mesa mesa= new Mesa(4);
        BlancaNieves blancaNieves=new BlancaNieves(mesa);
       
        for (int i = 0; i < 7; i++) {
            enanos[i]=new Enano("Enano"+(i+1),mesa);
        }
        
        Thread[]enanosThread= new Thread[7];
        
        for (int i = 0; i < 7; i++) {
            enanosThread[i]=new Thread(enanos[i]);
        }
        
        Thread blancaNievesThread= new Thread(blancaNieves);
        blancaNievesThread.start();
        for (int i = 0; i < 7; i++) {
            enanosThread[i].start();
    
            Thread.sleep(1000);
            
        }
        
        
    }
}
