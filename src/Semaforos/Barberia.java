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
public class Barberia {

    private Semaphore mutex;
    private Semaphore semSillas;
    private Semaphore semSillon;
    private int esperando = 0;
    private boolean barberoDormido = false;
    private boolean clienteEnSillon = false;

    public Barberia() {
        this.mutex = new Semaphore(1, true);
        this.semSillas = new Semaphore(5, true);
        this.semSillon = new Semaphore(1, true);

    }

    public void entraCliente() {
        try {
            
            mutex.acquire();
            if (barberoDormido) {
                System.out.println("UN CLIENTE DESPIERTA AL BARBERO Y OCUPA EL SILLON");
                barberoDormido = false;//Indico que el barbero dejo de dormir
                semSillon.release();//El barbero estaba ocupando el sillon
                esperando++;//Cuando toma el sillon indica que esta esperando ser atendido
                semSillon.acquire();//El cliente que lo despierta toma el permiso;
                
                mutex.release();//Todo lo anterior lo van realizando de a un cliente 
            } else {
                mutex.release();//Libero el permiso tomado antes por si el barbero no esta durmiendo
                if (!semSillas.tryAcquire()) {
                    System.out.println("NO HAY SILLAS POR LO QUE EL CLIENTE SE VA");
                } else {
                    System.out.println("EL CLIENTE TOMA UNA SILLA Y ESPERA SU TURNO");
                    mutex.acquire();
                    esperando++;
                    mutex.release();
                    semSillon.acquire(); //Si el sillon esta ocupado por un cliente espera
                    semSillas.release();//Libera el permiso que estaba ocupando en la silla una vez toma el sillon
                    
                }
            }

        } catch (InterruptedException e) {

        }
    }

    public void atenderClientes() {
        try {
            mutex.acquire();
            if (esperando > 0) {
                System.out.println("EL BARBERO ATIENDE A UN CLIENTE");
                esperando--;
                Thread.sleep(3000);
                semSillon.release();
                mutex.release(); //Libero el permiso tomado antes
            } else {
                mutex.release();//Libero el permiso anterior
                mutex.acquire();
                if (!barberoDormido) {
                    System.out.println("EL BARBERO SE VA A DORMIR");
                    barberoDormido = true;
                    semSillon.acquire();//Tendrian que estar el permiso liberado ya que no hay gente esperando
                    mutex.release();//Libero el permiso tomado antes
                } else {
                    mutex.release();//Libero el permiso por si el barbero esta dormido
                    System.out.println("EL BARBERO DUERME");
                }
            }
        } catch (InterruptedException e) {
        }
    }

}
