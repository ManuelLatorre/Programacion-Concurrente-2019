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
public class Deportiva extends Barco{
    private int potencia;
    

    public Deportiva (String unaMatricula, double unaEslora, int unAñoFabricacion,int unaPotencia){
        super(unaMatricula, unaEslora, unAñoFabricacion);
        potencia= unaPotencia;
    }
    public int getPotencia(){
        return this.potencia;
    }
    
        public double calcularModuloEspecial(double moduloNormal){
        double modulo;
        modulo= moduloNormal+ this.potencia;
        return modulo;
    }
}
