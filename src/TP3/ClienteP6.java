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
public class ClienteP6 {
    private String nombre; 
    private int[]carroCompra;
    
    public ClienteP6(String unNombre, int[] unCarro){
        this.nombre=unNombre;
        this.carroCompra= unCarro;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int[] getCarroCompra(){
        return this.carroCompra;
    }
}
