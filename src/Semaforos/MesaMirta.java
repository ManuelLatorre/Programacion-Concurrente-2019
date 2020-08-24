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
public class MesaMirta {

    private int numInvitados;
    private Semaphore semServir;
    private int nInvitadosSentados = 0;
    private boolean mirtaPregunta;
    private boolean mirtaSentada;
    private boolean mirtaSeLevanto;
    private int pidiendo=0;

    public MesaMirta(int nI) {
        this.numInvitados = nI;
        this.mirtaSentada=false;
        this.mirtaPregunta=false;
        this.mirtaSeLevanto=false;
        semServir = new Semaphore((numInvitados - 1));
    }

    public void servir() throws InterruptedException {
        if(pidiendo>0){
        System.out.println("Un empleado esta sirviendo comida");
        pidiendo--;
        Thread.sleep(2000);
        semServir.release();
        }
    }

    public void sentarseInvitado() throws InterruptedException { //inn
        System.out.println("UN INVITADO SE A SENTADO");
        nInvitadosSentados++;
        Thread.sleep(2000);
    }

    public void servirse() throws InterruptedException {
        semServir.acquire();
        pidiendo++;
        System.out.println("ALGUIEN PIDE QUE LE SIRVAN COMIDA");
        
    }

    public void comer() throws InterruptedException {
        System.out.println("ALGUIEN ESTA COMIENDO");
        Thread.sleep(2000);
    }

    public void responder() throws InterruptedException {
        if (mirtaPregunta) {
            System.out.println("UN INVITADO RESPONDE A MIRTA");
            Thread.sleep(2000);
            mirtaPregunta = false;
        }
    }

    public void levantarseInvitado() throws InterruptedException {
        if (mirtaSeLevanto) {
            System.out.println("UN INVITADO SE LEVANTA");
            Thread.sleep(2000);
        }

    }

    public void sentarseMirta() {
        System.out.println("MIRTA SE A SENTADO");
        mirtaSentada = true;
    }
    
    public void enojarse(){
        System.out.println("MIRTA SE ENOJO Y SE LEVANTO");
        mirtaSeLevanto= true;
        mirtaSentada= false;
    }
    
    public void lanzarPregunta(){
        System.out.println("MIRTA REALIZO UNA PREGUNTA");
        this.mirtaPregunta=true;
    }
}
