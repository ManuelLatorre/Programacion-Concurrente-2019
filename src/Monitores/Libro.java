/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monitores;

/**
 *
 * @author Manuel
 */
public class Libro {

    private String nombre;
    private int cantPaginas;
    private final int totalPaginas;//Como queda predefinida la cantidad de paginas la indico como final a la variable
    private int cantLec=0;//Lectores simultaneos
    private boolean alguienEscribiendo = false;//static?

    public Libro(String unNombre, int totalPaginas) {
        this.nombre = unNombre;
        this.totalPaginas=totalPaginas;
    }

    public synchronized void empezarALeer() {
        while (alguienEscribiendo) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        cantLec++;
        
    }

    public synchronized void empezarAEscribir(Escritor escritor) {
        while (alguienEscribiendo || cantLec!=0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        cantPaginas+=escritor.escribir();
        alguienEscribiendo = true;
    }
    
    public synchronized void terminarEscribir(){
        alguienEscribiendo=false;
        notifyAll();
    }
    
    public synchronized void terminarLeer(){
        if(cantLec>0){
        cantLec--;
        }
        notifyAll();
    }
    
    public synchronized boolean hayEscrito(){
        return cantPaginas>0;
    }
    
    public synchronized boolean terminado(){
        return cantPaginas==totalPaginas;
    }
    
    public synchronized int getCantidadLectores(){
        return this.cantLec;
    }

}
