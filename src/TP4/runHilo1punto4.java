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
public class runHilo1punto4 implements Runnable{
    private Valor TOTAL;

    public runHilo1punto4(Valor unValor) {
        TOTAL = unValor;
    }

    public void run() {
        this.TOTAL.suma();
    }
    
}
