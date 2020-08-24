/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO2;

/**
 *
 * @author Manuel
 */
import java.util.concurrent.Semaphore;
public class Tenedor {
    private String nombre;
    private Semaphore mutex;
    public Tenedor(String unNombre){
        mutex =new Semaphore(1);
        nombre=unNombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    
    
    public void ocupaTenedor(){
        try{
            this.mutex.acquire();
        }catch(InterruptedException e){
        }
    }
    
    public void liberaTenedor(){
            this.mutex.release();
    }
}
