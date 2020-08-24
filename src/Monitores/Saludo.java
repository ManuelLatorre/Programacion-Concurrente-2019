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
public class Saludo {
    private boolean jefeSaludo=false;//agrego una variable para verificar si los debe esperar o si pueden ser liberado en caso de recibir notify
    
    synchronized void esperaJefe(String empleado){
        try{
            while(!jefeSaludo){ //agregue la condicion en el while
            wait();
            }
            System.out.println(empleado+"> Buenos dias jefe!");
        }catch(InterruptedException e){
            System.out.println(e.toString());
        }
    }
    
    synchronized void saludoJefe(){
        System.out.println("JEFE> Buenos dias!");
        jefeSaludo=true;
        notifyAll();//cambie a notifyAll porque si no se liberaria un solo empleado y solo saludaria uno
    }
}
