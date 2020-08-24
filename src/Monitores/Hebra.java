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
public class Hebra implements Runnable {

    private String nombre;
    private boolean jubilado;
    private Sala sala;
    static int cantPersonas = 0;

    public Hebra(String n, boolean jubi, Sala s) {
        this.nombre = n;
        this.jubilado = jubi;
        this.sala = s;
    }

    public Hebra(String n, Sala s) {
        this.jubilado = false;
        this.nombre = n;
        this.sala = s;
    }

    public void run() {
        if (!this.nombre.equals("hebraTemp")) {
            if (sala.getTemperatura() <= 35) {
                if (this.jubilado) {
                    sala.entraSalaJubilado();
                } else {
                    sala.entraSala();
                }
            }
        } else {
            if (this.nombre.equals("hebraTemp")) {
                while (true) {
                    sala.notificarTemperaturaSala((sala.getTemperatura() + 10));

                    if (sala.getTemperatura() > 35) {
                        System.out.println("SE SUPERARON LOS 35 GRADOS");
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }

            }
        }
        System.out.println("Cantidad personas en sala: " + sala.getCantidadPersonas());
        try {
            Thread.sleep(5000);
           
        } catch (InterruptedException e) {
        }
        
        if (!this.nombre.equals("hebraTemp")) {
            sala.salirSala();
            System.out.println("Cantidad personas en sala: " + sala.getCantidadPersonas());
        }

    }
}
