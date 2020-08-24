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
public class Lector implements Runnable{
    private String nombre;
    private Libro libro;
    
    public Lector(String unNombre, Libro unLibro){
        this.nombre=unNombre;
        this.libro=unLibro;
    }
    
    public void run(){
        while(true){
        libro.empezarALeer();
        System.out.println("El lector "+nombre+ " esta leyendo");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
        }
        libro.terminarLeer();
        System.out.println("El lector "+nombre+ " termino de leer");
    }
    }
}
