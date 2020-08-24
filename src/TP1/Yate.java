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
public class Yate extends Barco{
    private int potencia;
    private int nroCamarotes;
    
    public Yate (String unaMatricula, double unaEslora, int unAñoFabricacion,int unaPotencia, int cantCamarotes){
        super(unaMatricula, unaEslora, unAñoFabricacion);
        potencia= unaPotencia;
        nroCamarotes= cantCamarotes;
    }
    
    public int getPotencia(){
        return this.potencia;
    }
    
    public int getNroCamarotes(){
        return this.nroCamarotes;
    }
    
        public double calcularModuloEspecial(double moduloNormal){
        double modulo;
        modulo= moduloNormal+ this.potencia+ this.nroCamarotes;
        return modulo;
    }
}
