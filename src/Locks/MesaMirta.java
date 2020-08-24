/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locks;

import java.util.concurrent.locks.*;

/**
 *
 * @author Manuel
 */
public class MesaMirta {

    private int numInvitados;
    private int nInvitadosSentados = 0;
    private boolean mirtaPregunta;
    private boolean mirtaSentada;
    private boolean mirtaSeLevanto;
    private int pidiendo = 0;
    private Lock l;
    private Condition esperaSentarseMirta;
    private Condition esperaServirse;
    private Condition esperaLevantarse;
    public MesaMirta(int nI) {
        this.numInvitados = nI;
        this.mirtaSentada = false;
        this.mirtaPregunta = false;
        this.mirtaSeLevanto = false;
        l = new ReentrantLock();
        esperaSentarseMirta = l.newCondition();
        esperaServirse= l.newCondition();
        esperaLevantarse= l.newCondition();

    }

    public void servir() throws InterruptedException {
        try {
            l.lock();
            if(pidiendo>0){
                System.out.println("UN EMPLEADO LE SIRVIO A UN INVITADO");
                pidiendo--;
            }
        } catch (Exception e) {
        } finally {
            l.unlock();
        }
    }

    public synchronized void sentarseInvitado() {
        try {
            l.lock();
            System.out.println("UN INVITADO SE A SENTADO");
            nInvitadosSentados++;
        } catch (Exception e) {
        } finally {
            l.unlock();
        }

    }

    public synchronized void servirse() throws InterruptedException {
        try {
            l.lock();
            while(nInvitadosSentados<numInvitados || pidiendo==(nInvitadosSentados-1) || !mirtaSentada){
                this.esperaServirse.await();
            }
            System.out.println("UN INVITADO PIDE QUE LE SIRVAN");
            pidiendo++;
        } catch (InterruptedException e) {
        } finally {
            l.unlock();
        }
    }

    public synchronized void comer() throws InterruptedException {
        try {
            l.lock();
            System.out.println("ALGUIEN TERMINO DE COMER");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        } finally {
            l.unlock();
        }
    }

    public synchronized void responder() throws InterruptedException {
        try {
            l.lock();
            if(mirtaPregunta){
                System.out.println("UN INVITADO LE RESPONDIO A MIRTA");
            }
        } catch (Exception e) {
        } finally {
            l.unlock();
        }
    }

    public synchronized void levantarseInvitado() throws InterruptedException {
        try {
            l.lock();
            while(!mirtaSeLevanto){
                esperaLevantarse.await();
                esperaServirse.signal();
            }
            System.out.println("UN INVITADO SE A LEVANTADO");
            
        } catch (InterruptedException e) {
        } finally {
            l.unlock();
        }

    }

    public synchronized void sentarseMirta() {
        try {
            l.lock();
            System.out.println("MIRTA SE HA SENTADO");
            mirtaSentada=true;
            mirtaSeLevanto=false;
            esperaServirse.signal();
        } catch (Exception e) {
        } finally {
            l.unlock();
        }
    }

    public synchronized void enojarse() {
        try {
            l.lock();

        } catch (Exception e) {
        } finally {
            l.unlock();
        }
    }

    public synchronized void lanzarPregunta() {
        try {
            l.lock();

        } catch (Exception e) {
        } finally {
            l.unlock();
        }
    }
}
