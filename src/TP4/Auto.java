/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel
 */
public class Auto extends Vehiculo implements Runnable{
    private int kmReservaCombustible;
    private Surtidor surtidor;
    
    public Auto(String unaPatente, String unModelo, String unaMarca, int cantKmFaltantesService, int cantKmReservaCombustible,Surtidor unSurtidor) {
        super(unaPatente, unModelo, unaMarca, cantKmFaltantesService);
        this.kmReservaCombustible= cantKmReservaCombustible;
        this.surtidor=unSurtidor;
    }
    
    public String toString(){
        String cadena;
        cadena= "Patente: "+this.getPatente()+" Modelo: "+this.getModelo()+" Marca: "+this.getMarca()+" cantKmFaltantesService: "+this.getKmFaltantesService()+" CantKmReservaCombustible: "+this.kmReservaCombustible;
        return cadena;
    }
    
    public void run(){
        while(this.kmReservaCombustible!=0) {
            this.recorrerKm();
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
            }
            try {
                this.surtidor.surtir(this);
            } catch (InterruptedException ex) {
                Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void recorrerKm(){
        while(kmReservaCombustible>0){
            kmReservaCombustible=kmReservaCombustible-100;
            System.out.println("Hilo: "+Thread.currentThread().getName()+" km de reserva: "+this.kmReservaCombustible);
        }
    }
    
    public void setKmReservaCombustible(int unaCant){
        this.kmReservaCombustible=unaCant;
    }
    
    public int getKmReservaCombustible(){
        return this.kmReservaCombustible;
    }
    

    
    
}
