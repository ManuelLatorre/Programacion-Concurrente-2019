/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.*;

/**
 *
 * @author Manuel
 */
public class SalaImpresion {

    private final int numA;
    private final int numB;
    private int imprimiendoA = 0;
    private int imprimiendoB = 0;
    private static Lock l;
    private static Condition esperaA;
    private static Condition esperaB;
    private static Condition esperaC;

    public SalaImpresion(int cantImpresorasA, int cantImpresorasB) {
        numA = cantImpresorasA;
        numB = cantImpresorasB;
        l = new ReentrantLock(true);
        esperaA = l.newCondition();
        esperaB = l.newCondition();
        esperaC = l.newCondition();

    }

    public void imprimirA() {
        l.lock();
        try {
            while (imprimiendoA >= numA) {
                esperaA.await();
            }
            imprimiendoA++;
        } catch (InterruptedException e) {
        } finally {
            l.unlock();
        }
    }

    public void imprimirB() {
        l.lock();
        try {
            while (imprimiendoB >= numB) {
                esperaB.await();
            }
            imprimiendoB++;
        } catch (InterruptedException e) {
        } finally {
            l.unlock();
        }
    }

    public void imprimirC(UsuarioImpresora usuario) {
        l.lock();
        try {
            while (imprimiendoA >= numA && imprimiendoB >= numB) { //si todas las impresoras estan ocupadas espera
                esperaC.await();
            }
            if (imprimiendoA < numA) { //si hay alguna impresora tipo A imprime en esa
                imprimiendoA++;
                usuario.setTipoImp('A'); //Modifica el tipo de impresion por la de la impresora donde se realiza para poder terminar
            } else {
                if (imprimiendoB < numB) { //si no hay impresoras tipo A pero si tipo B imprime en esa
                    imprimiendoB++;
                    usuario.setTipoImp('B');
                }
            }
        } catch (InterruptedException e) {
        } finally {
            l.unlock();
        }
    }

    public void terminaImprimirA() {
        l.lock();
        try {
            imprimiendoA--;
            esperaA.signalAll();
            esperaC.signalAll();
        } catch (Exception e) {
        } finally {
            l.unlock();
        }
    }

    public void terminaImprimirB() {
        l.lock();
        try {
            imprimiendoB--;
            esperaB.signalAll();
            esperaC.signalAll();
        } catch (Exception e) {
        }finally{
            l.unlock();
        }
    }
    
    public void terminaImprimirC(char tipo){
        l.lock();
        try{
        if(tipo=='A'){
            this.terminaImprimirA();
        }else{
            if(tipo=='B'){
                this.terminaImprimirB();
            }
        }
        } catch(Exception e){
        }finally{
            l.unlock();
        }
               
                
                
                
    }
    
   
}
