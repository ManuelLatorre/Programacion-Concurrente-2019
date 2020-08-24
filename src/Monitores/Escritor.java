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
public class Escritor implements Runnable {

    private String nombre;
    private Libro libro;

    public Escritor(String unNombre, Libro unLibro) {
        this.nombre = unNombre;
        this.libro = unLibro;
    }

    public int escribir() { //Devuelve la cantidad de paginas que escribe cada escritor por turno;
        return 50;
    }

    public void run() {
        while (!libro.terminado()) {
            libro.empezarAEscribir(this);
            System.out.println("El escritor " + nombre + " esta escribiendo. CANTIDAD DE LECTORES ACTUALES: "+libro.getCantidadLectores());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            libro.terminarEscribir();
            System.out.println("El escritor "+nombre+" termino de escribir");
        }
    }
}
