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
public class Persona implements Runnable{
    private String nombre;
    private Centro centro;
    private boolean tieneRev=false;
    private boolean tieneSilla=false;
    
    public Persona(String n,Centro c){
        this.nombre=n;
        this.centro=c;
    }
    public void run(){
        this.centro.entrarCentro(this);
        this.centro.agarrarRevista(this);
        this.centro.esperarCamilla(this);
    }
    
    public void setTieneRev(boolean t){
        this.tieneRev=t;
    }
    public void setTieneSilla(boolean t){
        this.tieneSilla=t;
    }
    
    public boolean getTieneRev(){
        return this.tieneRev;
    }
    
    public boolean getTieneSilla(boolean t){
        return this.tieneSilla;
    }
    public String getNombre(){
        return this.nombre;
    }
}
