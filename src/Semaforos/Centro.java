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
public class Centro {

    private int camillas = 4;
    private int sillas = 12;
    private int revistas = 9;
    private Semaphore semRevistas;
    private Semaphore semSillas;
    private Semaphore semCamillas;
    private Semaphore mutex;
    private int esperando = 0;

    public Centro() {
        this.semCamillas = new Semaphore(4, true);
        this.mutex = new Semaphore(1, true);
        this.semRevistas = new Semaphore(9, true);
        this.semSillas = new Semaphore(12, true);
    }

    public void entrarCentro(Persona persona) {
        try {

            if (!semSillas.tryAcquire()) {
                mutex.acquire();
                System.out.println("LA "+persona.getNombre()+" ESPERA PARADA, ESPERANDO UNA SILLA");
                mutex.release();
                semSillas.acquire();//Espera por una silla

            } else {
                mutex.acquire();
                System.out.println("LA "+persona.getNombre()+" TOMO UNA SILLA");
                mutex.release();
            }
        } catch (Exception e) {

        }
    }

    public void agarrarRevista(Persona persona) {
        try {
            if (!semRevistas.tryAcquire()) {
                System.out.println("LA "+persona.getNombre()+" MIRA LA TELE ESPERANDO POR UNA REVISTA");
                semRevistas.acquire();
            } else {
                System.out.println("LA "+persona.getNombre()+" TOMO UNA REVISTA");
            }
        } catch (InterruptedException e) {
        }
    }

    public void esperarCamilla(Persona persona) {
        try {
            if (!semCamillas.tryAcquire()) {
                System.out.println("LA "+persona.getNombre()+" ESPERA QUE LO ATIENDAN");
                semCamillas.acquire();//Vuelve a comeptir
            }
            mutex.acquire();
                System.out.println("LLAMAN A LA "+persona.getNombre()+" Y PASA A LA CAMILLA");//Ya tiene adquirido el permiso
                esperando++;//Indico que hay pacientes en camillas esperando ser atendidos
             mutex.release();
                semSillas.release();//Si o si va a tener una revista ya que quedan loqueados en otros metodos al cometir
                semRevistas.release();//Si o si va a tener una silla
                
        } catch (InterruptedException e) {

        }
    }
    
    public void atenderPaciente(){
        try{
            mutex.acquire();
            if(esperando>0){
                System.out.println("UN ENFERMERO ATIENDE A UN PACIENTE");
                esperando--;
                mutex.release();
                semCamillas.release();
            }else{
                mutex.release();//Libero el de antes
                //System.out.println("NO HAY PACIENTES");
            }
        }catch(InterruptedException e){
        }
    }
}
