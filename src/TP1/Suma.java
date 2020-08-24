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
public class Suma {
    private double valor1;
    private double valor2;
    private double resultado;
    
    public void cargar1(double primerValor){
        valor1= primerValor;
    }
    
    public void cargar2(double segundoValor){
        valor2= segundoValor;
    }
    
    public void operar(){
        resultado= valor1+valor2;
    }
}
