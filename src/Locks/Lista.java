/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locks;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Manuel
 */
public class Lista {

    private Lock l;
    private Condition buscadorEsp;
    private Condition insertorEsp;
    private Condition borradorEsp;
    private int cantBuscador = 0;
    private int cantInsertar = 0;
    private int cantBorrador = 0;

    private ArrayList<Integer> lista;

    public Lista() {
        
        this.lista = new ArrayList<>();
        l = new ReentrantLock(true);
        buscadorEsp = l.newCondition();
        insertorEsp = l.newCondition();
        borradorEsp = l.newCondition();
    }

    public void examinar(int posicion) {
        try {
            l.lock();
      
            while(posicion>=lista.size() || lista.get(posicion)==null){
                System.out.println("EL BUSCADOR"+posicion+" ESTA ESPERANDO QUE ESCRIBAN");
                buscadorEsp.await();
            }
            System.out.println("Examinando posicion: " + posicion + " Elemento: " + this.lista.get(posicion));
            cantBuscador++;
           // Thread.sleep(2000);
            cantBuscador--;
            borradorEsp.signal();
        } catch (InterruptedException e) {
        } finally {
            l.unlock();
        }
    }

    public void insertar(int elemento) {
        try {
            l.lock();
            while (cantInsertar > 0) {
                insertorEsp.await();
            }
            System.out.println("Insertando elemento en ultima posicion de la lista");
            cantInsertar++;
            lista.add(elemento);
         //   Thread.sleep(2000);

            cantInsertar--;
            insertorEsp.signal();
            buscadorEsp.signal();
            borradorEsp.signal();
        } catch (InterruptedException e) {
        } finally {
            l.unlock();
        }

    }

    public void borrar(int posicion) {
        try {
            l.lock();
            while (cantBorrador > 0 || cantBuscador > 0 || cantInsertar > 0 || posicion>=lista.size()) {
                borradorEsp.await();
            }
            System.out.println("SE ESTA ELIMINANDO UN ELEMENTO");
            cantBorrador++;
            lista.remove(posicion);
           // Thread.sleep(2000);
            cantBorrador--;
                 
        } catch (InterruptedException e) {
        } finally {
            l.unlock();
        }
    }
}
