/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;

/**
 *
 * @author Manuel
 */
public class Velero extends Barco{
    private int nroMastiles;
    
    
     public Velero (String unaMatricula, double unaEslora, int unAñoFabricacion,int unNroMastiles){
        super(unaMatricula, unaEslora, unAñoFabricacion);
        nroMastiles= unNroMastiles;
    }
    public int getNroMastiles(){
        return this.nroMastiles;
    }
    
    public double calcularModuloEspecial(double moduloNormal){
        double modulo;
        modulo= moduloNormal+ this.nroMastiles;
        return modulo;
    }
}
