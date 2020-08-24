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
public class Valor {
    private int VALOR;
    
    public Valor(int unValor){
        this.VALOR=unValor;
    }
    
    public synchronized int getValor(){
        return this.VALOR;
    }

    public synchronized void setValor(int unValor){
        this.VALOR=unValor;
    }
    
    public synchronized void suma(){
        VALOR++;
    }
    
    public synchronized void multiplica(){
        VALOR*=2;
    }
    
    
}
