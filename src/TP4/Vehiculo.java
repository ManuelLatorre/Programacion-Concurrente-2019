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
public class Vehiculo {
    private String patente;
    private String modelo;
    private String marca;
    private int kmFaltantesService;
    
    public Vehiculo(String unaPatente, String unModelo, String unaMarca, int cantKmFaltantesService){
        this.patente=unaPatente;
        this.modelo= unModelo;
        this.marca= unaMarca;
        this.kmFaltantesService= cantKmFaltantesService;
    }
    
    public String getPatente(){
        return this.patente;
    }
    
    public String getModelo(){
        return this.modelo;
    }
    
    public String getMarca(){
        return this.marca;
    }
    
    public int getKmFaltantesService(){
        return this.kmFaltantesService;
    }
}
