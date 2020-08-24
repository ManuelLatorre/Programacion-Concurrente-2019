/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semaforos;

import java.util.concurrent.Semaphore;


/**
 *
 * @author Manuel
 */
public class Comedor {

    private int mostradorBandejas = 5;
    private int abridores = 10;
    private int mostPostre = 3;
    private Semaphore esperaBandeja;
    private Semaphore esperaAbridor;
    private Semaphore esperaPostre;

    public Comedor() {
        this.esperaBandeja= new Semaphore(5);
        this.esperaAbridor= new Semaphore(10);
        this.esperaPostre= new Semaphore(3);
            
    }

    public void agarraBandeja() {
       try{
           esperaBandeja.acquire();
       }catch(InterruptedException e){
       }
    }

    public void agarraAbridor() {
        try{
           esperaAbridor.acquire();
       }catch(InterruptedException e){
       }
    }

    public void agarraPostre() {
       try{
           esperaPostre.acquire();//Agarra un postre
       }catch(Exception e){
       }
    }

    public void dejarMostBand() {
        try{
           esperaBandeja.release();
       }catch(Exception e){
       }
    }

    public void destaparBotella() {
        try{
            esperaAbridor.release(); 
       }catch(Exception e){
       }
    }

    public void dejarMostPostre() {
        try{
           esperaPostre.release();
       }catch(Exception e){
       }
    }
}
