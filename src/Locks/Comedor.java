/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Manuel
 */
public class Comedor {

    private int mostradorBandejas = 5;
    private int abridores = 10;
    private int mostPostre = 3;
    private Lock l;
    private Condition esperaBandeja;
    private Condition esperaAbridor;
    private Condition esperaPostre;

    public Comedor() {
        l = new ReentrantLock(true);
        esperaBandeja = l.newCondition();
        esperaPostre = l.newCondition();
        esperaAbridor = l.newCondition();
    }

    public void agarraBandeja() {
        l.lock();
        try {
            while (mostradorBandejas == 0) {
                esperaBandeja.await();
            }
            mostradorBandejas--;
        } catch (InterruptedException e) {
        } finally {
            l.unlock();
        }
    }

    public void agarraAbridor() {
        l.lock();
        try {
            while (abridores == 0) {
                esperaAbridor.await();
            }
            abridores--;
        } catch (InterruptedException e) {
        } finally {
            l.unlock();
        }
    }

    public void agarraPostre() {
        l.lock();
        try {
            while (mostPostre == 0) {
                esperaPostre.await();
            }
            mostPostre--;
        } catch (InterruptedException e) {
        } finally {
            l.unlock();
        }
    }

    public void dejarMostBand() {
        l.lock();
        try {
            mostradorBandejas++;
            esperaBandeja.signal();
        } catch (Exception e) {
        } finally {
            l.unlock();
        }
    }

    public void destaparBotella() {
        l.lock();
        try {
            abridores++;
            esperaAbridor.signal();
        } catch (Exception e) {
        } finally {
            l.unlock();
        }
    }

    public void dejarMostPostre() {
        l.lock();
        try {
            mostPostre++;
            esperaPostre.signal();
        } catch (Exception e) {
        } finally {
            l.unlock();
        }
    }
}
