/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semaforos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel
 */
public class Empleado implements Runnable{
    private MesaMirta mesa;
    private int nEmpleado;
    
    public Empleado(MesaMirta m){
        this.mesa=m;
    }
    
    public void run(){
        while(true){
            try {
                mesa.servir();
            } catch (InterruptedException ex) {
                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
       
    }
}
