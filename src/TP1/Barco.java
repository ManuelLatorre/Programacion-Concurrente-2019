/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;

import java.util.Date;

/**
 *
 * @author Manuel
 */
public class Barco {
    private String matricula;
    private double eslora;
    private int a�oFabricacion;
    
    public Barco(String unaMatricula, double unaEslora, int unA�oFabricacion){
        matricula= unaMatricula;
        eslora= unaEslora;
        a�oFabricacion=unA�oFabricacion;
    }
    
    public double getEslora(){
        return this.eslora;
    }
        public double calcularModuloEspecial(double moduloNormal){
        return moduloNormal;
    }
    

}
