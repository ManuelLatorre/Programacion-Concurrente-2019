/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semaforos;



/**
 *
 * @author Manuel
 */
public class Soldado implements Runnable {

    private String nombre;
    private Comedor comedor;
    private boolean quiereBotella;
    private boolean quierePostre;

    public Soldado(String n, Comedor c, boolean qb, boolean qp) {
        this.nombre = n;
        this.comedor = c;
        this.quiereBotella = qb;
        this.quierePostre = qp;
    }

    public void run() {
        comedor.agarraBandeja();
        try {
            System.out.println("El " + this.nombre + " esta agarrando una bandeja");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        }

        comedor.dejarMostBand();
        
        if (quiereBotella) {
            comedor.agarraAbridor();
            try {
                System.out.println("El " + this.nombre + " esta destapando una botella");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
            }
            comedor.destaparBotella();
        }
        
        if(quierePostre){
            comedor.agarraPostre();
            try {
                System.out.println("El " + this.nombre + " esta agarrando postre");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
            }
            comedor.dejarMostPostre();
        }
    }

}
