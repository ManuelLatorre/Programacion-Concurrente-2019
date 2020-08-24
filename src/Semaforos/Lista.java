/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semaforos;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Manuel
 */
public class Lista {
    private ArrayList<Integer>lista;
    private Semaphore insertorSem;
    private Semaphore borradorSem;
    private int cantBuscadores=0;
    private int cantInsertores=0;
    
    public Lista(){
        lista= new ArrayList<>();
        insertorSem= new Semaphore(1);
        borradorSem= new Semaphore(1);
    }
    
    public void buscar(int posicion){
        try{
        if(posicion<lista.size()){
            System.out.println("Examinando posicion: " + posicion + " Elemento: " + this.lista.get(posicion));
            cantBuscadores++;
            Thread.sleep(2000);
        }else{
            System.out.println("EEEEEEO");
            Thread.sleep(2000);
        }
        }catch(InterruptedException e){
        }
    }
    
    public void insertar(int elemento){
        try{
            insertorSem.acquire();
            cantInsertores++;
            System.out.println("Insertando elemento en ultima posicion de la lista");
            lista.add(elemento);
            Thread.sleep(2000);
            cantInsertores--;
            insertorSem.release();
        }catch(InterruptedException e){
        }
    }
    
    public void borrar(int posicion){
        try{
            if(cantBuscadores==0 && cantInsertores==0){
               borradorSem.acquire();
               System.out.println("SE ESTA ELIMINANDO UN ELEMENTO");
               lista.remove(posicion);
               Thread.sleep(2000);
               borradorSem.release();
            }
        }catch(InterruptedException e){
        }
    }
}
